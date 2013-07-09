/**
 * 
 */
package org.memsoa.app.service.base;

import java.io.Serializable;


/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project test-api
 * @class AbstractService
 * @date 24/06/2013
 *
 */
public interface AbstractService<E, K extends Serializable> {

	/**
	 * guarda la entidad
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 24/06/2013
	 * @param entity
	 * @throws Exception
	 */
	public abstract void save(E entity) throws Exception;

	/**
	 * modifica la entidad
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 24/06/2013
	 * @param entity
	 * @throws Exception
	 */
	public abstract void update(E entity) throws Exception;

	/**
	 * guarda o modifica la entidad
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 24/06/2013
	 * @param entity
	 * @throws Exception
	 */
	public abstract void saveOrUpdate(E entity) throws Exception;

	/**
	 * consulta por ID
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 24/06/2013
	 * @param id
	 * @return {@link E}
	 * @throws Exception
	 */
	public abstract E findById(K id) throws Exception;

	/**
	 * elimina la entidad por ID
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 24/06/2013
	 * @param key
	 * @throws Exception
	 */
	public abstract void delete(K key) throws Exception;

	/**
	 * elimina la entidad
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 24/06/2013
	 * @param entity
	 * @throws Exception
	 */
	public abstract void delete(E entity) throws Exception;


}