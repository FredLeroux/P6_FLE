package std.fle._03_sfc.climbingSiteSFC.associatedClimbingSiteSFC;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import fle.toolBox.springFormManager.annotations.entityModelAssociation.EntityModelAssociation;
import std.fle._03_sfc.assetsSFC.ClimbingLevelSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;

@EntityModelAssociation
@SpringFormSettings(
		action = "createRoutePitch",
		method = "post",
		modelAttribute = "routePitch",
		name = "routePitchFormular",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		submitButtonAlignmentPropertyKey = "userFormBtn.align",
		submitButtonMessagePropertyKey = "userFormBtn.message.createRoutePitch",
		jspFilePath = "createNewSiteRoutePitchForm.path",
		labelMessageSourceSuffix = "userForm.label",
		readOnly = false)

public class RoutePitchClimbingLvlSFC extends SFC {
	
	private RoutePitchSFC routePitchSFC;
	
	private ClimbingLevelSFC climbingLevelSFC;

	public RoutePitchSFC getRoutePitchSFC() {
		return routePitchSFC;
	}

	public void setRoutePitchSFC(RoutePitchSFC routePitchSFC) {
		this.routePitchSFC = routePitchSFC;
	}

	public ClimbingLevelSFC getClimbingLevelSFC() {
		return climbingLevelSFC;
	}

	public void setClimbingLevelSFC(ClimbingLevelSFC climbingLevelSFC) {
		this.climbingLevelSFC = climbingLevelSFC;
	}
	
	

}
