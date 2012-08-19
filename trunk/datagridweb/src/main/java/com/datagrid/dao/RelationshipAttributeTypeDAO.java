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
 * RelationshipAttributeType entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.datagrid.dao.RelationshipAttributeType
 * @author MyEclipse Persistence Tools
 */

public class RelationshipAttributeTypeDAO extends JpaDaoSupport implements
		IRelationshipAttributeTypeDAO {
	// property constants
	public static final String REL_ATTR_TYPE_CODE = "relAttrTypeCode";
	public static final String REL_ATTR_TYPE_NAME = "relAttrTypeName";
	public static final String REL_ATTR_TYPE_DESC = "relAttrTypeDesc";

	/**
	 * Perform an initial save of a previously unsaved RelationshipAttributeType
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
	 * RelationshipAttributeTypeDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            RelationshipAttributeType entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(RelationshipAttributeType entity) {
		logger.info("saving RelationshipAttributeType instance");
		try {
			getJpaTemplate().persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	/**
	 * Delete a persistent RelationshipAttributeType entity. This operation must
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
	 * RelationshipAttributeTypeDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            RelationshipAttributeType entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(RelationshipAttributeType entity) {
		logger.info("deleting RelationshipAttributeType instance");
		try {
			entity = getJpaTemplate().getReference(
					RelationshipAttributeType.class, entity.getRelAttrTypeId());
			getJpaTemplate().remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved RelationshipAttributeType entity and return it
	 * or a copy of it to the sender. A copy of the RelationshipAttributeType
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
	 * entity = RelationshipAttributeTypeDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            RelationshipAttributeType entity to update
	 * @return RelationshipAttributeType the persisted RelationshipAttributeType
	 *         entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public RelationshipAttributeType update(RelationshipAttributeType entity) {
		logger.info("updating RelationshipAttributeType instance");
		try {
			RelationshipAttributeType result = getJpaTemplate().merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public RelationshipAttributeType findById(String id) {
		logger.info("finding RelationshipAttributeType instance with id: " + id);
		try {
			RelationshipAttributeType instance = getJpaTemplate().find(
					RelationshipAttributeType.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	/**
	 * Find all RelationshipAttributeType entities with a specific property
	 * value.
	 * 
	 * @param propertyName
	 *            the name of the RelationshipAttributeType property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<RelationshipAttributeType> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<RelationshipAttributeType> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		logger.info("finding RelationshipAttributeType instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from RelationshipAttributeType model where model."
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

	public List<RelationshipAttributeType> findByRelAttrTypeCode(
			Object relAttrTypeCode, int... rowStartIdxAndCount) {
		return findByProperty(REL_ATTR_TYPE_CODE, relAttrTypeCode,
				rowStartIdxAndCount);
	}

	public List<RelationshipAttributeType> findByRelAttrTypeName(
			Object relAttrTypeName, int... rowStartIdxAndCount) {
		return findByProperty(REL_ATTR_TYPE_NAME, relAttrTypeName,
				rowStartIdxAndCount);
	}

	public List<RelationshipAttributeType> findByRelAttrTypeDesc(
			Object relAttrTypeDesc, int... rowStartIdxAndCount) {
		return findByProperty(REL_ATTR_TYPE_DESC, relAttrTypeDesc,
				rowStartIdxAndCount);
	}

	/**
	 * Find all RelationshipAttributeType entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<RelationshipAttributeType> all RelationshipAttributeType
	 *         entities
	 */
	@SuppressWarnings("unchecked")
	public List<RelationshipAttributeType> findAll(
			final int... rowStartIdxAndCount) {
		logger.info("finding all RelationshipAttributeType instances");
		try {
			final String queryString = "select model from RelationshipAttributeType model";
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

	public static IRelationshipAttributeTypeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IRelationshipAttributeTypeDAO) ctx
				.getBean("RelationshipAttributeTypeDAO");
	}
}