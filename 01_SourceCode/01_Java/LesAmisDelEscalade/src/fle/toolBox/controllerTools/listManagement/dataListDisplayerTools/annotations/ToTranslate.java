package fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })

//TODO javadoc preciser qu il faut l epoint anat le suffix
/**
 * 
 * @author Frederic Leroux <br>
 *
 */
public @interface ToTranslate {
	
	String suffix();

}
