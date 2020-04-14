package fle.toolBox.springFormManager.selectInputManagement.javascriptFunctions.selectOptions;

import java.lang.reflect.Field;

import fle.toolBox.javaScriptGenerator.JavaScriptTag;

public class JsFunctionSelectOptions extends JavaScriptTag {

	private String emptyValue = "empty";

	private String onChange 
			= "\n function selectOnChange(entityName, fieldName,formName,formAction,dependentListName,dependentValueName){\r\n"
			+ " var selectListId = selectId(entityName, fieldName); \r\n"
			+ "	var select = document.getElementById(selectId(entityName, fieldName));	\r\n"
			+ "	select.setAttribute(\"onchange\", \"sendObjet('\"+formName+\"','\"+selectListId+\"','\"+formAction+\"','\"+dependentListName+\"',formError)\");\r\n"
			+ "}\r\n";
	private String submitSelectListOptionsFilter = "function sendObjet(formName,selectListId,formAction,dependentListName,formError){\r\n"
			+ "		var form = document.getElementById(formName);\r\n"
			+ "		var select = document.getElementById(selectListId);	\r\n" 
			+ "		form.action = formAction;\r\n"
			+ "		var criterion = select.options[select.selectedIndex].value;	\r\n"
			+ "		var filterInput = document.createElement(\"input\");\r\n"
			+ "		filterInput.type=\"hidden\";\r\n"
			+ "		filterInput.name = \"criterion\";\r\n" 
			+ "		filterInput.value = criterion;\r\n"
			+ "		var listToFilter = document.createElement(\"input\");\r\n"
			+ "		listToFilter.type=\"hidden\";\r\n"
			+ "		listToFilter.name = \"listName\";\r\n" 
			+ "		listToFilter.value = dependentListName;\r\n"
			+ "		var isError = document.createElement(\"input\");\r\n" 
			+ "		isError.type=\"hidden\";\r\n"
			+ "		isError.name = \"formError\";\r\n"
			+ "		isError.value = formError;\n\r" 
			+ "		var linkedFormName = document.createElement(\"input\");\r\n"
			+ "		linkedFormName.type=\"hidden\";\r\n"
			+ "		linkedFormName.name = \"formName\";\r\n"
			+"		linkedFormName.value = formName;\n\r"
			+ "		form.appendChild(filterInput);\r\n"
			+ "		form.appendChild(listToFilter);\r\n" 
			+ "		form.appendChild(isError);\r\n"
			+ "		form.appendChild(linkedFormName);\n\r"
			+ "		form.submit();\r\n" 
			+ "		}\r\n";

	private String selectListJSFunction = "function selectListPopulate(list, entityName,fieldName,defaultValue,splitter) {\r\n"
			+ "	var select = document.getElementById(selectId(entityName, fieldName));\r\n"
			+ "	var defaultOption = document.createElement(\"option\");\r\n"
			+ "	defaultOption.value = defaultValue;\r\n" 
			+ "	defaultOption.setAttribute(\"selected\", true);\r\n"
			+ "	select.appendChild(defaultOption);	\r\n" 
			+ "	for(let i=0;i<list.length;i++){\r\n"
			+ "		var string = list[i];\r\n" 
			+ "		var array = string.split(splitter);\r\n"
			+ "		var option = document.createElement(\"option\");\r\n" 
			+ "		option.value = array[0];\r\n"
			+ "		option.innerHTML=array[1];\r\n" 
			+ "		select.appendChild(option);\r\n" 
			+ "	};\r\n"
			+ "}\r\n";

	private String selectIdJSFunction = "function selectId(entityName,fieldName){\r\n"
			+ "	if(entityName === \"none\"){\r\n" 
			+ "	return fieldName.concat(\".select\");\r\n" 
			+ "	}else{\r\n"
			+ "	return entityName.concat(\".\",fieldName,\".select\");\r\n" 
			+ "}}\r\n";



	private String selectValueJSFunction 
				= "function setSelect(entityName,fieldName,valueToSet){\r\n" + "	if(valueToSet !== '"
				+ emptyValue + "'){\r\n"
				+ "	var select = document.getElementById(selectId(entityName, fieldName));\r\n"
				+ "	select.value = valueToSet;}	\r\n" + "}\r\n";
		

	public String selectJSFunctions() {		
		StringBuilder functions = new StringBuilder();		
		functions.append(varFromModel("formError", "formError"));
		functions.append(selectIdJSFunction);
		functions.append(selectListJSFunction);
		functions.append(selectValueJSFunction);
		functions.append(submitSelectListOptionsFilter);
		functions.append(onChange);
		return functions.toString();
	}

	private String selectListPopulate(String listVarName, String entityName, String fieldName, String defaultValue,
			String Splitter) {
		String[] args = { listVarName, entityName, fieldName, defaultValue, Splitter };
		return jsFunction("selectListPopulate", args);
	}

	private String setSelect(String entityName, String fieldName, String valueToSetVarName) {
		String[] args = { entityName, fieldName, valueToSetVarName };
		return jsFunction("setSelect", args);
	}

	public String selectOnchangeAttribute(String entityName, String fieldName, String formName, String formAction,
			String dependentListName) {
		String[] args = { entityName, fieldName, formName, formAction, dependentListName };
		return jsFunction("selectOnChange", args);
	}

	public void addSelectOptionsListAndValue(StringBuilder stringBuilder, String selectEntityName,
			String selectDefaultValue, String selectSplitter, String listVarName, String fieldName,
			String valueToSetVarName) {

		try {
			stringBuilder.append(
					selectListPopulate(listVarName, stringToJSString(selectEntityName), stringToJSString(fieldName),
							stringToJSString(selectDefaultValue), stringToJSString(selectSplitter)));
			stringBuilder.append(
					setSelect(stringToJSString(selectEntityName), stringToJSString(fieldName), valueToSetVarName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addSelectOnchangeAttribute(StringBuilder stringBuilder, String selectEntityName, Field fOI,
			String formName, String formAction, String dependentListName) {
		stringBuilder
				.append(selectOnchangeAttribute(stringToJSString(selectEntityName), stringToJSString(fOI.getName()),
						stringToJSString(formName), stringToJSString(formAction), stringToJSString(dependentListName)));

	}

}
