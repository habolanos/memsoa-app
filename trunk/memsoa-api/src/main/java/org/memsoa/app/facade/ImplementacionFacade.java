/**
 * 
 */
package org.memsoa.app.facade;

import java.util.List;

import org.memsoa.app.facade.base.AbstractFacade;
import org.memsoa.app.model.Categoria;
import org.memsoa.app.model.Implementacion;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-api
 * @class ImplementacionFacade
 * @date 23/07/2013
 *
 */
public interface ImplementacionFacade extends AbstractFacade<Implementacion, Long> {

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
