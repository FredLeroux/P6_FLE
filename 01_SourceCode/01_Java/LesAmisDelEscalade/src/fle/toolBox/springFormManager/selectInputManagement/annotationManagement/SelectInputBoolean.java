package fle.toolBox.springFormManager.selectInputManagement.annotationManagement;

import java.lang.reflect.Field;

import fle.toolBox.springFormManager.test.TestSelectInputTypeAnnotationFill;

public class SelectInputBoolean extends TestSelectInputTypeAnnotationFill {

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
		if ((masterFieldName(fOI).isEmpty()) && (filterByMasterObjectFieldName(fOI).isEmpty())) {
			return false;
		} else {
			return true;
		}
	}

	protected boolean isSourceTypeEnum(Field field) {
		if (queryHQL(field).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean isConfigFieldPath(Field field) {
		if (configFilePath(field).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
