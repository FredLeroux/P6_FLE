package fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique;

import java.lang.reflect.Field;

import fle.toolBox.IsAnnotationPresent;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.numeric.Numeric;


public class UniqueAnnotationBoolean extends UniqueAnnotationData {

	protected boolean isUniqueAnnotated(Field fOI) {
		return IsAnnotationPresent.onField(fOI, Unique.class);
	}

	protected boolean isNumeric(Field fOI) {
		return IsAnnotationPresent.onField(fOI, Numeric.class);
	}

}
