/**
 * 
 */
package org.memsoa.app.facade.base;

import java.io.Serializable;

import org.memsoa.app.service.base.AbstractService;


/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project test-api
 * @class AbstractServiceImpl
 * @date 24/06/2013
 *
 */
public abstract class AbstractFacadeImpl<E,K extends Serializable> implements AbstractFacade<E, K> {
	
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 24/06/2013
	 * @return {@link AbstractService}
	 * @throws Exception
	 */
	public abstract AbstractService<E, K> getService()throws Exception;

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see org.memsoa.app.facade.base.AbstractFacade#save(E)
	 */
	public void save(E entity)throws Exception{
		getService().save(entity);
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see org.memsoa.app.facade.base.AbstractFacade#update(E)
	 */
	public void update(E entity)throws Exception{
		getService().update(entity);
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see org.memsoa.app.facade.base.AbstractFacade#saveOrUpdate(E)
	 */
	public void saveOrUpdate(E entity)throws Exception{
		getService().saveOrUpdate(entity);
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see org.memsoa.app.facade.base.AbstractFacade#findById(K)
	 */
	public E findById(K id) throws Exception{
		return getService().findById(id);
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see org.memsoa.app.facade.base.AbstractFacade#delete(K)
	 */
	public void delete(K key) throws Exception{
		getService().delete(key);
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see org.memsoa.app.facade.base.AbstractFacade#delete(E)
	 */
	public void delete(E entity)throws Exception{
		getService().delete(entity);
	}
}
