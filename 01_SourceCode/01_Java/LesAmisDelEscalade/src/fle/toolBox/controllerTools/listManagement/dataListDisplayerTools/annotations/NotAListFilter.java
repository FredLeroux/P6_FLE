package fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote in SLO class define a field has to be not taked in account for filter list creation<br>
 * 
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface NotAListFilter {

}
