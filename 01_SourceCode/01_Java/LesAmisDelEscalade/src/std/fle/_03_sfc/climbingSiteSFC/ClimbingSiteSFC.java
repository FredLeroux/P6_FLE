package std.fle._03_sfc.climbingSiteSFC;



import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import fle.toolBox.springFormManager.annotations.actionButtons.SpringFormActionButton;
import fle.toolBox.springFormManager.annotations.actionButtons.SpringFormButton;



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

@Validated
public class ClimbingSiteSFC extends SFC {

	@HiddenPath
	private Integer id;

	private String climbingSiteName;

	private String siteDescription;

	private Integer altitude;

	private Integer heightMin;

	private Integer heightMax;

	private Integer numberOfRoutes;

	private String accessToSite;

//	private States state;

//	private Counties county;
	
	
	@SpringFormActionButton(displayMessagePropertyKey = "ajouter une voix")
	private SpringFormButton siteRoutes;

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

	public String getSiteDescription() {
		return siteDescription;
	}

	public void setSiteDescription(String siteDescription) {
		this.siteDescription = siteDescription;
	}

	public Integer getAltitude() {
		return altitude;
	}

	public void setAltitude(Integer altitude) {
		this.altitude = altitude;
	}

	public Integer getHeightMin() {
		return heightMin;
	}

	public void setHeightMin(Integer heightMin) {
		this.heightMin = heightMin;
	}

	public Integer getHeightMax() {
		return heightMax;
	}

	public void setHeightMax(Integer heightMax) {
		this.heightMax = heightMax;
	}

	public Integer getNumberOfRoutes() {
		return numberOfRoutes;
	}

	public void setNumberOfRoutes(Integer numberOfRoutes) {
		this.numberOfRoutes = numberOfRoutes;
	}

	public String getAccessToSite() {
		return accessToSite;
	}

	public void setAccessToSite(String accessToSite) {
		this.accessToSite = accessToSite;
	}

/*	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public Counties getCounty() {
		return county;
	}

	public void setCounty(Counties county) {
		this.county = county;
	}*/

	public SpringFormButton getSiteRoutes() {
		return siteRoutes;
	}

	public void setSiteRoutes(SpringFormButton siteRoutes) {
		this.siteRoutes = siteRoutes;
	}

	
	
	
	
	
	
}
