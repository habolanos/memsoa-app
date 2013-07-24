/**
 * 
 */
package org.memsoa.app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.memsoa.app.dao.ImplementacionDao;
import org.memsoa.app.dao.base.AbstractDaoImpl;
import org.memsoa.app.model.Implementacion;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-dao
 * @class ImplementacionDaoImpl
 * @date 23/07/2013
 *
 */
@Repository
public class ImplementacionDaoImpl extends AbstractDaoImpl<Implementacion, Long> implements ImplementacionDao {

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 23/07/2013
	 * @see org.memsoa.app.dao.ImplementacionDao#findAll()
	 */
	@Override
	public List<Implementacion> findAll() throws Exception {
		DetachedCriteria detachedCriteria= DetachedCriteria.forClass(Implementacion.class);
		Criteria criteria=detachedCriteria.getExecutableCriteria(getSession());
		return criteria.list();
	}

}
