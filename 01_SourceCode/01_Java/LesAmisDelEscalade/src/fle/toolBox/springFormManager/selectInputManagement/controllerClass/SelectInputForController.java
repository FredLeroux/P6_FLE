package fle.toolBox.springFormManager.selectInputManagement.controllerClass;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.web.servlet.ModelAndView;

public interface SelectInputForController {

	public LinkedHashMap<String, JSONArray> listToAddToModel(Object cOI);

	public LinkedHashMap<String, JSONArray> listToAddToModelFiltered();

	public void upDateSelectListAndValue(Object cOI, ModelAndView model,HttpServletRequest request);

	/**
	 * 
	 * @param formName the @SpringFormSettings name attribute
	 * @param controllerRequest the controller wich will display the formular w/o error
	 * @param errorControllerRequest the controller wich use a validated entity to manage error
	 */
	public void setFormularAndRequestMap(String formName, String controllerRequest,String errorControllerRequest);

	public ModelAndView formSelectInputFieldUpdate(Object cOI, ModelAndView model,HttpServletRequest request);
	
	public ModelAndView dispatchSelectListAndValue(ModelAndView model,HttpServletRequest request);

	public void selectListAndValueOnBindingError(Object cOI, ModelAndView model);

	public void addSelectListsAndValues(Object cOI, ModelAndView model);

	public boolean formError();

	public LinkedHashMap<String, Object> valuesToAddToModel(Object cOI);

}
