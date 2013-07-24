/**
 * 
 */
package org.memsoa.app.service.impl;

import java.util.Date;
import java.util.List;

import org.memsoa.app.dao.ImplementacionCategoriaDao;
import org.memsoa.app.dao.ImplementacionDao;
import org.memsoa.app.dao.base.AbstractDao;
import org.memsoa.app.model.Implementacion;
import org.memsoa.app.model.ImplementacionCategoria;
import org.memsoa.app.service.ImplementacionService;
import org.memsoa.app.service.base.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class ImplementacionServiceImpl
 * @date 23/07/2013
 *
 */
@Service
public class ImplementacionServiceImpl extends AbstractServiceImpl<Implementacion,Long> implements ImplementacionService {

	@Autowired
	private ImplementacionDao implementacionDao;
	@Autowired
	private ImplementacionCategoriaDao implementacionCategoriaDao;
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 23/07/2013
	 * @see org.memsoa.app.service.ImplementacionService#findAll()
	 */
	@Override
	public List<Implementacion> findAll() throws Exception {
		return implementacionDao.findAll();
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 23/07/2013
	 * @see org.memsoa.app.service.base.AbstractServiceImpl#getDao()
	 */
	@Override
	public AbstractDao<Implementacion, Long> getDao() throws Exception {
		return implementacionDao;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 23/07/2013
	 * @see org.memsoa.app.service.ImplementacionService#save(org.memsoa.app.model.Implementacion, java.util.List)
	 */
	@Override
	public void save(Implementacion implementacion, List<String> listCategorias)
			throws Exception {
		implementacionDao.save(implementacion);
		for (String categoria : listCategorias) {
			implementacionCategoriaDao.save(new ImplementacionCategoria(new Date(),categoria, implementacion.getCodigoImplementacion()));
		}
	}

}
