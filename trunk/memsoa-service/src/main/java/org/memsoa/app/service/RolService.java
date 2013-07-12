/**
 * 
 */
package org.memsoa.app.service;

import java.util.List;

import org.memsoa.app.model.Rol;
import org.memsoa.app.service.base.AbstractService;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class RolService
 * @date 11/07/2013
 *
 */
public interface RolService extends AbstractService<Rol,String> {
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @return List<{@link Rol}>
	 * @throws Exception
	 */
	List<Rol> findAll()throws Exception;
}
