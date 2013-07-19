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
import javax.faces.model.SelectItem;

import org.memsoa.app.api.enums.EstadoProyectoEnum;
import org.memsoa.app.facade.ProyectoFacade;
import org.memsoa.app.facade.ProyectoPersonaFacade;
import org.memsoa.app.model.Proyecto;
import org.memsoa.app.model.ProyectoPersona;
import org.memsoa.app.model.ProyectoPersonaId;
import org.memsoa.app.ui.support.AbstractUI;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-web
 * @class ProjectUI
 * @date 10/07/2013
 *
 */
@ManagedBean
@ViewScoped
public class ProjectUI  extends AbstractUI<Proyecto>{

	@ManagedProperty("#{proyectoPersonaFacade}")
	private ProyectoPersonaFacade proyectoPersonaFacade;
	@ManagedProperty("#{proyectoFacade}")
	private ProyectoFacade proyectoFacade;
	
	private Proyecto proyecto;
	private EstadoProyectoEnum estado=EstadoProyectoEnum.DEFAULT;
	private List<SelectItem> listEstado;
	
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 16/07/2013
	 */
	@PostConstruct
	public void init(){
		proyecto= new Proyecto();
	}
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 16/07/2013
	 */
	public void actionGuardar(){
		proyecto.setEstado(estado.name());
		proyecto.setFechaRegistro(new Date());
		proyecto.setFechaModificacion(new Date());
		try {
			if(validate(proyecto)){
				return;
			}
			proyectoFacade.saveOrUpdate(proyecto);
			ProyectoPersona proyectoPersona= new ProyectoPersona(new ProyectoPersonaId(proyecto.getCodigoProyecto(), "1", "1"));
			proyectoPersonaFacade.saveOrUpdate(proyectoPersona);
			info("i18n.msg-inbox","MSG_GUARDO_EXITO");
		} catch (Exception e) {
			error(e.getMessage());
		}
	}
	
	private boolean validate(Proyecto proyecto){
		boolean error=false;
		if(proyecto.getNombre()==null
				|| proyecto.getNombre().length()<1){
			error(getMessage("i18n.msg-inbox", "MSG_NO_NOMBRE"));
			error=true;
		}
		if(proyecto.getOrganizacion()==null
				|| proyecto.getOrganizacion().length()<1){
			error(getMessage("i18n.msg-inbox", "MSG_NO_ORGANIZACION"));
			error=true;
		}
		if(proyecto.getEstado()==null
				|| proyecto.getEstado().length()<1
				||proyecto.getEstado().equals(EstadoProyectoEnum.DEFAULT.name())){
			error(getMessage("i18n.msg-inbox", "MSG_NO_ESTADO"));
			error=true;
		}
		if(proyecto.getObservacion()==null
				|| proyecto.getObservacion().length()<1){
			error(getMessage("i18n.msg-inbox", "MSG_NO_OBSERVACION"));
			error=true;
		}
		return error;
	}
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 16/07/2013
	 */
	public void actionLimpiar(){
		init();
	}
	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 16/07/2013
	 * @return
	 */
	public String actionRegresar(){
		return "goInbox";
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 16/07/2013
	 * @return the proyecto
	 */
	public Proyecto getProyecto() {
		return proyecto;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 16/07/2013
	 * @param proyecto the proyecto to set
	 */
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @return the listEstado
	 */
	public List<SelectItem> getListEstado() {
		if(listEstado==null){
			try {
				listEstado=new ArrayList<SelectItem>();
				listEstado.add(new SelectItem(EstadoProyectoEnum.DEFAULT,getMessage("i18n.messages", "DEFAULT_SELECT_TIEM")));
				for (EstadoProyectoEnum estadoProyectoEnum : EstadoProyectoEnum.values()) {
					if(!estadoProyectoEnum.equals(EstadoProyectoEnum.DEFAULT)){
						listEstado.add(new SelectItem(estadoProyectoEnum, estadoProyectoEnum.name()));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listEstado;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @param listEstado the listEstado to set
	 */
	public void setListEstado(List<SelectItem> listEstado) {
		this.listEstado = listEstado;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 16/07/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#isDefaultAscending(java.lang.String)
	 */
	@Override
	protected boolean isDefaultAscending(String sortColumn) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 16/07/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#findDataModelEntries(int, int, java.lang.String)
	 */
	@Override
	protected List<Proyecto> findDataModelEntries(int startRow, int pageSize,
			String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 16/07/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#countDataModel()
	 */
	@Override
	protected int countDataModel() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 16/07/2013
	 * @return the estado
	 */
	public EstadoProyectoEnum getEstado() {
		return estado;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 16/07/2013
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoProyectoEnum estado) {
		this.estado = estado;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 16/07/2013
	 * @return the proyectoPersonaFacade
	 */
	public ProyectoPersonaFacade getProyectoPersonaFacade() {
		return proyectoPersonaFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 16/07/2013
	 * @param proyectoPersonaFacade the proyectoPersonaFacade to set
	 */
	public void setProyectoPersonaFacade(ProyectoPersonaFacade proyectoPersonaFacade) {
		this.proyectoPersonaFacade = proyectoPersonaFacade;
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 16/07/2013
	 * @return the proyectoFacade
	 */
	public ProyectoFacade getProyectoFacade() {
		return proyectoFacade;
	}
	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 16/07/2013
	 * @param proyectoFacade the proyectoFacade to set
	 */
	public void setProyectoFacade(ProyectoFacade proyectoFacade) {
		this.proyectoFacade = proyectoFacade;
	}
}
