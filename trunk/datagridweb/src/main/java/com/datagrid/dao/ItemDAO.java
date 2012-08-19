package com.datagrid.dao;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Item
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.datagrid.dao.Item
 * @author MyEclipse Persistence Tools
 */

public class ItemDAO extends JpaDaoSupport implements IItemDAO {
	// property constants
	public static final String ITEM_CODE = "itemCode";
	public static final String ITEM_NAME = "itemName";
	public static final String ITEM_DESC = "itemDesc";
	public static final String ITEM_METAPHONE_SRC_STRING = "itemMetaphoneSrcString";
	public static final String ITEM_METAPHONE_KEY = "itemMetaphoneKey";

	/**
	 * Perform an initial save of a previously unsaved Item entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * ItemDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Item entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Item entity) {
		logger.info("saving Item instance");
		try {
			getJpaTemplate().persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Item entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * ItemDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Item entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Item entity) {
		logger.info("deleting Item instance");
		try {
			entity = getJpaTemplate().getReference(Item.class,
					entity.getItemId());
			getJpaTemplate().remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Item entity and return it or a copy of it to
	 * the sender. A copy of the Item entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * entity = ItemDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Item entity to update
	 * @return Item the persisted Item entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Item update(Item entity) {
		logger.info("updating Item instance");
		try {
			Item result = getJpaTemplate().merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public Item findById(String id) {
		logger.info("finding Item instance with id: " + id);
		try {
			Item instance = getJpaTemplate().find(Item.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	/**
	 * Find all Item entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Item property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<Item> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Item> findByProperty(String propertyName, final Object value,
			final int... rowStartIdxAndCount) {
		logger.info("finding Item instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from Item model where model."
					+ propertyName + "= :propertyValue";
			return getJpaTemplate().executeFind(new JpaCallback() {
				public Object doInJpa(EntityManager em)
						throws PersistenceException {
					Query query = em.createQuery(queryString);
					query.setParameter("propertyValue", value);
					if (rowStartIdxAndCount != null
							&& rowStartIdxAndCount.length > 0) {
						int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
						if (rowStartIdx > 0) {
							query.setFirstResult(rowStartIdx);
						}

						if (rowStartIdxAndCount.length > 1) {
							int rowCount = Math.max(0, rowStartIdxAndCount[1]);
							if (rowCount > 0) {
								query.setMaxResults(rowCount);
							}
						}
					}
					return query.getResultList();
				}
			});
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Item> findByItemCode(Object itemCode,
			int... rowStartIdxAndCount) {
		return findByProperty(ITEM_CODE, itemCode, rowStartIdxAndCount);
	}

	public List<Item> findByItemName(Object itemName,
			int... rowStartIdxAndCount) {
		return findByProperty(ITEM_NAME, itemName, rowStartIdxAndCount);
	}

	public List<Item> findByItemDesc(Object itemDesc,
			int... rowStartIdxAndCount) {
		return findByProperty(ITEM_DESC, itemDesc, rowStartIdxAndCount);
	}

	public List<Item> findByItemMetaphoneSrcString(
			Object itemMetaphoneSrcString, int... rowStartIdxAndCount) {
		return findByProperty(ITEM_METAPHONE_SRC_STRING,
				itemMetaphoneSrcString, rowStartIdxAndCount);
	}

	public List<Item> findByItemMetaphoneKey(Object itemMetaphoneKey,
			int... rowStartIdxAndCount) {
		return findByProperty(ITEM_METAPHONE_KEY, itemMetaphoneKey,
				rowStartIdxAndCount);
	}

	/**
	 * Find all Item entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Item> all Item entities
	 */
	@SuppressWarnings("unchecked")
	public List<Item> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all Item instances");
		try {
			final String queryString = "select model from Item model";
			return getJpaTemplate().executeFind(new JpaCallback() {
				public Object doInJpa(EntityManager em)
						throws PersistenceException {
					Query query = em.createQuery(queryString);
					if (rowStartIdxAndCount != null
							&& rowStartIdxAndCount.length > 0) {
						int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
						if (rowStartIdx > 0) {
							query.setFirstResult(rowStartIdx);
						}

						if (rowStartIdxAndCount.length > 1) {
							int rowCount = Math.max(0, rowStartIdxAndCount[1]);
							if (rowCount > 0) {
								query.setMaxResults(rowCount);
							}
						}
					}
					return query.getResultList();
				}
			});
		} catch (RuntimeException re) {
			logger.error("find all failed", re);
			throw re;
		}
	}

	public static IItemDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IItemDAO) ctx.getBean("ItemDAO");
	}
}