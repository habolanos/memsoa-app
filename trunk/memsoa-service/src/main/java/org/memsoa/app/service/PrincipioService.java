/**
 * 
 */
package org.memsoa.app.service;

import java.util.List;

import org.memsoa.app.model.Principio;
import org.memsoa.app.service.base.AbstractService;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-service
 * @class PrincipioService
 * @date 7/08/2013
 *
 */
public interface PrincipioService  extends AbstractService<Principio, String>{

	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return List<{@link Principio}>
	 * @throws Exception
	 */
	public List<Principio> findAll() throws Exception;
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @param codPatron
	 * @return List<{@link Principio}>
	 * @throws Exception
	 */
	List<Principio> findByPatron(String codPatron) throws Exception;
}
