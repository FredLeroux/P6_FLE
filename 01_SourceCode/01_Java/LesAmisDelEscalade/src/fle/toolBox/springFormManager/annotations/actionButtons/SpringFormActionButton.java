package fle.toolBox.springFormManager.annotations.actionButtons;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote change a field to a simple button(no action, no submit only waiting
 *          implemntation from javascript, jQuery or whatever) in a springForm
 *          created via SpringFormSettings with id = fieldName, Dipslaymessage =
 *          the key setted({@link #displayMessagePropertyKey()}) <b> Note:</b> for now the css is the same as the
 *          springForm submit button to change it use CSS attribute id
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface SpringFormActionButton {

	/**
	 * If properties files contains the key the display message will be the one in
	 * properties files(via spring tag message code attribute) however display
	 * message = displayMessagePropertyKey
	 */
	public String displayMessagePropertyKey();

}
