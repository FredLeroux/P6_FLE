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

import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;

@Controller
@RequestMapping(value="/climbingSite/routes/pitchs")
public class RoutePitchsController extends SiteRoutesController {
	
	@GetMapping("/displayRoutePitchForm")
	public ModelAndView displayRoutePitchForm(ModelAndView model,
			@ModelAttribute(name = "routePitch") RoutePitchSFC routePitchSFC, HttpServletRequest request) {
		return manager.manageDisplayRoutePitchForm(model, routePitchSFC);
	}

	@PostMapping("/createRoutePitch")
	public ModelAndView createRoutePitch(ModelAndView model,
			@ModelAttribute(name = "routePitch") @Validated RoutePitchSFC routePitchSFC, BindingResult result) {
		return manager.manageCreateSiteRoutePitch(model, routePitchSFC, result);
	}

	@GetMapping("/" + pitchEndController)
	public ModelAndView routePitchsFillingEnd(ModelAndView model,
			@ModelAttribute(name = "routePitch") RoutePitchSFC routePitchSFC, BindingResult result) {
		return manager.manageRoutePitchsFillingEnd(model, routePitchSFC, result);
	}

	@GetMapping("/" + routePitchEditController)
	public ModelAndView routePitchEditDisplay(ModelAndView model,
			@ModelAttribute(name = "editRoutePitch") RoutePitchSFC routePitchSFC) {
		return manager.manageDisplayRoutePitchsEditForm(model, routePitchSFC,"editRoutePitch");
	}

	@PostMapping("/routePitchModification")
	public ModelAndView routePitchsModification(ModelAndView model, RoutePitchSFC routePitchSFC) {
		return manager.manageRoutePitchsModification(model, routePitchSFC);
	}

	@GetMapping("/" + deleteRoutePitch)
	public ModelAndView deleteRoutePitch(ModelAndView model,
			@ModelAttribute(name = "editRoutePitch") RoutePitchSFC routePitchSFC) {
		return manager.manageDeleteRoutePitch(model, routePitchSFC);
	}


}
