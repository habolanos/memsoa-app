/**
 * 
 */
package org.memsoa.app.ui;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.memsoa.app.api.enums.EstadoProyectoEnum;
import org.memsoa.app.api.util.Paginator;
import org.memsoa.app.facade.ProyectoPersonaFacade;
import org.memsoa.app.facade.RolFacade;
import org.memsoa.app.model.ProyectoPersona;
import org.memsoa.app.model.Rol;
import org.memsoa.app.ui.support.AbstractUI;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-web
 * @class InboxUI
 * @date 10/07/2013
 *
 */
@ManagedBean
@ViewScoped
public class InboxUI extends AbstractUI<ProyectoPersona>{

	@ManagedProperty("#{proyectoPersonaFacade}")
	private ProyectoPersonaFacade proyectoPersonaFacade;
	@ManagedProperty("#{rolFacade}")
	private RolFacade rolFacade;
	private String nombreProyecto;
	private String codigoRol;
	private EstadoProyectoEnum estado=EstadoProyectoEnum.DEFAULT;
	private List<SelectItem> listRoles;
	private List<SelectItem> listEstado;

	/**
	 * 
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 16/07/2013
	 * @return String
	 */
	public String actionGoCreateProject(){
		return "goProject";
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#isDefaultAscending(java.lang.String)
	 */
	@Override
	protected boolean isDefaultAscending(String sortColumn) {
		return false;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#findDataModelEntries(int, int, java.lang.String)
	 */
	@Override
	protected List<ProyectoPersona> findDataModelEntries(int startRow, int pageSize,
			String sort) {
		try {
			return proyectoPersonaFacade.findByNameRolEstado(nombreProyecto, codigoRol, estado.name(), new Paginator(startRow, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *@author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 *@date 11/07/2013
	 * @see org.memsoa.app.ui.support.AbstractDataPaginatorUI#countDataModel()
	 */
	@Override
	protected int countDataModel() {
		try {
			return proyectoPersonaFacade.countByNameRolEstado(nombreProyecto, codigoRol, estado.name());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @return the nombreProyecto
	 */
	public String getNombreProyecto() {
		return nombreProyecto;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @param nombreProyecto the nombreProyecto to set
	 */
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @return the codigoRol
	 */
	public String getCodigoRol() {
		return codigoRol;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @param codigoRol the codigoRol to set
	 */
	public void setCodigoRol(String codigoRol) {
		this.codigoRol = codigoRol;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @return the estado
	 */
	public EstadoProyectoEnum getEstado() {
		return estado;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoProyectoEnum estado) {
		this.estado = estado;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @return the listRoles
	 */
	public List<SelectItem> getListRoles() {
		try {
			if(listRoles==null){
				List<Rol> list=rolFacade.findAll();
				listRoles= new ArrayList<SelectItem>();
				listRoles.add(new SelectItem("0",getMessage("i18n.messages", "DEFAULT_SELECT_TIEM")));
				for (Rol rol : list) {
					listRoles.add(new SelectItem(rol.getNombre(), rol.getCodigoRol()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listRoles;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @param listRoles the listRoles to set
	 */
	public void setListRoles(List<SelectItem> listRoles) {
		this.listRoles = listRoles;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @return the proyectoPersonaFacade
	 */
	public ProyectoPersonaFacade getProyectoPersonaFacade() {
		return proyectoPersonaFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @param proyectoPersonaFacade the proyectoPersonaFacade to set
	 */
	public void setProyectoPersonaFacade(ProyectoPersonaFacade proyectoPersonaFacade) {
		this.proyectoPersonaFacade = proyectoPersonaFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @return the rolFacade
	 */
	public RolFacade getRolFacade() {
		return rolFacade;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 11/07/2013
	 * @param rolFacade the rolFacade to set
	 */
	public void setRolFacade(RolFacade rolFacade) {
		this.rolFacade = rolFacade;
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



}
