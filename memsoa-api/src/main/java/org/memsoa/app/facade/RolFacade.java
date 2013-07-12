/**
 * 
 */
package org.memsoa.app.facade;

import java.util.List;

import org.memsoa.app.facade.base.AbstractFacade;
import org.memsoa.app.model.Rol;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-api
 * @class RolFacade
 * @date 11/07/2013
 *
 */
public interface RolFacade extends AbstractFacade<Rol, String>{

	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @return List<{@link Rol}>
	 * @throws Exception
	 */
	List<Rol> findAll()throws Exception;
}
