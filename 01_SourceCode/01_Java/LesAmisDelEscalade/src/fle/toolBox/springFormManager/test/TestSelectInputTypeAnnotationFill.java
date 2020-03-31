package fle.toolBox.springFormManager.test;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fle.toolBox.IsAnnotationPresent;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFields;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.TypeField;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import fle.toolBox.springFormManager.annotations.entityModelAssociation.ModelAssociationClass;
import fle.toolBox.springFormManager.selectInputManagement.annotationManagement.SelectInputData;
/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote check that @SelectInputType is well filled
 * @see {@linkplain fle.toolBox.springFormManager.annotations.SelectInputType  }
 */
public class TestSelectInputTypeAnnotationFill extends SelectInputData {

	@Test
	public void testSelectInputAnnotationValidity(Object cOI) {
		selectInputAnnotationValidation(cOI);
	}

	private void selectInputAnnotationValidation(Object cOI) {
		if (ModelAssociationClass.check(cOI)) {
			for (Field field : ClassFields.getAllFields(cOI)) {
				Object clazz = TypeField.newInstance(cOI, field.getName());
				for (Field subField : ClassFields.getAllFields(clazz)) {
					check(subField);
				}
			}
		} else {
			for (Field field : cOI.getClass().getDeclaredFields()) {
				check(field);
			}
		}
	}

	private void check(Field fOI) {
		if (IsAnnotationPresent.onField(fOI, SelectInputType.class)) {
			Assertions.assertTrue(mandatory(fOI));
			enumUseConstraint(fOI);
			dataBaseTableUse(fOI);			
			dependentFieldNameUse(fOI);
			masterFieldNameUse(fOI);
		}

	}
	
	private boolean mandatory(Field fOI) {
		return !enumClass(fOI).getSimpleName().contains("void") || !entityClassName(fOI).contains("void");
	}

	private void enumUseConstraint(Field fOI) {
		if (!enumClass(fOI).getSimpleName().contains("void")) {
			hasToBeEqualsTo("void", entityClassName(fOI), fOI);
			hasToBeNull(dtoClass(fOI), fOI);
			hasToBeEmpty(optionValueFieldName(fOI), fOI);
			hasToBeEmpty(optionDisplayValueFieldName(fOI), fOI);
			hasToBeEmpty(dependentFieldName(fOI), fOI);
			hasToBeEmpty(dependentFieldNameFilteringAction(fOI), fOI);
			hasToBeEmpty(relationShipField(fOI), fOI);
			hasToBeEmpty(relationShipFieldFilter(fOI), fOI);
		}
	}

	private void dataBaseTableUse(Field fOI) {
		if (!entityClassName(fOI).contains("void")) {
			hasToBeVoid(enumClass(fOI), fOI);
			hasToBeNotNull(dtoClass(fOI), fOI);
			hasToBeNotEmpty(optionValueFieldName(fOI), fOI);
			hasToBeNotEmpty(optionDisplayValueFieldName(fOI), fOI);
		}
	}
	

	private void dependentFieldNameUse(Field fOI) {
		if (!dependentFieldName(fOI).isEmpty() || !dependentFieldNameFilteringAction(fOI).isEmpty()) {
			hasToBeNotEmpty(dependentFieldName(fOI), fOI);
			hasToBeNotEmpty(dependentFieldNameFilteringAction(fOI), fOI);
		}
	}

	private void masterFieldNameUse(Field fOI) {
		if (!relationShipField(fOI).isEmpty() || !relationShipFieldFilter(fOI).isEmpty()) {
			hasToBeNotEmpty(relationShipField(fOI), fOI);
			hasToBeNotEmpty(relationShipFieldFilter(fOI), fOI);
		}
	}

	private String message(Field fOI) {
		return "SelectInputType  Annotation on field : " + fOI.getDeclaringClass().getName() + "." + fOI.getName()
				+ "  is on error";
	}

	private void hasToBeEmpty(String str, Field fOI) {
		Assertions.assertTrue(str.isEmpty(), message(fOI));
	}

	private void hasToBeNotEmpty(String str, Field fOI) {
		Assertions.assertFalse(str.isEmpty(), message(fOI));
	}

	private void hasToBeNull(Object object, Field fOI) {
		Assertions.assertNull(object, message(fOI));
	}

	private void hasToBeVoid(Object object, Field fOI) {
		Assertions.assertEquals(void.class, object, message(fOI));
	}

	private void hasToBeNotNull(Object object, Field fOI) {
		Assertions.assertNotNull(object, message(fOI));
	}
	
	private void hasToBeEqualsTo(String criterion, String toTest,Field fOI) {
		Assertions.assertEquals(criterion,toTest,message (fOI));
	}
}
