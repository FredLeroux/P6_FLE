package fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * @author Frederic Leroux <br>
 * @Version 1.0
 * @apiNote Determine if in the database the field value does not already
 *          exist<br>
 *          {@link #entityName()} <br>
 *          {@link #fieldName()}<br>
 *          {@link #modelAttributeValue()}
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface Unique {
	/**
	 * is the exact name of the entity ENT related to the SFC class class containing
	 * the field to check for example field color in class ENT(entity)
	 * CarPersonnal.class name will be CarPersonnal
	 *
	 */
	public String entityName();

	/**
	 * Simply the entity ENT field name corresponding to the SFC annotated field
	 * 
	 */
	public String fieldName();

	/**
	 * The form modelAttributeName value concerned by the constraint
	 * 
	 */
	public String modelAttributeValue();

}
