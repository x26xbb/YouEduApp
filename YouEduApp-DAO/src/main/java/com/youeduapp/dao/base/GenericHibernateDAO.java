package com.youeduapp.dao.base;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * <p>
 * Class GenericHibernateDAO
 * <p>
 * This class implements methods described in GenericHibernateDAO, using HibernateDaoSupport as library.
 *
 * @author Humberto Munoz
 * @version 1.0
 */
@SuppressWarnings( {"unchecked", "rawtypes"} )
public class GenericHibernateDAO<T, ID extends Serializable> extends HibernateDaoSupport implements GenericDAO<T, ID> {
	
	private Class<T> persistentClass;
	
	/**
	 * The Constructor.
	 */
	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	/**
	 * The Constructor.
	 *
	 * @param persistentClass the persistent class
	 */
	public GenericHibernateDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	/**
	 * Gets the persistent class.
	 *
	 * @return the persistent class
	 */
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#findById(java.io.Serializable)
	 */
	public T findById(ID id) {
		return (T) getHibernateTemplate().get(getPersistentClass(), id);
	}
	
	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#findAll()
	 */
	public List<T> findAll() {
		DetachedCriteria c = DetachedCriteria.forClass(getPersistentClass()); 
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); 
		return this.getHibernateTemplate().findByCriteria(c); 		
	}
	
	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#findByExample(java.lang.Object, java.lang.String[])
	 */
	public List<T> findByExample(T exampleInstance, String ... excludeProperty) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		Example example = Example.create(exampleInstance);
		for (String exclude : excludeProperty) {
			example.excludeProperty(exclude);
		}
		crit.add(example);
		return crit.list();
	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#save(java.lang.Object)
	 */
	public T save(T entity)	{
		getHibernateTemplate().save(entity);
		return entity;
	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#update(java.lang.Object)
	 */
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}
	
	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#saveOrUpdate(java.lang.Object)
	 */
	public T saveOrUpdate(T entity)	{
		getHibernateTemplate().saveOrUpdate(entity);		
		return entity;
	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#makeTransient(java.lang.Object)
	 */
	public void makeTransient(T entity)	{
		getHibernateTemplate().delete(entity);
	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#flush()
	 */
	public void flush()	{
		getHibernateTemplate().flush();
	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#clear()
	 */
	public void clear()	{
		getHibernateTemplate().clear();
	}

	
	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#merge(java.lang.Object)
	 */
	public T merge(T detachedInstance) {
		return (T) getHibernateTemplate().merge(detachedInstance);
	}
	
	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#getOneInstance()
	 */
	public T getOneInstance() {
		T retval = null;
		getHibernateTemplate().setMaxResults(1);
		List list = getHibernateTemplate().loadAll(getPersistentClass());
		
		if (list != null && list.size() > 0) {
			retval = (T) list.get(0);
		}
		return retval;
	}
	
}
