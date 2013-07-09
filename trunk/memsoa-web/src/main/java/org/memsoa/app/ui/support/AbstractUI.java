/**
 * 
 */
package org.memsoa.app.ui.support;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project test-web
 * @class AbstractUI
 * @date 25/06/2013
 *
 */
public abstract class AbstractUI<T> extends AbstractDataPaginatorUI<T>{

	private static final String MESSAGE_NOT_FOUND_PREFIX = "??";
	private static final String CURRENT_LOCALE = "currentLocale";
	
	/**
	 * retorna un mensaje con el nombre del archivo y la propiedad
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 25/06/2013
	 * @param messageBundle
	 * @param key
	 * @return {@link String}
	 */
	protected static String getMessage(String messageBundle, String key) {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(messageBundle, getLocale());
			return bundle.getString(key);
		} catch (Exception e) {
			return MESSAGE_NOT_FOUND_PREFIX + key + MESSAGE_NOT_FOUND_PREFIX;
		}
	}
	
	/**
	 * retorna el locale que se etsa utilizando
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 25/06/2013
	 * @return {@link Locale}
	 */
	protected static Locale getLocale() {
		Locale currentLocale = (Locale) getSession().getAttribute(CURRENT_LOCALE);
		if (currentLocale != null) {
			return currentLocale;
		}
		return getFacesContext().getViewRoot().getLocale();
	}
	/**
	 * retorna la seesion Web
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 25/06/2013
	 * @return {@link HttpSession}
	 */
	protected static HttpSession getSession() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		HttpSession session = request.getSession();
		return session;
	}
	/**
	 * retorna el facesContext
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 25/06/2013
	 * @return {@link FacesContext}
	 */
	protected static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	
}
