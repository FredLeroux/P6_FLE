package std.fle._05_controller._02_AccountMAnagementController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.Internationalization.LocalMessage;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoPassResetSFC;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoPassUpdateSFC;
import std.fle._0x_modelManagement.ModelManagement;

@Controller
public class PasswordModificationController {

	@Autowired
	LocalMessage locale;

	@Autowired
	ModelManagement manager;

	@GetMapping(value = "/02_AccountManagement/resetCompromisedPassword")
	public ModelAndView resetPassword(ModelAndView model,
			@ModelAttribute(value = "resetPass") UsersAccountInfoPassResetSFC usersAccountInfoPassModifSFC) {
		model.setViewName("02_AccountManagement/resetPasswordForm");
		return model;
	}

	@GetMapping(value = "/02_AccountManagement/passwordModification")
	public ModelAndView passwordModification(ModelAndView model,
			@ModelAttribute(value = "updatePass") UsersAccountInfoPassUpdateSFC usersAccountInfoUpdateModifSFC) {
		model.setViewName("02_AccountManagement/updatePasswordForm");
		return model;

	}

	@GetMapping(value = "/02_AccountManagement/passwordConfirmationError")
	public ModelAndView passwordConfirmationError(ModelAndView model,
			@ModelAttribute(value = "updatePass") UsersAccountInfoPassUpdateSFC usersAccountInfoUpdateModifSFC) {
		model.setViewName("02_AccountManagement/updatePasswordForm");
		model.addObject("wrongPass", locale.message("wrongOldPass.error"));
		return model;

	}

	@PostMapping(value = "/02_AccountManagement/resetPassword")
	public ModelAndView resetPassword(ModelAndView model,
			@ModelAttribute(value = "resetPass") @Validated UsersAccountInfoPassResetSFC usersAccountInfoPassResetSFC,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			model.setViewName("02_AccountManagement/resetPasswordForm");
			return model;
		}
		return manager.manageResetPasswordModel(model, usersAccountInfoPassResetSFC, request);
	}

	@PostMapping(value = "/02_AccountManagement/updatePassword")
	public ModelAndView updatePassword(ModelAndView model,
			@ModelAttribute(value = "updatePass") @Validated UsersAccountInfoPassUpdateSFC usersAccountInfoPassUpdateSFC,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			model.setViewName("02_AccountManagement/updatePasswordForm");
			return model;
		}
		return manager.manageUpdatePasswordModel(model, usersAccountInfoPassUpdateSFC, request);
	}

}
