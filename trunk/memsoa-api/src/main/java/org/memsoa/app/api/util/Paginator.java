package org.memsoa.app.api.util;

import java.io.Serializable;

/**
 * Mantiene los parametros de paginacion. para la propiedad sort se puede especificar el siguiente patron:
 * 
 * +=ASC, -=DESC, for example: +id,-processName
 * 
 * @author <a href="mailto:jorge.middleton@gmail.com">Jorge L. Middleton</a>
 * @version $
 * @date Jun 16, 2010
 */
public class Paginator implements Serializable {

	private static final long serialVersionUID = -4006021151205318554L;

	private int firstResult;

	private int maxResults;

	// a separated comma order properties: +=ASC, -=DESC, for example: +id,-processName
	private String sort;

	public Paginator(int firstResult, int maxResults, String sort) {
		super();
		this.firstResult = firstResult;
		this.maxResults = maxResults;
		this.sort = sort;
	}

	public static Paginator createPaginator() {
		return new Paginator(-1, -1);
	}

	public Paginator(int firstResult, int maxResults) {
		this.firstResult = firstResult;
		this.maxResults = maxResults;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public String getSort() {
		return sort;
	}

	public static Paginator getDefault() {
		return new Paginator(0, 500);
	}
}
