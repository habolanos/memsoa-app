/**
 * 
 */
package org.memsoa.app.service.impl;

import org.memsoa.app.dao.PersonaDao;
import org.memsoa.app.dao.ProyectoDao;
import org.memsoa.app.dao.base.AbstractDao;
import org.memsoa.app.model.Proyecto;
import org.memsoa.app.service.ProyectoService;
import org.memsoa.app.service.base.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class ProyectoServiceImpl
 * @date 16/07/2013
 *
 */
@Service
public class ProyectoServiceImpl extends AbstractServiceImpl<Proyecto,Long> implements ProyectoService {

	@Autowired
	private ProyectoDao proyectoDao;
	@Autowired
	private PersonaDao personaDao;
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 16/07/2013
	 * @see org.memsoa.app.service.base.AbstractServiceImpl#getDao()
	 */
	@Override
	public AbstractDao<Proyecto, Long> getDao() throws Exception {
		return proyectoDao;
	}
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 16/07/2013
	 * @see org.memsoa.app.service.base.AbstractServiceImpl#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(Proyecto entity) throws Exception {
		entity.setPersona(personaDao.findById("1"));
		super.saveOrUpdate(entity);
	}

}
