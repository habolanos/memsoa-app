/**
 * 
 */
package org.memsoa.app.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.memsoa.app.facade.CategoriaFacade;
import org.memsoa.app.facade.ImplementacionFacade;
import org.memsoa.app.facade.PatronFacade;
import org.memsoa.app.facade.PrincipioFacade;
import org.memsoa.app.facade.ProyectoFacade;
import org.memsoa.app.facade.ProyectoPersonaFacade;
import org.memsoa.app.model.Categoria;
import org.memsoa.app.model.Evaluacion;
import org.memsoa.app.model.Implementacion;
import org.memsoa.app.model.Patron;
import org.memsoa.app.model.Principio;
import org.memsoa.app.model.Proyecto;
import org.memsoa.app.model.ProyectoPersona;
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
	@ManagedProperty("#{implementacionFacade}")
	private ImplementacionFacade implementacionFacade;
	@ManagedProperty("#{proyectoFacade}")
	private ProyectoFacade proyectoFacade;
	@ManagedProperty("#{proyectoPersonaFacade}")
	private ProyectoPersonaFacade proyectoPersonaFacade;
	@ManagedProperty("#{patronFacade}")
	private PatronFacade patronFacade;
	@ManagedProperty("#{principioFacade}")
	private PrincipioFacade principioFacade;
	@ManagedProperty("#{categoriaFacade}")
	private CategoriaFacade categoriaFacade;
	private List<SelectItem> listImplementacion;
	private List<SelectItem> listPatrones;
	private List<SelectItem> listCategorias;
	private List<SelectItem> listPrincipios;
	private Evaluacion evaluacion;
	private Proyecto proyecto;
	private ProyectoPersona proyectoPersona;
	private Patron patron;
	private Principio principio;
	private Categoria categoria;
	
	@PostConstruct
	private void init(){
		try {
			categoria= new Categoria();
			principio= new Principio();
			patron= new Patron();
			evaluacion= new Evaluacion();
			evaluacion.setImplementacion(new Implementacion());
			evaluacion.setFechaActualizacion(new Date());
			String id=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idProject");
			proyecto=proyectoFacade.findById(Long.parseLong(id));
			proyectoPersona=proyectoPersonaFacade.findByid(Long.parseLong(id), "1","1");
		} catch (Exception e) {
			logger.error(e);
		}
				
	}

	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @param codImple
	 */
	public void listenerImplementacion(Long codImple){
		try {
			List<Categoria> listCate=categoriaFacade.findByImplementacion(codImple);
			listCategorias= new ArrayList<SelectItem>();
			listCategorias.add(new SelectItem("", getMessage("i18n.message", "DEFAULT_SELECT_TIEM")));
			if(listCate!=null){
				for (Categoria categoria : listCate) {
					listCategorias.add(new SelectItem(categoria.getCodigoCategoria(), categoria.getNombre()));
				}
			}
		} catch (Exception e) {
			error(e.getMessage());
		}
	}
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @param codPatron
	 */
	public void listenerPatron(String codPatron){
		try {
			List<Principio> listPrin=principioFacade.findByPatron(codPatron);
			listPrincipios= new ArrayList<SelectItem>();
			listPrincipios.add(new SelectItem("", getMessage("i18n.message", "DEFAULT_SELECT_TIEM")));
			if(listPrin!=null){
				for (Principio prin : listPrin) {
					listPrincipios.add(new SelectItem(prin.getCodigoPrincipio(), prin.getNombre()));
				}
			}
		} catch (Exception e) {
			error(e.getMessage());
		}
	}

	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @param codCate
	 */
	public void listenerCategoria(String codCate){
		try {
			List<Patron> listPa=patronFacade.findByCategoria(codCate);
			listPatrones= new ArrayList<SelectItem>();
			listPatrones.add(new SelectItem("", getMessage("i18n.message", "DEFAULT_SELECT_TIEM")));
			if(listPa!=null){
				for (Patron pa : listPa) {
					listPatrones.add(new SelectItem(pa.getCodigoPatron(), pa.getNombre()));
				}
			}
		} catch (Exception e) {
			error(e.getMessage());
		}
	}
	
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return the listImplementacion
	 */
	public List<SelectItem> getListImplementacion() {
		try {
			if(listImplementacion==null){
				List<Implementacion> listImpl=implementacionFacade.findAll(null);
				if(listImpl!=null && listImpl.size()>0){
					listImplementacion= new ArrayList<SelectItem>();
					listImplementacion.add(new SelectItem(0,"seleccione"));
					for (Implementacion implementacion : listImpl) {
						listImplementacion.add(new SelectItem(implementacion.getCodigoImplementacion(), implementacion.getNombre()));
					}
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return listImplementacion;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @param listImplementacion the listImplementacion to set
	 */
	public void setListImplementacion(List<SelectItem> listImplementacion) {
		this.listImplementacion = listImplementacion;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return the implementacionFacade
	 */
	public ImplementacionFacade getImplementacionFacade() {
		return implementacionFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @param implementacionFacade the implementacionFacade to set
	 */
	public void setImplementacionFacade(ImplementacionFacade implementacionFacade) {
		this.implementacionFacade = implementacionFacade;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 7/08/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#isDefaultAscending(java.lang.String)
	 */
	@Override
	protected boolean isDefaultAscending(String sortColumn) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 7/08/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#findDataModelEntries(int, int, java.lang.String)
	 */
	@Override
	protected List<Evaluacion> findDataModelEntries(int startRow, int pageSize,
			String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 7/08/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#countDataModel()
	 */
	@Override
	protected int countDataModel() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return the evaluacion
	 */
	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @param evaluacion the evaluacion to set
	 */
	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return the proyectoFacade
	 */
	public ProyectoFacade getProyectoFacade() {
		return proyectoFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @param proyectoFacade the proyectoFacade to set
	 */
	public void setProyectoFacade(ProyectoFacade proyectoFacade) {
		this.proyectoFacade = proyectoFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return the proyecto
	 */
	public Proyecto getProyecto() {
		return proyecto;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @param proyecto the proyecto to set
	 */
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return the proyectoPersonaFacade
	 */
	public ProyectoPersonaFacade getProyectoPersonaFacade() {
		return proyectoPersonaFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @param proyectoPersonaFacade the proyectoPersonaFacade to set
	 */
	public void setProyectoPersonaFacade(ProyectoPersonaFacade proyectoPersonaFacade) {
		this.proyectoPersonaFacade = proyectoPersonaFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return the proyectoPersona
	 */
	public ProyectoPersona getProyectoPersona() {
		return proyectoPersona;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @param proyectoPersona the proyectoPersona to set
	 */
	public void setProyectoPersona(ProyectoPersona proyectoPersona) {
		this.proyectoPersona = proyectoPersona;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return the patronFacade
	 */
	public PatronFacade getPatronFacade() {
		return patronFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @param patronFacade the patronFacade to set
	 */
	public void setPatronFacade(PatronFacade patronFacade) {
		this.patronFacade = patronFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return the principioFacade
	 */
	public PrincipioFacade getPrincipioFacade() {
		return principioFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @param principioFacade the principioFacade to set
	 */
	public void setPrincipioFacade(PrincipioFacade principioFacade) {
		this.principioFacade = principioFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return the listPatrones
	 */
	public List<SelectItem> getListPatrones() {
//		try {
//			if (listPatrones==null) {
//				List<Patron> listPatron=patronFacade.findAll();
//				if(listPatron!=null && listPatron.size()>0){
//					listPatrones= new ArrayList<SelectItem>();
//					listPatrones.add(new SelectItem("", "Seleccione"));
//					for (Patron patron : listPatron) {
//						listPatrones.add(new SelectItem(patron.getCodigoPatron(),patron.getNombre()));
//					}
//				}
//			}
//		} catch (Exception e) {
//			logger.error(e);
//		}
		return listPatrones;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @param listPatrones the listPatrones to set
	 */
	public void setListPatrones(List<SelectItem> listPatrones) {
		this.listPatrones = listPatrones;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return the listCategorias
	 */
	public List<SelectItem> getListCategorias() {
		return listCategorias;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @param listCategorias the listCategorias to set
	 */
	public void setListCategorias(List<SelectItem> listCategorias) {
		this.listCategorias = listCategorias;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return the listPrincipios
	 */
	public List<SelectItem> getListPrincipios() {
//		try {
//			if (listPrincipios==null) {
//				List<Principio> listPrin=principioFacade.findAll();
//				if(listPrin!=null && listPrin.size()>0){
//					listPrincipios= new ArrayList<SelectItem>();
//					listPrincipios.add(new SelectItem("", "Seleccione"));
//					for (Principio principio : listPrin) {
//						listPrincipios.add(new SelectItem(principio.getCodigoPrincipio(),principio.getNombre()));
//					}
//				}
//			}
//		} catch (Exception e) {
//			logger.error(e);
//		}
		return listPrincipios;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @param listPrincipios the listPrincipios to set
	 */
	public void setListPrincipios(List<SelectItem> listPrincipios) {
		this.listPrincipios = listPrincipios;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @return the categoriaFacade
	 */
	public CategoriaFacade getCategoriaFacade() {
		return categoriaFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 7/08/2013
	 * @param categoriaFacade the categoriaFacade to set
	 */
	public void setCategoriaFacade(CategoriaFacade categoriaFacade) {
		this.categoriaFacade = categoriaFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @return the patron
	 */
	public Patron getPatron() {
		return patron;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @param patron the patron to set
	 */
	public void setPatron(Patron patron) {
		this.patron = patron;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @return the principio
	 */
	public Principio getPrincipio() {
		return principio;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @param principio the principio to set
	 */
	public void setPrincipio(Principio principio) {
		this.principio = principio;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 18/08/2013
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	
}
