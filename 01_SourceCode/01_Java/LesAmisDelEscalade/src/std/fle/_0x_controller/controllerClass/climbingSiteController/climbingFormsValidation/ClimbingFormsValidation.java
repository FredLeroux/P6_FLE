package std.fle._0x_controller.controllerClass.climbingSiteController.climbingFormsValidation;

import java.util.List;

import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;

public interface ClimbingFormsValidation {
	
	public String checkPitchExistence(List<RoutePitchSFC> list, RoutePitchSFC toCheck);

}
