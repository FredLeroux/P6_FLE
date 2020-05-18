package fle.toolBox.springFormManager.springMVCValidation.tools;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote allow to create a springFrameWork FieldError and add it to a
 *          BindingResult + define the error code
 */
public abstract class SpringValidationError {

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
	 *          "NotUnique.modelAttributeValue.fieldValueName"<br>
	 *          More over the field on error will have the value wich gives the
	 *          error setted and so allow user to know exactly what is the issue<br>
	 *          if the field value "1" cause an erro the field will kept this value
	 *          after error.
	 */

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
	public static void addErrorWithOutFieldValue(String errorCode, String modelAttributeValue, String fieldValueName,
			String defaultMessage, BindingResult result) {
		result.addError(
				fieldErrorWithOutFieldValue(errorCode, modelAttributeValue, fieldValueName, defaultMessage, result));
	}

	private static FieldError fieldError(String errorCode, String modelAttributeValue, String fieldValueName,
			String defaultMessage, BindingResult result) {
		String[] code = code(errorCode, modelAttributeValue, fieldValueName);
		return error(code, modelAttributeValue, fieldValueName, defaultMessage, result);
	}

	private static FieldError fieldErrorWithOutFieldValue(String errorCode, String modelAttributeValue,
			String fieldValueName, String defaultMessage, BindingResult result) {
		String[] code = code(errorCode, modelAttributeValue, fieldValueName);
		return errorWithOutFieldValue(code, modelAttributeValue, fieldValueName, defaultMessage, result);
	}

	private static FieldError error(String[] code, String modelAttributeValue, String fieldValueName,
			String defaultMessage, BindingResult result) {
		return new FieldError(modelAttributeValue, fieldValueName, result.getFieldValue(fieldValueName), false, code,
				null, defaultMessage);
	}

	private static FieldError errorWithOutFieldValue(String[] code, String modelAttributeValue, String fieldValueName,
			String defaultMessage, BindingResult result) {
		return new FieldError(modelAttributeValue, fieldValueName, null, false, code, null, defaultMessage);
	}

	private static String[] code(String errorCode, String modelAttributeValue, String fieldValueName) {
		String[] code = { errorCode, errorCode + "." + modelAttributeValue + "." + fieldValueName };
		return code;
	}

}
