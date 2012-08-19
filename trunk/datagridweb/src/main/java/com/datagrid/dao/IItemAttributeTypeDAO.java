package com.datagrid.dao;

import java.util.List;

/**
 * Interface for ItemAttributeTypeDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IItemAttributeTypeDAO {
	/**
	 * Perform an initial save of a previously unsaved ItemAttributeType entity.
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
	 * IItemAttributeTypeDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemAttributeType entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(ItemAttributeType entity);

	/**
	 * Delete a persistent ItemAttributeType entity. This operation must be
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
	 * IItemAttributeTypeDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemAttributeType entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(ItemAttributeType entity);

	/**
	 * Persist a previously saved ItemAttributeType entity and return it or a
	 * copy of it to the sender. A copy of the ItemAttributeType entity
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
	 * entity = IItemAttributeTypeDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemAttributeType entity to update
	 * @return ItemAttributeType the persisted ItemAttributeType entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public ItemAttributeType update(ItemAttributeType entity);

	public ItemAttributeType findById(String id);

	/**
	 * Find all ItemAttributeType entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the ItemAttributeType property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ItemAttributeType> found by query
	 */
	public List<ItemAttributeType> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<ItemAttributeType> findByItemAttrTypeCode(
			Object itemAttrTypeCode, int... rowStartIdxAndCount);

	public List<ItemAttributeType> findByItemAttrTypeName(
			Object itemAttrTypeName, int... rowStartIdxAndCount);

	public List<ItemAttributeType> findByItemAttrTypeDesc(
			Object itemAttrTypeDesc, int... rowStartIdxAndCount);

	public List<ItemAttributeType> findByItemAttrTypeLength(
			Object itemAttrTypeLength, int... rowStartIdxAndCount);

	public List<ItemAttributeType> findByItemAttrTypeIssearchable(
			Object itemAttrTypeIssearchable, int... rowStartIdxAndCount);

	public List<ItemAttributeType> findByItemAttrTypeDisplayIndex(
			Object itemAttrTypeDisplayIndex, int... rowStartIdxAndCount);

	public List<ItemAttributeType> findByItemAttrTypeIsRequired(
			Object itemAttrTypeIsRequired, int... rowStartIdxAndCount);

	public List<ItemAttributeType> findByItemAttrTypeIsMetaphonekey(
			Object itemAttrTypeIsMetaphonekey, int... rowStartIdxAndCount);

	public List<ItemAttributeType> findByItemAttrTypeMetaphonekeypos(
			Object itemAttrTypeMetaphonekeypos, int... rowStartIdxAndCount);

	/**
	 * Find all ItemAttributeType entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ItemAttributeType> all ItemAttributeType entities
	 */
	public List<ItemAttributeType> findAll(int... rowStartIdxAndCount);
}