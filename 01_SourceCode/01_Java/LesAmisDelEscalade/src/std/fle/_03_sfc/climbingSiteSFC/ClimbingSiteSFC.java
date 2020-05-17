package std.fle._03_sfc.climbingSiteSFC;



import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.InputTextArea;
import fle.toolBox.springFormManager.annotations.ReadOnlyInput;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import fle.toolBox.springFormManager.annotations.actionButtons.SpringFormActionButton;
import fle.toolBox.springFormManager.annotations.actionButtons.SpringFormButton;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.numeric.Numeric;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique.Unique;
import std.fle._01_entity.assetsClasses.Counties;
import std.fle._01_entity.assetsClasses.States;
import std.fle._02_dto.assetsClassesDTO.CountiesDTO;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;



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
	
	@SelectInputType(
			selectListName = "statesList",
			selectValueName = "stateValue",
			entityClass = States.class,
			dtoClass = StatesDTO.class,
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "stateName",
			dependentFieldName = "climbingSiteCountyId",
			dependentFieldNameFilteringAction = "filterClimbingSiteCountiesList",
			defaultValue = "19")
	private Integer climbingSiteStateId;

	@SelectInputType(
			selectListName = "countiesList",
			selectValueName = "countyValue",
			entityClass = Counties.class,
			dtoClass = CountiesDTO.class,
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "countyName",
			relationShipField = "state",
			relationShipFieldFilter = "id",
			masterFieldName = "climbingSiteStateId",
			defaultValue = "102")
	private Integer climbingSiteCountyId;

	@Unique(entityName = "ClimbingSite", fieldName = "climbingSiteName", modelAttributeValue = "siteFullInfo")
	@NotEmpty
	private String climbingSiteName;

	@Length(max = 200)
	@InputTextArea(charByRows = 50, rows = 4)
	private String siteDescription;

	@Numeric(maxDigits = 4, modelAttributeValue = "siteFullInfo")
	private String altitude;

	@Numeric(maxDigits = 3, modelAttributeValue = "siteFullInfo")
	private String heightMin;

	@Numeric(maxDigits = 3, modelAttributeValue = "siteFullInfo")
	private String heightMax;

	@ReadOnlyInput
	private Integer numberOfRoutes;

	@Length(max = 500)
	@InputTextArea(charByRows = 50, rows = 10)
	private String accessToSite;

	@SpringFormActionButton(displayMessagePropertyKey = "addRoute.label")
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

	public Integer getClimbingSiteStateId() {
		return climbingSiteStateId;
	}

	public void setClimbingSiteStateId(Integer climbingSiteStateId) {
		this.climbingSiteStateId = climbingSiteStateId;
	}

	public Integer getClimbingSiteCountyId() {
		return climbingSiteCountyId;
	}

	public void setClimbingSiteCountyId(Integer climbingSiteCountyId) {
		this.climbingSiteCountyId = climbingSiteCountyId;
	}

	public SpringFormButton getSiteRoutes() {
		return siteRoutes;
	}

	public void setSiteRoutes(SpringFormButton siteRoutes) {
		this.siteRoutes = siteRoutes;
	}

}
