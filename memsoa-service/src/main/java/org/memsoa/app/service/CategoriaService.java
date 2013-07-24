/**
 * 
 */
package org.memsoa.app.service;

import java.util.List;

import org.memsoa.app.model.Categoria;
import org.memsoa.app.service.base.AbstractService;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class CategoriaService
 * @date 23/07/2013
 *
 */
public interface CategoriaService  extends AbstractService<Categoria, String>{

	/**
	 * consulta todas las entidades
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return List<{@link Categoria}>
	 * @throws Exception
	 */
	List<Categoria> findAll()throws Exception;
}
