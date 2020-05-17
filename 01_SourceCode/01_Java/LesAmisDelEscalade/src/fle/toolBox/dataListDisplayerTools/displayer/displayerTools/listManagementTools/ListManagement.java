package fle.toolBox.dataListDisplayerTools.displayer.displayerTools.listManagementTools;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.json.JSONArray;

import exceptions.PageNumberException;
import exceptions.PageWishedException;

public class ListManagement<O extends Object> extends Pagination<O> {

	private String ascendingOrder = "asc";
	private String descendingOrder = "desc";
	
	
	
	
	
public ListManagement(O entityModel) {
	
	super(entityModel);
	//this.entityModel = entityModel;
	addPagesJumpRule(1, 20, 1, 5, 10);
	addPagesJumpRule(20, 100, 1, 10, 20);
	addPagesJumpRule(100, 1000, 10, 50, 100);
	addPagesJumpRule(100, 5000, 10, 50, 500);
	addPagesJumpRule(5000, 10000, 50, 100, 500);
	addPagesJumpRule(10000, -1, 100, 500, 1000);
	
}

	public String getAscendingOrder() {
		return ascendingOrder;
	}

	public void setAscendingOrder(String ascendingOrder) {
		this.ascendingOrder = ascendingOrder;
	}

	public String getDescendingOrder() {
		return descendingOrder;
	}

	public void setDescendingOrder(String descendingOrder) {
		this.descendingOrder = descendingOrder;
	}

	public JSONArray rowsPerPagesListToJSONArray(Integer[] rowsPerPagesList) {
		JSONArray rowsPerPagesListTransient = new JSONArray();
		for (Integer i : rowsPerPagesList) {
			rowsPerPagesListTransient.put(i);
		}
		return rowsPerPagesListTransient;
	}

	/**
	 * 
	 * @param criteriaList
	 * @param list
	 * @return a list filtered in function of criterialist set
	 * @Note the JSONArray criteria must be composed of string as follow:<br>
	 *       fieldName + operator + data<br>
	 *       example : "city=Paris".
	 */
	public List<O> getfilteredList(JSONArray criteriaList, List<O> list) {
		List<O> originList = new ArrayList<O>(list);
		List<O> filteredList = new ArrayList<O>();
		for (Object criterion : criteriaList) {
			filteredList = filteredList.isEmpty() ? (List<O>) listFiltration(list, criterion.toString(), entityModel)
					: (List<O>) listFiltration(filteredList, criterion.toString(),entityModel);
		}
		originList.clear();
		return filteredList;

	}

	/**
	 * 
	 * @param list
	 * @param rowsPerPages
	 * @return
	 */
	public Integer totalPages(List<O> list, Integer rowsPerPages) {
		return calculateTotalPages(list.size(), rowsPerPages);
	}

	public JSONArray basicPageNavigation(Integer page, Integer totalPages, String empty) {
		JSONArray nav = null;
		nav = new JSONArray(basicNav(page, totalPages, empty));
		return nav;
	}

	public void addPagesJumpRule(Integer pagesLimitMin, Integer pagesLimitMax, Integer lowJump, Integer mediumJump,
			Integer highJump) {
		addRuleToRulesList(createPagesJumpRule(pagesLimitMin, pagesLimitMax, lowJump, mediumJump, highJump));
	}
	
	public ArrayList<LinkedHashMap<String, Integer>> pagesJumpRulesList(){
		return getRulesList();
	}
	
	public JSONArray jumpFooPage(Integer page, Integer totalPages,
			ArrayList<LinkedHashMap<String, Integer>> rulesList){
		JSONArray jumpListFooPage = null;
		jumpListFooPage =new JSONArray(jumpListFooPage(page, totalPages, rulesList)); 
						
		return jumpListFooPage;
	}

	/**
	 * 
	 * @param list
	 * @param rowsPerPages
	 * @param pageWished
	 * @return the page whished (List) with the nomber of rows set
	 */
	public List<O> pagination(List<O> list, Integer rowsPerPages, Integer pageWished) {
		List<O> listToPaginate = new ArrayList<>(list);
		int totalPages = calculateTotalPages(list.size(), rowsPerPages);
		try {
			setPage(pageWished, rowsPerPages, totalPages, listToPaginate);
		} catch (PageWishedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listToPaginate.clear();
		return getPage();
	}

	/**
	 * 
	 * @param criteriaList
	 * @param list
	 * @param rowsPerPages
	 * @param pageWished
	 * @return the filteredList page whished (List) with the nomber of rows set
	 */
	public List<O> filteredListPaginnate(JSONArray criteriaList, List<O> list, Integer rowsPerPages,
			Integer pageWished) {
		return pagination(getfilteredList(criteriaList, list), rowsPerPages, pageWished);
	}

	public List<List<O>> pageList(List<O> list, Integer rowsPerPages) {
		List<O> originList = new ArrayList<O>(list);
		List<O> pageTransient = new ArrayList<O>();
		List<List<O>> pageList = new ArrayList<List<O>>();
		int totalPages = calculateTotalPages(originList.size(), rowsPerPages);
		int i = 0;
		for (i = 0; i < totalPages; i++) {
			pageTransient = pagination(originList, rowsPerPages, (i + 1));
			pageList.add(pageTransient);
		}

		return pageList;
	}

	public List<List<O>> filteredPageList(JSONArray criteriaList, List<O> list, Integer rowsPerPages) {
		return pageList(getfilteredList(criteriaList, list), rowsPerPages);

	}

	/**
	 * 
	 * @param pagesList
	 * @param pageNumber
	 * @return
	 * @throws PageNumberException
	 * @Note <b><u> Important</b> use the real page number i.e. for page 1 call page
	 *       1 the method will automatically get pageList index 0<u>
	 */
	public List<O> fromPageListGetPageNumber(List<List<O>> pagesList, Integer pageNumber) throws PageNumberException {		
		if (pageNumber > pagesList.size() || pageNumber <= 0) {
			throw new PageNumberException(pageNumber);

		}

		return pagesList.get(pageNumber - 1);
	}

	/**
	 * 
	 * @param orderWay  by default accept asc and desc, however can be customized
	 *                  using setAscendingOrder and setDescendingOrder
	 * @param list      the list to sort
	 * @param fieldName the column field by wich list will be sorted
	 * @return a sorted list in orderWay function
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public List<O> sortListByFieldName(String orderWay, List<O> list, String fieldName)  {
		List<O> sortedList = new ArrayList<O>(list);
		if (orderWay.equals(ascendingOrder)) {			
				sortNaturalOrderByField(fieldName, sortedList,entityModel);			 
		} else {			
				sortReverseOrderByField(fieldName, sortedList,entityModel);
			
		}
		
		return sortedList;
	}

	/**
	 * 
	 * @param list
	 * @return a list as JSONArray
	 */
	public JSONArray listConvertorToJSONArray(List<O> list) {
		return new JSONArray(list);
	}

}
