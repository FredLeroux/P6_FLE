package std.fle._12_controller.controllerClass.homeController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.ConfigurationFileReader;
import fle.toolBox.FredParser;
import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.logger.Log4J2;
import fle.toolBox.navBarManagement.NavBarOptions;
import fle.toolBox.navBarManagement.NavBarOptionsList;
import std.fle._00_general.SessionVariables;

@Controller
public class HomeController {

	@Autowired
	LocalMessage locale;
	
	

	private Log4J2<HomeController> log = new Log4J2<HomeController>(this);
	private NavBarOptionsList optionList = new NavBarOptionsList(
			"configuration/securitySettings/NavBarOptionsInfo.xml");
	private ConfigurationFileReader tentative = new ConfigurationFileReader(
			"configuration/securitySettings/securitySettings.xml");
	private Integer maxTentative = FredParser.toInteger(tentative.getProperty("maxTentatativesAllowed"));

	@GetMapping(value = "/navbar")
	public ModelAndView navbar(ModelAndView model, HttpServletRequest request) {
		SessionVariables sessVar = new SessionVariables(request);
		ArrayList<NavBarOptions> option =  optionList.getAllNavBarOptions(sessVar.getSecurityLevel());		
		model.setViewName("01_home/index");
		model.addObject("optionList", option);
		return model;
	}
	 
	@GetMapping(value = "/index")
	public ModelAndView indexDisplay(ModelAndView model) {		
		model.addObject("iFrameSource", "'01_home/01_01_welcomePage/welcomePage'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");		
		return model;

	}
	
	

	@GetMapping(value = "/createAccount")
	public ModelAndView createAccountNav(ModelAndView model) {
		model.addObject("iFrameSource", "'02_AccountManagement/userFormRegister'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}

	@GetMapping(value = "/emptyConnexion")
	public ModelAndView emptyError(ModelAndView model) {		
		model.addObject("error", locale.message("logEmpty.error"));
		model.addObject("iFrameSource", "'01_home/01_01_welcomePage/welcomePage'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}

	@GetMapping(value = "/incorrectConnexion")
	public ModelAndView incorrectError(ModelAndView model) {
		model.addObject("error", locale.message("logIncorrect.error"));
		model.addObject("iFrameSource", "'01_home/01_01_welcomePage/welcomePage'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}

	
	@GetMapping(value = "/wrongConnexion")
	public ModelAndView wrong(ModelAndView model, HttpServletRequest request) {
		Integer tentativeLeft = maxTentative - FredParser.toInteger(request.getParameter("tentative"));
		model.addObject("error", tentativeLeft + locale.message("wrong.error"));
		model.addObject("iFrameSource", "'01_home/01_01_welcomePage/welcomePage'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}

	@GetMapping(value = "/myAccount")
	public ModelAndView myAccount(ModelAndView model) {
		model.addObject("iFrameSource", "'02_AccountManagement/userFormUpdate'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}

	@GetMapping(value = "/accountActivated")
	public ModelAndView activation(ModelAndView model) {
		model.addObject("iFrameSource", "'03_messagesPages/accountActivated'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}

	@GetMapping(value = "/accountActivationError")
	public ModelAndView activationError(ModelAndView model) {
		model.addObject("iFrameSource", "'03_messagesPages/accountActivationError'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}
	
	@GetMapping(value = "/accountNotActivated")
	public ModelAndView accountNotActivated(ModelAndView model) {
		model.addObject("iFrameSource", "'03_messagesPages/accountNotYetActivated'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}
	
	@GetMapping(value = "/lockedAccount")
	public ModelAndView lockedAccount(ModelAndView model) {
		model.addObject("iFrameSource", "'03_messagesPages/accountLocked'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}
	

	
	@GetMapping(value = "/unlockMyAccount")
	public ModelAndView unlockMyAccount(ModelAndView model,HttpServletRequest request) {
		
		model.addObject("iFrameSource", "'02_AccountManagement/resetCompromisedPassword'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.addObject("forgot",request.getAttribute("forgot"));
		model.setViewName("forward:/navbar");
		
		return model;
	}
	
	@GetMapping(value = "/resetCodeExpired")
	public ModelAndView resetCodeExpired(ModelAndView model) {
		model.addObject("iFrameSource", "'03_messagesPages/codeExpired'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}
	
	@GetMapping(value = "/error")
	public ModelAndView error(ModelAndView model) {
		model.addObject("iFrameSource", "'03_messagesPages/errorsPage'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}
	
/*	@GetMapping(value = "/errorNotException")
	public ModelAndView errorNotException(ModelAndView model) {
		model.setViewName("03_messagesPages/errorsPage");
		return model;
	}
*/	
	@GetMapping(value = { "/internalError","/errorNotException"})
	public ModelAndView internalError(ModelAndView model) {
		model.setViewName("03_messagesPages/errorsPage");		
		return model;
	}
	
	
	@GetMapping(value = "/forgotPassword")
	public ModelAndView forgotPassword(ModelAndView model) {
		model.addObject("iFrameSource", "'03_messagesPages/forgotPassword'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}
	
	@GetMapping(value = "/callList")
	public ModelAndView list(ModelAndView model,HttpServletRequest request) {
		String listType = request.getParameter("listType");
		model.addObject("iFrameSource", "'04_listPage/listPage?listType="+listType+"'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");		
		return model;
	}
	
	
	@GetMapping(value = "/accesDenied")
	public ModelAndView accesDenied(ModelAndView model) {		
		model.addObject("iFrameSource", "'03_messagesPages/accesDenied'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");		
		return model;
	}
	
	@GetMapping(value = "/noResultsToDisplay")
	public ModelAndView noResultsToDisplay(ModelAndView model) {		
		model.addObject("iFrameSource", "'03_messagesPages/noResultsToDisplay'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");		
		return model;
	}

	
	@GetMapping(value="/addMineTopo")
	public ModelAndView addMineTopo(ModelAndView model) {
		model.addObject("iFrameSource", "'05_topo/createNewTopoForm'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");		
		return model;
	}
	
	
	
	@GetMapping(value="/borrowDemands")
	public ModelAndView borrowDemands(ModelAndView model) {
		model.addObject("iFrameSource", "'05_topo/borrowDemandsList'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");		
		return model;
	}
	
	@GetMapping(value="/addSite")
	public ModelAndView addSite(ModelAndView model) {		
		model.addObject("iFrameSource", "'06_climbingSite/createNewSite'");//
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");		
		return model;
	}
	
	@GetMapping(value="/siteHaveBeenCommented")
	public ModelAndView siteDetails(ModelAndView model) {		
		model.addObject("iFrameSource", "'06_climbingSite/climbingSiteDetailsDisplay'");//
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");		
		return model;
	}
	

	
	
}
