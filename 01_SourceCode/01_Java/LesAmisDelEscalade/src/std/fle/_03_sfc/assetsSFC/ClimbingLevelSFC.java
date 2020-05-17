package std.fle._03_sfc.assetsSFC;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import std.fle._01_entity.assetsClasses.ClimbingLevels;
import std.fle._02_dto.assetsClassesDTO.ClimbingLevelsDTO;

public class ClimbingLevelSFC extends SFC {

	@HiddenPath
	private Integer id;

	@SelectInputType(selectListName = "climbList", selectValueName = "climbValue", entityClass = ClimbingLevels.class, dtoClass = ClimbingLevelsDTO.class, optionValueFieldName = "id", optionDisplayValueFieldName = "cotationLevel",
			defaultValue = "0")
	private Integer climbingLevelId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClimbingLevelId() {
		return climbingLevelId;
	}

	public void setClimbingLevelId(Integer climbingLevelId) {
		this.climbingLevelId = climbingLevelId;
	}

}
