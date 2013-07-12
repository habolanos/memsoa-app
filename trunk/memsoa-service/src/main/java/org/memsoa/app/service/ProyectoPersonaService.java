/**
 * 
 */
package org.memsoa.app.service;

import java.util.List;

import org.memsoa.app.api.util.Paginator;
import org.memsoa.app.model.ProyectoPersona;
import org.memsoa.app.model.ProyectoPersonaId;
import org.memsoa.app.service.base.AbstractService;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class ProyectoPersonaService
 * @date 11/07/2013
 *
 */
public interface ProyectoPersonaService extends AbstractService<ProyectoPersona, ProyectoPersonaId>{

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
