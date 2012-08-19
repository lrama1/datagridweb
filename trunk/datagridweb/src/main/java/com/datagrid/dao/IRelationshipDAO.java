package com.datagrid.dao;

import java.util.List;
import java.util.Set;

/**
 * Interface for RelationshipDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IRelationshipDAO {
	/**
	 * Perform an initial save of a previously unsaved Relationship entity. All
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
	 * IRelationshipDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Relationship entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Relationship entity);

	/**
	 * Delete a persistent Relationship entity. This operation must be performed
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
	 * IRelationshipDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Relationship entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Relationship entity);

	/**
	 * Persist a previously saved Relationship entity and return it or a copy of
	 * it to the sender. A copy of the Relationship entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
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
	 * entity = IRelationshipDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Relationship entity to update
	 * @return Relationship the persisted Relationship entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Relationship update(Relationship entity);

	public Relationship findById(String id);

	/**
	 * Find all Relationship entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Relationship property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Relationship> found by query
	 */
	public List<Relationship> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Relationship> findByRelName(Object relName,
			int... rowStartIdxAndCount);

	public List<Relationship> findByRelDesc(Object relDesc,
			int... rowStartIdxAndCount);

	/**
	 * Find all Relationship entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Relationship> all Relationship entities
	 */
	public List<Relationship> findAll(int... rowStartIdxAndCount);
}