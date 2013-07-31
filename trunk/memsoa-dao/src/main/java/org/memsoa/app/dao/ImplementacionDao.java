/**
 * 
 */
package org.memsoa.app.dao;

import java.util.List;

import org.memsoa.app.api.util.Paginator;
import org.memsoa.app.dao.base.AbstractDao;
import org.memsoa.app.model.Categoria;
import org.memsoa.app.model.Implementacion;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-dao
 * @class ImplementacionCategoriaDao
 * @date 23/07/2013
 *
 */
public interface ImplementacionDao extends AbstractDao<Implementacion, Long>{

	/**
	 * consulta todas las entidades
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return List<{@link Categoria}>
	 * @throws Exception
	 */
	List<Implementacion> findAll(Paginator paginator)throws Exception;
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @return Integer
	 * @throws Exception
	 */
	Integer countAll()throws Exception;
}
