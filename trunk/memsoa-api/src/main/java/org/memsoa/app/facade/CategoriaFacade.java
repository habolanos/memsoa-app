/**
 * 
 */
package org.memsoa.app.facade;

import java.util.List;

import org.memsoa.app.facade.base.AbstractFacade;
import org.memsoa.app.model.Categoria;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-api
 * @class CategoriaFacade
 * @date 23/07/2013
 *
 */
public interface CategoriaFacade extends AbstractFacade<Categoria, String> {

	/**
	 * consulta todas las entidades
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return List<{@link Categoria}>
	 * @throws Exception
	 */
	List<Categoria> findAll()throws Exception;
	
}
