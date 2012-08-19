package com.datagrid.dao;

import java.util.List;
import java.util.Set;

/**
 * Interface for ItemAttrTypeDatatypeDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IItemAttrTypeDatatypeDAO {
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
	 * IItemAttrTypeDatatypeDAO.save(entity);
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
	public void save(ItemAttrTypeDatatype entity);

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
	 * IItemAttrTypeDatatypeDAO.delete(entity);
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
	public void delete(ItemAttrTypeDatatype entity);

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
	 * entity = IItemAttrTypeDatatypeDAO.update(entity);
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
	public ItemAttrTypeDatatype update(ItemAttrTypeDatatype entity);

	public ItemAttrTypeDatatype findById(Byte id);

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
	 *            count of results to return.
	 * @return List<ItemAttrTypeDatatype> found by query
	 */
	public List<ItemAttrTypeDatatype> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<ItemAttrTypeDatatype> findByItemAttrTypeDatatypeName(
			Object itemAttrTypeDatatypeName, int... rowStartIdxAndCount);

	public List<ItemAttrTypeDatatype> findByItemAttrTypeDatatypeDesc(
			Object itemAttrTypeDatatypeDesc, int... rowStartIdxAndCount);

	public List<ItemAttrTypeDatatype> findByRegexPattern(Object regexPattern,
			int... rowStartIdxAndCount);

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
	public List<ItemAttrTypeDatatype> findAll(int... rowStartIdxAndCount);
}