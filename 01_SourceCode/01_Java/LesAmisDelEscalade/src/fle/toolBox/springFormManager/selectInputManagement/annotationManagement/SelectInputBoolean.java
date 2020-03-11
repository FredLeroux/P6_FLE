package fle.toolBox.springFormManager.selectInputManagement.annotationManagement;

import java.lang.reflect.Field;

public class SelectInputBoolean extends SelectInputData {

	protected boolean isDependentFieldName(Field fOI) {
		if (dependentFieldName(fOI).isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	protected boolean isFromMessageSource(Field fOI) {
		if (messageSourceSuffix(fOI).isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	protected boolean isLinkedList(Field fOI) {
		if ((joinFieldName(fOI).isEmpty()) && (filterByFieldName(fOI).isEmpty())) {
			return false;
		} else {
			return true;
		}
	}

	protected boolean isSourceTypeEnum(Field field) {
		if (query(field).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
