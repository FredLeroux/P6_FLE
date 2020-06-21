package std.fle._0x_controller.modelManagement.climbingSiteCommentsManagement;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteCommentsSFC;

public interface ClimbingSiteCommentsModelManagement {

	public ModelAndView manageInitVar(ModelAndView model, Integer id, String redirectTo);

	public ModelAndView manageDisplayCommentEditor(ModelAndView model, String modelAttributName);

	public ModelAndView manageUpdateComment(ModelAndView model, ClimbingSiteCommentsSFC climbingSiteCommentsSFC,String modelAttributeName,BindingResult result);
	
	public ModelAndView manageDeleteComment(ModelAndView model, ClimbingSiteCommentsSFC climbingSiteCommentsSFC);

}
