package std.fle._12_controller.controllerClass.climbingSiteController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteCommentsSFC;
import std.fle._12_controller.modelManagement.climbingSiteCommentsManagement.ClimbingSiteCommentsModelManagement;

@Controller
public class ClimbingSiteCommentEditController {
	
	@Autowired
	ClimbingSiteCommentsModelManagement manager;

	@GetMapping(value = "/04_listPage/commentEdit/{id}")
	public ModelAndView initVar(ModelAndView model,@PathVariable Integer id) {
		return manager.manageInitVar(model, id, "06_climbingSite/displayComment");
	}
	
	@GetMapping(value= "/06_climbingSite/displayComment")
	public ModelAndView displayCommentEditor(ModelAndView model,
			@ModelAttribute(value = "climbingSiteComment") ClimbingSiteCommentsSFC climbingSiteCommentsSFC) {
		return manager.manageDisplayCommentEditor(model, "climbingSiteComment" );
	}
			
	@PostMapping(value="/06_climbingSite/updateComment")
	public ModelAndView updateComments(ModelAndView model,@ModelAttribute(value = "climbingSiteComment") @Validated ClimbingSiteCommentsSFC climbingSiteCommentsSFC,BindingResult result) {
		return manager.manageUpdateComment(model, climbingSiteCommentsSFC,"climbingSiteComment",result);
	}
	
	@GetMapping(value ="/06_climbingSite/deleteComment")
	public ModelAndView deleteComment(ModelAndView model,ClimbingSiteCommentsSFC climbingSiteCommentsSFC) {
		return manager.manageDeleteComment(model, climbingSiteCommentsSFC);
	}

}
