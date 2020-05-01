package std.fle._0x_modelManagement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import std.fle._03_sfc._03_01_usersInfoSFC.UsersInfoMailSFC;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoPassResetSFC;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoPassUpdateSFC;
import std.fle._04_associationModel._04_03_sfc.UserSFC;

public interface ModelManagement {
	
	
	
	public ModelAndView manageForgotPassModel(ModelAndView model, UsersInfoMailSFC usersInfoMailSFC,
			HttpServletRequest request);

	public ModelAndView manageResetPasswordModel(ModelAndView model,
			UsersAccountInfoPassResetSFC usersAccountInfoPassResetSFC, HttpServletRequest request);
	
	public ModelAndView manageUpdatePasswordModel(ModelAndView model,
			UsersAccountInfoPassUpdateSFC usersAccountInfoPassUpdateSFC, HttpServletRequest request);
}
