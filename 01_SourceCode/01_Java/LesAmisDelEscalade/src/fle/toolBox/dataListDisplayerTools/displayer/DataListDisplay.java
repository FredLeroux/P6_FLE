package fle.toolBox.dataListDisplayerTools.displayer;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

public interface DataListDisplay {

	public void changeDefaultRowsPerPagesTo(Integer defaultRowsPerPages);

	public void changeRowsPerPagesListTo(Integer[] rowsPerPagesList);

	public void changeFrontViewStoreFilterName(String frontViewStoreFilterName);

	/**
	 * @required GetMapping annotation with value set as follow <br>
	 *           value = "/jspFolder(if needed)/jspName"
	 * 
	 */
	public ModelAndView initiatePage(List<?> fullData, Object entityModel,String frontViewAddObjectHandlerName,String internationalizationSuffix);

	/**
	 * @required GetMapping annotation with value set as follow <br>
	 *           value = "/jspFolder(if needed)/setDataToDisplayHandlerName"
	 */
	public ModelAndView setDataToDisplay(String frontViewAddObjectHandlerName);

	/**
	 * @required GetMapping annotation with value set as follow <br>
	 *           value = "/jspFolder(if needed)/frontViewAddObjectHandlerName"
	 */
	public ModelAndView frontViewAddObject(String jspFolderName, String jspName, String sortListHandlerName,
			String rowsDisplayedHandlerName, String selectPageHandlerName, String orderListHandlerName,String editHandlerName);

	/**
	 * @required GetMapping annotation with value set as follow <br>
	 *           value = "/jspFolder(if needed)/sortListHandlerName"
	 */
	public ModelAndView sortList(String setDataToDisplayHandlerName,String jspName);

	/**
	 * @required GetMapping annotation with value set as follow <br>
	 *           value = "/jspFolder(if needed)/rowsDisplayedHandlerName"
	 */
	public ModelAndView listRowsDisplayed(String setDataToDisplayHandlerName, String frontViewAddObjectHandlerName);

	/**
	 * @note request page parameter setted and fixed to "page"
	 * @param forwardToSetDataToDisplay
	 * @required GetMapping annotation with value set as follow <br>
	 *           value = "/jspFolder(if needed)/selectPageHandlerName"
	 * 
	 */
	public ModelAndView selectedPage(String setDataToDisplayHandlerName);

	/**
	 * @note request parameter column to order and orderway names setted and fixed
	 *       respectively to "column" and "orderway"
	 * @param forwardToSetDataToDisplay * @required GetMapping annotation with value
	 *                                  set as follow <br>
	 *                                  value = "/jspFolder(if
	 *                                  needed)/orderListHandlerName"
	 *
	 */
	public ModelAndView orderedPage(String setDataToDisplayHandlerName);
}
