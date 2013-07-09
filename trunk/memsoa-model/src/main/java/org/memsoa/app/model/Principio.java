package org.memsoa.app.model;

// Generated 8/07/2013 08:12:02 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Principio generated by hbm2java
 */
public class Principio implements java.io.Serializable {

	private String codigoPrincipio;
	private String nombre;
	private String url;
	private Set patrons = new HashSet(0);
	private Set evaluacionPatronPrincipios = new HashSet(0);

	public Principio() {
	}

	public Principio(String codigoPrincipio, String nombre) {
		this.codigoPrincipio = codigoPrincipio;
		this.nombre = nombre;
	}

	public Principio(String codigoPrincipio, String nombre, String url,
			Set patrons, Set evaluacionPatronPrincipios) {
		this.codigoPrincipio = codigoPrincipio;
		this.nombre = nombre;
		this.url = url;
		this.patrons = patrons;
		this.evaluacionPatronPrincipios = evaluacionPatronPrincipios;
	}

	public String getCodigoPrincipio() {
		return this.codigoPrincipio;
	}

	public void setCodigoPrincipio(String codigoPrincipio) {
		this.codigoPrincipio = codigoPrincipio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set getPatrons() {
		return this.patrons;
	}

	public void setPatrons(Set patrons) {
		this.patrons = patrons;
	}

	public Set getEvaluacionPatronPrincipios() {
		return this.evaluacionPatronPrincipios;
	}

	public void setEvaluacionPatronPrincipios(Set evaluacionPatronPrincipios) {
		this.evaluacionPatronPrincipios = evaluacionPatronPrincipios;
	}

}
