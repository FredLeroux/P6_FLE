package std.fle._0x_controller.controllerClass.climbingSiteController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.FredParser;
import fle.toolBox.JSPString;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import fle.toolBox.springFormManager.springMVCValidation.SpringMVCValidation;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;
import std.fle._06_dao.climbingSiteDao.ClimbingSiteDAO;
import std.fle._0x_controller.controllerClass.climbingSiteController.climbingFormsValidation.ClimbingFormsValidation;

@Controller
public class ClimbingSiteController {

	@Autowired
	SelectInputForController selectService;

	@Autowired
	SpringMVCValidation springMVCValidation;

	@Autowired
	ClimbingFormsValidation climbingFormsValidation;

	@Autowired
	ClimbingSiteDAO dao;

	private final String siteRouteEditController = "editSiteRoute";
	private final String routePitchEditController = "editRoutePitch";
	private final String deleteRoutePitch = "deletePitch";
	private RoutePitchSFC routePitchEdit = new RoutePitchSFC();
	private ClimbingSiteSFC climbingSiteSFC = new ClimbingSiteSFC();
	private Map<String, SiteRoutesSFC> siteRoutesMap = new LinkedHashMap<>();
	private Map<String, List<RoutePitchSFC>> routePitchsMap = new LinkedHashMap<>();
	private String siteName = null;
	private String routeName = null;
	private String routeToEdit = null;
	private String checkPitch = null;
	private List<RoutePitchSFC> sortedPitchList;

	@GetMapping("06_climbingSite/createNewSiteForm")
	public ModelAndView displaySiteFullInfoForm() {
		climbingSiteSFC = new ClimbingSiteSFC();
		siteRoutesMap = new LinkedHashMap<>();
		routePitchsMap = new LinkedHashMap<>();
		return new ModelAndView("redirect:climbingSiteForm");
	}

	@GetMapping("06_climbingSite/climbingSiteForm")
	public ModelAndView bactToCreateNewSiteForm(ModelAndView model,
			@ModelAttribute(name = "siteFullInfo") ClimbingSiteSFC climbingSiteSFC, HttpServletRequest request) {
		model.setViewName("06_climbingSite/createNewSiteForm");
		if (this.climbingSiteSFC.getClimbingSiteName() == null) {
			this.climbingSiteSFC.setNumberOfRoutes(0);
			selectService.addSelectListsAndValues(climbingSiteSFC, model);
		} else {
			this.climbingSiteSFC.setNumberOfRoutes(siteRoutesMap.size());
			selectService.addSelectListsAndValues(this.climbingSiteSFC, model);
		}
		model.addObject("siteFullInfo", this.climbingSiteSFC);
		addRouteHrefToModel(model);
		return model;
	}

	@PostMapping(value = "06_climbingSite/filterClimbingSiteCountiesList")
	public ModelAndView filterDispatcher(ModelAndView model, HttpServletRequest request,
			ClimbingSiteSFC climbingSiteSFC) {
		model.setViewName("forward:createNewSiteFormSelectFieldUpdated");
		return model;
	}

	@PostMapping(value = "/06_climbingSite/createNewSiteFormSelectFieldUpdated")
	public ModelAndView userFormUpdated(ModelAndView model,
			@ModelAttribute(name = "siteFullInfo") ClimbingSiteSFC climbingSiteSFC, HttpServletRequest request) {
		model.setViewName("06_climbingSite/createNewSiteForm");
		addRouteHrefToModel(model);
		return selectService.formSelectInputFieldUpdate(climbingSiteSFC, model, request);
	}

	@PostMapping("06_climbingSite/addSiteRoutes")
	public ModelAndView setClimbingSiteDto(ModelAndView model, ClimbingSiteSFC climbingSiteSFC) {
		this.climbingSiteSFC = climbingSiteSFC;
		siteName = climbingSiteSFC.getClimbingSiteName();
		model.setViewName("redirect:displaySiteRoutesList");
		return model;
	}

	@GetMapping("06_climbingSite/displaySiteRoutesList")
	public ModelAndView displaySiteRoutesList(ModelAndView model, ClimbingSiteSFC climbingSiteSFC,
			@ModelAttribute(name = "route") SiteRoutesSFC sfc) {
		model.setViewName("06_climbingSite/siteRoutesForm");
		model.addObject("siteName", siteName);
		model.addObject("siteRoutesList", siteRoutesMap);
		model.addObject("siteRouteEditController", siteRouteEditController);
		return model;
	}

	@PostMapping("06_climbingSite/createRoute")
	public ModelAndView createRoute(ModelAndView model, ClimbingSiteSFC climbingSiteSFC, SiteRoutesSFC sfc) {
		if (siteRoutesMap.containsKey(sfc.getRouteName())) {/*
															 * Important this condition avoid to discard pitchList if
															 * same key is entered by user
															 */
			model.setViewName("redirect:displaySiteRoutesList");
			return model;
		}

		routeName = sfc.getRouteName();
		siteRoutesMap.put(routeName, sfc);
		return new ModelAndView("redirect:displayRoutePitchForm");
	}

	// TODO add final controller to manage error and normal display to add all info
	// for both
	@GetMapping("06_climbingSite/displayRoutePitchForm")
	public ModelAndView displayRoutePitchForm(ModelAndView model,
			@ModelAttribute(name = "routePitch") RoutePitchSFC routePitchSFC) {
		model.setViewName("06_climbingSite/routePitchForm");
		model.addObject("siteName", siteName);
		model.addObject("routeName", routeName);
		model.addObject("pitchError", checkPitch);
		model.addObject("pitchRouteModification", routePitchEditController);
		model.addObject("deleteRoutePitch", deleteRoutePitch);
		if (routePitchsMap.containsKey(routeName)) {
			model.addObject("routePitchList", dao.sortedRoutePitchsDTOList(routeName, routePitchsMap));
		}
		selectService.addSelectListsAndValues(routePitchSFC, model);
		return model;
	}

	@PostMapping("06_climbingSite/createRoutePitch")
	public ModelAndView createRoutePitch(ModelAndView model,
			@ModelAttribute(name = "routePitch") @Validated RoutePitchSFC routePitchSFC, BindingResult result) {
		if (result.hasErrors()) {
			model.setViewName("06_climbingSite/routePitchForm");
			if (routePitchsMap.containsKey(routeName)) {
				model.addObject("routePitchList", dao.sortedRoutePitchsDTOList(routeName, routePitchsMap));
			}
			selectService.selectListAndValueOnBindingError(routePitchSFC, model);
			return model;
		}
		model.setViewName("redirect:displayRoutePitchForm");
		List<RoutePitchSFC> routePitchList = new ArrayList<>();
		if (!routePitchsMap.containsKey(routeName)) {
			routePitchList.add(routePitchSFC);
			routePitchsMap.put(routeName, routePitchList);
		} else {
			String checkPitch = null;
			checkPitch = climbingFormsValidation.checkPitchExistence(routePitchsMap.get(routeName), routePitchSFC);
			System.out.println(checkPitch);
			if (checkPitch.isEmpty()) {
				routePitchsMap.get(routeName).add(routePitchSFC);
				this.checkPitch = "";
			} else {
				this.checkPitch = checkPitch;
			}
		}

		return model;
	}

	private void addRouteHrefToModel(ModelAndView model) {
		model.addObject("siteRoutesController", JSPString.parse("addSiteRoutes"));
	}

	@PostMapping("06_climbingSite/createSite")
	public ModelAndView createSite(ModelAndView model,
			@ModelAttribute(name = "siteFullInfo") ClimbingSiteSFC climbingSiteSFC, BindingResult results) {
		springMVCValidation.SpringMVCValidationCheck(climbingSiteSFC, results);
		if (results.hasErrors()) {
			model.setViewName("06_climbingSite/createNewSiteForm");
			selectService.selectListAndValueOnBindingError(climbingSiteSFC, model);
			return model;
		}
		model.setViewName("redirect:createNewSiteForm");
		dao.saveClimbingSite(climbingSiteSFC, siteRoutesMap, routePitchsMap);
		return model;
	}

	@GetMapping("06_climbingSite/" + siteRouteEditController)
	public ModelAndView siteRouteEdit(ModelAndView model,
			@ModelAttribute(name = "editRoute") SiteRoutesSFC siteRouteSFC, HttpServletRequest request) {
		routeToEdit = request.getParameter("route");
		model.setViewName("06_climbingSite/editRouteSite");
		model.addObject("routePitchEditController", routePitchEditController);
		model.addObject("editRoute", siteRoutesMap.get(routeToEdit));
		if (routePitchSFCListIsNotNull(routeToEdit)) {
			model.addObject("routePitchList", dao.sortedRoutePitchsDTOList(routeToEdit, routePitchsMap));
		}
		return model;
	}

	private List<RoutePitchSFC> getRoutePitchListFromMap(String key) {
		return routePitchsMap.get(key);
	}

	private Boolean routePitchSFCListIsNotNull(String key) {
		return getRoutePitchListFromMap(key) != null;
	}

	@PostMapping("06_climbingSite/routeModification")
	public ModelAndView routeModification(ModelAndView model,
			@ModelAttribute(name = "editRoute") SiteRoutesSFC siteRouteSFC) {
		model.setViewName("redirect:displaySiteRoutesList");
		routeName = siteRouteSFC.getRouteName();
		siteRoutesMap.remove(routeToEdit);
		siteRoutesMap.put(routeName, siteRouteSFC);
		if (routePitchSFCListIsNotNull(routeToEdit)) {
			List<RoutePitchSFC> pitchList = new ArrayList<>(routePitchsMap.get(routeToEdit));
			routePitchsMap.remove(routeToEdit);
			routePitchsMap.put(routeName, pitchList);
		}
		return model;
	}

	@GetMapping("06_climbingSite/" + routePitchEditController)
	public ModelAndView routePitchEditDisplay(ModelAndView model,
			@ModelAttribute(name = "editRoutePitch") RoutePitchSFC routePitchSFC, HttpServletRequest request) {
		String route = request.getParameter("route");
		Integer pitchIndex = FredParser.toInteger(request.getParameter("index"));
		routePitchEdit = dao.sortedRoutePitchsSFCList(route, routePitchsMap).get(pitchIndex); // routePitchsMap.get(route);
		model.setViewName("06_climbingSite/editRoutePitch");
		model.addObject("routeToEdit", routeToEdit);
		model.addObject("editRoutePitch", routePitchEdit);
		selectService.upDateSelectListAndValue(routePitchEdit, model, request);
		return model;
	}

	@PostMapping("06_climbingSite/updateRoutePitch")
	public ModelAndView updateRoutePitch(ModelAndView model, RoutePitchSFC routePitchSFC) {
		routePitchEdit.setPitchClimbingLevels(routePitchSFC.getPitchClimbingLevels());
		return new ModelAndView("redirect:displayRoutePitchForm");
	}

	@GetMapping("06_climbingSite/" + deleteRoutePitch)
	public ModelAndView deleteRoutePitch(ModelAndView model,
			@ModelAttribute(name = "editRoutePitch") RoutePitchSFC routePitchSFC, HttpServletRequest request) {
		String route = request.getParameter("route");
		Integer pitchIndex = FredParser.toInteger(request.getParameter("index"));
		routePitchsMap.get(route).removeIf(o -> o.equals(routePitchsMap.get(route).get(pitchIndex)));
		System.out.println(routePitchsMap.get(route));
		return new ModelAndView("redirect:displayRoutePitchForm");
	}

}
