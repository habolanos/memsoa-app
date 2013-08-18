/**
 * 
 */
package org.memsoa.app.service.impl;

import java.util.List;

import org.memsoa.app.dao.PatronDao;
import org.memsoa.app.dao.base.AbstractDao;
import org.memsoa.app.model.Patron;
import org.memsoa.app.service.PatronService;
import org.memsoa.app.service.base.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class PatronServiceImpl
 * @date 7/08/2013
 *
 */
@Service
public class PatronServiceImpl extends AbstractServiceImpl<Patron,String> implements PatronService {

	@Autowired
	private PatronDao patronDao;
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 7/08/2013
	 * @see org.memsoa.app.service.base.AbstractServiceImpl#getDao()
	 */
	@Override
	public AbstractDao<Patron, String> getDao() throws Exception {
		return patronDao;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 7/08/2013
	 * @see org.memsoa.app.service.PatronService#findAll()
	 */
	@Override
	public List<Patron> findAll() throws Exception {
		return patronDao.findAll();
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 18/08/2013
	 * @see org.memsoa.app.service.PatronService#findByCategoria(java.lang.String)
	 */
	@Override
	public List<Patron> findByCategoria(String codCate) throws Exception {
		return patronDao.findByCategoria(codCate);
	}

}
