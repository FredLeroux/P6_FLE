package fle.toolBox.springFormManager.selectInputManagement.controllerClass;

import java.util.LinkedHashMap;

import org.json.JSONArray;
import org.springframework.web.servlet.ModelAndView;

public interface SelectInputForController {

	public LinkedHashMap<String, JSONArray> listToAddToModel(Object cOI);
	
	public LinkedHashMap<String, JSONArray> listToAddToModelFiltered();
	
	public void upDateSelectListAndValue(Object cOI,ModelAndView model);
	
	public void selectListAndValueOnBindingError(Object cOI,ModelAndView model);
	
	public void addSelectListsAndValues(Object cOI,ModelAndView model);
	
	public boolean formError();
	
	public LinkedHashMap<String, Object> valuesToAddToModel(Object cOI);
	


}
