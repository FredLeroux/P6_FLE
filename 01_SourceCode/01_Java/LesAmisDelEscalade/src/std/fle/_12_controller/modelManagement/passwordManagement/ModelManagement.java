package std.fle._12_controller.modelManagement.passwordManagement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoPassResetSFC;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoPassUpdateSFC;
import std.fle._03_sfc.usersInfoSFC.UsersInfoMailSFC;

public interface ModelManagement {
	
	
	
	public ModelAndView manageForgotPassModel(ModelAndView model, UsersInfoMailSFC usersInfoMailSFC,
			HttpServletRequest request);

	public ModelAndView manageResetPasswordModel(ModelAndView model,
			UsersAccountInfoPassResetSFC usersAccountInfoPassResetSFC, HttpServletRequest request);
	
	public ModelAndView manageUpdatePasswordModel(ModelAndView model,
			UsersAccountInfoPassUpdateSFC usersAccountInfoPassUpdateSFC, HttpServletRequest request);
}
