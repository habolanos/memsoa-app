/**
 * 
 */
package org.memsoa.app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.memsoa.app.dao.PatronDao;
import org.memsoa.app.dao.base.AbstractDaoImpl;
import org.memsoa.app.model.Patron;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-dao
 * @class PatronDaoImpl
 * @date 7/08/2013
 *
 */
@Repository
public class PatronDaoImpl extends AbstractDaoImpl<Patron, String> implements PatronDao {

	/**
	 * 
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 7/08/2013
	 * @see org.memsoa.app.dao.PatronDao#findAll()
	 */
	public List<Patron> findAll() throws Exception {
		DetachedCriteria detachedCriteria= DetachedCriteria.forClass(Patron.class);
		Criteria criteria=detachedCriteria.getExecutableCriteria(getSession());
		return criteria.list();
	}
	
	public List<Patron> findByCategoria(String codCate) throws Exception {
		DetachedCriteria detachedCriteria= DetachedCriteria.forClass(Patron.class);
		detachedCriteria.add(Restrictions.eq("categoria.codigoCategoria", codCate));
		Criteria criteria=detachedCriteria.getExecutableCriteria(getSession());
		return criteria.list();
	}
}
