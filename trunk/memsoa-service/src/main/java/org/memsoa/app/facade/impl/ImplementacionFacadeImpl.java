/**
 * 
 */
package org.memsoa.app.facade.impl;

import java.util.List;

import org.memsoa.app.api.util.Paginator;
import org.memsoa.app.facade.ImplementacionFacade;
import org.memsoa.app.facade.base.AbstractFacadeImpl;
import org.memsoa.app.model.Implementacion;
import org.memsoa.app.service.ImplementacionService;
import org.memsoa.app.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class ImplementacionFacadeImpl
 * @date 23/07/2013
 *
 */
@Service("implementacionFacade")
public class ImplementacionFacadeImpl extends AbstractFacadeImpl<Implementacion,Long> implements ImplementacionFacade {

	@Autowired
	private ImplementacionService implementacionService;
	
	/**
	 * 
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 30/07/2013
	 * @see org.memsoa.app.facade.ImplementacionFacade#findAll(org.memsoa.app.api.util.Paginator)
	 */
	@Override
	public List<Implementacion> findAll(Paginator paginator) throws Exception {
		return implementacionService.findAll( paginator);
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 23/07/2013
	 * @see org.memsoa.app.facade.base.AbstractFacadeImpl#getService()
	 */
	@Override
	public AbstractService<Implementacion, Long> getService() throws Exception {
		return implementacionService;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 23/07/2013
	 * @see org.memsoa.app.facade.ImplementacionFacade#save(org.memsoa.app.model.Implementacion, java.util.List)
	 */
	@Override
	public void save(Implementacion implementacion, List<String> listCategorias)
			throws Exception {
		implementacionService.save(implementacion, listCategorias);
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 30/07/2013
	 * @see org.memsoa.app.facade.ImplementacionFacade#countAll()
	 */
	@Override
	public Integer countAll() throws Exception {
		return implementacionService.countAll();
	}

}
