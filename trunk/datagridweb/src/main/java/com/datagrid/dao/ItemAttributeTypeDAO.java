package com.datagrid.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * ItemAttributeType entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.datagrid.dao.ItemAttributeType
 * @author MyEclipse Persistence Tools
 */

public class ItemAttributeTypeDAO extends JpaDaoSupport implements
		IItemAttributeTypeDAO {
	// property constants
	public static final String ITEM_ATTR_TYPE_CODE = "itemAttrTypeCode";
	public static final String ITEM_ATTR_TYPE_NAME = "itemAttrTypeName";
	public static final String ITEM_ATTR_TYPE_DESC = "itemAttrTypeDesc";
	public static final String ITEM_ATTR_TYPE_LENGTH = "itemAttrTypeLength";
	public static final String ITEM_ATTR_TYPE_ISSEARCHABLE = "itemAttrTypeIssearchable";
	public static final String ITEM_ATTR_TYPE_DISPLAY_INDEX = "itemAttrTypeDisplayIndex";
	public static final String ITEM_ATTR_TYPE_IS_REQUIRED = "itemAttrTypeIsRequired";
	public static final String ITEM_ATTR_TYPE_IS_METAPHONEKEY = "itemAttrTypeIsMetaphonekey";
	public static final String ITEM_ATTR_TYPE_METAPHONEKEYPOS = "itemAttrTypeMetaphonekeypos";

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
	 * ItemAttributeTypeDAO.save(entity);
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
	public void save(ItemAttributeType entity) {
		logger.info("saving ItemAttributeType instance");
		try {
			getJpaTemplate().persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

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
	 * ItemAttributeTypeDAO.delete(entity);
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
	public void delete(ItemAttributeType entity) {
		logger.info("deleting ItemAttributeType instance");
		try {
			entity = getJpaTemplate().getReference(ItemAttributeType.class,
					entity.getItemAttrTypeId());
			getJpaTemplate().remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

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
	 * entity = ItemAttributeTypeDAO.update(entity);
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
	public ItemAttributeType update(ItemAttributeType entity) {
		logger.info("updating ItemAttributeType instance");
		try {
			ItemAttributeType result = getJpaTemplate().merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public ItemAttributeType findById(String id) {
		logger.info("finding ItemAttributeType instance with id: " + id);
		try {
			ItemAttributeType instance = getJpaTemplate().find(
					ItemAttributeType.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

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
	 *            number of results to return.
	 * @return List<ItemAttributeType> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<ItemAttributeType> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		logger.info("finding ItemAttributeType instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from ItemAttributeType model where model."
					+ propertyName + "= :propertyValue";
			return getJpaTemplate().executeFind(new JpaCallback() {
				public Object doInJpa(EntityManager em)
						throws PersistenceException {
					Query query = em.createQuery(queryString);
					query.setParameter("propertyValue", value);
					if (rowStartIdxAndCount != null
							&& rowStartIdxAndCount.length > 0) {
						int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
						if (rowStartIdx > 0) {
							query.setFirstResult(rowStartIdx);
						}

						if (rowStartIdxAndCount.length > 1) {
							int rowCount = Math.max(0, rowStartIdxAndCount[1]);
							if (rowCount > 0) {
								query.setMaxResults(rowCount);
							}
						}
					}
					return query.getResultList();
				}
			});
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ItemAttributeType> findByItemAttrTypeCode(
			Object itemAttrTypeCode, int... rowStartIdxAndCount) {
		return findByProperty(ITEM_ATTR_TYPE_CODE, itemAttrTypeCode,
				rowStartIdxAndCount);
	}

	public List<ItemAttributeType> findByItemAttrTypeName(
			Object itemAttrTypeName, int... rowStartIdxAndCount) {
		return findByProperty(ITEM_ATTR_TYPE_NAME, itemAttrTypeName,
				rowStartIdxAndCount);
	}

	public List<ItemAttributeType> findByItemAttrTypeDesc(
			Object itemAttrTypeDesc, int... rowStartIdxAndCount) {
		return findByProperty(ITEM_ATTR_TYPE_DESC, itemAttrTypeDesc,
				rowStartIdxAndCount);
	}

	public List<ItemAttributeType> findByItemAttrTypeLength(
			Object itemAttrTypeLength, int... rowStartIdxAndCount) {
		return findByProperty(ITEM_ATTR_TYPE_LENGTH, itemAttrTypeLength,
				rowStartIdxAndCount);
	}

	public List<ItemAttributeType> findByItemAttrTypeIssearchable(
			Object itemAttrTypeIssearchable, int... rowStartIdxAndCount) {
		return findByProperty(ITEM_ATTR_TYPE_ISSEARCHABLE,
				itemAttrTypeIssearchable, rowStartIdxAndCount);
	}

	public List<ItemAttributeType> findByItemAttrTypeDisplayIndex(
			Object itemAttrTypeDisplayIndex, int... rowStartIdxAndCount) {
		return findByProperty(ITEM_ATTR_TYPE_DISPLAY_INDEX,
				itemAttrTypeDisplayIndex, rowStartIdxAndCount);
	}

	public List<ItemAttributeType> findByItemAttrTypeIsRequired(
			Object itemAttrTypeIsRequired, int... rowStartIdxAndCount) {
		return findByProperty(ITEM_ATTR_TYPE_IS_REQUIRED,
				itemAttrTypeIsRequired, rowStartIdxAndCount);
	}

	public List<ItemAttributeType> findByItemAttrTypeIsMetaphonekey(
			Object itemAttrTypeIsMetaphonekey, int... rowStartIdxAndCount) {
		return findByProperty(ITEM_ATTR_TYPE_IS_METAPHONEKEY,
				itemAttrTypeIsMetaphonekey, rowStartIdxAndCount);
	}

	public List<ItemAttributeType> findByItemAttrTypeMetaphonekeypos(
			Object itemAttrTypeMetaphonekeypos, int... rowStartIdxAndCount) {
		return findByProperty(ITEM_ATTR_TYPE_METAPHONEKEYPOS,
				itemAttrTypeMetaphonekeypos, rowStartIdxAndCount);
	}

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
	@SuppressWarnings("unchecked")
	public List<ItemAttributeType> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all ItemAttributeType instances");
		try {
			final String queryString = "select model from ItemAttributeType model";
			return getJpaTemplate().executeFind(new JpaCallback() {
				public Object doInJpa(EntityManager em)
						throws PersistenceException {
					Query query = em.createQuery(queryString);
					if (rowStartIdxAndCount != null
							&& rowStartIdxAndCount.length > 0) {
						int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
						if (rowStartIdx > 0) {
							query.setFirstResult(rowStartIdx);
						}

						if (rowStartIdxAndCount.length > 1) {
							int rowCount = Math.max(0, rowStartIdxAndCount[1]);
							if (rowCount > 0) {
								query.setMaxResults(rowCount);
							}
						}
					}
					return query.getResultList();
				}
			});
		} catch (RuntimeException re) {
			logger.error("find all failed", re);
			throw re;
		}
	}

	public static IItemAttributeTypeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IItemAttributeTypeDAO) ctx.getBean("ItemAttributeTypeDAO");
	}
}