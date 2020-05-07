package std.fle._0x_controller.modelManagement.accountModelManagement;


import org.springframework.web.servlet.ModelAndView;

import std.fle._04_associationModel._04_03_sfc.UserSFC;

public interface AccountModelManagement {

	public ModelAndView manageUserFormRegister(ModelAndView model, UserSFC userSFC);
	
	public ModelAndView manageUserFormUpdate(ModelAndView model);

	public ModelAndView manageUserCreation(UserSFC userSFC);
	
	public ModelAndView displayMemeberStatus(ModelAndView model,String modelAttributeName,Integer id);
	
	public ModelAndView doUpdateMemberStatus(ModelAndView model,Integer id, String memberStatusSFC);
		

}