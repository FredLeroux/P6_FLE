package std.fle._12_controller.modelManagement.deleteManager;

import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote allow to add to model view the delete controller URL via model
 *          attribute "deleteURL", and I18N message via model attribute
 *          "confirmMessage".
 */
public interface DeleteConfirmationManager {

	/**
	 * 
	 * @param model the model where to add informations.
	 * @param deleteURL the controller URL added to model as attribute name = "deleteURL".
	 * @param messageKey the message key to add I18N message to model as attribute name =  "confirmMessage".
	 */
	public void addURLAndMessage(ModelAndView model, String deleteURL, String messageKey);

}
