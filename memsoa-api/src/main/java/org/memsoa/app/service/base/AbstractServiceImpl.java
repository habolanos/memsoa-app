/**
 * 
 */
package org.memsoa.app.service.base;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import org.memsoa.app.dao.base.AbstractDao;


/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project test-api
 * @class AbstractServiceImpl
 * @date 24/06/2013
 *
 */
public abstract class AbstractServiceImpl<E,K extends Serializable> implements AbstractService<E, K> {
	
	private static final String MESSAGE_NOT_FOUND_PREFIX = "??";
	
	/**
	 * retorna 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 24/06/2013
	 * @return {@linkplain AbstractDao}
	 * @throws Exception
	 */
	public abstract AbstractDao<E, K>getDao()throws Exception;
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see org.memsoa.app.service.base.AbstractService#save(E)
	 */
	public void save(E entity)throws Exception{
		getDao().save(entity);
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see org.memsoa.app.service.base.AbstractService#update(E)
	 */
	public void update(E entity)throws Exception{
		getDao().update(entity);
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see org.memsoa.app.service.base.AbstractService#saveOrUpdate(E)
	 */
	public void saveOrUpdate(E entity)throws Exception{
		getDao().saveOrUpdate(entity);
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see org.memsoa.app.service.base.AbstractService#findById(K)
	 */
	public E findById(K id) throws Exception{
		return getDao().findById(id);
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see org.memsoa.app.service.base.AbstractService#delete(K)
	 */
	public void delete(K key) throws Exception{
		getDao().delete(key);
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 24/06/2013
	 * @see org.memsoa.app.service.base.AbstractService#delete(E)
	 */
	public void delete(E entity)throws Exception{
		getDao().delete(entity);
	}
	
	protected static String getMessage(String messageBundle, String key) {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(messageBundle, Locale.getDefault());
			return bundle.getString(key);
		} catch (Exception e) {
			return MESSAGE_NOT_FOUND_PREFIX + key + MESSAGE_NOT_FOUND_PREFIX;
		}
	}
}
