/**
 * 
 */
package org.memsoa.app.dao;

import java.util.List;

import org.memsoa.app.dao.base.AbstractDao;
import org.memsoa.app.model.Persona;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-dao
 * @class PersonaDao
 * @date 16/07/2013
 *
 */
public interface PersonaDao extends AbstractDao<Persona, String> {

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
