/**
 * 
 */
package org.memsoa.app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.memsoa.app.api.util.Paginator;
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
	 * 
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 30/07/2013
	 * @see org.memsoa.app.dao.ImplementacionDao#findAll(org.memsoa.app.api.util.Paginator)
	 */
	@Override
	public List<Implementacion> findAll(Paginator paginator) throws Exception {
		DetachedCriteria detachedCriteria= DetachedCriteria.forClass(Implementacion.class);
		Criteria criteria=detachedCriteria.getExecutableCriteria(getSession());
		if(paginator!=null){
			if(paginator.getFirstResult()>0){
				criteria.setFirstResult(paginator.getFirstResult());
			}
			if(paginator.getMaxResults()>0){
				criteria.setMaxResults(paginator.getMaxResults());
			}
		}
		return criteria.list();
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 30/07/2013
	 * @see org.memsoa.app.dao.ImplementacionDao#countAll()
	 */
	@Override
	public Integer countAll() throws Exception {
		DetachedCriteria detachedCriteria= DetachedCriteria.forClass(Implementacion.class);
		detachedCriteria.setProjection(Projections.rowCount());
		Criteria criteria=detachedCriteria.getExecutableCriteria(getSession());
		return ((Number)criteria.uniqueResult()).intValue();
	}

}
