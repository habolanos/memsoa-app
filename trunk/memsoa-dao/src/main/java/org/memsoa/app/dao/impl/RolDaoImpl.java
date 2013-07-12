/**
 * 
 */
package org.memsoa.app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.memsoa.app.dao.RolDao;
import org.memsoa.app.dao.base.AbstractDaoImpl;
import org.memsoa.app.model.Rol;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-dao
 * @class RolDaoImpl
 * @date 11/07/2013
 *
 */
@Repository
public class RolDaoImpl extends AbstractDaoImpl<Rol, String> implements RolDao{

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.dao.RolDao#findAll()
	 */
	@Override
	public List<Rol> findAll() throws Exception {
		DetachedCriteria detachedCriteria= DetachedCriteria.forClass(Rol.class);
		Criteria criteria=detachedCriteria.getExecutableCriteria(getSession());
		return criteria.list();
	}

}
