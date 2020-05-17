package fle.toolBox.springFormManager.springMVCValidation.validationManagement.numeric;

import java.lang.reflect.Field;

import fle.toolBox.ConfigurationFileReader;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote allow to parse data from configuration file or use directly data in
 *          function of needs.
 */
public class NumericAnnotationDataValue extends NumericAnnotationBoolean {

	private ConfigurationFileReader reader;

	protected int getMaxDigitsValue(Field fOI) {
		if (isReaderNeeded(fOI)) {
			return Integer.parseInt(reader.getProperty(maxDigitsKey(fOI)));
		} else {
			return maxDigits(fOI);
		}
	}

	protected int getTotalDigitsValue(Field fOI) {
		if (isReaderNeeded(fOI)) {
			return Integer.parseInt(reader.getProperty(totalDigitsKey(fOI)));
		} else {
			return totalDigits(fOI);
		}
	}

	protected int getPrecisionValue(Field fOI) {
		if (isReaderNeeded(fOI)) {
			return Integer.parseInt(reader.getProperty(precisionKey(fOI)));
		} else {
			return precision(fOI);
		}
	}

	private boolean isReaderNeeded(Field fOI) {
		if (!isConfigFilePath(fOI)) {
			if (reader == null) {
				reader = new ConfigurationFileReader(configFilePath(fOI));
				return true;
			} else {
				return true;
			}
		} else {
			return false;
		}

	}

}
