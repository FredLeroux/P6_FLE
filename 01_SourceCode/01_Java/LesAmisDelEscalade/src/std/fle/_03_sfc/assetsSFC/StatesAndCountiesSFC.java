package std.fle._03_sfc.assetsSFC;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import std.fle._01_entity.assetsClasses.Counties;
import std.fle._01_entity.assetsClasses.States;
import std.fle._02_dto.assetsClassesDTO.CountiesDTO;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;

public class StatesAndCountiesSFC extends SFC {

	@HiddenPath
	private Integer ghost;
	
	@SelectInputType(
			selectListName = "statesList",
			selectValueName = "stateValue",
			entityClass = States.class,
			dtoClass = StatesDTO.class,
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "stateName",
			dependentFieldName = "countyId",
			dependentFieldNameFilteringAction = "filterCountiesList",
			defaultValue = "19")
	private Integer stateId;

	@SelectInputType(
			selectListName = "countiesList",
			selectValueName = "countyValue",
			entityClass = Counties.class,
			dtoClass = CountiesDTO.class,
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "countyName",
			relationShipField = "state",
			relationShipFieldFilter = "id",
			masterFieldName = "stateId",
			defaultValue = "102")
	private Integer countyId;
}
