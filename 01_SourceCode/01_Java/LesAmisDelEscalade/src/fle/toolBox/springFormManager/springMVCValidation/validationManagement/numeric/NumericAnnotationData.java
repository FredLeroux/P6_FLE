package fle.toolBox.springFormManager.springMVCValidation.validationManagement.numeric;

import java.lang.reflect.Field;
/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote allow to retrive all values from annotation
 */
public class NumericAnnotationData {

	private Numeric getAnnotation(Field fOI) {
		return fOI.getAnnotation(Numeric.class);
	}

	protected String modelAttributeValue(Field fOI) {
		return getAnnotation(fOI).modelAttributeValue();
	}

	protected int maxDigits(Field fOI) {
		return getAnnotation(fOI).maxDigits();
	}

	protected int totalDigits(Field fOI) {
		return getAnnotation(fOI).totalDigits();
	}

	protected int precision(Field fOI) {
		return getAnnotation(fOI).precision();
	}

	protected String configFilePath(Field fOI) {
		return getAnnotation(fOI).configFilePath();
	}

	protected String maxDigitsKey(Field fOI) {
		return getAnnotation(fOI).maxDigitsKey();
	}
	
	protected String totalDigitsKey(Field fOI) {
		return getAnnotation(fOI).totalDigitsKey();
	}
	
	protected String precisionKey(Field fOI) {
		return getAnnotation(fOI).precisionKey();
	}
	
	protected boolean acceptEmptyValue(Field fOI) {
		return getAnnotation(fOI).acceptEmptyValue();
	}
}
