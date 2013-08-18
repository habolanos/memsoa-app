/**
 * 
 */
package org.memsoa.app.facade.impl;

import java.util.List;

import org.memsoa.app.facade.CategoriaFacade;
import org.memsoa.app.facade.base.AbstractFacadeImpl;
import org.memsoa.app.model.Categoria;
import org.memsoa.app.service.CategoriaService;
import org.memsoa.app.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class CategoriaFacadeImpl
 * @date 23/07/2013
 *
 */
@Service("categoriaFacade")
public class CategoriaFacadeImpl extends AbstractFacadeImpl<Categoria,String> implements CategoriaFacade{

	@Autowired
	private CategoriaService categoriaService;
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 23/07/2013
	 * @see org.memsoa.app.facade.base.AbstractFacadeImpl#getService()
	 */
	@Override
	public AbstractService<Categoria, String> getService() throws Exception {
		return categoriaService;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 18/08/2013
	 * @see org.memsoa.app.facade.CategoriaFacade#findByImplementacion(java.lang.Long)
	 */
	@Override
	public List<Categoria> findByImplementacion(Long codImpl) throws Exception {
		return categoriaService.findByImplementacion(codImpl);
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 18/08/2013
	 * @see org.memsoa.app.facade.CategoriaFacade#findAll()
	 */
	@Override
	public List<Categoria> findAll() throws Exception {
		return categoriaService.findAll();
	}


}
