package std.fle._01_entity._01_02_assetsEnum;

import org.springframework.context.MessageSource;

import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectOptions;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectOptionsInterface;

public enum Gender implements SelectOptionsInterface {

	FEMALE("female","Female"), MALE("male","Male");

	private SelectOptions selectOptions;;

		private Gender(String value, String displayValue) {
		this.selectOptions = new SelectOptions(value, displayValue);
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
