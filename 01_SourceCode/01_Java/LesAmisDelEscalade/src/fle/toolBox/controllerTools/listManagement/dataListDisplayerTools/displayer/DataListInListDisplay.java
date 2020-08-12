package fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.displayer;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

public interface DataListInListDisplay  {

	public void listInListChangeDefaultRowsPerPagesTo(Integer defaultRowsPerPages);

	public void listInListChangeRowsPerPagesListTo(Integer[] rowsPerPagesList);

	public void listInListChangeFrontViewStoreFilterName(String frontViewStoreFilterName);

	/**
	 * @required GetMapping annotation with value set as follow <br>
	 *           value = "/jspFolder(if needed)/jspName"
	 *
	 */
	public ModelAndView initiatePagelistInList(List<?> fullData, Object entityModel, String frontViewAddObjectHandlerName,
			String internationalizationSuffix);

	/**
	 * @required GetMapping annotation with value set as follow <br>
	 *           value = "/jspFolder(if needed)/setDataToDisplayHandlerName"
	 */
	public ModelAndView setDataToDisplaylistInList(String frontViewAddObjectHandlerName,List<?>fullData);

	/**
	 * @required GetMapping annotation with value set as follow <br>
	 *           value = "/jspFolder(if needed)/frontViewAddObjectHandlerName"
	 */
	public ModelAndView frontViewAddObjectlistInList(String jspFolderName, String jspName, String sortListHandlerName,
			String rowsDisplayedHandlerName, String selectPageHandlerName, String orderListHandlerName,
			String editHandlerName, String listName);

	/**
	 * @required GetMapping annotation with value set as follow <br>
	 *           value = "/jspFolder(if needed)/sortListHandlerName"
	 */
	public ModelAndView sortlistInList(String setDataToDisplayHandlerName, String jspName);

	/**
	 * @required GetMapping annotation with value set as follow <br>
	 *           value = "/jspFolder(if needed)/rowsDisplayedHandlerName"
	 */
	public ModelAndView listRowsDisplayedlistInList(String setDataToDisplayHandlerName, String frontViewAddObjectHandlerName);

	/**
	 * @note request page parameter setted and fixed to "page"
	 * @param forwardToSetDataToDisplay
	 * @required GetMapping annotation with value set as follow <br>
	 *           value = "/jspFolder(if needed)/selectPageHandlerName"
	 *
	 */
	public ModelAndView selectedPagelistInList(String setDataToDisplayHandlerName);

	/**
	 * @note request parameter column to order and orderway names setted and fixed
	 *       respectively to "column" and "orderway"
	 * @param forwardToSetDataToDisplay * @required GetMapping annotation with value
	 *                                  set as follow <br>
	 *                                  value = "/jspFolder(if
	 *                                  needed)/orderListHandlerName"
	 *
	 */
	public ModelAndView orderedPagelistInList(String setDataToDisplayHandlerName);

}
