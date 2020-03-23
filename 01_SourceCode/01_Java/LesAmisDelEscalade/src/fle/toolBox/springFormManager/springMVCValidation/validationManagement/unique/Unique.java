package fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Unique {
	
	public String entityName();
	
	public String fieldName();
	
	public String modelAttributeValue();

}
