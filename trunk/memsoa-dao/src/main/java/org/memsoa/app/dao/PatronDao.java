/**
 * 
 */
package org.memsoa.app.dao;

import java.util.List;

import org.memsoa.app.dao.base.AbstractDao;
import org.memsoa.app.model.Patron;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-dao
 * @class PatronDao
 * @date 7/08/2013
 *
 */
public interface PatronDao extends AbstractDao<Patron, String> {

	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return List<{@link Patron}>
	 * @throws Exception
	 */
	public List<Patron> findAll() throws Exception;
	
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @param codCate
	 * @return  List<{@link Patron}>
	 * @throws Exception
	 */
	 List<Patron> findByCategoria(String codCate) throws Exception;
}
