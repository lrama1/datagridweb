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
 * A data access object (DAO) providing persistence and search support for
 * ItemType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.datagrid.dao.ItemType
 * @author MyEclipse Persistence Tools
 */

public class ItemTypeDAO extends JpaDaoSupport implements IItemTypeDAO {
	// property constants
	public static final String ITEM_TYPE_CODE = "itemTypeCode";
	public static final String ITEM_TYPE_NAME = "itemTypeName";
	public static final String ITEM_TYPE_DESC = "itemTypeDesc";

	/**
	 * Perform an initial save of a previously unsaved ItemType entity. All
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
	 * ItemTypeDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemType entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(ItemType entity) {
		logger.info("saving ItemType instance");
		try {
			getJpaTemplate().persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	/**
	 * Delete a persistent ItemType entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * ItemTypeDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemType entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(ItemType entity) {
		logger.info("deleting ItemType instance");
		try {
			entity = getJpaTemplate().getReference(ItemType.class,
					entity.getItemTypeId());
			getJpaTemplate().remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved ItemType entity and return it or a copy of it
	 * to the sender. A copy of the ItemType entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
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
	 * entity = ItemTypeDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemType entity to update
	 * @return ItemType the persisted ItemType entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public ItemType update(ItemType entity) {
		logger.info("updating ItemType instance");
		try {
			ItemType result = getJpaTemplate().merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public ItemType findById(String id) {
		logger.info("finding ItemType instance with id: " + id);
		try {
			ItemType instance = getJpaTemplate().find(ItemType.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	/**
	 * Find all ItemType entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the ItemType property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<ItemType> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<ItemType> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		logger.info("finding ItemType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from ItemType model where model."
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

	public List<ItemType> findByItemTypeCode(Object itemTypeCode,
			int... rowStartIdxAndCount) {
		return findByProperty(ITEM_TYPE_CODE, itemTypeCode, rowStartIdxAndCount);
	}

	public List<ItemType> findByItemTypeName(Object itemTypeName,
			int... rowStartIdxAndCount) {
		return findByProperty(ITEM_TYPE_NAME, itemTypeName, rowStartIdxAndCount);
	}

	public List<ItemType> findByItemTypeDesc(Object itemTypeDesc,
			int... rowStartIdxAndCount) {
		return findByProperty(ITEM_TYPE_DESC, itemTypeDesc, rowStartIdxAndCount);
	}

	/**
	 * Find all ItemType entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ItemType> all ItemType entities
	 */
	@SuppressWarnings("unchecked")
	public List<ItemType> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all ItemType instances");
		try {
			final String queryString = "select model from ItemType model";
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

	public static IItemTypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IItemTypeDAO) ctx.getBean("ItemTypeDAO");
	}
}