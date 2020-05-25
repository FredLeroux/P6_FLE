package std.fle._0x_controller.controllerClass.climbingSiteController.climbingFormsValidation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;
import std.fle._0x_controller.controllerClass.climbingSiteController.ClimbingSiteCont;

@Controller
@RequestMapping(value = "/climbingSite/routes")
public class SiteRoutesController extends ClimbingSiteCont {

	@PostMapping("/addSiteRoutes")
	public ModelAndView storeClimbingSiteInfo(ModelAndView model, ClimbingSiteSFC climbingSiteSFC) {
		return manager.storeClimbingSiteInfo(model, climbingSiteSFC);
	}

	@GetMapping("/displaySiteRoutesList")
	public ModelAndView displaySiteRoutesList(ModelAndView model,
			@ModelAttribute(name = "route") SiteRoutesSFC siteRouteSFC) {
		return manager.manageDisplaySiteRoutesForm(model);
	}

	@PostMapping("/createRoute")
	public ModelAndView createRoute(ModelAndView model,
			@ModelAttribute(name = "route") @Validated SiteRoutesSFC siteRouteSFC, BindingResult result) {
		return manager.manageCreateSiteRoute(model, siteRouteSFC, "route", result);
	}

	@GetMapping("/" + routeEndController)
	public ModelAndView siteRoutesFillingEnd(ModelAndView model,
			@ModelAttribute(name = "route") SiteRoutesSFC siteRouteSFC, BindingResult result) {
		return manager.manageSiteRoutesFillingEnd(model, siteRouteSFC, "route", result);
	}

	@GetMapping("/" + siteRouteEditController)
	public ModelAndView displaySiteRouteEditForm(ModelAndView model,
			@ModelAttribute(name = "editRoute") SiteRoutesSFC siteRouteSFC, HttpServletRequest request) {
		return manager.manageDisplaySiteRouteEditForm(model, siteRouteSFC, "editRoute");
	}

	@PostMapping("/routeModification")
	public ModelAndView siteRouteModification(ModelAndView model, SiteRoutesSFC siteRouteSFC) {
		return manager.manageSiteRouteModification(model, siteRouteSFC);
	}

	@GetMapping("/" + deleteSiteRoute)
	public ModelAndView deleteSiteRoute(HttpServletRequest request) {
		return manager.manageDeleteSiteRoute();
	}

}
