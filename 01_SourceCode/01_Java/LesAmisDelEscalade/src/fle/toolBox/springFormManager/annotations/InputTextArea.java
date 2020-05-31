package fle.toolBox.springFormManager.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote define a field as an textarea <br>
 *          {@link #rows()}<br>
 *          {@link #charByRows()}<br>
 *          {@link #readOnly()}
 */
@Retention(RUNTIME)
@Target(FIELD)

public @interface InputTextArea {
	/**
	 * 
	 * Define the number of rows displayed
	 */
	int rows();

	/**
	 * 
	 * define the numbers of char by rows
	 */
	int charByRows();

	/**
	 * 
	 * define if textArea is read only default false
	 */
	boolean readOnly() default false;

}
