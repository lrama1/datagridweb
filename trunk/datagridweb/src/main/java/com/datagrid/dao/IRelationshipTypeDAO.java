package com.datagrid.dao;

import java.util.List;
import java.util.Set;

/**
 * Interface for RelationshipTypeDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IRelationshipTypeDAO {
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
	 * IRelationshipTypeDAO.save(entity);
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
	public void save(RelationshipType entity);

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
	 * IRelationshipTypeDAO.delete(entity);
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
	public void delete(RelationshipType entity);

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
	 * entity = IRelationshipTypeDAO.update(entity);
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
	public RelationshipType update(RelationshipType entity);

	public RelationshipType findById(String id);

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
	 *            count of results to return.
	 * @return List<RelationshipType> found by query
	 */
	public List<RelationshipType> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<RelationshipType> findByRelTypeCode(Object relTypeCode,
			int... rowStartIdxAndCount);

	public List<RelationshipType> findByRelTypeName(Object relTypeName,
			int... rowStartIdxAndCount);

	public List<RelationshipType> findByRelTypeDesc(Object relTypeDesc,
			int... rowStartIdxAndCount);

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
	public List<RelationshipType> findAll(int... rowStartIdxAndCount);
}