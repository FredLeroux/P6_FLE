package fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

import fle.toolBox.fieldsReflectivity.ExtractSetAndGetFields;



public class SelectInputListAndValue extends SelectInputListOrder {
	private String empty = "empty";

	protected Object selectinputValue(Field field) {
		return fieldManager.getFieldValue(field);

	}

	protected Object emptyValue(Object value) {
		if (value == null|| value.toString().isEmpty()) {
			value = empty;
		}
		return value;
	}

	protected void addValueFromObject(LinkedHashMap<String, Object> mapToAdd, Field field,
			ExtractSetAndGetFields<Object> extract) {		
		Object value = extract.getFieldValue(field);
		mapToAdd.put(selectValueName(field), "'" + emptyValue(value) + "'");
	}

	protected void addValueFromObject(LinkedHashMap<String, Object> mapToAdd, Field field) {
		Object value = fieldManager.getFieldValue(field);
		mapToAdd.put(selectValueName(field), "'" + emptyValue(value) + "'");
	}
	
	

}
