/**
 * 
 */
package org.memsoa.app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.memsoa.app.dao.PrincipioDao;
import org.memsoa.app.dao.base.AbstractDaoImpl;
import org.memsoa.app.model.PatronPrincipio;
import org.memsoa.app.model.Principio;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-dao
 * @class PrincipioDaoImpl
 * @date 7/08/2013
 *
 */
@Repository
public class PrincipioDaoImpl  extends AbstractDaoImpl<Principio, String> implements PrincipioDao {

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 7/08/2013
	 * @see org.memsoa.app.dao.PrincipioDao#findAll()
	 */
	@Override
	public List<Principio> findAll() throws Exception {
		DetachedCriteria detachedCriteria= DetachedCriteria.forClass(Principio.class);
		Criteria criteria=detachedCriteria.getExecutableCriteria(getSession());
		return criteria.list();
	}
	/**
	 * 
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 18/08/2013
	 * @see org.memsoa.app.dao.PrincipioDao#findByPatron(java.lang.String)
	 */
	public List<Principio> findByPatron(String codPatron) throws Exception {
		Query query=getSession().createQuery("Select prin from Principio prin,PatronPrincipio patPrinc where prin.codigoPrincipio=patPrinc.codigoPrincipio and patPrinc.codigoPatron=:codPatron");
		query.setString("codPatron",codPatron);
		return query.list();
	}

}
