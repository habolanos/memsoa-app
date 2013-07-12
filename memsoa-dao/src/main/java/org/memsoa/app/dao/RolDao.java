/**
 * 
 */
package org.memsoa.app.dao;

import java.util.List;

import org.memsoa.app.dao.base.AbstractDao;
import org.memsoa.app.model.Rol;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-dao
 * @class RolDao
 * @date 11/07/2013
 *
 */
public interface RolDao extends AbstractDao<Rol, String> {

	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @return List<{@link Rol}>
	 * @throws Exception
	 */
	List<Rol> findAll()throws Exception;
}
