/**
 * 
 */
package org.memsoa.app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.memsoa.app.dao.CategoriaDao;
import org.memsoa.app.dao.base.AbstractDaoImpl;
import org.memsoa.app.model.Categoria;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-dao
 * @class CategoriaDaoImpl
 * @date 23/07/2013
 *
 */
@Repository
public class CategoriaDaoImpl extends AbstractDaoImpl<Categoria, String> implements CategoriaDao{

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 23/07/2013
	 * @see org.memsoa.app.dao.CategoriaDao#findAll()
	 */
	@Override
	public List<Categoria> findAll() throws Exception {
		DetachedCriteria detachedCriteria= DetachedCriteria.forClass(Categoria.class);
		Criteria criteria=detachedCriteria.getExecutableCriteria(getSession());
		return criteria.list();
	}

}
