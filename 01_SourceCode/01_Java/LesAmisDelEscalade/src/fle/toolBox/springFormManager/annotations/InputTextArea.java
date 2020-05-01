package fle.toolBox.springFormManager.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote define a field as an textarea input height and width are managed by CSS,<br>
 * if the field is fieldName for a simple class, className.fieldName for a associated class
 */
@Retention(RUNTIME)
@Target(FIELD)

public @interface InputTextArea {

}
