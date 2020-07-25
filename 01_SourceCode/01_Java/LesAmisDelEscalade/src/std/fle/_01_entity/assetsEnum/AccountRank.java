package std.fle._01_entity.assetsEnum;

import org.springframework.context.MessageSource;

import fle.toolBox.FredParser;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectOptions;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectOptionsInterface;
import std.fle._10_security.SecurityLevel;

public enum AccountRank implements SelectOptionsInterface {
	ADMINISTRATOR(SecurityLevel.ADMIN.rank(),"administrator"),
	MEMBER(SecurityLevel.SUPER_USER.rank(),"member"),
	USER(SecurityLevel.USER.rank(),"user");

	private SelectOptions selectOptions;
	
	
	
	
	private AccountRank(Integer value,String displayValue) {
		this.selectOptions = new SelectOptions(FredParser.asString(value), displayValue);
	}

	@Override
	public String getValue() {
		return selectOptions.getValue();
	}

	@Override
	public String getDisplayValue() {	
		return selectOptions.getDisplayValue();
	}

	@Override
	public String getDisplayValueI18N(MessageSource messageSource, String suffix) {		
		return selectOptions.getDisplayValueI18N(messageSource, suffix);
	}

}
