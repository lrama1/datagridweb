package com.datagrid.dao;

import java.util.List;

/**
 * Interface for RelationshipAttributeDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IRelationshipAttributeDAO {
	/**
	 * Perform an initial save of a previously unsaved RelationshipAttribute
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
	 * IRelationshipAttributeDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            RelationshipAttribute entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(RelationshipAttribute entity);

	/**
	 * Delete a persistent RelationshipAttribute entity. This operation must be
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
	 * IRelationshipAttributeDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            RelationshipAttribute entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(RelationshipAttribute entity);

	/**
	 * Persist a previously saved RelationshipAttribute entity and return it or
	 * a copy of it to the sender. A copy of the RelationshipAttribute entity
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
	 * entity = IRelationshipAttributeDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            RelationshipAttribute entity to update
	 * @return RelationshipAttribute the persisted RelationshipAttribute entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public RelationshipAttribute update(RelationshipAttribute entity);

	public RelationshipAttribute findById(String id);

	/**
	 * Find all RelationshipAttribute entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the RelationshipAttribute property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<RelationshipAttribute> found by query
	 */
	public List<RelationshipAttribute> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<RelationshipAttribute> findByRelAttrValue(Object relAttrValue,
			int... rowStartIdxAndCount);

	public List<RelationshipAttribute> findByRelAttrTypeId(
			Object relAttrTypeId, int... rowStartIdxAndCount);

	/**
	 * Find all RelationshipAttribute entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<RelationshipAttribute> all RelationshipAttribute entities
	 */
	public List<RelationshipAttribute> findAll(int... rowStartIdxAndCount);
}