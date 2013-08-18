/**
 * 
 */
package org.memsoa.app.service;

import java.util.List;

import org.memsoa.app.model.Patron;
import org.memsoa.app.service.base.AbstractService;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class PatronService
 * @date 7/08/2013
 *
 */
public interface PatronService  extends AbstractService<Patron, String>{

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
