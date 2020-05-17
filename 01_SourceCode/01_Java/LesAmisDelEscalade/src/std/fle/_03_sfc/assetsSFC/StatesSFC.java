package std.fle._03_sfc.assetsSFC;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import std.fle._01_entity.assetsClasses.States;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;

public class StatesSFC extends SFC {

	@HiddenPath
	private Integer id;

	@SelectInputType(
			selectListName = "statesList",
			selectValueName = "stateValue",
			entityClass = States.class,
			dtoClass = StatesDTO.class,
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "stateName",
			dependentFieldName = "countyId",
			dependentFieldNameFilteringAction = "filterCountiesList",
			defaultValue = "102")
	private Integer stateId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

}
