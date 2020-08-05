package std.fle._12_controller.modelManagement.climbingSiteModelManagement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import fle.toolBox.JspJavaScriptStringParser;
import std.fle._00_general.SessionVariables;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;

public class ClimbingSiteModelMgntAndControllerVar {

	protected final String addRouteController = JspJavaScriptStringParser.parse("addSiteRoutes");// routes/addSiteRoutes to be use with the 3 controller
	protected final String siteRouteEditController = "editSiteRouteName";
	protected final String routePitchEditController = "editRoutePitch";
	protected final String routeEndController = "routeEnd";
	protected final String deleteRoutePitch = "deletePitch";
	protected final String deleteSiteRoute = "deleteRoute";
	protected final String pitchEndController = "pitchEnd";
	protected final String editRoutePitchsLinkFromRoutePage = "displayRoutePitchForm";
	protected RoutePitchSFC routePitchEdit = new RoutePitchSFC();
	protected ClimbingSiteSFC climbingSiteSFC = new ClimbingSiteSFC();
	protected Map<String, SiteRoutesSFC> siteRoutesMap = new LinkedHashMap<>();
	protected Map<String, List<RoutePitchSFC>> routePitchsMap = new LinkedHashMap<>();
	protected SessionVariables sessVar = new SessionVariables();
	protected Integer climbingSiteId = null;
	protected String siteName = null;
	protected String routeName = null;
	protected String routeToEdit = null;
	protected String editRouteModelAttributName = null;
	protected Boolean callFromCreateForm = null;
	protected ArrayList<List<RoutesAndPitchsPage>> routesAndPitchsPageList = new ArrayList<>();
	protected final String commentModal = "siteCommentModal";
	protected final String commentNotAllowedModal = "siteCommentNotAllowedModal";

}
