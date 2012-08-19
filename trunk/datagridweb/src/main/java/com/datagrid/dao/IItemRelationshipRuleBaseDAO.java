package com.datagrid.dao;

import java.util.List;

/**
 * Interface for ItemRelationshipRuleBaseDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IItemRelationshipRuleBaseDAO {
	/**
	 * Perform an initial save of a previously unsaved ItemRelationshipRuleBase
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
	 * IItemRelationshipRuleBaseDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemRelationshipRuleBase entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(ItemRelationshipRuleBase entity);

	/**
	 * Delete a persistent ItemRelationshipRuleBase entity. This operation must
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
	 * IItemRelationshipRuleBaseDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemRelationshipRuleBase entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(ItemRelationshipRuleBase entity);

	/**
	 * Persist a previously saved ItemRelationshipRuleBase entity and return it
	 * or a copy of it to the sender. A copy of the ItemRelationshipRuleBase
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
	 * entity = IItemRelationshipRuleBaseDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ItemRelationshipRuleBase entity to update
	 * @return ItemRelationshipRuleBase the persisted ItemRelationshipRuleBase
	 *         entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public ItemRelationshipRuleBase update(ItemRelationshipRuleBase entity);

	public ItemRelationshipRuleBase findById(String id);

	/**
	 * Find all ItemRelationshipRuleBase entities with a specific property
	 * value.
	 * 
	 * @param propertyName
	 *            the name of the ItemRelationshipRuleBase property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ItemRelationshipRuleBase> found by query
	 */
	public List<ItemRelationshipRuleBase> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<ItemRelationshipRuleBase> findByItemRelRuleBaseDesc(
			Object itemRelRuleBaseDesc, int... rowStartIdxAndCount);

	/**
	 * Find all ItemRelationshipRuleBase entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ItemRelationshipRuleBase> all ItemRelationshipRuleBase
	 *         entities
	 */
	public List<ItemRelationshipRuleBase> findAll(int... rowStartIdxAndCount);
}