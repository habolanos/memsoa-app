/**
 * 
 */
package org.memsoa.app.dao;

import java.util.List;

import org.memsoa.app.dao.base.AbstractDao;
import org.memsoa.app.model.Categoria;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-dao
 * @class CategoriaDao
 * @date 23/07/2013
 *
 */
public interface CategoriaDao extends AbstractDao<Categoria, String>{

	/**
	 * consulta todas las entidades
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return List<{@link Categoria}>
	 * @throws Exception
	 */
	List<Categoria> findAll()throws Exception;
	
}
