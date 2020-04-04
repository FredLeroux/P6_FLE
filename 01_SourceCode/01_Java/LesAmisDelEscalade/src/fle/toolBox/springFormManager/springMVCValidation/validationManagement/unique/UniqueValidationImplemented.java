package fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFieldsSetAndGet;
import fle.toolBox.springFormManager.springMVCValidation.tools.SpringValidationError;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique.service.IsUniqueService;



@Service
public class UniqueValidationImplemented extends UniqueAnnotationBoolean implements UniqueValidation {

	@Autowired
	IsUniqueService service;

	String uniqueError = "NotUnique";
	String notUniqueDefaultMessage = "Unique constraint on field, value entered already exist";

	public void associatedModelNumericFieldValidation(Field fOI, Object clazz, String entityName,
			BindingResult result) {
		if (isUniqueAnnotated(fOI)) {
			String value = ClassFieldsSetAndGet.getFieldValue(clazz, fOI.getName()).toString();
			String fieldValueName = entityName.concat(".").concat(fOI.getName());
			isUniqueValidation(fOI, uniqueError, fieldValueName, value, notUniqueDefaultMessage, result);
		}
	}

	public void simpleModelNumericFieldAnnotation(Object cOI, Field fOI, BindingResult result) {
		if (isUniqueAnnotated(fOI)) {
			String value = ClassFieldsSetAndGet.getFieldValue(cOI, fOI.getName()).toString();
			isUniqueValidation(fOI, uniqueError, fOI.getName(), value, notUniqueDefaultMessage, result);
		}
	}

	/**
	 * 
	 * @param entityName          the "entity.class" name.
	 * @param fieldName           the field in entity representing the column of
	 *                            interest.
	 * @param modelAttributeValue the @ModelAttribute value
	 * @param fieldValueName      is the fieldname where to apply Unique constraint.
	 *                            <b><u>Note</u></b> in case of associated model
	 *                            field is composed of entityName.fieldname if a
	 *                            single model fieldName will be enought.
	 * @param valueTocheckUnicity valueTocheckUnicity value to check presence in a
	 *                            columnElements list
	 * @param result              BindingResult
	 */
	private void isUniqueValidation(Field fOI, String errorCode, String fieldValueName, String valueTocheckUnicity,
			String defaultMessage, BindingResult result) {
		if (!isUnique(entityName(fOI), fieldName(fOI), valueTocheckUnicity)) {
			SpringValidationError.addError(errorCode, modelAttributeValue(fOI), fieldValueName, defaultMessage, result);
		}
	}

	/**
	 * 
	 * @param fieldName the field in entity representing the column of interest
	 * @Param entityName the entity name of entity representing database table of
	 *        interest
	 * @param valueTocheckUnicity value to check presence in a columnElements list
	 * @return true if valueToCheckUnicity is not present else false
	 * @see IsUniqueService
	 */
	private boolean isUnique(String entityName, String fieldName, String valueTocheckUnicity) {
		if (service.columnElementsList(fieldName, entityName).contains(valueTocheckUnicity)) {
			return false;
		} else {
			return true;
		}
	}

}
