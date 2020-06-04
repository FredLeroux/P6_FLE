package std.fle._0x_controller.modelManagement.climbingSiteCommentsManagement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import std.fle._00_general.SessionVariables;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteCommentsSFC;
import std.fle._06_dao.climbingSiteCommentsDao.ClimbingSiteCommentsDAO;

@Service
public class ClimbingSiteCommentsModelManagementImplemented implements ClimbingSiteCommentsModelManagement {

	@Autowired
	HttpServletRequest request;

	@Autowired
	ClimbingSiteCommentsDAO dao;

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
		model.addObject(modelAttributName, dao.getClimbingSiteCommentsSFCForEdit(commentId));
		model.addObject("log",dao.modificationLogI18N(commentId));
		return model;
	}

	@Override
	public ModelAndView manageUpdateComment(ModelAndView model, ClimbingSiteCommentsSFC climbingSiteCommentsSFC) {		
		dao.updateComment(climbingSiteCommentsSFC,commentId,getAuthorPseudo());
		setBackToList(model);
		return model;
	}
	
	@Override
	public ModelAndView manageDeleteComment(ModelAndView model, ClimbingSiteCommentsSFC climbingSiteCommentsSFC) {
		dao.deleteComment(climbingSiteCommentsSFC,commentId, getAuthorPseudo());
		setBackToList(model);
		return model;
	}
	
	private String getAuthorPseudo() {
		sessVar.setRequest(request);
		return sessVar.getPseudo();
	}
	
	private void setBackToList(ModelAndView model) {
		model.setViewName("redirect:/04_listPage/listPage?listType=climbingSitesComments");
	}

}
