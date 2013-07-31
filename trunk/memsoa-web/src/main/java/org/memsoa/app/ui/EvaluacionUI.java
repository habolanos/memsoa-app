/**
 * 
 */
package org.memsoa.app.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.memsoa.app.facade.ImplementacionFacade;
import org.memsoa.app.facade.PersonaFacade;
import org.memsoa.app.facade.ProyectoFacade;
import org.memsoa.app.model.Evaluacion;
import org.memsoa.app.model.Implementacion;
import org.memsoa.app.model.Persona;
import org.memsoa.app.model.Proyecto;
import org.memsoa.app.ui.support.AbstractUI;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-web
 * @class EvaluacionUI
 * @date 30/07/2013
 *
 */
@ManagedBean
@ViewScoped
public class EvaluacionUI extends AbstractUI<Evaluacion> implements Serializable{

	private Logger logger= Logger.getLogger(EvaluacionUI.class);
	private Evaluacion evaluacion;
	@ManagedProperty("#{implementacionFacade}")
	private ImplementacionFacade implementacionFacade;
	@ManagedProperty("#{proyectoFacade}")
	private ProyectoFacade proyectoFacade;
	@ManagedProperty("#{personaFacade}")
	private PersonaFacade personaFacade;
	private List<SelectItem> listImplementaciones;
	private Proyecto proyecto;
	
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 */
	@PostConstruct
	private void init(){
		evaluacion= new Evaluacion();
		try {
			String id=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idProject");
			proyecto=proyectoFacade.findById(Long.parseLong(id));
			evaluacion= new Evaluacion();
			evaluacion.setPersona(new Persona());
			evaluacion.setImplementacion(new Implementacion());
		} catch (Exception e) {
			logger.error(e);
		}
	}
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 */
	public void actionGuardar(){
		
	}
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 */
	public void actionLimpiar(){
		
	}
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 */
	public void actionRegresar(){
		
	}
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @param event
	 */
	 public List<Persona> completePersona(String query){
		 List<Persona> listPersonas=new ArrayList<Persona>();
		try {
			listPersonas = personaFacade.findByname(query);
		} catch (Exception e) {
			error(e.getMessage());
		}
		 return listPersonas;
	 } 
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 */
	public void actionShowPopupPersona(){
		
	}
	
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @return the listImplementaciones
	 */
	public List<SelectItem> getListImplementaciones() {
		try {
			if(listImplementaciones==null){
				List<Implementacion> list=implementacionFacade.findAll(null);
				listImplementaciones= new ArrayList<SelectItem>();
				listImplementaciones.add(new SelectItem("0",getMessage("i18n.messages", "DEFAULT_SELECT_TIEM")));
				for (Implementacion impl : list) {
					listImplementaciones.add(new SelectItem(impl.getCodigoImplementacion(),impl.getNombre()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listImplementaciones;
	}


	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 30/07/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#isDefaultAscending(java.lang.String)
	 */
	@Override
	protected boolean isDefaultAscending(String sortColumn) {
		return false;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 30/07/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#findDataModelEntries(int, int, java.lang.String)
	 */
	@Override
	protected List<Evaluacion> findDataModelEntries(int startRow, int pageSize,
			String sort) {
		return null;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 30/07/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#countDataModel()
	 */
	@Override
	protected int countDataModel() {
		return 0;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @return the evaluacion
	 */
	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @param evaluacion the evaluacion to set
	 */
	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @return the implementacionFacade
	 */
	public ImplementacionFacade getImplementacionFacade() {
		return implementacionFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @param implementacionFacade the implementacionFacade to set
	 */
	public void setImplementacionFacade(ImplementacionFacade implementacionFacade) {
		this.implementacionFacade = implementacionFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @param listImplementaciones the listImplementaciones to set
	 */
	public void setListImplementaciones(List<SelectItem> listImplementaciones) {
		this.listImplementaciones = listImplementaciones;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @return the proyecto
	 */
	public Proyecto getProyecto() {
		return proyecto;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @param proyecto the proyecto to set
	 */
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @return the proyectoFacade
	 */
	public ProyectoFacade getProyectoFacade() {
		return proyectoFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @param proyectoFacade the proyectoFacade to set
	 */
	public void setProyectoFacade(ProyectoFacade proyectoFacade) {
		this.proyectoFacade = proyectoFacade;
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @return the personaFacade
	 */
	public PersonaFacade getPersonaFacade() {
		return personaFacade;
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @param personaFacade the personaFacade to set
	 */
	public void setPersonaFacade(PersonaFacade personaFacade) {
		this.personaFacade = personaFacade;
	}
}
