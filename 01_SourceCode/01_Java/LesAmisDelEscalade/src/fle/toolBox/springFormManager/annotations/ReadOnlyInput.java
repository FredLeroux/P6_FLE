package fle.toolBox.springFormManager.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface ReadOnlyInput {
	/**
	 * Is the form name list where to apply the read only constrain
	 * Optional: if not used annotated field will be on readOnly for each formular
	 * calling it, however by setting the applyToFormName this will allow to set
	 * readonly only on specified form(s)
	 */
	public String[] applyToForm() default {};

}
