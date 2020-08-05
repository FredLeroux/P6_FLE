package std.fle._12_controller.modelManagement.climbingSiteModelManagement;

import org.json.JSONArray;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;

import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;

public interface ClimbingSiteModelManagement {

	public ModelAndView createNewSiteFormVarInit();

	public ModelAndView updateFormVarInit(Integer id);

	public ModelAndView displayFormVarInit(ModelAndView model,Integer id,String redirectURI);

	public ModelAndView manageClimbingSiteForm(ModelAndView model, ClimbingSiteSFC climbingSiteSFC);

	public ModelAndView manageClimbingSiteUpdateForm(ModelAndView model);

	public ModelAndView manageSelectFieldFilterDispatching(ModelAndView model);

	public ModelAndView manageCreateNewSiteFormSelectFieldUpdating(ModelAndView model,ClimbingSiteSFC climbingSiteSFC);

	public ModelAndView manageUpdateSiteFormSelectFieldUpdating(ModelAndView model,ClimbingSiteSFC climbingSiteSFC);

	public ModelAndView manageCreateClimbingSite(ModelAndView model, ClimbingSiteSFC climbingSiteSFC,
			String modelAttributeName, BindingResult result);

	public ModelAndView manageUpdateClimbingSite(ModelAndView model, ClimbingSiteSFC climbingSiteSFC,
			String modelAttributeName, BindingResult result);

	public ModelAndView manageClimbingSiteDelete(ModelAndView model);

	public ModelAndView storeClimbingSiteInfo(ModelAndView model, ClimbingSiteSFC climbingSiteSFC);

	public ModelAndView manageDisplaySiteRoutesForm(ModelAndView model);

	public ModelAndView manageCreateSiteRoute(ModelAndView model, @Validated SiteRoutesSFC siteRouteSFC,
			String modelAttributeName, BindingResult result);

	public ModelAndView manageSiteRoutesFillingEnd(ModelAndView model, SiteRoutesSFC siteRouteSFC,
			String modelAttributeName, BindingResult result);

	public ModelAndView manageDisplaySiteRouteEditForm(ModelAndView model, SiteRoutesSFC siteRouteSFC,
			String modelAttributeName);

	public ModelAndView manageSiteRouteModification(ModelAndView model, SiteRoutesSFC siteRouteSFC,BindingResult results);

	public ModelAndView manageDeleteSiteRoute();

	public ModelAndView manageDisplayRoutePitchForm(ModelAndView model, RoutePitchSFC routePitchSFC);

	public ModelAndView manageCreateSiteRoutePitch(ModelAndView model, RoutePitchSFC routePitchSFC,
			BindingResult result);

	public ModelAndView manageRoutePitchsFillingEnd(ModelAndView model, RoutePitchSFC routePitchSFC,
			BindingResult result);

	public ModelAndView manageDisplayRoutePitchsEditForm(ModelAndView model, RoutePitchSFC routePitchSFC,String modelAttributeName);;

	public ModelAndView manageRoutePitchsModification(ModelAndView model, RoutePitchSFC routePitchSFC);

	public ModelAndView manageDeleteRoutePitch(ModelAndView model, RoutePitchSFC routePitchSFC);

	public ModelAndView manageDisplayClimBingSiteDetails(ModelAndView model);

	public JSONArray getPageAsJSONArray(Integer currentPage);

	public ModelAndView managePostComment(String requestCommentParameterName);

}
