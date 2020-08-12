package fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools;

import org.springframework.context.MessageSource;

import fle.toolBox.Internationalization.Internationalization;

//TODO 1-JAVADOC
/**
 *
 * @author Frederic Leroux <br>
 *
 */

public class SelectOptions extends Internationalization implements SelectOptionsInterface {

	private String value;
	private String displayValue;

	public SelectOptions(String value, String displayValue) {
		this.value = value;
		this.displayValue = displayValue;

	}

	@Override
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	@Override
	public String getDisplayValueI18N(MessageSource messageSource, String suffix) {
		setSuffix(suffix);
		return messI18n(keyFinal(value), messageSource);
	}

}
