/**
 * 
 */
package org.memsoa.app.facade.impl;

import java.util.List;

import org.memsoa.app.api.util.Paginator;
import org.memsoa.app.facade.ProyectoPersonaFacade;
import org.memsoa.app.facade.base.AbstractFacadeImpl;
import org.memsoa.app.model.ProyectoPersona;
import org.memsoa.app.model.ProyectoPersonaId;
import org.memsoa.app.service.ProyectoPersonaService;
import org.memsoa.app.service.base.AbstractService;
import org.memsoa.app.service.base.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class ProyectoPersonaD
 * @date 11/07/2013
 *
 */
@Service("proyectoPersonaFacade")
public class ProyectoPersonaFacadeImpl  extends AbstractFacadeImpl<ProyectoPersona,ProyectoPersonaId> implements ProyectoPersonaFacade{

	@Autowired
	private ProyectoPersonaService proyectoPersonaService;
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.facade.base.AbstractFacadeImpl#getService()
	 */
	@Override
	public AbstractService<ProyectoPersona, ProyectoPersonaId> getService()
			throws Exception {
		return proyectoPersonaService;
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.facade.ProyectoPersonaFacade#findByNameRolEstado(java.lang.String, java.lang.String, java.lang.String, org.memsoa.app.api.util.Paginator)
	 */
	@Override
	public List<ProyectoPersona> findByNameRolEstado(String nombre,
			String codigoRol, String estado, Paginator paginator)
			throws Exception {
		return proyectoPersonaService.findByNameRolEstado(nombre, codigoRol, estado, paginator);
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.facade.ProyectoPersonaFacade#countByNameRolEstado(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Integer countByNameRolEstado(String nombre, String codigoRol,
			String estado) throws Exception {
		return proyectoPersonaService.countByNameRolEstado(nombre, codigoRol, estado);
	}

}
