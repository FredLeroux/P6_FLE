package fle.toolBox.springFormManager.springMVCValidation.validationManagement.numeric;

import java.lang.reflect.Field;

import org.springframework.validation.BindingResult;

import fle.toolBox.PatternMatcher;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFieldsSetAndGet;
import fle.toolBox.springFormManager.springMVCValidation.tools.SpringValidationError;


/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote allow to, in case of numeric error to add this one to BinDingResult 
 */
public class NumericValidation extends NumericAnnotationRegex {

	String numericError = "NotNumeric";
	String notNumericeDefaultMessage = "Numeric constraint on field, value entered not matche numeric regex";

	public void associatedModelNumericFieldValidation(Field fOI, Object clazz, String entityName,
			BindingResult result) {
		if (isNumeric(fOI)) {
			
			String value = ClassFieldsSetAndGet.getFieldValue(clazz, fOI.getName()).toString();
			String fieldValueName = entityName.concat(".").concat(fOI.getName());
			if(!acceptEmptyValue(fOI) ||!value.equals("")) {
			isNumericValidation(fOI, numericError, fieldValueName, value, notNumericeDefaultMessage, result);
			}
			
		}
	}

	public void simpleModelNumericFieldAnnotation(Object cOI, Field fOI, BindingResult result) {
		if (isNumeric(fOI)) {
			
			String value = ClassFieldsSetAndGet.getFieldValue(cOI, fOI.getName()).toString();
			if(!acceptEmptyValue(fOI)|| !value.equals("")) {
			isNumericValidation(fOI, numericError, fOI.getName(), value, notNumericeDefaultMessage, result);
		}}
	}

	

	private void isNumericValidation(Field fOI, String errorCode, String fieldValueName, String valueTocheck,
			String defaultMessage, BindingResult result) {
		if (!isNumericMatch(fOI, valueTocheck)) {
			SpringValidationError.addError(errorCode, modelAttributeValue(fOI), fieldValueName, defaultMessage, result);
		}
	}

	private boolean isNumericMatch(Field fOI, String toCheck) {
		return PatternMatcher.isMatch(setRegex(fOI), toCheck);

	}

}