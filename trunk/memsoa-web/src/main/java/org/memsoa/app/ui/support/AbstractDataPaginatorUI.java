package org.memsoa.app.ui.support;

import java.util.List;

import javax.faces.model.DataModel;



public abstract class AbstractDataPaginatorUI<T>{

	// DataModel bound to dataTable
	protected PagedListDataModel<T> dataModel;

	// bound to rows attribute in dataTable
	protected int pageSize = 10;

	// Sortable Headers
	protected String sortColumnName;
	protected boolean sortAscending;

	public AbstractDataPaginatorUI() {
	}

	/**
	 * Bound to DataTable value in the ui.
	 */
	@SuppressWarnings("rawtypes")
	public DataModel getData() {
		if (dataModel == null) {
			dataModel = new LocalDataModel(pageSize);
		}
		return dataModel;
	}
	
	public boolean isDataAvailable() {
		return getData () != null && getData ().getRowCount() > 0;
	}

	public void clearDataModel() {
		dataModel = null;
	}

	/**
	 * This is where the data is retrieved from the database and returned as a list of objects for display in the UI.
	 */
	public DataPage<T> getDataPage(int startRow, int pageSize) {

		// Retrieve the total number of customers from the database. This
		// number is required by the DataPage object so the paginator will know
		// the relative location of the page data.
		int total = countDataModel();

		// Calculate indices to be displayed in the ui.
		int endIndex = startRow + pageSize;
		if (endIndex > total) {
			endIndex = total;
		}

		String sort = null;
		if (sortColumnName != null) {
			sort = (sortAscending ? "+" : "-") + sortColumnName;
		}

		// Query database for sorted results.
		List<T> list = findDataModelEntries(startRow, endIndex - startRow, sort);

		// Reset the dirtyData flag.
		if(dataModel!=null){
			dataModel.setDirtyData(false);
		}

		return new DataPage<T>(total, startRow, list);
	}

	/**
	 * A special type of JSF DataModel to allow a datatable and datapaginator to page through a large set of data
	 * without having to hold the entire set of data in memory at once. Any time a managed bean wants to avoid holding
	 * an entire dataset, the managed bean declares this inner class which extends PagedListDataModel and implements the
	 * fetchData method. fetchData is called as needed when the table requires data that isn't available in the current
	 * data page held by this object. This requires the managed bean (and in general the business method that the
	 * managed bean uses) to provide the data wrapped in a DataPage object that provides info on the full size of the
	 * dataset.
	 */
	private class LocalDataModel extends PagedListDataModel<T> {
		public LocalDataModel(int pageSize) {
			super(pageSize);
		}

		public DataPage<T> fetchPage(int startRow, int pageSize) {
			// call enclosing managed bean method to fetch the data
			return getDataPage(startRow, pageSize);
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Gets the sortColumnName column.
	 * 
	 * @return column to sortColumnName
	 */
	public String getSortColumnName() {
		return sortColumnName;
	}

	/**
	 * Sets the sortColumnName column.
	 * 
	 * @param sortColumnName
	 *            column to sortColumnName
	 */
	public void setSortColumnName(String sortColumnName) {
		if (!sortColumnName.equals(this.sortColumnName)) {
			dataModel.setDirtyData();
			this.sortColumnName = sortColumnName;
		}
	}

	/**
	 * Is the sortColumnName sortAscending?
	 * 
	 * @return true if the sortAscending sortColumnName otherwise false
	 */
	public boolean isSortAscending() {
		return sortAscending;
	}

	/**
	 * Sets sortColumnName type.
	 * 
	 * @param sortAscending
	 *            true for sortAscending sortColumnName, false for descending sortColumnName.
	 */
	public void setSortAscending(boolean sortAscending) {
		if (sortAscending != (this.sortAscending)) {
			dataModel.setDirtyData();
			this.sortAscending = sortAscending;
		}
	}

	protected abstract boolean isDefaultAscending(String sortColumn);

	/**
	 * Consulta los datos para un rango determinado.
	 * 
	 * @param startRow
	 * @param pageSize
	 * @param sort
	 * @return
	 */
	protected abstract List<T> findDataModelEntries(int startRow, int pageSize, String sort);

	/**
	 * Consulta la cantidad de registros totales.
	 * 
	 * @return
	 */
	protected abstract int countDataModel();
}
