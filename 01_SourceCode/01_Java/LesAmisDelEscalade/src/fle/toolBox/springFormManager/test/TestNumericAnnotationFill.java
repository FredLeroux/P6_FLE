package fle.toolBox.springFormManager.test;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFields;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.TypeField;
import fle.toolBox.springFormManager.annotations.entityModelAssociation.ModelAssociationClass;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.numeric.NumericAnnotationDataValueBoolean;


/**
 * 
 * @author Frederic Leroux <br>
 * @Version 1.0
 * @apiNote test the numeric annotation filling rules.
 * 
 */
public class TestNumericAnnotationFill extends NumericAnnotationDataValueBoolean {
	
	@Test
	public void testNumericAnnotationValidity(Object cOI) {
		modelNumericAnnotationValidation(cOI);
	}

	private void modelNumericAnnotationValidation(Object cOI) {
		if (ModelAssociationClass.check(cOI)) {
			for (Field field : ClassFields.getAllFields(cOI)) {
				Object clazz = TypeField.newInstance(cOI, field.getName());
				for (Field subField : ClassFields.getAllFields(clazz)) {
					checkNumericAnnotation(subField);
				}
			}
		} else {
			for (Field field : cOI.getClass().getDeclaredFields()) {
				checkNumericAnnotation(field);
			}
		}
	}

	private void checkNumericAnnotation(Field fOI) {
		if (isNumeric(fOI)) {
			configFilePathUse(fOI);
			maxDigitsUse(fOI);
			totalDigitsUse(fOI);
			precisionOnMaxDigits(fOI);
			precisionOnTotalDigits(fOI);
			
		}
	}
	
	private void configFilePathUse(Field fOI) {
		if (!configFilePath(fOI).isEmpty()) {
			Assertions.assertTrue(maxDigits(fOI) == 0);
			Assertions.assertTrue(totalDigits(fOI) == 0);
			Assertions.assertTrue(precision(fOI) == 0);
			Assertions.assertFalse(maxDigitsKey(fOI).isEmpty());
			Assertions.assertFalse(totalDigitsKey(fOI).isEmpty());
			Assertions.assertFalse(precisionKey(fOI).isEmpty());

		}
	}

	private void maxDigitsUse(Field fOI) {
		if (!isMaxDigitsZero(fOI))
			Assertions.assertTrue(isTotalDigitsZero(fOI));
	}

	private void totalDigitsUse(Field fOI) {
		if (!isTotalDigitsZero(fOI)) {
			Assertions.assertTrue(isMaxDigitsZero(fOI));
		}
	}

	private void precisionOnMaxDigits(Field fOI) {
		if (!isPrecisionZero(fOI) && !isMaxDigitsZero(fOI)) {
			Assertions.assertTrue(getPrecisionValue(fOI) <= getMaxDigitsValue(fOI));
		}
	}

	private void precisionOnTotalDigits(Field fOI) {
		if (!isPrecisionZero(fOI) && !isTotalDigitsZero(fOI)) {
			Assertions.assertTrue(getPrecisionValue(fOI) <= getTotalDigitsValue(fOI));
		}
	}

	

}
