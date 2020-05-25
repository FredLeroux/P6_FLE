package std.fle._0x_controller.controllerClass.climbingSiteController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._0x_controller.modelManagement.climbingSiteModelManagement.ClimbingSiteModelManagement;
import std.fle._0x_controller.modelManagement.climbingSiteModelManagement.ClimbingSiteModelMgntAndControllerVar;

@Controller
@RequestMapping(value = {"/climbingSite","/04_listPage"})/* /04_listPage used for climbingSiteEdit called from listPage*/
public class ClimbingSiteCont extends ClimbingSiteModelMgntAndControllerVar {

	@Autowired
	protected ClimbingSiteModelManagement manager;

	@GetMapping("/createNewSite")
	public ModelAndView climbingSiteFormsInit() {
		return manager.createNewSiteFormVarInit();//
	}

	@GetMapping(value = "/climbingSiteEdit/{id}")
	public ModelAndView climbingSiteEdit(@PathVariable Integer id) {
		return manager.updateFormVarInit(id);
	}

	@GetMapping("/climbingSiteForm")
	public ModelAndView createNewSiteForm(ModelAndView model,
			@ModelAttribute(name = "siteFullInfo") ClimbingSiteSFC climbingSiteSFC) {
		return manager.manageClimbingSiteForm(model, climbingSiteSFC);
	}

	@GetMapping("/climbingSiteUpdateForm")
	public ModelAndView climbingSiteUpadteForm(ModelAndView model,
			@ModelAttribute(name = "siteFullInfoUpdate") ClimbingSiteSFC climbingSiteSFC) {
		return manager.manageClimbingSiteUpdateForm(model);

	}

	@PostMapping(value = "/filterClimbingSiteCountiesList")
	public ModelAndView filterDispatcher(ModelAndView model) {
		return manager.manageSelectFieldFilterDispatching(model);
	}

	@PostMapping(value = "/createNewSiteFormSelectFieldUpdating")
	public ModelAndView createNewSiteFormUpdated(ModelAndView model,
			@ModelAttribute(name = "siteFullInfo") ClimbingSiteSFC climbingSiteSFC) {
		return manager.manageCreateNewSiteFormSelectFieldUpdating(model,climbingSiteSFC);
	}

	@PostMapping(value = "/updateSiteFormSelectFieldUpdating")
	public ModelAndView userFormUpdated(ModelAndView model,
			@ModelAttribute(name = "siteFullInfoUpdate") ClimbingSiteSFC climbingSiteSFC) {
		return manager.manageUpdateSiteFormSelectFieldUpdating(model,climbingSiteSFC);
	}
	
	@PostMapping("/createSite")
	public ModelAndView createSite(ModelAndView model,
			@ModelAttribute(name = "siteFullInfo") @Validated ClimbingSiteSFC climbingSiteSFC, BindingResult result,
			HttpServletRequest request) {
		return manager.manageCreateClimbingSite(model, climbingSiteSFC, "siteFullInfo", result);
	}

	@PostMapping("/updateSite")
	public ModelAndView updateSite(ModelAndView model,
			@ModelAttribute(name = "siteFullInfoUpdate") @Validated ClimbingSiteSFC climbingSiteSFC,
			BindingResult result, HttpServletRequest request) {
		return manager.manageUpdateClimbingSite(model, climbingSiteSFC, "siteFullInfoUpdate", result);
	}

	@GetMapping("/deleteSite")
	public ModelAndView deleteSite(ModelAndView model) {
		return manager.manageClimbingSiteDelete(model);
	}
	
	
}
