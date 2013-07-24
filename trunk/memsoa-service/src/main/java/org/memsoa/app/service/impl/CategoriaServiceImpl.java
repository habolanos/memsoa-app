/**
 * 
 */
package org.memsoa.app.service.impl;

import java.util.List;

import org.memsoa.app.dao.CategoriaDao;
import org.memsoa.app.dao.base.AbstractDao;
import org.memsoa.app.model.Categoria;
import org.memsoa.app.service.CategoriaService;
import org.memsoa.app.service.base.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class CategoriaServiceImpl
 * @date 23/07/2013
 *
 */
@Service
public class CategoriaServiceImpl extends AbstractServiceImpl<Categoria,String> implements CategoriaService{

	@Autowired
	private CategoriaDao categoriaDao;
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 23/07/2013
	 * @see org.memsoa.app.service.base.AbstractServiceImpl#getDao()
	 */
	@Override
	public AbstractDao<Categoria, String> getDao() throws Exception {
		return categoriaDao;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 23/07/2013
	 * @see org.memsoa.app.service.CategoriaService#findAll()
	 */
	@Override
	public List<Categoria> findAll() throws Exception {
		return categoriaDao.findAll();
	}

}
