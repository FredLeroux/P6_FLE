package std.fle._03_sfc.climbingSiteSFC.associatedClimbingSiteSFC;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import fle.toolBox.springFormManager.annotations.entityModelAssociation.EntityModelAssociation;
import std.fle._03_sfc.assetsSFC.StatesAndCountiesSFC;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;

@EntityModelAssociation
@SpringFormSettings(
		action = "createSite",
		method = "post",
		modelAttribute = "siteFullInfo",
		name = "siteFullInfoFormular",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		submitButtonAlignmentPropertyKey = "userFormBtn.align",
		submitButtonMessagePropertyKey = "userFormBtn.message.createSite",
		jspFilePath = "createNewSiteForm.path",
		labelMessageSourceSuffix = "userForm.label",
		readOnly = false)
public class ClimbingSiteStatesAndCountiesSFC extends SFC {
	
	private StatesAndCountiesSFC statesAndCountiesSFC;
	
	private ClimbingSiteSFC climbingSiteSFC;

	public StatesAndCountiesSFC getStatesAndCountiesSFC() {
		return statesAndCountiesSFC;
	}

	public void setStatesAndCountiesSFC(StatesAndCountiesSFC statesAndCountiesSFC) {
		this.statesAndCountiesSFC = statesAndCountiesSFC;
	}

	public ClimbingSiteSFC getClimbingSiteSFC() {
		return climbingSiteSFC;
	}

	public void setClimbingSiteSFC(ClimbingSiteSFC climbingSiteSFC) {
		this.climbingSiteSFC = climbingSiteSFC;
	}
	
	

}
