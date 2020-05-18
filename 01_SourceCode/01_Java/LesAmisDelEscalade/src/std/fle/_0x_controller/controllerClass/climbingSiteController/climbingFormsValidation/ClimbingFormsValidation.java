package std.fle._0x_controller.controllerClass.climbingSiteController.climbingFormsValidation;

import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;

import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;

public interface ClimbingFormsValidation {

	public void checkNumberOfRoutes(ClimbingSiteSFC climbingSiteSFC, String modelAttributeName, BindingResult result);

	public void checkHeightMinAndMax(ClimbingSiteSFC climbingSiteSFC, String modelAttributeName, BindingResult result);

	public void checkRouteListNotEmpty(Map<String, SiteRoutesSFC> siteRoutesMap, String modelAttributeName,
			BindingResult result);

	public void checkRouteExistence(Map<String, SiteRoutesSFC> siteRoutesMap, String routeNameSent,
			String modelAttributeName, BindingResult result);

	public void checkPitchExistence(List<RoutePitchSFC> list, RoutePitchSFC toCheck, String modelAttributeName,
			BindingResult result);

	public void checkPitchListNotEmpty(List<RoutePitchSFC> list, String modelAttributeName, BindingResult result);
}
