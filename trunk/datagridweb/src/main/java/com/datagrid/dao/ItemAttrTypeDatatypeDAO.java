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
 * ItemAttrTypeDatatype entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.datagrid.dao.ItemAttrTypeDatatype
 * @author MyEclipse Persistence Tools
 */

public class ItemAttrTypeDatatypeDAO extends JpaDaoSupport implements
		IItemAttrTypeDatatypeDAO {
	// property constants
	public static final String ITEM_ATTR_TYPE_DATATYPE_NAME = "itemAttrTypeDatatypeName";
	public static final String ITEM_ATTR_TYPE_DATATYPE_DESC = "itemAttrTypeDatatypeDesc";
	public static final String REGEX_PATTERN = "regexPattern";

	/**
	 * Perform an initial save of a previously unsaved ItemAttrTypeDatatype
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
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
	 * ItemAttrTypeDatatypeDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemAttrTypeDatatype entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(ItemAttrTypeDatatype entity) {
		logger.info("saving ItemAttrTypeDatatype instance");
		try {
			getJpaTemplate().persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	/**
	 * Delete a persistent ItemAttrTypeDatatype entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * ItemAttrTypeDatatypeDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemAttrTypeDatatype entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(ItemAttrTypeDatatype entity) {
		logger.info("deleting ItemAttrTypeDatatype instance");
		try {
			entity = getJpaTemplate().getReference(ItemAttrTypeDatatype.class,
					entity.getItemAttrTypeDatatypeCode());
			getJpaTemplate().remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved ItemAttrTypeDatatype entity and return it or a
	 * copy of it to the sender. A copy of the ItemAttrTypeDatatype entity
	 * parameter is returned when the JPA persistence mechanism has not
	 * previously been tracking the updated entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently saved to the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#merge(Object)
	 * EntityManager#merge} operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * entity = ItemAttrTypeDatatypeDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemAttrTypeDatatype entity to update
	 * @return ItemAttrTypeDatatype the persisted ItemAttrTypeDatatype entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public ItemAttrTypeDatatype update(ItemAttrTypeDatatype entity) {
		logger.info("updating ItemAttrTypeDatatype instance");
		try {
			ItemAttrTypeDatatype result = getJpaTemplate().merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public ItemAttrTypeDatatype findById(Byte id) {
		logger.info("finding ItemAttrTypeDatatype instance with id: " + id);
		try {
			ItemAttrTypeDatatype instance = getJpaTemplate().find(
					ItemAttrTypeDatatype.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	/**
	 * Find all ItemAttrTypeDatatype entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the ItemAttrTypeDatatype property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<ItemAttrTypeDatatype> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<ItemAttrTypeDatatype> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		logger.info("finding ItemAttrTypeDatatype instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from ItemAttrTypeDatatype model where model."
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

	public List<ItemAttrTypeDatatype> findByItemAttrTypeDatatypeName(
			Object itemAttrTypeDatatypeName, int... rowStartIdxAndCount) {
		return findByProperty(ITEM_ATTR_TYPE_DATATYPE_NAME,
				itemAttrTypeDatatypeName, rowStartIdxAndCount);
	}

	public List<ItemAttrTypeDatatype> findByItemAttrTypeDatatypeDesc(
			Object itemAttrTypeDatatypeDesc, int... rowStartIdxAndCount) {
		return findByProperty(ITEM_ATTR_TYPE_DATATYPE_DESC,
				itemAttrTypeDatatypeDesc, rowStartIdxAndCount);
	}

	public List<ItemAttrTypeDatatype> findByRegexPattern(Object regexPattern,
			int... rowStartIdxAndCount) {
		return findByProperty(REGEX_PATTERN, regexPattern, rowStartIdxAndCount);
	}

	/**
	 * Find all ItemAttrTypeDatatype entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ItemAttrTypeDatatype> all ItemAttrTypeDatatype entities
	 */
	@SuppressWarnings("unchecked")
	public List<ItemAttrTypeDatatype> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all ItemAttrTypeDatatype instances");
		try {
			final String queryString = "select model from ItemAttrTypeDatatype model";
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

	public static IItemAttrTypeDatatypeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IItemAttrTypeDatatypeDAO) ctx
				.getBean("ItemAttrTypeDatatypeDAO");
	}
}