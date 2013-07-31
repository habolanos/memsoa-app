/**
 * 
 */
package org.memsoa.app.service.impl;

import java.util.List;

import org.memsoa.app.dao.PersonaDao;
import org.memsoa.app.dao.base.AbstractDao;
import org.memsoa.app.model.Persona;
import org.memsoa.app.service.PersonaService;
import org.memsoa.app.service.base.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class PersonaServiceImpl
 * @date 30/07/2013
 *
 */
@Service
public class PersonaServiceImpl extends AbstractServiceImpl<Persona,String> implements PersonaService{

	@Autowired
	private PersonaDao personaDao;
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 30/07/2013
	 * @see org.memsoa.app.service.base.AbstractServiceImpl#getDao()
	 */
	@Override
	public AbstractDao<Persona, String> getDao() throws Exception {
		return personaDao;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 30/07/2013
	 * @see org.memsoa.app.service.PersonaService#findByname(java.lang.String)
	 */
	@Override
	public List<Persona> findByname(String name) throws Exception {
		return personaDao.findByname(name);
	}

}
