package com.datagrid.dao;

import java.util.Date;
import java.util.List;

/**
 * Interface for ImportJobsDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IImportJobsDAO {
	/**
	 * Perform an initial save of a previously unsaved ImportJobs entity. All
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
	 * IImportJobsDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ImportJobs entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(ImportJobs entity);

	/**
	 * Delete a persistent ImportJobs entity. This operation must be performed
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
	 * IImportJobsDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ImportJobs entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(ImportJobs entity);

	/**
	 * Persist a previously saved ImportJobs entity and return it or a copy of
	 * it to the sender. A copy of the ImportJobs entity parameter is returned
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
	 * entity = IImportJobsDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ImportJobs entity to update
	 * @return ImportJobs the persisted ImportJobs entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public ImportJobs update(ImportJobs entity);

	public ImportJobs findById(String id);

	/**
	 * Find all ImportJobs entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the ImportJobs property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ImportJobs> found by query
	 */
	public List<ImportJobs> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<ImportJobs> findByStatus(Object status,
			int... rowStartIdxAndCount);

	/**
	 * Find all ImportJobs entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ImportJobs> all ImportJobs entities
	 */
	public List<ImportJobs> findAll(int... rowStartIdxAndCount);
}