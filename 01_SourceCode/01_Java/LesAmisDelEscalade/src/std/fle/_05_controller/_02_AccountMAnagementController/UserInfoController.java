package std.fle._05_controller._02_AccountMAnagementController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import std.fle._01_model._01_accountManagement.UserInfo;


@Controller
public class UserInfoController {

	@RequestMapping("/userinfo")
	public ModelAndView displayUserInfoPage(@ModelAttribute(value= "UserInfo") UserInfo userInfo) {
		return new ModelAndView("/02_AccountManagement/userInfo");
	}
}
