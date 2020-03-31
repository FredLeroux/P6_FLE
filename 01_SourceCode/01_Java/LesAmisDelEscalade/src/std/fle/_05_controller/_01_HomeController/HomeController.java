package std.fle._05_controller._01_HomeController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.FredParser;
import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.logger.Log4J2;
import std.fle._05_controller.NavBarOptions;
import std.fle._05_controller.NavBarOptionsList;
import std.fle._05_controller.SessionVariables;


@Controller
public class HomeController {
	
	@Autowired
	LocalMessage locale;
	
	private Log4J2<HomeController> log = new Log4J2<HomeController>(this);
	private NavBarOptionsList optionList = new NavBarOptionsList("configuration/securitySettings/NavBarOptionsInfo.xml");
	
	
	
	@GetMapping(value ="/index")
	public ModelAndView indexDisplay(ModelAndView model,HttpServletRequest request) {
		SessionVariables sessVar = new SessionVariables(request);
		ArrayList<NavBarOptions> option = optionList.getAllNavBarOptions(sessVar.getSecurityLevel());		
		log.log().info("in homeController");
		model.setViewName("01_home/index");	
		model.addObject("iFrameSource", "'01_home/01_01_welcomePage/welcomePage'");		
		model.addObject("optionList",option);
		return model;

	}
	
	@GetMapping(value = "/createAccount")
	public ModelAndView createAccountNav(ModelAndView model) {		
		model.setViewName("01_home/index");	
		ArrayList<NavBarOptions> option = optionList.getAllNavBarOptions(3);
		model.addObject("optionList",option);
		model.addObject("iFrameSource", "'02_AccountManagement/userFormRegister'");		
		return model;
	}
	
	@GetMapping(value = "/emptyConnexion")
	public ModelAndView emptyError(ModelAndView model) {
		model.setViewName("01_home/index");
		model.addObject("error", locale.message("logEmpty.error"));
		model.addObject("iFrameSource", "'01_home/01_01_welcomePage/welcomePage'");
		return model;
	}
	
	@GetMapping(value = "/incorrectConnexion")
	public ModelAndView incorrectError(ModelAndView model) {
		model.setViewName("01_home/index");
		model.addObject("error", locale.message("logIncorrect.error"));
		model.addObject("iFrameSource", "'01_home/01_01_welcomePage/welcomePage'");
		return model;
	}
	
	
	//TODO 0-Implemented countdown on tentative
	@GetMapping(value = "/wrongConnexion")
	public ModelAndView wrong(ModelAndView model) {
		model.setViewName("01_home/index");
		model.addObject("error", 1+locale.message("wrong.error"));
		model.addObject("iFrameSource", "'01_home/01_01_welcomePage/welcomePage'");
		return model;
	}
}
