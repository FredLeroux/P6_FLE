package fle.toolBox.springFormManager.springMVCValidation.validationManagement.numeric;

import java.lang.reflect.Field;

import fle.toolBox.IsAnnotationPresent;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote contains all boolean wich assert if a non mandatory attributes is
 *          default or not.
 */
public class NumericAnnotationBoolean extends NumericAnnotationData {

	protected boolean isNumeric(Field fOI) {
		return IsAnnotationPresent.onField(fOI, Numeric.class);
	}

	protected boolean isMaxDigits(Field fOI) {
		return maxDigits(fOI) == 0;
	}

	protected boolean isTotalDigits(Field fOI) {
		return totalDigits(fOI) == 0;
	}

	protected boolean isPrecision(Field fOI) {
		return precision(fOI) == 0;
	}

	protected boolean isConfigFilePath(Field fOI) {
		return configFilePath(fOI).isEmpty();
	}

	protected boolean isMaxDigitsKey(Field fOI) {
		return maxDigitsKey(fOI).isEmpty();
	}

	protected boolean isTotalDigitsKey(Field fOI) {
		return totalDigitsKey(fOI).isEmpty();
	}

	protected boolean isPrecisionKey(Field fOI) {
		return precisionKey(fOI).isEmpty();
	}

}
