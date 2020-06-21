package std.fle._03_sfc.climbingSiteSFC;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.PlaceHolderText;
import fle.toolBox.springFormManager.annotations.ReadOnlyInput;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import fle.toolBox.springFormManager.annotations.actionButtons.SpringFormActionButton;
import fle.toolBox.springFormManager.annotations.actionButtons.SpringFormButton;
import fle.toolBox.springFormManager.annotations.inputTextArea.InputTextArea;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.numeric.Numeric;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique.Unique;
import std.fle._01_entity.assetsClasses.Counties;
import std.fle._01_entity.assetsClasses.States;
import std.fle._01_entity.assetsEnum.BooleanValue;
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
@SpringFormSettings(
		action = "updateSite",
		method = "post",
		modelAttribute = "siteFullInfoUpdate",
		name = "siteFullInfoUpdateFormular",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		submitButtonAlignmentPropertyKey = "userFormBtn.align",
		submitButtonMessagePropertyKey = "userFormBtn.message.updateSite",
		jspFilePath = "updateSiteForm.path",
		labelMessageSourceSuffix = "userForm.label",
		readOnly = false)

@Validated
public class ClimbingSiteSFC extends SFC {

	@HiddenPath
	private Integer id;
	
	@NotEmpty
	@Unique(entityName = "ClimbingSite", fieldName = "climbingSiteName", modelAttributeValue = "siteFullInfo")
	private String climbingSiteName;
	
	@SelectInputType(enumClass = BooleanValue.class, selectListName = "officialList", selectValueName = "officialValue",defaultValue = "false",messageSourceSuffix = ".official")
	private String official;
	
	
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
	private String climbingSiteStateId;

	@NotNull
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
	private String climbingSiteCountyId;

	@Length(max = 200)
	@InputTextArea(charByRows = 50, rows = 4,maxLenght = 200,limitCharName = "siteDescriptionCharLeft.name")
	@PlaceHolderText(message = "description")
	private String siteDescription;
	
	

	@Numeric(maxDigits = 4, modelAttributeValue = "siteFullInfo")
	private String altitude;

	@Numeric(maxDigits = 3, modelAttributeValue = "siteFullInfo")
	private String heightMin;

	@Numeric(maxDigits = 3, modelAttributeValue = "siteFullInfo")
	private String heightMax;

	@ReadOnlyInput
	private String numberOfRoutes;

	
	@Length(max = 500)
	@InputTextArea(charByRows = 50, rows = 10,maxLenght = 500,limitCharName = "siteAccesToSiteCharLeft.name")
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

	public String getOfficial() {
		return official;
	}

	public void setOfficial(String official) {
		this.official = official;
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

	public SpringFormButton getSiteRoutes() {
		return siteRoutes;
	}

	public void setSiteRoutes(SpringFormButton siteRoutes) {
		this.siteRoutes = siteRoutes;
	}

}
