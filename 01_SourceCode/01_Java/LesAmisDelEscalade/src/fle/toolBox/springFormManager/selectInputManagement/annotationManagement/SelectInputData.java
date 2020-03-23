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

	protected String queryHQL(Field fOI) {
		return getAnnotation(fOI).queryHQL();
	}
	
	protected String configFileQueryHQLKey(Field fOI) {
		return getAnnotation(fOI).configFileQueryHQLKey();
	}
	
	protected String configFilePath(Field fOI) {
		return getAnnotation(fOI).configFilePath();
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

	protected String masterFieldName(Field fOI) {
		return getAnnotation(fOI).masterFieldName();
	}

	protected String filterByMasterObjectFieldName(Field fOI) {
		return getAnnotation(fOI).filterByMasterObjectFieldName();
	}

	protected String dependentFieldName(Field fOI) {
		return getAnnotation(fOI).dependentFieldName();
	}

	protected String dependentFieldNameFilteringAction(Field fOI) {
		return getAnnotation(fOI).dependentFieldNameFilteringAction();
	}

	protected Field dependentField(ExtractSetAndGetFields<Object> extract, Field fOI) {
		return extract.getFieldByIsName(dependentFieldName(fOI));
	}

}
