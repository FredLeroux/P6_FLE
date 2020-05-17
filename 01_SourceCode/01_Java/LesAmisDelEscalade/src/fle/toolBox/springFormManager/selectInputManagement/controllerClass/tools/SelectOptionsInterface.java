package fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools;

import org.springframework.context.MessageSource;

public interface SelectOptionsInterface {	
	
	
	public String getValue();	
	
	public String getDisplayValue();
	
	public String getDisplayValueI18N(MessageSource messageSource, String suffix);
	
	
	

	

	

	
	
}
