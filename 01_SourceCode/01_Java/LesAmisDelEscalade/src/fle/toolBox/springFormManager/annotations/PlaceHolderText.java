package fle.toolBox.springFormManager.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0<br>
 * Allow to set the place holder using sentence directly or key to properties 
 * @advice use key as follow String.String  
 * @note accent not yet accepted for direct message
 */
@Retention(RUNTIME)
@Target({ FIELD, METHOD })

public @interface PlaceHolderText {

	
	String message() ;
}
