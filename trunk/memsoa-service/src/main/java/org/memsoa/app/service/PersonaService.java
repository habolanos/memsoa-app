/**
 * 
 */
package org.memsoa.app.service;

import java.util.List;

import org.memsoa.app.model.Persona;
import org.memsoa.app.service.base.AbstractService;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class PersonaService
 * @date 30/07/2013
 *
 */
public interface PersonaService extends AbstractService<Persona, String>{

	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @param name
	 * @return {@link Persona}
	 * @throws Exception
	 */
	List<Persona> findByname(String name)throws Exception;
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 15/09/2013
	 * @param email
	 * @param clave
	 * @return {@link Persona}
	 * @throws Exception
	 */
	Persona findByEmailClave(String email,String clave) throws Exception ;
}
