/**
 * 
 */
package org.memsoa.app.model;

import java.io.Serializable;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-model
 * @class PatronPrincipio
 * @date 18/08/2013
 *
 */
public class PatronPrincipio implements Serializable{

	private String codigoPatron;
	private String codigoPrincipio;
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @return the codigoPatron
	 */
	public String getCodigoPatron() {
		return codigoPatron;
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @param codigoPatron the codigoPatron to set
	 */
	public void setCodigoPatron(String codigoPatron) {
		this.codigoPatron = codigoPatron;
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @return the codigoPrincipio
	 */
	public String getCodigoPrincipio() {
		return codigoPrincipio;
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @param codigoPrincipio the codigoPrincipio to set
	 */
	public void setCodigoPrincipio(String codigoPrincipio) {
		this.codigoPrincipio = codigoPrincipio;
	}
	
	
	
}
