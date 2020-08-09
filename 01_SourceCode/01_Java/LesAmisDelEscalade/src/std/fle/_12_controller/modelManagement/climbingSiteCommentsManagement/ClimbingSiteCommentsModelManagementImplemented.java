package std.fle._12_controller.modelManagement.climbingSiteCommentsManagement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import std.fle._00_general.SessionVariables;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteCommentsSFC;
import std.fle._07_service.climbingSiteCommentsService.ClimbingSiteCommentsService;

@Service
public class ClimbingSiteCommentsModelManagementImplemented implements ClimbingSiteCommentsModelManagement {

	@Autowired
	HttpServletRequest request;

	@Autowired
	ClimbingSiteCommentsService commentsService;

	private SessionVariables sessVar = new SessionVariables();
	private Integer commentId = null;


	@Override
	public ModelAndView manageInitVar(ModelAndView model,Integer id,String redirectTo) {
		commentId = id;
		model.setViewName("redirect:/".concat(redirectTo));
		return model;
	}

	@Override
	public ModelAndView manageDisplayCommentEditor(ModelAndView model,  String modelAttributName) {
		model.setViewName("06_climbingSite/editCommentForm");
		model.addObject(modelAttributName, commentsService.getClimbingSiteCommentsSFCForEdit(commentId));
		model.addObject("log",commentsService.modificationLogI18N(commentId));
		model.addObject("commentListBackUrl", "04_listPage/listInListfrontViewAddObject");
		return model;
	}

	@Override
	public ModelAndView manageUpdateComment(ModelAndView model, ClimbingSiteCommentsSFC climbingSiteCommentsSFC,String modelAttributeName,BindingResult result) {
		if(result.hasErrors()) {
			model.setViewName("06_climbingSite/editCommentForm");
			model.addObject(modelAttributeName,climbingSiteCommentsSFC);
			model.addObject("log",commentsService.modificationLogI18N(commentId));
			return model;
		}
		commentsService.updateComment(climbingSiteCommentsSFC,commentId,getAuthorPseudo());
		setBackToList(model);
		return model;
	}

	@Override
	public ModelAndView manageDeleteComment(ModelAndView model, ClimbingSiteCommentsSFC climbingSiteCommentsSFC) {
		commentsService.deleteComment(climbingSiteCommentsSFC,commentId, getAuthorPseudo());
		setBackToList(model);
		return model;
	}

	private String getAuthorPseudo() {
		sessVar.setRequest(request);
		return sessVar.getPseudo();
	}

	private void setBackToList(ModelAndView model) {
		model.setViewName("redirect:/04_listPage/listInListfrontViewAddObject");
	}

}
