package fle.toolBox.springFormManager.springMVCValidation.tools;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote allow to create a springFrameWork FieldError and add it to a BindingResult + define the error code
 */
public abstract class SpringValidationError{
	
	
	
	public static void addError(String errorCode, String modelAttributeValue, String fieldValueName,
			String defaultMessage, BindingResult result) {		
		result.addError(fieldError(errorCode, modelAttributeValue, fieldValueName, defaultMessage, result));
	}

	/**
	 * 
	 * @param modelAttributeValue the @ModelAttribute value
	 * @param fieldValueName      is the fieldname where to apply Unique constraint.
	 *                            <b><u>Note</u></b> in case of associated model
	 *                            field is composed of entityName.fieldname if a
	 *                            single model fieldName will be enought. *
	 * @param result              BindingResult
	 * @return a new FieldError
	 * @see #fieldError(String, String, BindingResult)
	 * @apiNote the code error will be
	 *          "NotUnique.modelAttributeValue.fieldValueName"
	 */
	private static FieldError fieldError(String errorCode, String modelAttributeValue, String fieldValueName,
			String defaultMessage, BindingResult result) {
		String[] code = code(errorCode, modelAttributeValue, fieldValueName);
		FieldError error = new FieldError(modelAttributeValue, fieldValueName, result.getFieldValue(fieldValueName),
				false, code, null, defaultMessage);
		return error;
	}
	
	private static String[] code(String errorCode, String modelAttributeValue, String fieldValueName) {
		String[] code = {errorCode, errorCode + "." + modelAttributeValue + "." + fieldValueName };
		return code;
	}

	
	

}
