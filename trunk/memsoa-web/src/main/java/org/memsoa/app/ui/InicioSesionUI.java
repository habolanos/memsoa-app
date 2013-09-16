/**
 * 
 */
package org.memsoa.app.ui;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.memsoa.app.facade.PersonaFacade;
import org.memsoa.app.model.Persona;
import org.memsoa.app.ui.support.AbstractUI;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-web
 * @class InicioSesionUI
 * @date 15/09/2013
 *
 */
@ManagedBean
@ViewScoped
public class InicioSesionUI extends  AbstractUI<Persona> implements Serializable{

	
	private static final long serialVersionUID = 3929009305536199226L;
	@ManagedProperty("#{personaFacade}")
	private PersonaFacade personaFacade; 
	private String email;
	private String clave;
	private Persona persona;
	
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 15/09/2013
	 */
	public String actionValidate(){
		try {
			if(email==null || email.length()<1){
				error("msg-inicio","MSG_NO_EMAIL");
				return "";
			}
			if(clave==null || clave.length()<1){
				error("msg-inicio","MSG_NO_CLAVE");
				return "";
			}
			Persona persona= personaFacade.findByEmailClave(email, clave);
			if(persona==null){
				error("msg-inicio","MSG_NO_AUTORIZADO");
				return "";
			}
			this.getSession().setAttribute("Persona", persona);
		} catch (Exception e) {
			error("msg-inicio","MSG_NO_AUTORIZADO");
			return "";
		}
		return "goInbox";
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 15/09/2013
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 15/09/2013
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 15/09/2013
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 15/09/2013
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 15/09/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#isDefaultAscending(java.lang.String)
	 */
	@Override
	protected boolean isDefaultAscending(String sortColumn) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 15/09/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#findDataModelEntries(int, int, java.lang.String)
	 */
	@Override
	protected List<Persona> findDataModelEntries(int startRow, int pageSize,
			String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 15/09/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#countDataModel()
	 */
	@Override
	protected int countDataModel() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 15/09/2013
	 * @return the personaFacade
	 */
	public PersonaFacade getPersonaFacade() {
		return personaFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 15/09/2013
	 * @param personaFacade the personaFacade to set
	 */
	public void setPersonaFacade(PersonaFacade personaFacade) {
		this.personaFacade = personaFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 15/09/2013
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 15/09/2013
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
