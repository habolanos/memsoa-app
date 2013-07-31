/**
 * 
 */
package org.memsoa.app.facade;

import java.util.List;

import org.memsoa.app.facade.base.AbstractFacade;
import org.memsoa.app.model.Persona;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-api
 * @class PersonaFacade
 * @date 30/07/2013
 *
 */
public interface PersonaFacade extends AbstractFacade<Persona, String> {

	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @param name
	 * @return {@link Persona}
	 * @throws Exception
	 */
	List<Persona> findByname(String name)throws Exception;
}
