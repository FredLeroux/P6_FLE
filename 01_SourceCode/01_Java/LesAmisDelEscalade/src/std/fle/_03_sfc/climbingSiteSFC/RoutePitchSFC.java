package std.fle._03_sfc.climbingSiteSFC;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.ReadOnlyInput;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import std.fle._01_entity.assetsClasses.ClimbingLevels;
import std.fle._02_dto.assetsClassesDTO.ClimbingLevelsDTO;

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

@SpringFormSettings(
		action = "routePitchModification",
		method = "post",
		modelAttribute = "editRoutePitch",
		name = "editRoutePitchFormular",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		submitButtonAlignmentPropertyKey = "userFormBtn.align",
		submitButtonMessagePropertyKey = "userFormBtn.message.editRoutePitch",
		jspFilePath = "editSiteRoutePitchForm.path",
		labelMessageSourceSuffix = "userForm.label",
		readOnly = false)
@Validated
public class RoutePitchSFC extends SFC {
	
	@HiddenPath
	private Integer id;

	@NotEmpty
	@ReadOnlyInput(applyToForm = "editRoutePitchFormular")
	private String pitchNumber;
	
	@NotNull
	@SelectInputType(selectListName = "climbList",
			selectValueName = "climbValue",
			entityClass = ClimbingLevels.class,
			dtoClass = ClimbingLevelsDTO.class,
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "cotationLevel",
			defaultValue = "5")
	private String pitchClimbingLevels;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPitchNumber() {
		return pitchNumber;
	}

	public void setPitchNumber(String pitchNumber) {
		this.pitchNumber = pitchNumber;
	}

	public String getPitchClimbingLevels() {
		return pitchClimbingLevels;
	}

	public void setPitchClimbingLevels(String pitchClimbingLevels) {
		this.pitchClimbingLevels = pitchClimbingLevels;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pitchNumber == null) ? 0 : pitchNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoutePitchSFC other = (RoutePitchSFC) obj;
		if (pitchNumber == null) {
			if (other.pitchNumber != null)
				return false;
		} else if (!pitchNumber.equals(other.pitchNumber))
			return false;
		return true;
	}

	
	
	
	
	
	
	
	

}
