/**
 * 
 */
package org.memsoa.app.service;

import java.util.List;

import org.memsoa.app.model.Categoria;
import org.memsoa.app.model.Implementacion;
import org.memsoa.app.service.base.AbstractService;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class ImplementacionService
 * @date 23/07/2013
 *
 */
public interface ImplementacionService extends AbstractService<Implementacion, Long> {

	/**
	 * consulta todas las entidades
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return List<{@link Categoria}>
	 * @throws Exception
	 */
	List<Implementacion> findAll()throws Exception;
	
	/**
	 * guarda una implementacion y categorias
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @param implementacion
	 * @param listCategorias
	 * @throws Exception
	 */
	void save(Implementacion implementacion,List<String> listCategorias)throws Exception;
}
