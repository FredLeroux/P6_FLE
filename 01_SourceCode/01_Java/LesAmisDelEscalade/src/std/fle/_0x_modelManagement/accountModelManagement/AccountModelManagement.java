package std.fle._0x_modelManagement.accountModelManagement;

import org.springframework.web.servlet.ModelAndView;

import std.fle._04_associationModel._04_03_sfc.UserSFC;
import std.fle._04_associationModel._04_03_sfc.UserUpdateSFC;

public interface AccountModelManagement {

	public ModelAndView manageUserFormRegister(ModelAndView model, UserSFC userSFC);
	
	public ModelAndView manageUserFormUpdate(ModelAndView model, UserUpdateSFC userUpdateSFC);

	public ModelAndView manageUserCreation(UserSFC userSFC);

}
