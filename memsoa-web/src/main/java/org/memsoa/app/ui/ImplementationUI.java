/**
 * 
 */
package org.memsoa.app.ui;

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
import org.memsoa.app.api.enums.EstadoImplementacionEnum;
import org.memsoa.app.api.enums.EstadoProyectoEnum;
import org.memsoa.app.facade.CategoriaFacade;
import org.memsoa.app.facade.ImplementacionFacade;
import org.memsoa.app.facade.ProyectoFacade;
import org.memsoa.app.model.Categoria;
import org.memsoa.app.model.Implementacion;
import org.memsoa.app.model.ImplementacionCategoria;
import org.memsoa.app.model.Proyecto;
import org.memsoa.app.ui.support.AbstractUI;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-web
 * @class ImplementationUI
 * @date 23/07/2013
 *
 */
@ManagedBean
@ViewScoped
public class ImplementationUI extends AbstractUI<ImplementacionCategoria>{

	Logger logger=Logger.getLogger(ImplementationUI.class);
	private Implementacion implementacion;
	@ManagedProperty("#{proyectoFacade}")
	private ProyectoFacade proyectoFacade;
	@ManagedProperty("#{categoriaFacade}")
	private CategoriaFacade categoriaFacade;
	@ManagedProperty("#{implementacionFacade}")
	private ImplementacionFacade implementacionFacade;
	private Proyecto proyecto;
	private List<String> listCategoriasSelect;
	private List<SelectItem> listCategorias;
	private Long proyectoId;
	
	@PostConstruct
	public void init(){
		try {
			String id=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idProject");
			proyecto=proyectoFacade.findById(Long.parseLong(id));
			implementacion= new Implementacion();
			implementacion.setProyecto(proyecto);
			List<Categoria> list=categoriaFacade.findAll();
			listCategorias= new ArrayList<SelectItem>();
			if(list!=null && list.size()>0){
				for (Categoria categoria : list) {
					listCategorias.add(new SelectItem(categoria.getCodigoCategoria(), categoria.getNombre()));
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 */
	public void actionGuardar(){
		try {
			if(validate(implementacion)){
				return;
			}
			implementacion.setFechaRegistro(new Date());
			implementacion.setFechaModificacion(new Date());
			implementacion.setEstado(EstadoImplementacionEnum.ACTIVO.name());
			implementacionFacade.save(implementacion,listCategoriasSelect);
			info("i18n.msg-implementation", "MSG_GUARDO_EXITO");
			actionLimpiar();
		} catch (Exception e) {
			error(e.getMessage());
		}
	}
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @param implementacion
	 * @return boolean
	 */
	private boolean validate(Implementacion implementacion){
		boolean error=false;
		if(implementacion.getNombre()==null
				|| implementacion.getNombre().length()<1){
			error(getMessage("i18n.msg-implementation", "MSG_NO_IMPLEMENTACION"));
			error=true;
		}
		if(implementacion.getObservacion()==null
				|| implementacion.getObservacion().length()<1){
			error(getMessage("i18n.msg-implementation", "MSG_NO_OBSERVACION"));
			error=true;
		}
		if(listCategoriasSelect==null || listCategoriasSelect.size()<1){
			error(getMessage("i18n.msg-implementation", "MSG_NO_CATEGORIAS"));
			error=true;
		}
		return error;
	}
	
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 */
	public void actionLimpiar(){
		implementacion= new Implementacion();
		implementacion.setProyecto(proyecto);
		dataModel=null;
	}
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 */
	public String actionRegresar(){
		return "goInbox";
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return the implementacion
	 */
	public Implementacion getImplementacion() {
		return implementacion;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @param implementacion the implementacion to set
	 */
	public void setImplementacion(Implementacion implementacion) {
		this.implementacion = implementacion;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return the proyectoFacade
	 */
	public ProyectoFacade getProyectoFacade() {
		return proyectoFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @param proyectoFacade the proyectoFacade to set
	 */
	public void setProyectoFacade(ProyectoFacade proyectoFacade) {
		this.proyectoFacade = proyectoFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return the proyecto
	 */
	public Proyecto getProyecto() {
		return proyecto;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @param proyecto the proyecto to set
	 */
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return the categoriaFacade
	 */
	public CategoriaFacade getCategoriaFacade() {
		return categoriaFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @param categoriaFacade the categoriaFacade to set
	 */
	public void setCategoriaFacade(CategoriaFacade categoriaFacade) {
		this.categoriaFacade = categoriaFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return the listCategoriasSelect
	 */
	public List<String> getListCategoriasSelect() {
		return listCategoriasSelect;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @param listCategoriasSelect the listCategoriasSelect to set
	 */
	public void setListCategoriasSelect(List<String> listCategoriasSelect) {
		this.listCategoriasSelect = listCategoriasSelect;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 23/07/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#isDefaultAscending(java.lang.String)
	 */
	@Override
	protected boolean isDefaultAscending(String sortColumn) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 23/07/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#findDataModelEntries(int, int, java.lang.String)
	 */
	@Override
	protected List<ImplementacionCategoria> findDataModelEntries(int startRow,
			int pageSize, String sort) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 23/07/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#countDataModel()
	 */
	@Override
	protected int countDataModel() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return the implementacionFacade
	 */
	public ImplementacionFacade getImplementacionFacade() {
		return implementacionFacade;
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @param implementacionFacade the implementacionFacade to set
	 */
	public void setImplementacionFacade(ImplementacionFacade implementacionFacade) {
		this.implementacionFacade = implementacionFacade;
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return the proyectoId
	 */
	public Long getProyectoId() {
		return proyectoId;
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @param proyectoId the proyectoId to set
	 */
	public void setProyectoId(Long proyectoId) {
		this.proyectoId = proyectoId;
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return the listCategorias
	 */
	public List<SelectItem> getListCategorias() {
		return listCategorias;
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @param listCategorias the listCategorias to set
	 */
	public void setListCategorias(List<SelectItem> listCategorias) {
		this.listCategorias = listCategorias;
	}

}
