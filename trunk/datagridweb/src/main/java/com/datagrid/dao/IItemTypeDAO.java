package com.datagrid.dao;

import java.util.List;
import java.util.Set;

/**
 * Interface for ItemTypeDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IItemTypeDAO {
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
	 * IItemTypeDAO.save(entity);
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
	public void save(ItemType entity);

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
	 * IItemTypeDAO.delete(entity);
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
	public void delete(ItemType entity);

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
	 * entity = IItemTypeDAO.update(entity);
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
	public ItemType update(ItemType entity);

	public ItemType findById(String id);

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
	 *            count of results to return.
	 * @return List<ItemType> found by query
	 */
	public List<ItemType> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<ItemType> findByItemTypeCode(Object itemTypeCode,
			int... rowStartIdxAndCount);

	public List<ItemType> findByItemTypeName(Object itemTypeName,
			int... rowStartIdxAndCount);

	public List<ItemType> findByItemTypeDesc(Object itemTypeDesc,
			int... rowStartIdxAndCount);

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
	public List<ItemType> findAll(int... rowStartIdxAndCount);
}