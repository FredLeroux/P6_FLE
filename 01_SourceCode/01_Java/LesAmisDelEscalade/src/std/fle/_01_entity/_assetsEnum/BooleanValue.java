package std.fle._01_entity._assetsEnum;

import org.springframework.context.MessageSource;

import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectOptions;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectOptionsInterface;

public enum BooleanValue implements SelectOptionsInterface {
	TRUE(true,"true"),
	FALSE(false,"false");
	
	private SelectOptions selectOption;
	
	

	private BooleanValue(Boolean value, String displayValue) {
		this.selectOption = new SelectOptions(value.toString(), displayValue);
	}

	@Override
	public String getValue() {		
		return selectOption.getValue();
	}

	@Override
	public String getDisplayValue() {	
		return selectOption.getDisplayValue();
	}

	@Override
	public String getDisplayValueI18N(MessageSource messageSource, String suffix) {	
		return selectOption.getDisplayValueI18N(messageSource, suffix);
	}

}
