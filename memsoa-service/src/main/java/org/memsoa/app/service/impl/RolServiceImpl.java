/**
 * 
 */
package org.memsoa.app.service.impl;

import java.util.List;

import org.memsoa.app.dao.RolDao;
import org.memsoa.app.dao.base.AbstractDao;
import org.memsoa.app.model.Rol;
import org.memsoa.app.service.RolService;
import org.memsoa.app.service.base.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class RolServiceImpl
 * @date 11/07/2013
 *
 */
@Service
public class RolServiceImpl extends AbstractServiceImpl<Rol, String> implements RolService{

	@Autowired
	private RolDao rolDao;
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.service.base.AbstractServiceImpl#getDao()
	 */
	@Override
	public AbstractDao<Rol, String> getDao() throws Exception {
		return rolDao;
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.service.RolService#findAll()
	 */
	@Override
	public List<Rol> findAll() throws Exception {
		return rolDao.findAll();
	}

}
