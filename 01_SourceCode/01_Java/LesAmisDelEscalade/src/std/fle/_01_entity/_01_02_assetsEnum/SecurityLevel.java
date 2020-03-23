package std.fle._01_entity._01_02_assetsEnum;

import org.springframework.context.MessageSource;

import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectOptions;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectOptionsInterface;

public enum SecurityLevel implements SelectOptionsInterface {
	
	ADMIN("0","Administrator"),
	SUPER_USER("1","Member"),
	USER("2","User"),
	VISITOR("3","Visitor");
	
	private SelectOptions selectOptions;
	
	
	private SecurityLevel(String levelCode,String levelName ) {
		selectOptions = new SelectOptions(levelCode, levelName);
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
