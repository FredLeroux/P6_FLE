package std.fle._0x_controller.modelManagement.climbingSiteModelManagement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.FredParser;
import fle.toolBox.JspJavaScriptStringParser;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import fle.toolBox.springFormManager.springMVCValidation.SpringMVCValidation;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteCommentsSFC;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;
import std.fle._06_dao.climbingSiteCommentsDao.ClimbingSiteCommentsDAO;
import std.fle._06_dao.climbingSiteDao.ClimbingSiteDAO;
import std.fle._0X_security.SecurityLevel;
import std.fle._0x_controller.controllerClass.climbingSiteController.climbingFormsValidation.ClimbingFormsValidation;

@Service
public class ClimbingSiteModelManagementImplemented extends ClimbingSiteModelMgntAndControllerVar
		implements ClimbingSiteModelManagement {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private SelectInputForController selectService;

	@Autowired
	private SpringMVCValidation springMVCValidation;

	@Autowired
	private ClimbingFormsValidation climbingFormsValidation;

	@Autowired
	private ClimbingSiteDAO dao;

	@Autowired
	private ClimbingSiteCommentsDAO commentDao;

	private ClimbingSiteCommentsSFC climbingSiteCommentsSFC = new ClimbingSiteCommentsSFC();

	@Override
	public ModelAndView createNewSiteFormVarInit() {
		climbingSiteSFC = new ClimbingSiteSFC();
		siteRoutesMap = new LinkedHashMap<>();
		routePitchsMap = new LinkedHashMap<>();
		callFromCreateForm = true;
		return new ModelAndView("redirect:climbingSiteForm");
	}

	@Override
	public ModelAndView updateFormVarInit(Integer id) {
		// setFormVarValue(id);
		climbingSiteSFC = dao.getClimbingSiteSFCByID(id);
		siteRoutesMap = dao.getSiteRouteMapByClimbingSiteId(id);
		routePitchsMap = dao.getRoutePitchsMapByClimbingSiteId(id);
		callFromCreateForm = false;
		climbingSiteId = id;
		return new ModelAndView("redirect:/06_climbingSite/climbingSiteUpdateForm");
	}

	@Override
	public ModelAndView displayFormVarInit(ModelAndView model, Integer id, String redirectURI) {
		setFormVarValue(id);		
		return new ModelAndView("redirect:/".concat(redirectURI));
	}

	private void setFormVarValue(Integer id) {
		climbingSiteSFC = dao.getClimbingSiteSFCByID(id);
		siteRoutesMap = dao.getSiteRouteMapByClimbingSiteId(id);
		routePitchsMap = dao.getRoutePitchsMapByClimbingSiteId(id);
		callFromCreateForm = false;
		climbingSiteId = id;
	}

	@Override
	public ModelAndView manageClimbingSiteForm(ModelAndView model, ClimbingSiteSFC climbingSiteSFC) {
		model.setViewName("06_climbingSite/createNewSiteForm");
		if (this.climbingSiteSFC.getClimbingSiteName() == null) {
			this.climbingSiteSFC.setNumberOfRoutes("0");
			selectService.addSelectListsAndValues(climbingSiteSFC, model);
		} else {
			this.climbingSiteSFC.setNumberOfRoutes(FredParser.asString(siteRoutesMap.size()));
			selectService.addSelectListsAndValues(this.climbingSiteSFC, model);
		}
		model.addObject("siteFullInfo", this.climbingSiteSFC);
		siteFormModelAttribute(model);
		return model;
	}

	@Override
	public ModelAndView manageClimbingSiteUpdateForm(ModelAndView model) {
		model.setViewName("06_climbingSite/updateSiteForm");
		model.addObject("siteFullInfoUpdate", climbingSiteSFC);
		selectService.addSelectListsAndValues(climbingSiteSFC, model);
		siteFormModelAttribute(model);
		return model;
	}

	private void siteFormModelAttribute(ModelAndView model) {
		model.addObject("siteRoutesController", addRouteController);
		model.addObject("displayOfficial", atLeastMember());
	}

	private Boolean atLeastMember() {
		sessVar.setRequest(request);
		return sessVar.getSecurityLevel() < SecurityLevel.USER.rank();

	}

	@Override
	public ModelAndView manageSelectFieldFilterDispatching(ModelAndView model) {
		selectService.setFormularAndRequestMap("siteFullInfoFormular", "createNewSiteFormSelectFieldUpdating",
				"createSite");
		selectService.setFormularAndRequestMap("siteFullInfoUpdateFormular", "updateSiteFormSelectFieldUpdating",
				"updateSite");
		return selectService.dispatchSelectListAndValue(model, request);
	}

	@Override
	public ModelAndView manageCreateNewSiteFormSelectFieldUpdating(ModelAndView model,
			ClimbingSiteSFC climbingSiteSFC) {
		return setFormSelectImputFieldUpdate(model, climbingSiteSFC, "06_climbingSite/createNewSiteForm");//
	}

	@Override
	public ModelAndView manageUpdateSiteFormSelectFieldUpdating(ModelAndView model, ClimbingSiteSFC climbingSiteSFC) {
		return setFormSelectImputFieldUpdate(model, climbingSiteSFC, "06_climbingSite/updateSiteForm");//
	}

	private ModelAndView setFormSelectImputFieldUpdate(ModelAndView model, ClimbingSiteSFC climbingSiteSFC,
			String controllerURL) {
		model.setViewName(controllerURL);
		siteFormModelAttribute(model);
		return selectService.formSelectInputFieldUpdate(climbingSiteSFC, model, request);
	}

	@Override
	public ModelAndView manageCreateClimbingSite(ModelAndView model, ClimbingSiteSFC climbingSiteSFC,
			String modelAttributeName, BindingResult result) {
		checkFormSiteCreation(climbingSiteSFC, modelAttributeName, result);
		if (result.hasErrors()) {
			model.setViewName("06_climbingSite/createNewSiteForm");//
			model.addObject("siteRoutesController", addRouteController);
			model.addObject("displayOfficial", atLeastMember());
			selectService.selectListAndValueOnBindingError(climbingSiteSFC, model);
			return model;
		}
		model.setViewName("redirect:createNewSite");
		if (!atLeastMember()) {
			climbingSiteSFC.setOfficial("false");
		}
		dao.saveClimbingSite(climbingSiteSFC, siteRoutesMap, routePitchsMap);
		return model;
	}

	@Override
	public ModelAndView manageUpdateClimbingSite(ModelAndView model, ClimbingSiteSFC climbingSiteSFC,
			String modelAttributeName, BindingResult result) {
		checkFormSiteCreation(climbingSiteSFC, modelAttributeName, result);
		if (result.hasErrors()) {
			model.setViewName("06_climbingSite/updateSiteForm");// 06_
			model.addObject("siteRoutesController", addRouteController);
			model.addObject("displayOfficial", atLeastMember());
			selectService.selectListAndValueOnBindingError(climbingSiteSFC, model);
			return model;
		}
		dao.updateClimbingSite(climbingSiteSFC, siteRoutesMap, routePitchsMap);
		model.setViewName("redirect:/04_listPage/listPage");
		return model;
	}

	private void checkFormSiteCreation(ClimbingSiteSFC climbingSiteSFC, String modelAttributeName,
			BindingResult result) {
		springMVCValidation.SpringMVCValidationCheck(climbingSiteSFC, modelAttributeName, result);
		climbingFormsValidation.checkNumberOfRoutes(climbingSiteSFC, modelAttributeName, result);
		climbingFormsValidation.checkHeightMinAndMax(climbingSiteSFC, modelAttributeName, result);
		climbingFormsValidation.checkStateNotEmpty(climbingSiteSFC, modelAttributeName, result);
		climbingFormsValidation.checkCountyNotEmpty(climbingSiteSFC, modelAttributeName, result);
	}

	@Override
	public ModelAndView manageClimbingSiteDelete(ModelAndView model) {
		dao.climbingSiteDelete(climbingSiteId);
		model.setViewName("redirect:/04_listPage/listPage");
		return model;
	}

	@Override
	public ModelAndView storeClimbingSiteInfo(ModelAndView model, ClimbingSiteSFC climbingSiteSFC) {
		this.climbingSiteSFC = climbingSiteSFC;
		siteName = climbingSiteSFC.getClimbingSiteName();
		model.setViewName("redirect:displaySiteRoutesList");
		return model;
	}

	@Override
	public ModelAndView manageDisplaySiteRoutesForm(ModelAndView model) {
		return setSiteRouteFormModelAttributes(model);
	}

	@Override
	public ModelAndView manageCreateSiteRoute(ModelAndView model, SiteRoutesSFC siteRouteSFC, String modelAttributeName,
			BindingResult result) {
		climbingFormsValidation.checkRouteExistence(siteRoutesMap, siteRouteSFC.getRouteName(), modelAttributeName,
				result);
		if (result.hasErrors()) {
			return setSiteRouteFormModelAttributes(model);
		} else {
			routeName = siteRouteSFC.getRouteName();
			siteRoutesMap.put(routeName, siteRouteSFC);
			return new ModelAndView("redirect:displayRoutePitchForm");
		}
	}

	@Override
	public ModelAndView manageSiteRoutesFillingEnd(ModelAndView model, SiteRoutesSFC siteRouteSFC,
			String modelAttributeName, BindingResult result) {
		climbingFormsValidation.checkRouteListNotEmpty(siteRoutesMap, "route", result);
		if (result.hasErrors()) {
			return setSiteRouteFormModelAttributes(model);
		}
		if (callFromCreateForm) {
			model.setViewName("redirect:climbingSiteForm");
		} else {
			model.setViewName("redirect:climbingSiteUpdateForm");
		}
		this.climbingSiteSFC.setNumberOfRoutes(FredParser.asString(siteRoutesMap.size()));
		return model;
	}

	private ModelAndView setSiteRouteFormModelAttributes(ModelAndView model) {
		model.setViewName("06_climbingSite/siteRoutesForm");
		model.addObject("siteName", siteName);
		model.addObject("siteRoutesList", siteRoutesMap);
		model.addObject("siteRouteEditController", siteRouteEditController);
		model.addObject("siteRouteDeleteController", deleteSiteRoute);
		model.addObject("routeEndController", routeEndController);
		model.addObject("editRoutePitchs", editRoutePitchsLinkFromRoutePage);
		return model;
	}

	@Override
	public ModelAndView manageDisplaySiteRouteEditForm(ModelAndView model, SiteRoutesSFC siteRouteSFC,
			String modelAttributeName) {
		routeToEdit = request.getParameter("route");
		model.setViewName("06_climbingSite/editRouteSite");
		model.addObject(routePitchEditController, routePitchEditController);
		model.addObject(modelAttributeName, siteRoutesMap.get(routeToEdit));
		model.addObject("cancel", "displaySiteRoutesList");
		if (routePitchSFCListIsNotNull(routeToEdit)) {
			model.addObject("routePitchList", dao.sortedRoutePitchsDTOList(routeToEdit, routePitchsMap));
		}
		return model;
	}

	@Override
	public ModelAndView manageSiteRouteModification(ModelAndView model, SiteRoutesSFC siteRouteSFC) {
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

	private Boolean routePitchSFCListIsNotNull(String key) {
		return getRoutePitchListFromMap(key) != null;
	}

	private List<RoutePitchSFC> getRoutePitchListFromMap(String key) {
		return routePitchsMap.get(key);
	}

	@Override
	public ModelAndView manageDeleteSiteRoute() {
		String route = request.getParameter("route");
		siteRoutesMap.remove(route);
		routePitchsMap.remove(route);
		return new ModelAndView("redirect:displaySiteRoutesList");
	}

	@Override
	public ModelAndView manageDisplayRoutePitchForm(ModelAndView model, RoutePitchSFC routePitchSFC) {
		model.setViewName("06_climbingSite/routePitchForm");// 06_
		String routeNameFromRequest = request.getParameter("route");
		routeName = routeNameFromRequest != null ? routeNameFromRequest : routeName;
		setPitchRouteFormModelAttributes(model, routeName);
		if (routePitchsMap.containsKey(routeName)) {
			model.addObject("routePitchList", dao.sortedRoutePitchsDTOList(routeName, routePitchsMap));
		}
		selectService.addSelectListsAndValues(routePitchSFC, model);
		return model;
	}

	@Override
	public ModelAndView manageCreateSiteRoutePitch(ModelAndView model, RoutePitchSFC routePitchSFC,
			BindingResult result) {
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

	@Override
	public ModelAndView manageRoutePitchsFillingEnd(ModelAndView model, RoutePitchSFC routePitchSFC,
			BindingResult result) {
		climbingFormsValidation.checkPitchListNotEmpty(getRoutePitchListFromMap(routeName), "pitchNumber", result);
		if (result.hasErrors()) {
			return pitchFormBindingError(model, routePitchSFC);
		}
		model.setViewName("redirect:displaySiteRoutesList");
		return model;
	}

	private ModelAndView pitchFormBindingError(ModelAndView model, RoutePitchSFC routePitchSFC) {
		model.setViewName("06_climbingSite/routePitchForm");// 06_
		if (routePitchsMap.containsKey(routeName)) {
			model.addObject("routePitchList", dao.sortedRoutePitchsDTOList(routeName, routePitchsMap));
		}
		setPitchRouteFormModelAttributes(model, routeName);
		selectService.selectListAndValueOnBindingError(routePitchSFC, model);
		return model;
	}

	private void setPitchRouteFormModelAttributes(ModelAndView model, String routeName) {
		model.addObject("siteName", siteName);
		model.addObject("routeName", routeName);
		model.addObject("pitchRouteModification", routePitchEditController);
		model.addObject("deleteRoutePitch", deleteRoutePitch);
		model.addObject("pitchEndController", pitchEndController);
	}

	@Override
	public ModelAndView manageDisplayRoutePitchsEditForm(ModelAndView model, RoutePitchSFC routePitchSFC,
			String modelAttributeName) {
		String route = request.getParameter("route");
		Integer pitchIndex = FredParser.toInteger(request.getParameter("index"));
		routePitchEdit = dao.sortedRoutePitchsSFCList(route, routePitchsMap).get(pitchIndex);
		model.setViewName("06_climbingSite/editRoutePitch");// 06_
		model.addObject("routeToEdit", route);// routeToEdit
		model.addObject(modelAttributeName, routePitchEdit);
		model.addObject("cancelEditPitch", "displayRoutePitchForm");
		selectService.upDateSelectListAndValue(routePitchEdit, model, request);
		return model;
	}

	@Override
	public ModelAndView manageRoutePitchsModification(ModelAndView model, RoutePitchSFC routePitchSFC) {
		routePitchEdit.setPitchClimbingLevels(routePitchSFC.getPitchClimbingLevels());
		return new ModelAndView("redirect:displayRoutePitchForm");
	}

	@Override
	public ModelAndView manageDeleteRoutePitch(ModelAndView model, RoutePitchSFC routePitchSFC) {
		String route = request.getParameter("route");
		Integer pitchIndex = FredParser.toInteger(request.getParameter("index"));
		routePitchsMap.get(route).removeIf(o -> o.equals(routePitchsMap.get(route).get(pitchIndex)));
		return new ModelAndView("redirect:displayRoutePitchForm");
	}

	@Override
	public ModelAndView manageDisplayClimBingSiteDetails(ModelAndView model) {
		model.setViewName("06_climbingSite/climbingSiteDetails");
		setClimbingSiteDetailsRoutesAndPitchs(model);
		model.addObject("siteInfoDisplay", dao.getClimbingSiteDisplaySFCById(climbingSiteId));
		return model;
	}

	private void setClimbingSiteDetailsRoutesAndPitchs(ModelAndView model) {
		routesAndPitchsPageList = setpages();
		model.addObject("currentPage", 1);
		model.addObject("totalPages", routesAndPitchsPageList.size());// list.size()
		model.addObject("changePageController", JspJavaScriptStringParser.parse("RoutesAndPitchsListPage"));
		model.addObject("routesAndListPages", routeAndPitchListToJsonArray(routesAndPitchsPageList.get(0)));
		model.addObject("commentModal", setCommentModalName());
		model.addObject("listCommentSrc", listCommentSrc(climbingSiteId));
		
	}

	

	private String listCommentSrc(Integer id) {
		return "/04_listPage/listPage?listType=climbingSitesComments&id=" + id;
	}

	private String setCommentModalName() {
		sessVar.setRequest(request);
		if (sessVar.getSecurityLevel() > SecurityLevel.USER.rank()) {
			return JspJavaScriptStringParser.parse(commentNotAllowedModal);
		} else {
			return JspJavaScriptStringParser.parse(commentModal);
		}
	}

	@Override
	public JSONArray getPageAsJSONArray(Integer currentPage) {

		return routeAndPitchListToJsonArray(routesAndPitchsPageList.get(currentPage - 1));
	}

	private JSONArray routeAndPitchListToJsonArray(List<RoutesAndPitchsPage> list) {
		JSONArray jsonArray = new JSONArray();
		list.forEach(o -> jsonArray.put(routeAndPitchListJSONObject(o.getRouteName(), o.getPitchsList())));
		return jsonArray;
	}

	private JSONObject routeAndPitchListJSONObject(String routeName, List<RoutePitchSFC> pitchsList) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("routeName", routeName);
		jsonObject.put("pitchsList", new JSONArray(pitchsList));
		return jsonObject;
	}

	private ArrayList<String> routesList() {
		ArrayList<String> list = new ArrayList<>();
		siteRoutesMap.forEach((key, value) -> list.add(key));
		return list;
	}

	private Map<String, List<RoutePitchSFC>> routesPitchsList() {
		Map<String, List<RoutePitchSFC>> map = new LinkedHashMap<>();
		routesList().forEach(o -> map.put(o, dao.sortedRoutePitchsSFCWithCotationLevelAsString(o, routePitchsMap)));
		return map;
	}

	private Integer RouteAndPitchLineNumber() {
		Integer i = 0;
		ArrayList<Integer> sizeList = new ArrayList<>();
		i = routePitchsMap.size();
		routePitchsMap.forEach((key, value) -> countPitchs(sizeList, value));
		Integer p = sizeList.stream().mapToInt(o -> o).sum();
		return i + p;

	}

	private ArrayList<List<RoutesAndPitchsPage>> setpages() {
		ArrayList<List<RoutesAndPitchsPage>> pages = new ArrayList<>();
		ArrayList<RoutesAndPitchsPage> page = new ArrayList<>();
		ArrayList<Integer> sizeList = new ArrayList<>();
		routePitchsMap.forEach((key, value) -> {
			countPitchs(sizeList, value);
			Integer pitchsNumber = sizeList.stream().mapToInt(o -> o).sum();
			Integer routesNumber = sizeList.size();
			Integer totalLine = pitchsNumber + routesNumber;
			if (totalLine <= 24) { /*
									 * 24 is 8*3, 3 is the accepted commons number of lines for a full routes info 1
									 * route name 2 pitchs
									 */
				page.add(new RoutesAndPitchsPage(key, dao.sortedRoutePitchsSFCWithCotationLevelAsString(value)));
			} else {
				ArrayList<RoutesAndPitchsPage> pagetoAdd = new ArrayList<>(page);/* see 1 */
				pages.add(pagetoAdd);
				page.clear();/*
								 * 1-becareful using clear will clear page instance need to set a new arraylist
								 * before clear
								 */
				page.add(new RoutesAndPitchsPage(key, dao.sortedRoutePitchsSFCWithCotationLevelAsString(value)));
				sizeList.clear();
				countPitchs(sizeList, value);
			}
		});
		pages.add(page);
		return pages;

	}

	private void countPitchs(ArrayList<Integer> sizeList, List<RoutePitchSFC> list) {
		sizeList.add(list.size());
	}

	@Override
	public ModelAndView managePostComment(String requestCommentParameterName) {
		sessVar.setRequest(request);
		commentDao.postComment(climbingSiteId, sessVar.getAccountID(),
				request.getParameter(requestCommentParameterName));
		return new ModelAndView("redirect:/siteHaveBeenCommented");
	}

}
