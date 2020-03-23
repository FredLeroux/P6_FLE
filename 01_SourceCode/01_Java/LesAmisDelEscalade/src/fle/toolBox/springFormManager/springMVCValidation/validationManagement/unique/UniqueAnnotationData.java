package fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique;

import java.lang.reflect.Field;

public class UniqueAnnotationData {

	private Unique getUniqueAnnotation(Field fOI) {
		return fOI.getAnnotation(Unique.class);
	}

	protected String entityName(Field fOI) {
		return getUniqueAnnotation(fOI).entityName();
	}

	protected String fieldName(Field fOI) {
		return getUniqueAnnotation(fOI).fieldName();
	}

	protected String modelAttributeValue(Field fOI) {
		return getUniqueAnnotation(fOI).modelAttributeValue();
	}

}
