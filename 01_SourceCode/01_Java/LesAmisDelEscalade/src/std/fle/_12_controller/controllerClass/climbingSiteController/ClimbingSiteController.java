package std.fle._12_controller.controllerClass.climbingSiteController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;
import std.fle._12_controller.modelManagement.climbingSiteModelManagement.ClimbingSiteModelManagement;
import std.fle._12_controller.modelManagement.climbingSiteModelManagement.ClimbingSiteModelMgntAndControllerVar;

@Controller
public class ClimbingSiteController extends ClimbingSiteModelMgntAndControllerVar {


	@Autowired
	ClimbingSiteModelManagement manager;

	@GetMapping("06_climbingSite/createNewSite")
	public ModelAndView climbingSiteFormsInit() {
		return manager.createNewSiteFormVarInit();//
	}

	@GetMapping(value = "04_listPage/climbingSiteEdit/{id}")
	public ModelAndView climbingSiteEdit(@PathVariable Integer id) {
		return manager.updateFormVarInit(id);
	}

	@GetMapping("06_climbingSite/climbingSiteForm")
	public ModelAndView backToCreateNewSiteForm(ModelAndView model,
			@ModelAttribute(name = "siteFullInfo") ClimbingSiteSFC climbingSiteSFC) {
		return manager.manageClimbingSiteForm(model, climbingSiteSFC);
	}

	@GetMapping("06_climbingSite/climbingSiteUpdateForm")
	public ModelAndView climbingSiteUpadteForm(ModelAndView model,
			@ModelAttribute(name = "siteFullInfoUpdate") ClimbingSiteSFC climbingSiteSFC) {
		return manager.manageClimbingSiteUpdateForm(model);

	}

	@PostMapping(value = "06_climbingSite/filterClimbingSiteCountiesList")
	public ModelAndView filterDispatcher(ModelAndView model) {
		return manager.manageSelectFieldFilterDispatching(model);
	}

	@PostMapping(value = "/06_climbingSite/createNewSiteFormSelectFieldUpdating")
	public ModelAndView createNewSiteFormUpdated(ModelAndView model,
			@ModelAttribute(name = "siteFullInfo") ClimbingSiteSFC climbingSiteSFC) {
		return manager.manageCreateNewSiteFormSelectFieldUpdating(model,climbingSiteSFC);
	}

	@PostMapping(value = "/06_climbingSite/updateSiteFormSelectFieldUpdating")
	public ModelAndView userFormUpdated(ModelAndView model,
			@ModelAttribute(name = "siteFullInfoUpdate") ClimbingSiteSFC climbingSiteSFC) {
		return manager.manageUpdateSiteFormSelectFieldUpdating(model,climbingSiteSFC);
	}

	@PostMapping("06_climbingSite/addSiteRoutes")
	public ModelAndView storeClimbingSiteInfo(ModelAndView model, ClimbingSiteSFC climbingSiteSFC) {
		return manager.storeClimbingSiteInfo(model, climbingSiteSFC);
	}

	@GetMapping("06_climbingSite/displaySiteRoutesList")
	public ModelAndView displaySiteRoutesList(ModelAndView model, ClimbingSiteSFC climbingSiteSFC,
			@ModelAttribute(name = "route") SiteRoutesSFC siteRouteSFC) {
		return manager.manageDisplaySiteRoutesForm(model);
	}

	@PostMapping("06_climbingSite/createRoute")
	public ModelAndView createRoute(ModelAndView model,
			@ModelAttribute(name = "route") @Validated SiteRoutesSFC siteRouteSFC, BindingResult result) {
		return manager.manageCreateSiteRoute(model, siteRouteSFC, "route", result);
	}

	@GetMapping("06_climbingSite/" + routeEndController)
	public ModelAndView siteRoutesFillingEnd(ModelAndView model,
			@ModelAttribute(name = "route") SiteRoutesSFC siteRouteSFC, BindingResult result) {
		return manager.manageSiteRoutesFillingEnd(model, siteRouteSFC, "route", result);
	}

	@GetMapping("06_climbingSite/" + siteRouteEditController)
	public ModelAndView displaySiteRouteEditForm(ModelAndView model,
			@ModelAttribute(name = "editRoute") SiteRoutesSFC siteRouteSFC, HttpServletRequest request) {
		return manager.manageDisplaySiteRouteEditForm(model, siteRouteSFC, "editRoute");
	}

	@PostMapping("06_climbingSite/routeModification")
	public ModelAndView siteRouteModification(ModelAndView model,@ModelAttribute(name = "editRoute") @Validated SiteRoutesSFC siteRouteSFC, BindingResult result) {
		return manager.manageSiteRouteModification(model, siteRouteSFC,result);
	}

	@GetMapping("06_climbingSite/" + deleteSiteRoute)
	public ModelAndView deleteSiteRoute(HttpServletRequest request) {
		return manager.manageDeleteSiteRoute();
	}

	@GetMapping("06_climbingSite/displayRoutePitchForm")
	public ModelAndView displayRoutePitchForm(ModelAndView model,
			@ModelAttribute(name = "routePitch") RoutePitchSFC routePitchSFC, HttpServletRequest request) {
		return manager.manageDisplayRoutePitchForm(model, routePitchSFC);
	}

	@PostMapping("06_climbingSite/createRoutePitch")
	public ModelAndView createRoutePitch(ModelAndView model,
			@ModelAttribute(name = "routePitch") @Validated RoutePitchSFC routePitchSFC, BindingResult result) {
		return manager.manageCreateSiteRoutePitch(model, routePitchSFC, result);
	}

	@GetMapping("06_climbingSite/" + pitchEndController)
	public ModelAndView routePitchsFillingEnd(ModelAndView model,
			@ModelAttribute(name = "routePitch") RoutePitchSFC routePitchSFC, BindingResult result) {
		return manager.manageRoutePitchsFillingEnd(model, routePitchSFC, result);
	}

	@GetMapping("06_climbingSite/" + routePitchEditController)
	public ModelAndView routePitchEditDisplay(ModelAndView model,
			@ModelAttribute(name = "editRoutePitch") RoutePitchSFC routePitchSFC) {
		return manager.manageDisplayRoutePitchsEditForm(model, routePitchSFC, "editRoutePitch");
	}

	@PostMapping("06_climbingSite/routePitchModification")
	public ModelAndView routePitchsModification(ModelAndView model, RoutePitchSFC routePitchSFC) {
		return manager.manageRoutePitchsModification(model, routePitchSFC);
	}

	@GetMapping("06_climbingSite/" + deleteRoutePitch)
	public ModelAndView deleteRoutePitch(ModelAndView model,
			@ModelAttribute(name = "editRoutePitch") RoutePitchSFC routePitchSFC) {
		return manager.manageDeleteRoutePitch(model, routePitchSFC);
	}

	@PostMapping("06_climbingSite/createSite")
	public ModelAndView createSite(ModelAndView model,
			@ModelAttribute(name = "siteFullInfo") @Validated ClimbingSiteSFC climbingSiteSFC, BindingResult result,
			HttpServletRequest request) {
		return manager.manageCreateClimbingSite(model, climbingSiteSFC, "siteFullInfo", result);
	}

	@PostMapping("06_climbingSite/updateSite")
	public ModelAndView updateSite(ModelAndView model,
			@ModelAttribute(name = "siteFullInfoUpdate") @Validated ClimbingSiteSFC climbingSiteSFC,
			BindingResult result, HttpServletRequest request) {
		return manager.manageUpdateClimbingSite(model, climbingSiteSFC, "siteFullInfoUpdate", result);
	}

	@GetMapping("06_climbingSite/deleteSite")
	public ModelAndView deleteSite(ModelAndView model) {
		return manager.manageClimbingSiteDelete(model);
	}

}
