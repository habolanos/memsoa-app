/**
 * 
 */
package org.memsoa.app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
	 * 
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 18/08/2013
	 * @see org.memsoa.app.dao.CategoriaDao#findByImplementacion(java.lang.Long)
	 */
	@Override
	public List<Categoria> findByImplementacion(Long codImpl) throws Exception {
		Query query= getSession().createQuery("select cate from Categoria cate, ImplementacionCategoria implCate where implCate.codigoCategoria=cate.codigoCategoria and implCate.codigoImplementacion=:codImpl");
		query.setLong("codImpl", codImpl);
		return query.list();
	}
	
	public List<Categoria> findAll() throws Exception {
		DetachedCriteria detachedCriteria= DetachedCriteria.forClass(Categoria.class);
		Criteria criteria=detachedCriteria.getExecutableCriteria(getSession());
		return criteria.list();
	}


}
