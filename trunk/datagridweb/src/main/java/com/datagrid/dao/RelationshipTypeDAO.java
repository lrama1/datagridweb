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
 * RelationshipType entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.datagrid.dao.RelationshipType
 * @author MyEclipse Persistence Tools
 */

public class RelationshipTypeDAO extends JpaDaoSupport implements
		IRelationshipTypeDAO {
	// property constants
	public static final String REL_TYPE_CODE = "relTypeCode";
	public static final String REL_TYPE_NAME = "relTypeName";
	public static final String REL_TYPE_DESC = "relTypeDesc";

	/**
	 * Perform an initial save of a previously unsaved RelationshipType entity.
	 * All subsequent persist actions of this entity should use the #update()
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
	 * RelationshipTypeDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            RelationshipType entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(RelationshipType entity) {
		logger.info("saving RelationshipType instance");
		try {
			getJpaTemplate().persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	/**
	 * Delete a persistent RelationshipType entity. This operation must be
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
	 * RelationshipTypeDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            RelationshipType entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(RelationshipType entity) {
		logger.info("deleting RelationshipType instance");
		try {
			entity = getJpaTemplate().getReference(RelationshipType.class,
					entity.getRelTypeId());
			getJpaTemplate().remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved RelationshipType entity and return it or a
	 * copy of it to the sender. A copy of the RelationshipType entity parameter
	 * is returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * entity = RelationshipTypeDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            RelationshipType entity to update
	 * @return RelationshipType the persisted RelationshipType entity instance,
	 *         may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public RelationshipType update(RelationshipType entity) {
		logger.info("updating RelationshipType instance");
		try {
			RelationshipType result = getJpaTemplate().merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public RelationshipType findById(String id) {
		logger.info("finding RelationshipType instance with id: " + id);
		try {
			RelationshipType instance = getJpaTemplate().find(
					RelationshipType.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	/**
	 * Find all RelationshipType entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the RelationshipType property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<RelationshipType> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<RelationshipType> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		logger.info("finding RelationshipType instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from RelationshipType model where model."
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

	public List<RelationshipType> findByRelTypeCode(Object relTypeCode,
			int... rowStartIdxAndCount) {
		return findByProperty(REL_TYPE_CODE, relTypeCode, rowStartIdxAndCount);
	}

	public List<RelationshipType> findByRelTypeName(Object relTypeName,
			int... rowStartIdxAndCount) {
		return findByProperty(REL_TYPE_NAME, relTypeName, rowStartIdxAndCount);
	}

	public List<RelationshipType> findByRelTypeDesc(Object relTypeDesc,
			int... rowStartIdxAndCount) {
		return findByProperty(REL_TYPE_DESC, relTypeDesc, rowStartIdxAndCount);
	}

	/**
	 * Find all RelationshipType entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<RelationshipType> all RelationshipType entities
	 */
	@SuppressWarnings("unchecked")
	public List<RelationshipType> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all RelationshipType instances");
		try {
			final String queryString = "select model from RelationshipType model";
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

	public static IRelationshipTypeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IRelationshipTypeDAO) ctx.getBean("RelationshipTypeDAO");
	}
}