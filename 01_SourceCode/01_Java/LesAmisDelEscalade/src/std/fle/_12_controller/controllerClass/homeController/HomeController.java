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
import fle.toolBox.navBarManagement.NavBarOptions;
import fle.toolBox.navBarManagement.NavBarOptionsList;
import std.fle._00_general.SessionVariables;
import std.fle._10_security.SecurityLevel;

@Controller
public class HomeController {

	@Autowired
	LocalMessage locale;




	private NavBarOptionsList optionList = new NavBarOptionsList(
			"configuration/securitySettings/NavBarOptionsInfo.xml");
	private ConfigurationFileReader tentative = new ConfigurationFileReader(
			"configuration/securitySettings/securitySettings.xml");
	private Integer maxTentative = FredParser.toInteger(tentative.getProperty("maxTentatativesAllowed"));

	@GetMapping(value = "/navbar")
	public ModelAndView navbar(ModelAndView model, HttpServletRequest request) {
		ArrayList<NavBarOptions> option =  optionList.getAllNavBarOptions(securityLevelToApply(request));
		model.setViewName("01_home/home");
		model.addObject("optionList", option);
		return model;
	}

	private Integer securityLevelToApply(HttpServletRequest request) {
		SessionVariables sessVar = new SessionVariables(request);
		Integer securityLevel = sessVar.getSecurityLevel();
		if (securityLevel == null) {
			return SecurityLevel.ERROR.rank();
		} else {
			return securityLevel;
		}

	}

	@GetMapping(value = { "/index","/welcome"})
	public ModelAndView indexDisplay(ModelAndView model) {
		model.addObject("iFrameSource", "'01_home/welcomePage/welcomePage'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}

	@GetMapping(value = "/home")
	public ModelAndView home() {
		return siteNav("01_home/welcomePage/welcomePage");
	}

	@GetMapping(value = "/createAccount")
	public ModelAndView createAccountNav() {
		return siteNav("02_AccountManagement/userFormRegister");
	}

	@GetMapping(value = "/emptyConnexion")
	public ModelAndView emptyError(ModelAndView model) {
		model.addObject("error", locale.message("logEmpty.error"));
		model.addObject("iFrameSource", "'01_home/welcomePage/welcomePage'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}

	@GetMapping(value = "/incorrectConnexion")
	public ModelAndView incorrectError(ModelAndView model) {
		model.addObject("error", locale.message("logIncorrect.error"));
		model.addObject("iFrameSource", "'01_home/welcomePage/welcomePage'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}


	@GetMapping(value = "/wrongConnexion")
	public ModelAndView wrong(ModelAndView model, HttpServletRequest request) {
		Integer tentativeLeft = maxTentative - FredParser.toInteger(request.getParameter("tentative"));
		model.addObject("error", tentativeLeft + locale.message("wrong.error"));
		model.addObject("iFrameSource", "'01_home/welcomePage/welcomePage'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}

	@GetMapping(value = "/myAccount")
	public ModelAndView myAccount() {
		return siteNav("02_AccountManagement/userFormUpdate");
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

	@GetMapping(value = "/accountAccesError")
	public ModelAndView error(ModelAndView model,HttpServletRequest request) {
		model.addObject("iFrameSource", "'03_messagesPages/errorsPage'");
		model.addObject("iFrameLoc","'pagesViewer'");
		model.setViewName("forward:/navbar");
		return model;
	}

	@GetMapping(value = { "/internalError"})
	public ModelAndView internalError(ModelAndView model) {
		model.setViewName("03_messagesPages/errorsPage");
		return model;
	}


	@GetMapping(value = "/forgotPassword")
	public ModelAndView forgotPassword(ModelAndView model) {
		return siteNav("03_messagesPages/forgotPassword");
	}

	@GetMapping(value = "/callList")
	public ModelAndView list(ModelAndView model,HttpServletRequest request) {
		String listType = request.getParameter("listType");
		model.setViewName("redirect:04_listPage/setListPage?listType="+listType);
		return model;
	}

	@GetMapping(value = "/callListBack")
	public ModelAndView listBack(ModelAndView model,HttpServletRequest request) {
		model.setViewName("redirect:04_listPage/getUpdatedList");
		return model;
	}

			@GetMapping(value = "/callListInListBack")
	public ModelAndView listInListBack(ModelAndView model,HttpServletRequest request) {
		model.setViewName("redirect:04_listPage/getUpdatedListInList");
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
		return siteNav("03_messagesPages/noResultsToDisplay");
	}


	@GetMapping(value="/addMineTopo")
	public ModelAndView addMineTopo(ModelAndView model) {
		return siteNav("05_topo/createNewTopoForm");
	}

	@GetMapping(value="/borrowDemands")
	public ModelAndView borrowDemands(ModelAndView model) {
		return siteNav("05_topo/borrowDemandsList");
	}

	@GetMapping(value="/addSite")
	public ModelAndView addSite(ModelAndView model) {
		return siteNav("06_climbingSite/createNewSite");
	}


	private ModelAndView siteNav(String controllerUrl) {
		return new ModelAndView ("redirect:"+controllerUrl);
	}



}
