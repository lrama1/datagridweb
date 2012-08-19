package com.datagrid.dao;

import java.util.List;

/**
 * Interface for ItemAttributeDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IItemAttributeDAO {
	/**
	 * Perform an initial save of a previously unsaved ItemAttribute entity. All
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
	 * IItemAttributeDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemAttribute entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(ItemAttribute entity);

	/**
	 * Delete a persistent ItemAttribute entity. This operation must be
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
	 * IItemAttributeDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemAttribute entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(ItemAttribute entity);

	/**
	 * Persist a previously saved ItemAttribute entity and return it or a copy
	 * of it to the sender. A copy of the ItemAttribute entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
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
	 * entity = IItemAttributeDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemAttribute entity to update
	 * @return ItemAttribute the persisted ItemAttribute entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public ItemAttribute update(ItemAttribute entity);

	public ItemAttribute findById(String id);

	/**
	 * Find all ItemAttribute entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the ItemAttribute property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ItemAttribute> found by query
	 */
	public List<ItemAttribute> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<ItemAttribute> findByItemAttrValue(Object itemAttrValue,
			int... rowStartIdxAndCount);

	public List<ItemAttribute> findByItemAttrTypeId(Object itemAttrTypeId,
			int... rowStartIdxAndCount);

	/**
	 * Find all ItemAttribute entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ItemAttribute> all ItemAttribute entities
	 */
	public List<ItemAttribute> findAll(int... rowStartIdxAndCount);
}