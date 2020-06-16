package std.fle._0x_controller.modelManagement.deleteManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.Internationalization.LocalMessage;


@Service
public class DeleteConfirmationManagerImplemented implements DeleteConfirmationManager {

	@Autowired
	private  LocalMessage local;
	

	@Override
	public  void addURLAndMessage(ModelAndView model, String deleteURL, String messageKey) {
		addDeleteURL(model, deleteURL);
		addDeleteConfirmMessage(model, messageKey);
	}

	private  void addDeleteURL(ModelAndView model, String deleteURL) {
		model.addObject("deleteURL", deleteURL);
	}

	private  void addDeleteConfirmMessage(ModelAndView model, String messageKey) {
		model.addObject("confirmMessage", local.message(messageKey));
	}

}
