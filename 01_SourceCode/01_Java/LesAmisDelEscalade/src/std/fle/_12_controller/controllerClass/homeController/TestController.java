package std.fle._12_controller.controllerClass.homeController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import std.fle._04_associationModel.sfc.UserSFC;

@Controller
public class TestController {

	@GetMapping(value = "/test/iframeTest")
	public ModelAndView iframe() {
		return new ModelAndView("test/iframeTest");
		
	}
	
	@GetMapping(value ="/test/userFormRegister")
	public ModelAndView indexDisplay(ModelAndView model,@ModelAttribute(value = "userManagement") UserSFC userSFC, HttpServletRequest request){		
		model.setViewName("test/userFormRegister");
		HttpSession sess = request.getSession();
		sess.setAttribute("option4", "hello");
		return model;
	
}}
