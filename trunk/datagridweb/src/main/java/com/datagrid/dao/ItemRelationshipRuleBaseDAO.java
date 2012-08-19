package com.datagrid.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * ItemRelationshipRuleBase entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.datagrid.dao.ItemRelationshipRuleBase
 * @author MyEclipse Persistence Tools
 */

public class ItemRelationshipRuleBaseDAO extends JpaDaoSupport implements
		IItemRelationshipRuleBaseDAO {
	// property constants
	public static final String ITEM_REL_RULE_BASE_DESC = "itemRelRuleBaseDesc";

	/**
	 * Perform an initial save of a previously unsaved ItemRelationshipRuleBase
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
	 * ItemRelationshipRuleBaseDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemRelationshipRuleBase entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(ItemRelationshipRuleBase entity) {
		logger.info("saving ItemRelationshipRuleBase instance");
		try {
			getJpaTemplate().persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	/**
	 * Delete a persistent ItemRelationshipRuleBase entity. This operation must
	 * be performed within the a database transaction context for the entity's
	 * data to be permanently deleted from the persistence store, i.e.,
	 * database. This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * ItemRelationshipRuleBaseDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemRelationshipRuleBase entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(ItemRelationshipRuleBase entity) {
		logger.info("deleting ItemRelationshipRuleBase instance");
		try {
			entity = getJpaTemplate().getReference(
					ItemRelationshipRuleBase.class,
					entity.getItemRelRuleBaseId());
			getJpaTemplate().remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved ItemRelationshipRuleBase entity and return it
	 * or a copy of it to the sender. A copy of the ItemRelationshipRuleBase
	 * entity parameter is returned when the JPA persistence mechanism has not
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
	 * entity = ItemRelationshipRuleBaseDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemRelationshipRuleBase entity to update
	 * @return ItemRelationshipRuleBase the persisted ItemRelationshipRuleBase
	 *         entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public ItemRelationshipRuleBase update(ItemRelationshipRuleBase entity) {
		logger.info("updating ItemRelationshipRuleBase instance");
		try {
			ItemRelationshipRuleBase result = getJpaTemplate().merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public ItemRelationshipRuleBase findById(String id) {
		logger.info("finding ItemRelationshipRuleBase instance with id: " + id);
		try {
			ItemRelationshipRuleBase instance = getJpaTemplate().find(
					ItemRelationshipRuleBase.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	/**
	 * Find all ItemRelationshipRuleBase entities with a specific property
	 * value.
	 * 
	 * @param propertyName
	 *            the name of the ItemRelationshipRuleBase property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<ItemRelationshipRuleBase> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<ItemRelationshipRuleBase> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		logger.info("finding ItemRelationshipRuleBase instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from ItemRelationshipRuleBase model where model."
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

	public List<ItemRelationshipRuleBase> findByItemRelRuleBaseDesc(
			Object itemRelRuleBaseDesc, int... rowStartIdxAndCount) {
		return findByProperty(ITEM_REL_RULE_BASE_DESC, itemRelRuleBaseDesc,
				rowStartIdxAndCount);
	}

	/**
	 * Find all ItemRelationshipRuleBase entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ItemRelationshipRuleBase> all ItemRelationshipRuleBase
	 *         entities
	 */
	@SuppressWarnings("unchecked")
	public List<ItemRelationshipRuleBase> findAll(
			final int... rowStartIdxAndCount) {
		logger.info("finding all ItemRelationshipRuleBase instances");
		try {
			final String queryString = "select model from ItemRelationshipRuleBase model";
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

	public static IItemRelationshipRuleBaseDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IItemRelationshipRuleBaseDAO) ctx
				.getBean("ItemRelationshipRuleBaseDAO");
	}
}