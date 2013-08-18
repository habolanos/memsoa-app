/**
 * 
 */
package org.memsoa.app.facade.impl;

import java.util.List;

import org.memsoa.app.facade.PrincipioFacade;
import org.memsoa.app.facade.base.AbstractFacadeImpl;
import org.memsoa.app.model.Principio;
import org.memsoa.app.service.PrincipioService;
import org.memsoa.app.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class PrincipioFacadeImpl
 * @date 7/08/2013
 *
 */
@Service("principioFacade")
public class PrincipioFacadeImpl extends AbstractFacadeImpl<Principio, String> implements PrincipioFacade {

	@Autowired
	private PrincipioService principioService;
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 7/08/2013
	 * @see org.memsoa.app.facade.base.AbstractFacadeImpl#getService()
	 */
	@Override
	public AbstractService<Principio, String> getService() throws Exception {
		return principioService;
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 7/08/2013
	 * @see org.memsoa.app.facade.PrincipioFacade#findAll()
	 */
	@Override
	public List<Principio> findAll() throws Exception {
		return principioService.findAll();
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 18/08/2013
	 * @see org.memsoa.app.facade.PrincipioFacade#findByPatron(java.lang.String)
	 */
	@Override
	public List<Principio> findByPatron(String codPatron) throws Exception {
		return principioService.findByPatron(codPatron);
	}

}
