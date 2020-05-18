package std.fle._0x_controller.controllerClass.climbingSiteController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.loader.plan.exec.query.internal.SelectStatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.FredParser;
import fle.toolBox.JspJavaScriptStringParser;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import fle.toolBox.springFormManager.springMVCValidation.SpringMVCValidation;
import std.fle._00_general.SessionVariables;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;
import std.fle._06_dao.climbingSiteDao.ClimbingSiteDAO;
import std.fle._0X_security.SecurityLevel;
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

	private final String addRouteController = JspJavaScriptStringParser.parse("addSiteRoutes");
	private final String siteRouteEditController = "editSiteRoute";
	private final String routePitchEditController = "editRoutePitch";
	private final String routeEndController = "routeEnd";
	private final String deleteRoutePitch = "deletePitch";
	private final String deleteSiteRoute = "deleteRoute";
	private final String pitchEndController = "pitchEnd";
	private RoutePitchSFC routePitchEdit = new RoutePitchSFC();
	private ClimbingSiteSFC climbingSiteSFC = new ClimbingSiteSFC();
	private Map<String, SiteRoutesSFC> siteRoutesMap = new LinkedHashMap<>();
	private Map<String, List<RoutePitchSFC>> routePitchsMap = new LinkedHashMap<>();
	private SessionVariables sessVar = new SessionVariables();
	private String siteName = null;
	private String routeName = null;
	private String routeToEdit = null;

	@GetMapping("06_climbingSite/createNewSiteForm")
	public ModelAndView displaySiteFullInfoForm() {
		climbingSiteSFC = new ClimbingSiteSFC();
		siteRoutesMap = new LinkedHashMap<>();
		routePitchsMap = new LinkedHashMap<>();
		return new ModelAndView("redirect:climbingSiteForm");
	}

	@GetMapping("06_climbingSite/climbingSiteForm")
	public ModelAndView backToCreateNewSiteForm(ModelAndView model,
			@ModelAttribute(name = "siteFullInfo") ClimbingSiteSFC climbingSiteSFC, HttpServletRequest request) {
		model.setViewName("06_climbingSite/createNewSiteForm");
		if (this.climbingSiteSFC.getClimbingSiteName() == null) {
			this.climbingSiteSFC.setNumberOfRoutes("0");
			selectService.addSelectListsAndValues(climbingSiteSFC, model);
		} else {
			this.climbingSiteSFC.setNumberOfRoutes(FredParser.asString(siteRoutesMap.size()));
			selectService.addSelectListsAndValues(this.climbingSiteSFC, model);
		}
		model.addObject("siteFullInfo", this.climbingSiteSFC);
		siteFormModelAttribute(model,request);
		return model;
	}

	@PostMapping(value = "06_climbingSite/filterClimbingSiteCountiesList")
	public ModelAndView filterDispatcher(ModelAndView model, HttpServletRequest request,
			ClimbingSiteSFC climbingSiteSFC) {	
		selectService.setFormularAndRequestMap("siteFullInfoFormular", "createNewSiteFormSelectFieldUpdated", "createSite");
		return selectService.dispatchSelectListAndValue(model, request);
	}

	@PostMapping(value = "/06_climbingSite/createNewSiteFormSelectFieldUpdated")
	public ModelAndView userFormUpdated(ModelAndView model,
			@ModelAttribute(name = "siteFullInfo") ClimbingSiteSFC climbingSiteSFC, HttpServletRequest request) {
		model.setViewName("06_climbingSite/createNewSiteForm");
		siteFormModelAttribute(model,request);
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
			@ModelAttribute(name = "route") SiteRoutesSFC siteRouteSFC) {
		return siteRouteModel(model);
	}

	@PostMapping("06_climbingSite/createRoute")
	public ModelAndView createRoute(ModelAndView model,
			@ModelAttribute(name = "route") @Validated SiteRoutesSFC siteRouteSFC, BindingResult result) {
		climbingFormsValidation.checkRouteExistence(siteRoutesMap, siteRouteSFC.getRouteName(), "route", result);
		if (result.hasErrors()) {
			return siteRouteModel(model);
		}
		routeName = siteRouteSFC.getRouteName();
		siteRoutesMap.put(routeName, siteRouteSFC);
		return new ModelAndView("redirect:displayRoutePitchForm");
	}

	@GetMapping("06_climbingSite/" + routeEndController)
	public ModelAndView routeEnd(ModelAndView model,
			@ModelAttribute(name = "route") SiteRoutesSFC siteRouteSFC, BindingResult result) {
		climbingFormsValidation.checkRouteListNotEmpty(siteRoutesMap, "route", result);
		if (result.hasErrors()) {
			return siteRouteModel(model);
		}
		model.setViewName("redirect:climbingSiteForm");
		return model;
	}

	private ModelAndView siteRouteModel(ModelAndView model) {
		model.setViewName("06_climbingSite/siteRoutesForm");
		model.addObject("siteName", siteName);
		model.addObject("siteRoutesList", siteRoutesMap);
		model.addObject("siteRouteEditController", siteRouteEditController);
		model.addObject("siteRouteDeleteController", deleteSiteRoute);
		model.addObject("routeEndController", routeEndController);
		return model;
	}

	@GetMapping("06_climbingSite/" + deleteSiteRoute)
	public ModelAndView deleteSiteRoute(HttpServletRequest request) {
		String route = request.getParameter("route");
		siteRoutesMap.remove(route);
		routePitchsMap.remove(route);
		return new ModelAndView("redirect:displaySiteRoutesList");

	}

	@GetMapping("06_climbingSite/displayRoutePitchForm")
	public ModelAndView displayRoutePitchForm(ModelAndView model,
			@ModelAttribute(name = "routePitch") RoutePitchSFC routePitchSFC) {
		model.setViewName("06_climbingSite/routePitchForm");
		pitchRouteFormModelAttribute(model);
		if (routePitchsMap.containsKey(routeName)) {
			model.addObject("routePitchList", dao.sortedRoutePitchsDTOList(routeName, routePitchsMap));
		}
		selectService.addSelectListsAndValues(routePitchSFC, model);
		return model;
	}

	@PostMapping("06_climbingSite/createRoutePitch")
	public ModelAndView createRoutePitch(ModelAndView model,
			@ModelAttribute(name = "routePitch") @Validated RoutePitchSFC routePitchSFC, BindingResult result) {
		if (routePitchsMap.get(routeName) != null) {
			climbingFormsValidation.checkPitchExistence(routePitchsMap.get(routeName), routePitchSFC, "pitchNumber",
					result);
		}
		if (result.hasErrors()) {
			return pitchFormBindingError(model, routePitchSFC);
		}
		model.setViewName("redirect:displayRoutePitchForm");
		List<RoutePitchSFC> routePitchList = new ArrayList<>();
		if (!routePitchsMap.containsKey(routeName)) {
			routePitchList.add(routePitchSFC);
			routePitchsMap.put(routeName, routePitchList);
		} else {
			routePitchsMap.get(routeName).add(routePitchSFC);

		}
		return model;
	}

	@GetMapping("06_climbingSite/" + pitchEndController)
	public ModelAndView pitchEnd(ModelAndView model, @ModelAttribute(name = "routePitch") RoutePitchSFC routePitchSFC,
			BindingResult result) {
		climbingFormsValidation.checkPitchListNotEmpty(getRoutePitchListFromMap(routeName), "pitchNumber", result);
		if (result.hasErrors()) {
			return pitchFormBindingError(model, routePitchSFC);
		}
		model.setViewName("redirect:displaySiteRoutesList");
		return model;
	}

	private ModelAndView pitchFormBindingError(ModelAndView model, RoutePitchSFC routePitchSFC) {
		model.setViewName("06_climbingSite/routePitchForm");
		if (routePitchsMap.containsKey(routeName)) {
			model.addObject("routePitchList", dao.sortedRoutePitchsDTOList(routeName, routePitchsMap));
		}
		pitchRouteFormModelAttribute(model);
		selectService.selectListAndValueOnBindingError(routePitchSFC, model);
		return model;

	}

	private void siteFormModelAttribute(ModelAndView model,HttpServletRequest request) {
		model.addObject("siteRoutesController", addRouteController);
		sessVar.setRequest(request);
		if(atLeastMember(request)) {
			model.addObject("displayOfficial",true);
		}else {
			model.addObject("displayOfficial",false);
		}
		
	}

	private void pitchRouteFormModelAttribute(ModelAndView model) {
		model.addObject("siteName", siteName);
		model.addObject("routeName", routeName);
		model.addObject("pitchRouteModification", routePitchEditController);
		model.addObject("deleteRoutePitch", deleteRoutePitch);
		model.addObject("pitchEndController", pitchEndController);
	}

	@PostMapping("06_climbingSite/createSite")
	public ModelAndView createSite(ModelAndView model,
			@ModelAttribute(name = "siteFullInfo") @Validated ClimbingSiteSFC climbingSiteSFC, BindingResult result,HttpServletRequest request) {
		
		checkFormSiteCreation(climbingSiteSFC,"siteFullInfo", result);
		if (result.hasErrors()) {
			model.setViewName("06_climbingSite/createNewSiteForm");			
			model.addObject("siteRoutesController", addRouteController);
			sessVar.setRequest(request);
			if(atLeastMember(request)) {
				model.addObject("displayOfficial",true);
			}else {
				model.addObject("displayOfficial",false);
			}
			selectService.selectListAndValueOnBindingError(climbingSiteSFC, model);
			return model;
		}
		model.setViewName("redirect:createNewSiteForm");
		if(!atLeastMember(request)) {
			climbingSiteSFC.setOfficial("false");
		}
		
		dao.saveClimbingSite(climbingSiteSFC, siteRoutesMap, routePitchsMap);
		return model;
	}
	
	private void checkFormSiteCreation(ClimbingSiteSFC climbingSiteSFC,String modelAttributeName,BindingResult result) {
		springMVCValidation.SpringMVCValidationCheck(climbingSiteSFC, result);
		climbingFormsValidation.checkNumberOfRoutes(climbingSiteSFC, modelAttributeName, result);
		climbingFormsValidation.checkHeightMinAndMax(climbingSiteSFC, modelAttributeName, result);
		climbingFormsValidation.checkStateNotEmpty(climbingSiteSFC, modelAttributeName, result);
		climbingFormsValidation.checkCountyNotEmpty(climbingSiteSFC, modelAttributeName, result);
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
	
	private Boolean atLeastMember(HttpServletRequest request) {
		System.out.println(sessVar.getSecurityLevel()< SecurityLevel.USER.rank());
		return sessVar.getSecurityLevel()< SecurityLevel.USER.rank();	
		
	}

}
