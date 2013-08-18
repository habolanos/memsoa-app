/**
 * 
 */
package org.memsoa.app.service.impl;

import java.util.List;

import org.memsoa.app.dao.PrincipioDao;
import org.memsoa.app.dao.base.AbstractDao;
import org.memsoa.app.model.Principio;
import org.memsoa.app.service.PrincipioService;
import org.memsoa.app.service.base.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class PrincipioServiceImpl
 * @date 7/08/2013
 *
 */
@Service
public class PrincipioServiceImpl extends AbstractServiceImpl<Principio,String> implements PrincipioService {

	@Autowired
	private PrincipioDao principioDao;
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 7/08/2013
	 * @see org.memsoa.app.service.base.AbstractServiceImpl#getDao()
	 */
	@Override
	public AbstractDao<Principio, String> getDao() throws Exception {
		return principioDao;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 7/08/2013
	 * @see org.memsoa.app.service.PrincipioService#findAll()
	 */
	@Override
	public List<Principio> findAll() throws Exception {
		return principioDao.findAll();
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 18/08/2013
	 * @see org.memsoa.app.service.PrincipioService#findByPatron(java.lang.String)
	 */
	@Override
	public List<Principio> findByPatron(String codPatron) throws Exception {
		return principioDao.findByPatron(codPatron);
	}

}
