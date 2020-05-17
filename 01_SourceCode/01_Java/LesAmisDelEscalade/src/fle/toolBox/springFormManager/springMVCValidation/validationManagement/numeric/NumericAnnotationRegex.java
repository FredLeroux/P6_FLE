package fle.toolBox.springFormManager.springMVCValidation.validationManagement.numeric;

import java.lang.reflect.Field;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote determine regex to validated numeric format in function of
 *          annotation data.
 */
public class NumericAnnotationRegex extends NumericAnnotationDataValueBoolean {

	private String genericRegex = "[0.9]*";

	protected String setRegex(Field fOI) {
		if (genericRegexBoolean(fOI)) {
			return genericRegex;
		} else if (genericRegexWithPrecisionBoolean(fOI)) {
			return genericRegexWithPrecisionRegex(fOI);
		} else if (maxDigitsBoolean(fOI)) {
			return maxDigitsRegex(fOI);
		} else if (totalDigitsBoolean(fOI)) {
			return totalDigitsRegex(fOI);
		} else if (maxDigitsWithPrecisionBoolean(fOI)) {
			return maxDigitsWithPrecisionRegex(fOI);
		} else if (totaDigitWithPrecisionBoolean(fOI)) {
			return totalDigitsWithPrecisionRegex(fOI);
		} else {
			return null;
		}
	}

	private boolean genericRegexBoolean(Field fOI) {
		return isMaxDigitsZero(fOI) && isTotalDigitsZero(fOI) && isPrecisionZero(fOI);
	}

	private boolean genericRegexWithPrecisionBoolean(Field fOI) {
		return isMaxDigitsZero(fOI) && isTotalDigitsZero(fOI) && !isPrecisionZero(fOI);
	}

	private String genericRegexWithPrecisionRegex(Field fOI) {
		return "[0.9]*.[0-9] {" + getPrecisionValue(fOI) + "}";
	}

	private boolean maxDigitsBoolean(Field fOI) {
		return !isMaxDigitsZero(fOI) && isPrecisionZero(fOI);
	}

	private String maxDigitsRegex(Field fOI) {
		return "[0-9]{1," + getMaxDigitsValue(fOI) + "}";
	}

	private boolean totalDigitsBoolean(Field fOI) {
		return !isTotalDigitsZero(fOI) && isPrecisionZero(fOI);
	}

	private String totalDigitsRegex(Field fOI) {
		return "[0-9]{" + getTotalDigitsValue(fOI) + "}";
	}

	private boolean maxDigitsWithPrecisionBoolean(Field fOI) {
		return !isMaxDigitsZero(fOI) && !isPrecisionZero(fOI);
	}

	private String maxDigitsWithPrecisionRegex(Field fOI) {
		int maxDigits = getMaxDigitsValue(fOI);
		int precision = getPrecisionValue(fOI);
		if (getMaxDigitsValue(fOI) > getPrecisionValue(fOI)) {
			int newMaxDigits = maxDigits - precision;
			return "[0-9]{1," + newMaxDigits + "}.[0-9]{" + precision + "}";
		} else {
			return "[0]{1}.[0-9]{1," + precision + "}";
		}
	}

	private boolean totaDigitWithPrecisionBoolean(Field fOI) {
		return !isTotalDigitsZero(fOI) && !isPrecisionZero(fOI);
	}

	private String totalDigitsWithPrecisionRegex(Field fOI) {
		int totalDigits = getTotalDigitsValue(fOI);
		int precision = getPrecisionValue(fOI);
		if (getTotalDigitsValue(fOI) > getPrecisionValue(fOI)) {
			int newTotalDigits = totalDigits - precision;
			return "[0-9]{" + newTotalDigits + "}.[0-9]{" + precision + "}";
		} else {
			return "[0]{1}.[0-9]{" + precision + "}";
		}
	}

}
