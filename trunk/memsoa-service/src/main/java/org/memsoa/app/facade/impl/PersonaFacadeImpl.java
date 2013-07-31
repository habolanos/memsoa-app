/**
 * 
 */
package org.memsoa.app.facade.impl;

import java.util.List;

import org.memsoa.app.facade.PersonaFacade;
import org.memsoa.app.facade.base.AbstractFacadeImpl;
import org.memsoa.app.model.Persona;
import org.memsoa.app.service.PersonaService;
import org.memsoa.app.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class PersonaFacadeImpl
 * @date 30/07/2013
 *
 */
@Service("personaFacade")
public class PersonaFacadeImpl extends AbstractFacadeImpl<Persona, String> implements PersonaFacade{

	@Autowired
	private PersonaService personaService;
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 30/07/2013
	 * @see org.memsoa.app.facade.base.AbstractFacadeImpl#getService()
	 */
	@Override
	public AbstractService<Persona, String> getService() throws Exception {
		return personaService;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 30/07/2013
	 * @see org.memsoa.app.facade.PersonaFacade#findByname(java.lang.String)
	 */
	@Override
	public List<Persona> findByname(String name) throws Exception {
		return personaService.findByname(name);
	}

}
