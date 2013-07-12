/**
 * 
 */
package org.memsoa.app.facade.impl;

import java.util.List;

import org.memsoa.app.facade.RolFacade;
import org.memsoa.app.facade.base.AbstractFacadeImpl;
import org.memsoa.app.model.Rol;
import org.memsoa.app.service.RolService;
import org.memsoa.app.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class RolFacadeImpl
 * @date 11/07/2013
 *
 */
@Service("rolFacade")
public class RolFacadeImpl extends AbstractFacadeImpl<Rol, String> implements RolFacade {

	@Autowired
	private RolService rolService;
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.facade.base.AbstractFacadeImpl#getService()
	 */
	@Override
	public AbstractService<Rol, String> getService() throws Exception {
		return rolService;
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.facade.RolFacade#findAll()
	 */
	@Override
	public List<Rol> findAll() throws Exception {
		return rolService.findAll();
	}

}
