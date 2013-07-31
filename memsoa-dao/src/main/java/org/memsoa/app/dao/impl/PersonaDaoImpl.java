/**
 * 
 */
package org.memsoa.app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.memsoa.app.dao.PersonaDao;
import org.memsoa.app.dao.base.AbstractDaoImpl;
import org.memsoa.app.model.Persona;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-dao
 * @class PersonaDaoImpl
 * @date 16/07/2013
 *
 */
@Repository
public class PersonaDaoImpl extends AbstractDaoImpl<Persona, String> implements PersonaDao{

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 30/07/2013
	 * @see org.memsoa.app.dao.PersonaDao#findByname(java.lang.String)
	 */
	@Override
	public List<Persona> findByname(String name) throws Exception {
		DetachedCriteria detachedCriteria= DetachedCriteria.forClass(Persona.class);
		if(name!=null && name.length()>0){
			detachedCriteria.add(Restrictions.like("nombreCompleto", name, MatchMode.ANYWHERE));
		}
		Criteria criteria=detachedCriteria.getExecutableCriteria(getSession());
		return criteria.list();
	}

}
