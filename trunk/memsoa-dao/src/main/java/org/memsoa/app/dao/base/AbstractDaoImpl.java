/**
 * 
 */
package org.memsoa.app.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project test-dao
 * @class AbstractServiceImpl
 * @date 24/06/2013
 *
 */
@SuppressWarnings("unchecked")
public abstract class AbstractDaoImpl<E,K extends Serializable> implements AbstractDao<E, K> {

	@Autowired
	private SessionFactory sessionFactory;
	private Class<E> entityClass;
	
	
	public AbstractDaoImpl(){
		this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see co.com.coomeva.mp.api.dao.AbstractDao#save(E)
	 */
	public void save(E entity)throws Exception{
		getSession().save(entity);
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see co.com.coomeva.mp.api.dao.AbstractDao#update(E)
	 */
	public void update(E entity)throws Exception{
		getSession().update(entity);
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see co.com.coomeva.mp.api.dao.AbstractDao#saveOrUpdate(E)
	 */
	public void saveOrUpdate(E entity)throws Exception{
		getSession().saveOrUpdate(entity);
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see co.com.coomeva.mp.api.dao.AbstractDao#findById(K)
	 */
	public E findById(K id) throws Exception{
		return (E)getSession().get(entityClass, id);
	}
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see co.com.coomeva.mp.api.dao.AbstractDao#delete(K)
	 */
	public void delete(K key) throws Exception{
		E entity=findById(key);
		getSession().delete(entity);
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see co.com.coomeva.mp.api.dao.AbstractDao#delete(E)
	 */
	public void delete(E entity)throws Exception{
		getSession().delete(entity);
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see co.com.coomeva.mp.api.dao.AbstractDao#getSession()
	 */
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
