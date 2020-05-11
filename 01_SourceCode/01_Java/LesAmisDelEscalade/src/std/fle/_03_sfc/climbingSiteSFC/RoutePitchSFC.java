package std.fle._03_sfc.climbingSiteSFC;

import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import fle.toolBox.springFormManager.annotations.entityModelAssociation.EntityModelAssociation;
import std.fle._01_entity.assetsClasses.ClimbingLevels;
import std.fle._01_entity.models.site.SiteRoutes;
import std.fle._02_dto.assetsClassesDTO.ClimbingLevelsDTO;
import std.fle._03_sfc.assetsSFC.ClimbingLevelSFC;

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
@Validated
public class RoutePitchSFC extends SFC {
	
	@HiddenPath
	private Integer id;

	private Integer pitchNumber;
	
/*	@SelectInputType(selectListName = "climbList",
			selectValueName = "climbValue",
			entityClass = ClimbingLevels.class,
			dtoClass = ClimbingLevelsDTO.class,
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "cotationLevel")
	private Integer climbingLevels;*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPitchNumber() {
		return pitchNumber;
	}

	public void setPitchNumber(Integer pitchNumber) {
		this.pitchNumber = pitchNumber;
	}

	
/*	public Integer getClimbingLevels() {
		return climbingLevels;
	}

	public void setClimbingLevels(Integer climbingLevels) {
		this.climbingLevels = climbingLevels;
	}*/
	
	
	
	
	
	

}
