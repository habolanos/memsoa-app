/**
 * 
 */
package org.memsoa.app.service.impl;

import java.util.List;

import org.memsoa.app.api.util.Paginator;
import org.memsoa.app.dao.PersonaDao;
import org.memsoa.app.dao.ProyectoDao;
import org.memsoa.app.dao.ProyectoPersonaDao;
import org.memsoa.app.dao.RolDao;
import org.memsoa.app.dao.base.AbstractDao;
import org.memsoa.app.model.ProyectoPersona;
import org.memsoa.app.model.ProyectoPersonaId;
import org.memsoa.app.service.ProyectoPersonaService;
import org.memsoa.app.service.base.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class ProyectoPersonaServiceImpl
 * @date 11/07/2013
 *
 */
@Service
public class ProyectoPersonaServiceImpl extends AbstractServiceImpl<ProyectoPersona,ProyectoPersonaId> implements ProyectoPersonaService{

	@Autowired
	private ProyectoPersonaDao proyectoPersonaDao;
	@Autowired
	private ProyectoDao proyectoDao;
	@Autowired
	private PersonaDao personaDao;
	@Autowired
	private RolDao rolDao;
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.service.base.AbstractServiceImpl#getDao()
	 */
	@Override
	public AbstractDao<ProyectoPersona, ProyectoPersonaId> getDao()
			throws Exception {
		return proyectoPersonaDao;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.service.ProyectoPersonaService#findByNameRolEstado(java.lang.String, java.lang.String, java.lang.String, org.memsoa.app.api.util.Paginator)
	 */
	@Override
	public List<ProyectoPersona> findByNameRolEstado(String nombre,
			String codigoRol, String estado, Paginator paginator)
			throws Exception {
		return proyectoPersonaDao.findByNameRolEstado(nombre, codigoRol, estado, paginator);
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.service.ProyectoPersonaService#countByNameRolEstado(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Integer countByNameRolEstado(String nombre, String codigoRol,
			String estado) throws Exception {
		return proyectoPersonaDao.countByNameRolEstado(nombre, codigoRol, estado);
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 16/07/2013
	 * @see org.memsoa.app.service.base.AbstractServiceImpl#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(ProyectoPersona entity) throws Exception {
		super.saveOrUpdate(entity);
	}
	
}
