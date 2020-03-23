package fle.toolBox.springFormManager.springMVCValidation.validationManagement.numeric;

import java.lang.reflect.Field;
/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote control value of max, total and precision, after value definition in function of needs.
 *
 */
public class NumericAnnotationDataValueBoolean extends NumericAnnotationDataValue {

	protected boolean isMaxDigitsZero(Field fOI) {
		return getMaxDigitsValue(fOI) == 0;
	}

	protected boolean isTotalDigitsZero(Field fOI) {
		return getTotalDigitsValue(fOI) == 0;
	}
	
	protected boolean isPrecisionZero(Field fOI) {
		return getPrecisionValue(fOI) == 0;
	}

}
