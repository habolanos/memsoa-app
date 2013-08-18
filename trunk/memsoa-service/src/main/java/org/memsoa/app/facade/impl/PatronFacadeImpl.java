/**
 * 
 */
package org.memsoa.app.facade.impl;

import java.util.List;

import org.memsoa.app.facade.PatronFacade;
import org.memsoa.app.facade.base.AbstractFacadeImpl;
import org.memsoa.app.model.Patron;
import org.memsoa.app.service.PatronService;
import org.memsoa.app.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class PatronFacadeImpl
 * @date 7/08/2013
 *
 */
@Service("patronFacade")
public class PatronFacadeImpl extends AbstractFacadeImpl<Patron, String> implements PatronFacade {

	@Autowired
	private PatronService patronService;
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 7/08/2013
	 * @see org.memsoa.app.facade.base.AbstractFacadeImpl#getService()
	 */
	@Override
	public AbstractService<Patron, String> getService() throws Exception {
		return patronService;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 7/08/2013
	 * @see org.memsoa.app.facade.PatronFacade#findAll()
	 */
	@Override
	public List<Patron> findAll() throws Exception {
		return patronService.findAll();
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 18/08/2013
	 * @see org.memsoa.app.facade.PatronFacade#findByCategoria(java.lang.String)
	 */
	@Override
	public List<Patron> findByCategoria(String codCate) throws Exception {
		return patronService.findByCategoria(codCate);
	}

}
