package fle.toolBox.springFormManager.selectInputManagement.annotationManagement;

import java.lang.reflect.Field;

import fle.toolBox.classType.DTO;
import fle.toolBox.fieldsReflectivity.ExtractSetAndGetFields;
//TODO 1-JAVADOC
public class SelectInputData extends SelectInputBasis {

	@SuppressWarnings("unchecked")
	protected <E extends Enum<E>> Class<E> enumClass(Field fOI) {
		return (Class<E>) getAnnotation(fOI).enumClass();
	}

	protected String selectListName(Field fOI) {
		return getAnnotation(fOI).selectListName();
	}

	protected String selectValueName(Field fOI) {
		return getAnnotation(fOI).selectValueName();
	}

		
	protected String defaultValue(Field fOI) {
		return getAnnotation(fOI).defaultValue();
	}
	
	protected String splitter(Field fOI) {
		return getAnnotation(fOI).splitter();
	}

	protected String query(Field fOI) {
		return getAnnotation(fOI).query();
	}

	protected String optionValueFieldName(Field fOI) {
		return getAnnotation(fOI).optionValueFieldName();
	}

	protected String optionDisplayValueFieldName(Field fOI) {
		return getAnnotation(fOI).optionDisplayValueFieldName();
	}

	private String dtoClassName(Field fOI) {
		return getAnnotation(fOI).dtoClass().getName();
	}

	@SuppressWarnings("unchecked")
	protected <D extends DTO> D dtoClass(Field fOI) {
		D dto = null;
		try {
			dto = (D) Class.forName(dtoClassName(fOI)).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}

	protected String messageSourceSuffix(Field fOI) {
		return getAnnotation(fOI).messageSourceSuffix();
	}

	protected String joinFieldName(Field fOI) {
		return getAnnotation(fOI).masterFieldName();
	}

	protected String filterByFieldName(Field fOI) {
		return getAnnotation(fOI).filterByFieldName();
	}

	protected String dependentFieldName(Field fOI) {
		return getAnnotation(fOI).dependentFieldName();
	}

	protected String filteringAction(Field fOI) {
		return getAnnotation(fOI).filteringAction();
	}

	protected Field dependentField(ExtractSetAndGetFields<Object> extract, Field fOI) {
		return extract.getFieldByIsName(dependentFieldName(fOI));
	}

}
