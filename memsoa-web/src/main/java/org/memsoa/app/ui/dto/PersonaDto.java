/**
 * 
 */
package org.memsoa.app.ui.dto;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.memsoa.app.facade.PersonaFacade;
import org.memsoa.app.model.Persona;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-web
 * @class PersonaDto
 * @date 30/07/2013
 *
 */
public class PersonaDto extends Persona implements Converter{

	@ManagedProperty("#{personaFacade}")
	private PersonaFacade personaFacade;
	
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 30/07/2013
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.trim().equals("")) {  
            return null;  
        } else {  
            try {  
            	return personaFacade.findById(value);
            } catch(Exception exception) {  
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Conversion", "Persona no valida"));  
            }  
        }  
  
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 30/07/2013
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		 if (value == null || value.equals("")) {  
	            return "";  
	        } else {  
	            return String.valueOf(((Persona) value).getCodigoPersona());  
	        }  
	}

}
