package com.datagrid.dao;

import java.util.List;

/**
 * Interface for RelationshipAttributeTypeDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IRelationshipAttributeTypeDAO {
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
	 * IRelationshipAttributeTypeDAO.save(entity);
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
	public void save(RelationshipAttributeType entity);

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
	 * IRelationshipAttributeTypeDAO.delete(entity);
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
	public void delete(RelationshipAttributeType entity);

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
	 * entity = IRelationshipAttributeTypeDAO.update(entity);
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
	public RelationshipAttributeType update(RelationshipAttributeType entity);

	public RelationshipAttributeType findById(String id);

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
	 *            count of results to return.
	 * @return List<RelationshipAttributeType> found by query
	 */
	public List<RelationshipAttributeType> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<RelationshipAttributeType> findByRelAttrTypeCode(
			Object relAttrTypeCode, int... rowStartIdxAndCount);

	public List<RelationshipAttributeType> findByRelAttrTypeName(
			Object relAttrTypeName, int... rowStartIdxAndCount);

	public List<RelationshipAttributeType> findByRelAttrTypeDesc(
			Object relAttrTypeDesc, int... rowStartIdxAndCount);

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
	public List<RelationshipAttributeType> findAll(int... rowStartIdxAndCount);
}