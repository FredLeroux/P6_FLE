package fle.toolBox.springFormManager.annotations.inputTextArea;

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
 *          {@link #maxLenght()}<br>
 *          {@link #readOnly()}<br>
 *          {@link #limitCharName()}
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
	 * the max length accepted in this text area
	 */
	int maxLenght() default 0;

	/**
	 * 
	 * define if textArea is read only default false
	 */
	boolean readOnly() default false;
	
	/**
	 * Allow to set the limit Char designation, comment.... or whatever  using sentence directly or key to properties 
	 * @note the limitCharName is always put before the char number indication
	 * @advice use key as follow String.String 
	 */
	  
	String limitCharName() default "";

}
