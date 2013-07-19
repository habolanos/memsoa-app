package org.memsoa.app.model;

// Generated 8/07/2013 08:12:02 PM by Hibernate Tools 3.4.0.CR1

/**
 * ProyectoPersonaId generated by hbm2java
 */
public class ProyectoPersonaId implements java.io.Serializable {

	private Long codigoProyecto;
	private String codigoRol;
	private String codigoPersona;
	

	public ProyectoPersonaId() {
	}

	public ProyectoPersonaId(Long codigoProyecto, String codigoRol,
			String codigoPersona) {
		this.codigoProyecto = codigoProyecto;
		this.codigoRol = codigoRol;
		this.codigoPersona = codigoPersona;
	}

	public Long getCodigoProyecto() {
		return this.codigoProyecto;
	}

	public void setCodigoProyecto(Long codigoProyecto) {
		this.codigoProyecto = codigoProyecto;
	}

	public String getCodigoRol() {
		return this.codigoRol;
	}

	public void setCodigoRol(String codigoRol) {
		this.codigoRol = codigoRol;
	}

	public String getCodigoPersona() {
		return this.codigoPersona;
	}

	public void setCodigoPersona(String codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProyectoPersonaId))
			return false;
		ProyectoPersonaId castOther = (ProyectoPersonaId) other;

		return (this.getCodigoProyecto() == castOther.getCodigoProyecto())
				&& ((this.getCodigoRol() == castOther.getCodigoRol()) || (this
						.getCodigoRol() != null
						&& castOther.getCodigoRol() != null && this
						.getCodigoRol().equals(castOther.getCodigoRol())))
				&& ((this.getCodigoPersona() == castOther.getCodigoPersona()) || (this
						.getCodigoPersona() != null
						&& castOther.getCodigoPersona() != null && this
						.getCodigoPersona()
						.equals(castOther.getCodigoPersona())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoProyecto().intValue();
		result = 37 * result
				+ (getCodigoRol() == null ? 0 : this.getCodigoRol().hashCode());
		result = 37
				* result
				+ (getCodigoPersona() == null ? 0 : this.getCodigoPersona()
						.hashCode());
		return result;
	}

	
}
