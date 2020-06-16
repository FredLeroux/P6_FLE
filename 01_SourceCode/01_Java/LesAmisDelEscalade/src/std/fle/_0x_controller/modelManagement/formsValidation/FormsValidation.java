package std.fle._0x_controller.modelManagement.formsValidation;

import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;

import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;
import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;

public interface FormsValidation {

	/**
	 * Error can be setted via message source using code =
	 * "routeListEmpty.modelAttributeName.fieldName"
	 *
	 */
	public void checkNumberOfRoutes(ClimbingSiteSFC climbingSiteSFC, String modelAttributeName, BindingResult result);

	/**
	 * Error can be setted via message source using code =
	 * "heightError.modelAttributeName.fieldName" (note: 2 errors key one for min
	 * the other for max )
	 *
	 */
	public void checkHeightMinAndMax(ClimbingSiteSFC climbingSiteSFC, String modelAttributeName, BindingResult result);

	/**
	 * Error can be setted via message source using code =
	 * "stateEmpty.modelAttributeName.fieldName"
	 *
	 */
	public void checkStateNotEmpty(ClimbingSiteSFC climbingSiteSFC, String modelAttributeName, BindingResult result);
	
	/**
	 * Error can be setted via message source using code =
	 * "stateEmpty.modelAttributeName.fieldName"
	 *
	 */
	public void checkStateNotEmpty(ClimbingTopoSFC climbingTopoSFC, String modelAttributeName, BindingResult result);

	/**
	 * Error can be setted via message source using code =
	 * "countyEmpty.modelAttributeName.fieldName"
	 *
	 */
	public void checkCountyNotEmpty(ClimbingSiteSFC climbingSiteSFC, String modelAttributeName, BindingResult result);


	/**
	 * Error can be setted via message source using code =
	 * "noRoute.modelAttributeName.fieldName"
	 *
	 */
	public void checkRouteListNotEmpty(Map<String, SiteRoutesSFC> siteRoutesMap, String modelAttributeName,
			BindingResult result);

	/**
	 * Error can be setted via message source using code =
	 * "routeNotUnique.modelAttributeName.fieldName"
	 *
	 */
	public void checkRouteExistence(Map<String, SiteRoutesSFC> siteRoutesMap, String routeNameSent,
			String modelAttributeName, BindingResult result);

	/**
	 * Error can be setted via message source using code =
	 * "pitchNotUnique.modelAttributeName.fieldName"
	 *
	 */
	public void checkPitchExistence(List<RoutePitchSFC> list, RoutePitchSFC toCheck, String modelAttributeName,
			BindingResult result);

	/**
	 * Error can be setted via message source using code =
	 * "pitchListEmpty.modelAttributeName.fieldName"
	 *
	 */
	public void checkPitchListNotEmpty(List<RoutePitchSFC> list, String modelAttributeName, BindingResult result);
}
