package std.fle._03_sfc.topoSFC;

import java.time.LocalDate;
import java.time.format.FormatStyle;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import fle.toolBox.classType.SFC;
import fle.toolBox.dataListDisplayerTools.annotations.ToTranslate;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.PlaceHolderText;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import std.fle._01_entity._assetsEnum.BooleanValue;
import std.fle._01_entity.assetsClasses.States;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;
@SpringFormSettings(
		action = "createNewTopo",
		method = "post",
		name = "createNewTopoForm",
		modelAttribute = "createTopo",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		jspFilePath = "createNewTopoForm.path",
		labelMessageSourceSuffix = "userForm.label",
		buttonAlignmentPropertyKey = "center",
		buttonMessagePropertyKey = "button.createTopo.label",
		readOnly = false )
public class ClimbingTopoSFC extends SFC {
	
	@HiddenPath
	private Integer id;

	@NotEmpty
	@Length(max = 100)
	@PlaceHolderText(message = "topoTitle.pht")
	private String title;

	@NotEmpty
	@DateTimeFormat(pattern = "YYYY")	
	private LocalDate editionYear;

	@ToTranslate(suffix = "isAvailable")
	@SelectInputType(enumClass = BooleanValue.class,messageSourceSuffix = ".isAvailabe", selectListName = "availableList",selectValueName = "availableValue")
	private Boolean available;

	@Length(max = 200)
	@PlaceHolderText(message = "topoDescription.pht")
	private String topoDescription;

	@SelectInputType(
			selectListName = "topoStatesList",
			selectValueName = "topoStateValue",
			entityClass = States.class,
			dtoClass = StatesDTO.class,
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "stateName")
	private States state;

	


}
