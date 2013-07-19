/**
 * 
 */
package org.memsoa.app.facade.impl;

import org.memsoa.app.facade.ProyectoFacade;
import org.memsoa.app.facade.base.AbstractFacadeImpl;
import org.memsoa.app.model.Proyecto;
import org.memsoa.app.service.ProyectoService;
import org.memsoa.app.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class ProyectoFacadeImpl
 * @date 16/07/2013
 *
 */
@Service("proyectoFacade")
public class ProyectoFacadeImpl extends AbstractFacadeImpl<Proyecto,Long> implements ProyectoFacade {

	@Autowired
	private ProyectoService proyectoService;
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 16/07/2013
	 * @see org.memsoa.app.facade.base.AbstractFacadeImpl#getService()
	 */
	@Override
	public AbstractService<Proyecto, Long> getService() throws Exception {
		return proyectoService;
	}

}
