package org.memsoa.app.model;

// Generated 8/07/2013 08:12:02 PM by Hibernate Tools 3.4.0.CR1

/**
 * EvaluacionPatronPrincipioId generated by hbm2java
 */
public class EvaluacionPatronPrincipioId implements java.io.Serializable {

	private long codigoEvaluacionPatron;
	private String codigoPrincipio;

	public EvaluacionPatronPrincipioId() {
	}

	public EvaluacionPatronPrincipioId(long codigoEvaluacionPatron,
			String codigoPrincipio) {
		this.codigoEvaluacionPatron = codigoEvaluacionPatron;
		this.codigoPrincipio = codigoPrincipio;
	}

	public long getCodigoEvaluacionPatron() {
		return this.codigoEvaluacionPatron;
	}

	public void setCodigoEvaluacionPatron(long codigoEvaluacionPatron) {
		this.codigoEvaluacionPatron = codigoEvaluacionPatron;
	}

	public String getCodigoPrincipio() {
		return this.codigoPrincipio;
	}

	public void setCodigoPrincipio(String codigoPrincipio) {
		this.codigoPrincipio = codigoPrincipio;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EvaluacionPatronPrincipioId))
			return false;
		EvaluacionPatronPrincipioId castOther = (EvaluacionPatronPrincipioId) other;

		return (this.getCodigoEvaluacionPatron() == castOther
				.getCodigoEvaluacionPatron())
				&& ((this.getCodigoPrincipio() == castOther
						.getCodigoPrincipio()) || (this.getCodigoPrincipio() != null
						&& castOther.getCodigoPrincipio() != null && this
						.getCodigoPrincipio().equals(
								castOther.getCodigoPrincipio())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getCodigoEvaluacionPatron();
		result = 37
				* result
				+ (getCodigoPrincipio() == null ? 0 : this.getCodigoPrincipio()
						.hashCode());
		return result;
	}

}