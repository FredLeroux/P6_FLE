package std.fle._03_sfc.climbingSiteSFC;

import fle.toolBox.classType.SFC;
import fle.toolBox.dataListDisplayerTools.annotations.ToTranslate;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.ReadOnlyInput;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import fle.toolBox.springFormManager.annotations.actionButtons.SpringFormActionButton;
import fle.toolBox.springFormManager.annotations.actionButtons.SpringFormButton;
import fle.toolBox.springFormManager.annotations.inputTextArea.InputTextArea;

@SpringFormSettings(
		action = "",
		method = "",
		modelAttribute = "siteInfoDisplay",
		name = "sitesiteInfoDisplayFormular",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		submitButtonAlignmentPropertyKey = "",
		submitButtonMessagePropertyKey = "",
		jspFilePath = "displaySiteForm.path",
		labelMessageSourceSuffix = "userForm.label",
		readOnly = true)

public class ClimbingSiteDisplaySFC extends SFC {

	@HiddenPath
	private Integer id;
	
	@ReadOnlyInput
	private String climbingSiteName;
	
	@ToTranslate(suffix = ".official")
	@ReadOnlyInput
	private String official;
	
	@ReadOnlyInput
	private String climbingSiteStateId;

	@ReadOnlyInput
	private String climbingSiteCountyId;

	
	@InputTextArea(charByRows = 50, rows = 5,readOnly = true)
	private String siteDescription;
	
	@ReadOnlyInput
	private String altitude;
	
	@ReadOnlyInput
	private String heightMin;
	
	@ReadOnlyInput
	private String heightMax;
	
	@ReadOnlyInput
	private String numberOfRoutes;
	
	
	@InputTextArea(charByRows = 50, rows = 5,readOnly = true)
	private String accessToSite;
	
	@SpringFormActionButton(displayMessagePropertyKey = "doAComment.label")
	private SpringFormButton commentSite;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClimbingSiteName() {
		return climbingSiteName;
	}

	public void setClimbingSiteName(String climbingSiteName) {
		this.climbingSiteName = climbingSiteName;
	}

	public String getOfficial() {
		return official;
	}

	public void setOfficial(String official) {
		this.official = official;
	}

	public String getClimbingSiteStateId() {
		return climbingSiteStateId;
	}

	public void setClimbingSiteStateId(String climbingSiteStateId) {
		this.climbingSiteStateId = climbingSiteStateId;
	}

	public String getClimbingSiteCountyId() {
		return climbingSiteCountyId;
	}

	public void setClimbingSiteCountyId(String climbingSiteCountyId) {
		this.climbingSiteCountyId = climbingSiteCountyId;
	}

	public String getSiteDescription() {
		return siteDescription;
	}

	public void setSiteDescription(String siteDescription) {
		this.siteDescription = siteDescription;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getHeightMin() {
		return heightMin;
	}

	public void setHeightMin(String heightMin) {
		this.heightMin = heightMin;
	}

	public String getHeightMax() {
		return heightMax;
	}

	public void setHeightMax(String heightMax) {
		this.heightMax = heightMax;
	}

	public String getNumberOfRoutes() {
		return numberOfRoutes;
	}

	public void setNumberOfRoutes(String numberOfRoutes) {
		this.numberOfRoutes = numberOfRoutes;
	}

	public String getAccessToSite() {
		return accessToSite;
	}

	public void setAccessToSite(String accessToSite) {
		this.accessToSite = accessToSite;
	}

	public SpringFormButton getCommentSite() {
		return commentSite;
	}

	public void setCommentSite(SpringFormButton commentSite) {
		this.commentSite = commentSite;
	}
	
	
}
	