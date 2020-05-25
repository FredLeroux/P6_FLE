package fle.toolBox.springFormManager.springMVCValidation;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFields;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFieldsSetAndGet;
import fle.toolBox.springFormManager.annotations.entityModelAssociation.ModelAssociationClass;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.numeric.NumericValidation;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique.UniqueValidation;



/**
 * 
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote implementation of SpringMVCValidation interface
 * @see {@link #isUnique(String, String, String)},
 *      {@link #isUniqueValidation(String, String, String, String, String, BindingResult)}
 *      and {@link #fieldError(String, String, BindingResult)}
 *
 */
@Service
public class SpringMVCValidationImplemented implements SpringMVCValidation {

	@Autowired
	UniqueValidation uniqueVal;
	
	private NumericValidation numVal = new NumericValidation();
	 

	/**
	 * add error to Bindingresult if @unique annotated field is not unique
	 */
	@Override
	public void SpringMVCValidationCheck(Object cOI, String modelAttributeName,BindingResult result) {
		if (ModelAssociationClass.check(cOI)) {
			associatedModelValidation(cOI,modelAttributeName, result);
		} else {
			simpleModelValidation(cOI,modelAttributeName, result);
		}
	}

	private void associatedModelValidation(Object cOI,String modelAttributeName, BindingResult result) {
		for (Field field : ClassFields.getAllFields(cOI)) {
			String entityName = field.getName();
			Object clazz = ClassFieldsSetAndGet.getFieldValue(cOI, entityName); // getFieldValue(field, cOI);
			for (Field subField : ClassFields.getAllFields(clazz)) {
				ClassFieldsSetAndGet.getFieldValue(clazz, subField.getName());
				uniqueVal.associatedModelNumericFieldValidation(subField, clazz, entityName,modelAttributeName, result);
				numVal.associatedModelNumericFieldValidation(subField, clazz, entityName, result);
			}
		}
	}

	private void simpleModelValidation(Object cOI,String modelAttributeName, BindingResult result) {
		for (Field field : ClassFields.getAllFields(cOI)) {
			uniqueVal.simpleModelNumericFieldAnnotation(cOI, field,modelAttributeName, result);
			numVal.simpleModelNumericFieldAnnotation(cOI, field, result);
		}

	}

}
