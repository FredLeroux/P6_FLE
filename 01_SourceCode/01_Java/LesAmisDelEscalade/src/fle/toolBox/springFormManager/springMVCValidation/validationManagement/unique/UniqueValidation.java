package fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique;

import java.lang.reflect.Field;

import org.springframework.validation.BindingResult;



public interface UniqueValidation {

	
	
	public void associatedModelNumericFieldValidation(Field fOI, Object clazz, String entityName,String modelAttributeName,
			BindingResult result);
	
	public void simpleModelNumericFieldAnnotation(Object cOI, Field fOI,String modelAttributeName, BindingResult result);
}
