package org.memsoa.app.model;

// Generated 8/07/2013 08:12:02 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * ImplementacionCategoria generated by hbm2java
 */
public class ImplementacionCategoria implements java.io.Serializable {

	private Date fechaRegistro;
	private String codigoCategoria;
	private Long codigoImplementacion;
	private String nombreCategoria;

	public ImplementacionCategoria() {
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @param fechaRegistro
	 * @param codigoCategoria
	 * @param codigoImplementacion
	 */
	public ImplementacionCategoria(Date fechaRegistro, String codigoCategoria,
			Long codigoImplementacion) {
		super();
		this.fechaRegistro = fechaRegistro;
		this.codigoCategoria = codigoCategoria;
		this.codigoImplementacion = codigoImplementacion;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return the codigoCategoria
	 */
	public String getCodigoCategoria() {
		return codigoCategoria;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @param codigoCategoria the codigoCategoria to set
	 */
	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @return the codigoImplementacion
	 */
	public Long getCodigoImplementacion() {
		return codigoImplementacion;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 23/07/2013
	 * @param codigoImplementacion the codigoImplementacion to set
	 */
	public void setCodigoImplementacion(Long codigoImplementacion) {
		this.codigoImplementacion = codigoImplementacion;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @return the nombreCategoria
	 */
	public String getNombreCategoria() {
		return nombreCategoria;
	}

	/**
	 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
	 * @date 30/07/2013
	 * @param nombreCategoria the nombreCategoria to set
	 */
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

}
