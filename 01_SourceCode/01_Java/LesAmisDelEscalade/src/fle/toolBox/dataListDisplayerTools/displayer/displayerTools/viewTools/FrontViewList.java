package fle.toolBox.dataListDisplayerTools.displayer.displayerTools.viewTools;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.ModelAndView;

import exceptions.RowsPerPagesException;
import fle.toolBox.JspJavaScriptStringParser;
import fle.toolBox.dataListDisplayerTools.displayer.displayerTools.dataExtractorTools.CollectionElementsExtrator;
import fle.toolBox.dataListDisplayerTools.displayer.displayerTools.dataExtractorTools.ColumnsNamesAndOperators;
import fle.toolBox.dataListDisplayerTools.displayer.displayerTools.listManagementTools.ListManagement;

/**
 * 
 * @author Frederic Leroux <br>
 *         if controller w/o O entityModel parameter is use, it is required to
 *         use setTools
 * @param <O>
 */
public class FrontViewList<O extends Object> {

	
	private ColumnsNamesAndOperators<O> columnsInfo = null;
	private CollectionElementsExtrator<O> collectionElements = null;;
	private ListManagement<O> listManagement = null;
	private JSONArray filterHead = new JSONArray();
	private JSONArray criteria = new JSONArray();
	private JSONArray tableElementsList = new JSONArray();
	private JSONArray dataToSend = new JSONArray();
	private List<O> fullData = new ArrayList<O>();
	private List<O> dataSorted = new ArrayList<O>();
	private List<O> dataOrdered = new ArrayList<O>();
	private List<List<O>> dataPaginate = new ArrayList<List<O>>();
	private JSONArray emptyArray = new JSONArray();
	private JSONArray rowsPerPagesListJSONArray = new JSONArray();
	private Integer rowsPerPagesSelected = 0;
	private String empty = "empty";
	private Integer totalPages = null;
	private Integer page = 0;
	private JSONArray pageNav = new JSONArray();
	private JSONArray pageJump = new JSONArray();
	private String orderWay = null;
	private String fieldName = null;
	private Integer[] rowsPerPagesList = { 10, 20, 30 };
	private Integer defaultRowsPerPages = rowsPerPagesList[1];
	private String frontViewStoreFilterName = "storeFilter";

	public FrontViewList(O entityModel) {		
		columnsInfo = new ColumnsNamesAndOperators<O>(entityModel);
		collectionElements = new CollectionElementsExtrator<O>(entityModel);
		listManagement = new ListManagement<O>(entityModel);

	}

	public FrontViewList() {

	}

	/**
	 * 
	 * @return default "storeFilter"
	 */
	public String getFrontViewStoreFilterName() {
		return frontViewStoreFilterName;
	}

	public void setFrontViewStoreFilterName(String frontViewStoreFilterName) {
		System.out.println(frontViewStoreFilterName);
		this.frontViewStoreFilterName = frontViewStoreFilterName;
	}
	

	public void setTools(O entityModel) {
		columnsInfo = new ColumnsNamesAndOperators<O>(entityModel);
		collectionElements = new CollectionElementsExtrator<O>(entityModel);
		listManagement = new ListManagement<O>(entityModel);
	}

	public JSONArray getFilterHead() {
		return filterHead;
	}

	public void setFilterHead(JSONArray filterHead) {
		this.filterHead = filterHead;
	}

	public JSONArray getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = new JSONArray(criteria);
	}

	public void setCriteria(JSONArray criteriaJSONArray) {
		this.criteria = criteriaJSONArray;
	}

	public JSONArray getTableElementsList() {
		return tableElementsList;
	}

	public void setTableElementsList(JSONArray tableElementsList) {
		this.tableElementsList = tableElementsList;
	}

	public JSONArray getDataToSend() {
		return dataToSend;
	}

	public void setDataToSend(JSONArray dataToSend) {
		this.dataToSend = dataToSend;
	}

	public List<O> getDataSorted() {
		return dataSorted;
	}

	public void setDataSorted(List<O> data) {
		this.dataSorted = data;
	}

	public List<O> getDataOrdered() {
		return dataOrdered;
	}

	public void setDataOrdered(List<O> dataOrdered) {
		this.dataOrdered = dataOrdered;
	}

	public List<O> getFullData() {
		return fullData;
	}

	public void setFullData(List<O> fullData) {
		this.fullData = fullData;
	}

	public List<List<O>> getDataPaginate() {
		return dataPaginate;
	}

	public void setDataPaginate(List<List<O>> dataPaginate) {
		this.dataPaginate = dataPaginate;
	}

	public JSONArray getEmptyArray() {
		return emptyArray;
	}

	public void setEmptyArray(String emptyFlag) {
		emptyArray.put(0, emptyFlag);
	}

	public JSONArray getRowsPerPagesListJSONArray() {
		return rowsPerPagesListJSONArray;
	}

	public void setRowsPerPagesListJSONArray(Integer[] rowsPerPagesList) {
		if (getRowsPerPagesListJSONArray().isEmpty()) {
			this.rowsPerPagesListJSONArray = listManagement.rowsPerPagesListToJSONArray(rowsPerPagesList);
		}
	}

	public Integer getRowsPerPagesSelected() {
		return rowsPerPagesSelected;
	}

	public void setRowsPerPagesSelected(Integer rowsPerPages) throws RowsPerPagesException {
		if (!rowsPerPagesListJSONArray.toList().contains(rowsPerPages)) {
			throw new RowsPerPagesException("The number " + rowsPerPages + " is not allowed as rows per pages number ");
		}
		this.rowsPerPagesSelected = rowsPerPages;
	}

	public Integer getDefaultRowsPerPages() {
		return defaultRowsPerPages;
	}

	public void setDefaultRowsPerPages(Integer defaultRowsPerPages) {
		this.defaultRowsPerPages = defaultRowsPerPages;
	}

	public Integer[] getRowsPerPagesList() {
		return rowsPerPagesList;
	}

	public void setRowsPerPagesList(Integer[] rowsPerPagesList) {
		this.rowsPerPagesList = rowsPerPagesList;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	/**
	 * 
	 * @return by default "empty"
	 */
	public String getEmpty() {
		return empty;
	}

	public void setEmpty(String empty) {
		this.empty = empty;
	}

	public void setTotalPages(List<O> list, Integer rowsPerpages) {
		this.totalPages = listManagement.totalPages(list, rowsPerpages);
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public JSONArray getPageNav() {
		return pageNav;
	}

	public void setPageNav(JSONArray pageNav) {
		this.pageNav = pageNav;
	}

	public JSONArray getPageJump() {
		return pageJump;
	}

	public void setPageJump(JSONArray pageJump) {
		this.pageJump = pageJump;
	}

	public String getOrderWay() {
		return orderWay;
	}

	public void setOrderWay(String orderWay) {
		this.orderWay = orderWay;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * 
	 * @return modelAndView containing all object required to use with template jsp
	 *         pagination and displayList
	 */
	/**
	 * 
	 * @param frontView                the ModelMapping returned
	 * @param jspFolderName            folder containing the JSP to set to null if
	 *                                 none
	 * @param jspName                  the name of the JSP used
	 * @param sortListHandlerName      the action to the form setting the sorted
	 *                                 list <b>AND</b> to use to the GetMapping
	 *                                 annotation
	 * @param rowsDisplayedHandlerName the GetMapping annotation value to get the
	 *                                 numbres of rows
	 * @param selectPageHandlerName    the GetMapping annotation value to get the
	 *                                 page selected
	 * @param orderListHandlerName     GetMapping annotation value to get the page
	 *                                 ordered
	 * @return ModelAnview with the required object added
	 */
	public ModelAndView addRequiredObject(ModelAndView frontView, String jspFolderName, String jspName,
			String sortListHandlerName, String rowsDisplayedHandlerName, String selectPageHandlerName,
			String orderListHandlerName, String editHandlerName) {
		frontView.addObject("reload",false);
		frontView.addObject("jspName", JspJavaScriptStringParser.parse(jspName));
		frontView.addObject("sortListHandlerName", JspJavaScriptStringParser.parse(sortListHandlerName));
		frontView.addObject("editHandlerName", JspJavaScriptStringParser.parse(editHandlerName));
		frontView.addObject("formMethod", JspJavaScriptStringParser.parse("get"));
		frontView.addObject("rowsDisplayed", JspJavaScriptStringParser.parse(rowsDisplayedHandlerName));
		frontView.addObject("selectedPage", JspJavaScriptStringParser.parse(selectPageHandlerName));
		frontView.addObject("orderLink", JspJavaScriptStringParser.parse(orderListHandlerName));
		frontView.addObject("storedFilterArrayName", JspJavaScriptStringParser.parse(getFrontViewStoreFilterName()));
		frontView.addObject("rowsPerPagesList", getRowsPerPagesListJSONArray());
		frontView.addObject("tableElementsList", getTableElementsList());
		frontView.addObject("filterHead", getFilterHead());
		frontView.addObject("dataBaseData", getDataToSend());
		frontView.addObject("filterSetted", getCriteria());
		frontView.addObject("rowsPerPages", getRowsPerPagesSelected()); // todo change attribute name
		frontView.addObject("currentPage", getPage());
		frontView.addObject("navigation", getPageNav());
		frontView.addObject("pageJump", getPageJump());
		frontView.setViewName(jspFolderName + "/" + jspName);
		return frontView;
	}

	public void initializingComponents(List<O> fulldata, HttpServletRequest request,
			MessageSource messageSource, Integer[] rowsPerPagesList, Integer defaultRowPerPages,String internationalizationSuffix) {
		setFullData(fulldata);
		columnsInfo.setInternationalizationSuffix(internationalizationSuffix);
		setFilterHead(columnsInfo.columnsAndOperatorsListI18N(request, messageSource));
		setRowsPerPagesListJSONArray(rowsPerPagesList);
		setTableElementsList(collectionElements.createTableElemetsList(getFullData()));
		setEmptyArray(getEmpty());
		setDataToSend(getEmptyArray());
		setDataSorted(null);
		setDataPaginate(null);
		setCriteria(getEmptyArray());
		setTotalPages(0);
		setPage(0);
		setPageNav(getEmptyArray());
		setPageJump(getEmptyArray());
		setOrderWay("asc");
		try {
			setRowsPerPagesSelected(defaultRowPerPages);
		} catch (RowsPerPagesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setComponentsToDisplay() {
		boolean doSetData = true;
		
		setEmptyArray(empty);
		if (getCriteria().isEmpty()) {
			doSetData = false;
		}
		if (doSetData) {
			if (getCriteria().get(0).equals(empty)) {
				setDataSorted(getFullData());
			} else {
				setDataSorted(listManagement.getfilteredList(getCriteria(), getFullData()));
			}
			setTableElementsList(collectionElements.createTableElemetsList(getDataSorted()));
			if (getFieldName() != null) {
				setDataOrdered(listManagement.sortListByFieldName(getOrderWay(), getDataSorted(), getFieldName()));
			} else {
				setDataOrdered(getDataSorted());
				// setPage(1);
			}
			setDataPaginate(listManagement.pageList(getDataOrdered(), getRowsPerPagesSelected()));
			if (getPage() == 0) {
				setPage(1);
			}
			setDataToSend(listManagement
					.listConvertorToJSONArray(listManagement.fromPageListGetPageNumber(getDataPaginate(), getPage())));
			setTotalPages(getDataSorted(), getRowsPerPagesSelected());
			setPageNav(listManagement.basicPageNavigation(getPage(), getTotalPages(), empty));
			setPageJump(listManagement.jumpFooPage(getPage(), getTotalPages(), listManagement.pagesJumpRulesList()));

		}
	}

	public void setFiltersCriteria(String criteria, String DisplayAllTerms) {
		setCriteria(criteria);
		if (!getCriteria().isEmpty() && getCriteria().get(0).equals(DisplayAllTerms)) {
			setCriteria(getEmptyArray());
		}
	}

}
