package std.fle._0x_controller.controllerClass.climbingSiteController.climbingFormsValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import fle.toolBox.FredParser;
import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.springFormManager.springMVCValidation.tools.SpringValidationError;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;

@Service
public class ClimbingFormsValidationImplemented implements ClimbingFormsValidation {

	@Autowired
	LocalMessage locale;

	private String noRoute = "routeListEmpty";
	private String noRouteDefaultMessage = "At least one route is required !! ";
	private String heightError = "heightError";
	private String HeightErrorDefaultMessage = "Minimum can't be superior than maximum !! ";
	private String stateEmpty = "stateEmpty";
	private String stateEmptyDefaultMessage = "State cannot be empty !!";
	private String countyEmpty = "countyEmpty";
	private String countyEmptyDefaultMessage = "county cannot be empty !!";
	private String routeListEmptyError = "noRoute";
	private String routeListEmptyDefaultMessage = "At least One route must be filled !! ";
	private String routeErrorCode = "routeNotUnique";
	private String routeErrorDefaultMessage = "This route already exist !! ";
	private String pitchErrorCode = "pitchNotUnique";
	private String pitchErrorDefaultMessage = "Pitch already Exist !! ";
	private String pitchEmptyCode = "pitchListEmpty";
	private String pitchEmptyDefaultMessage = "At least One Pitch must be filled";
	private Boolean pitchError = null;

	/**
	 * Error can be setted via message source using code =
	 * "routeListEmpty.modelAttributeName.fieldName"
	 *
	 */
	@Override
	public void checkNumberOfRoutes(ClimbingSiteSFC climbingSiteSFC, String modelAttributeName, BindingResult result) {
		if (climbingSiteSFC.getNumberOfRoutes().equals("0")) {
			SpringValidationError.addError(noRoute, modelAttributeName, "numberOfRoutes", noRouteDefaultMessage,
					result);
		}
	}

	/**
	 * Error can be setted via message source using code =
	 * "heightError.modelAttributeName.fieldName" (note: 2 errors key one for min
	 * the other for max )
	 *
	 */
	@Override
	public void checkHeightMinAndMax(ClimbingSiteSFC climbingSiteSFC, String modelAttributeName, BindingResult result) {
		String[] heightFieldsName = { "heightMin", "heightMax" };
		if (!minAndMax(climbingSiteSFC.getHeightMin(), climbingSiteSFC.getHeightMax())) {
			for (int i = 0; i <= heightFieldsName.length - 1; i++) {
				SpringValidationError.addError(heightError, modelAttributeName, heightFieldsName[i],
						HeightErrorDefaultMessage, result);
			}
		}
	}

	/**
	 * Error can be setted via message source using code =
	 * "stateEmpty.modelAttributeName.fieldName"
	 *
	 */
	@Override
	public void checkStateNotEmpty(ClimbingSiteSFC climbingSiteSFC, String modelAttributeName, BindingResult result) {
		try {
			if (climbingSiteSFC.getClimbingSiteStateId() == 19)
				throw new NullPointerException();
		} catch (Exception e) {
			SpringValidationError.addError(stateEmpty, modelAttributeName, "climbingSiteStateId",
					stateEmptyDefaultMessage, result);
		}
	}

	/**
	 * Error can be setted via message source using code =
	 * "countyEmpty.modelAttributeName.fieldName"
	 *
	 */
	@Override
	public void checkCountyNotEmpty(ClimbingSiteSFC climbingSiteSFC, String modelAttributeName, BindingResult result) {
		try {
			if (climbingSiteSFC.getClimbingSiteCountyId() == 102)
				throw new NullPointerException();
		} catch (Exception e) {
			SpringValidationError.addError(countyEmpty, modelAttributeName, "climbingSiteCountyId",
					countyEmptyDefaultMessage, result);
		}
	}

	/**
	 * Error can be setted via message source using code =
	 * "noRoute.modelAttributeName.fieldName"
	 *
	 */
	@Override
	public void checkRouteListNotEmpty(Map<String, SiteRoutesSFC> siteRoutesMap, String modelAttributeName,
			BindingResult result) {
		if (siteRoutesMap.isEmpty()) {
			SpringValidationError.addError(routeListEmptyError, modelAttributeName, "routeName",
					routeListEmptyDefaultMessage, result);
		}
	}

	/**
	 * Error can be setted via message source using code =
	 * "routeNotUnique.modelAttributeName.fieldName"
	 *
	 */
	@Override
	public void checkRouteExistence(Map<String, SiteRoutesSFC> siteRoutesMap, String routeNameSent,
			String modelAttributeName, BindingResult result) {
		if (routeExistenceError(siteRoutesMap, routeNameSent)) {
			SpringValidationError.addError(routeErrorCode, modelAttributeName, "routeName", routeErrorDefaultMessage,
					result);
		}
	}

	/**
	 * Error can be setted via message source using code =
	 * "pitchNotUnique.modelAttributeName.fieldName"
	 *
	 */
	@Override
	public void checkPitchExistence(List<RoutePitchSFC> list, RoutePitchSFC toCheck, String modelAttributeName,
			BindingResult result) {
		if (pitchExistenceError(list, toCheck)) {
			SpringValidationError.addError(pitchErrorCode, modelAttributeName, "pitchNumber", pitchErrorDefaultMessage,
					result);
		}
	}

	/**
	 * Error can be setted via message source using code =
	 * "pitchListEmpty.modelAttributeName.fieldName"
	 *
	 */
	@Override
	public void checkPitchListNotEmpty(List<RoutePitchSFC> list, String modelAttributeName, BindingResult result) {
		try {
			if (list.isEmpty()) {

				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			SpringValidationError.addError(pitchEmptyCode, modelAttributeName, "pitchNumber", pitchEmptyDefaultMessage,
					result);
		}
	}

	private Boolean minAndMax(String min, String max) {
		if (!min.isEmpty() && !max.isEmpty()) {
			return FredParser.toInteger(min) <= FredParser.toInteger(max);
		} else {
			return true;
		}
	}

	private Boolean routeExistenceError(Map<String, SiteRoutesSFC> siteRoutesMap, String routeNameSent) {
		return siteRoutesMap.containsKey(routeNameSent);
	}

	private Boolean pitchExistenceError(List<RoutePitchSFC> list, RoutePitchSFC toCheck) {
		pitchError = false;
		list.forEach(o -> {
			if (o.equals(toCheck)) {
				pitchError = true;
			}
		});
		return pitchError;
	}

	public Boolean routePitchSFCCheck(RoutePitchSFC elemt1, RoutePitchSFC elemt2) {
		return elemt1.equals(elemt2);
	}

}
