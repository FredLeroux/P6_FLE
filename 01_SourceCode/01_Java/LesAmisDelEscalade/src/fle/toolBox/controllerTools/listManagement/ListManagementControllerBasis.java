package fle.toolBox.controllerTools.listManagement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public abstract interface ListManagementControllerBasis {

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
