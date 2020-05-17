package fle.toolBox.controllerTools.listManagement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.dataListDisplayerTools.displayer.DataListDisplay;

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
public interface SetListManagementController {
	//
	
	
	public DataListDisplay controllerConfig();

	
	/**
	 * @required GetMapping annotation with value set as follow <br>
	 * value = "/jspFolder(if needed)/jspName"
	 * 
	 */
	public ModelAndView initiatePage(ModelAndView model,HttpServletRequest request);
	/**
	 * @required GetMapping annotation with value set as follow <br>
	 * value = "/jspFolder(if needed)/setDataToDisplayHandlerName"
	 */
	public ModelAndView setDataToDisplay();
	/**
	 * @required GetMapping annotation with value set as follow <br>
	 * value = "/jspFolder(if needed)/frontViewAddObjectHandlerName"
	 */
	public ModelAndView frontViewAddObject();	
	/**
	 * @required GetMapping annotation with value set as follow <br>
	 * value = "/jspFolder(if needed)/sortListHandlerName"
	 */
	public ModelAndView sortList();
	/**
	 * @required GetMapping annotation with value set as follow <br>
	 * value = "/jspFolder(if needed)/rowsDisplayedHandlerName"
	 */
	public ModelAndView listRowsDisplayed();
	/**
	 * @required GetMapping annotation with value set as follow <br>
	 * value = "/jspFolder(if needed)/selectPageHandlerName"
	 */
	public ModelAndView selectedPage ();
	/**
	 * @required GetMapping annotation with value set as follow <br>
	 * value = "/jspFolder(if needed)/orderListHandlerName"
	 */
	public ModelAndView orderedPage();
	
}
