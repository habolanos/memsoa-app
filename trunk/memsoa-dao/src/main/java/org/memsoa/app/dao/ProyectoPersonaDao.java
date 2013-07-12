/**
 * 
 */
package org.memsoa.app.dao;

import java.util.List;

import org.memsoa.app.api.util.Paginator;
import org.memsoa.app.dao.base.AbstractDao;
import org.memsoa.app.model.Proyecto;
import org.memsoa.app.model.ProyectoPersona;
import org.memsoa.app.model.ProyectoPersonaId;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-dao
 * @class ProyectoPersonaDao
 * @date 11/07/2013
 *
 */
public interface ProyectoPersonaDao extends AbstractDao<ProyectoPersona, ProyectoPersonaId>{

	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @param nombre
	 * @param codigoRol
	 * @param estado
	 * @param paginator
	 * @return List<{@link ProyectoPersona}>
	 * @throws Exception
	 */
	List<ProyectoPersona> findByNameRolEstado(String nombre,String codigoRol,String estado,Paginator paginator)throws Exception;
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @param nombre
	 * @param codigoRol
	 * @param estado
	 * @return {@link Integer}
	 * @throws Exception
	 */
	Integer countByNameRolEstado(String nombre,String codigoRol,String estado)throws Exception;
}
