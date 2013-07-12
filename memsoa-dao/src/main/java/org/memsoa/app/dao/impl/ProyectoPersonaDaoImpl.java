/**
 * 
 */
package org.memsoa.app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.memsoa.app.api.enums.EstadoProyectoEnum;
import org.memsoa.app.api.util.Paginator;
import org.memsoa.app.dao.ProyectoPersonaDao;
import org.memsoa.app.dao.base.AbstractDaoImpl;
import org.memsoa.app.model.ProyectoPersona;
import org.memsoa.app.model.ProyectoPersonaId;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-dao
 * @class ProyectoPersonaDaoImpl
 * @date 11/07/2013
 *
 */
@Repository
public class ProyectoPersonaDaoImpl extends AbstractDaoImpl<ProyectoPersona, ProyectoPersonaId> implements ProyectoPersonaDao{

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.dao.ProyectoPersonaDao#findByNameRolEstado(java.lang.String, java.lang.String, java.lang.String, org.memsoa.app.api.util.Paginator)
	 */
	@Override
	public List<ProyectoPersona> findByNameRolEstado(String nombre, String codigoRol,
			String estado, Paginator paginator) throws Exception {
		DetachedCriteria detachedCriteria=createDetached(nombre, codigoRol, estado);
		Criteria criteria= detachedCriteria.getExecutableCriteria(getSession());
		if(paginator!=null && paginator.getFirstResult()>0 && paginator.getMaxResults()>0){
			criteria.setMaxResults(paginator.getMaxResults());
			criteria.setFirstResult(paginator.getFirstResult());
		}
		return criteria.list();
	}


	private DetachedCriteria createDetached(String nombre, String codigoRol,
			String estado)throws Exception {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(ProyectoPersona.class,"proyectoPersona");
		boolean putProyecto=true;
		if(nombre!=null && nombre.length()>0 ){
			detachedCriteria.setFetchMode("proyectoPersona.proyecto", FetchMode.JOIN);
			detachedCriteria.createAlias("proyecto", "proy");
			putProyecto=false;
			detachedCriteria.add(Restrictions.like("proy.nombre", nombre, MatchMode.ANYWHERE));
		}
		if(codigoRol!=null && codigoRol.length()>0 && !codigoRol.equals("0")){
			detachedCriteria.add(Restrictions.eq("id.codigoRol", codigoRol));
		}
		if(estado!=null && estado.length()>0 && !estado.equals(EstadoProyectoEnum.DEFAULT.name())){
			if(putProyecto){
				detachedCriteria.setFetchMode("proyectoPersona.proyecto", FetchMode.JOIN);
				detachedCriteria.createAlias("proyecto", "proy");
			}
			detachedCriteria.add(Restrictions.like("proy.estado", nombre, MatchMode.ANYWHERE));
		}
		return detachedCriteria;
	} 
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.dao.ProyectoPersonaDao#countByNameRolEstado(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Integer countByNameRolEstado(String nombre, String codigoRol,
			String estado) throws Exception {
		DetachedCriteria detachedCriteria=createDetached(nombre, codigoRol, estado);
		detachedCriteria.setProjection(Projections.rowCount());
		Criteria criteria= detachedCriteria.getExecutableCriteria(getSession());
		return ((Number)criteria.uniqueResult()).intValue();
	}



}
