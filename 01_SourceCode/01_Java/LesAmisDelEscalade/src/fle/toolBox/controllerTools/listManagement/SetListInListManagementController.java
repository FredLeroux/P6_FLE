package fle.toolBox.controllerTools.listManagement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.displayer.DataListInListDisplay;

/**
 *
 * @author Frederic Leroux <br>
 *
 * to be used with templates Jsp displayList and pagination
 * to be implemented with DataListDisplay interface setted with controllerConfig method;
 * each handler have to be in web.xml
 *
 * @advise set the following <br>
 * private final String jspFolderName = "";<br>
	private final String getMappingFolderName = "/" + jspFolderName + "/";<br>
	private final String jspName = "";<br>
	private final String frontViewAddObjectHandlerName = "";<br>
	private final String setDataToDisplayHandlerName = "";<br>
	private final String sortListHandlerName = "";<br>
	private final String rowsDisplayedHandlerName = "";<br>
	private final String selectPageHandlerName = "";<br>
	private final String orderListHandlerName = "";<br>
 *
 */
public interface SetListInListManagementController  {
	//


	public DataListInListDisplay listInListControllerConfig();


	/**
	 * @required GetMapping annotation with value set as follow <br>
	 * value = "/jspFolder(if needed)/jspName"
	 *
	 */
	public ModelAndView initiatePageListInList(ModelAndView model,HttpServletRequest request);
	/**
	 * @required GetMapping annotation with value set as follow <br>
	 * value = "/jspFolder(if needed)/setDataToDisplayHandlerName"
	 */
	public ModelAndView setDataToDisplayListInList();
	/**
	 * @required GetMapping annotation with value set as follow <br>
	 * value = "/jspFolder(if needed)/frontViewAddObjectHandlerName"
	 */
	public ModelAndView frontViewAddObjectListInList();
	/**
	 * @required GetMapping annotation with value set as follow <br>
	 * value = "/jspFolder(if needed)/sortListHandlerName"
	 */
	public ModelAndView sortListInList();
	/**
	 * @required GetMapping annotation with value set as follow <br>
	 * value = "/jspFolder(if needed)/rowsDisplayedHandlerName"
	 */
	public ModelAndView listRowsDisplayedListInList();
	/**
	 * @required GetMapping annotation with value set as follow <br>
	 * value = "/jspFolder(if needed)/selectPageHandlerName"
	 */
	public ModelAndView selectedPageListInList ();
	/**
	 * @required GetMapping annotation with value set as follow <br>
	 * value = "/jspFolder(if needed)/orderListHandlerName"
	 */
	public ModelAndView orderedPageListInList();



}
