package std.fle._03_sfc.topoSFC;

import java.time.Year;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.dataListDisplayerTools.annotations.ToTranslate;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.PlaceHolderText;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import std.fle._01_entity._assetsEnum.BooleanValue;
import std.fle._01_entity.assetsClasses.States;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;

@Validated
@SpringFormSettings(
		action = "createNewTopo",
		method = "post",
		name = "createNewTopoForm",
		modelAttribute = "createTopo",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		jspFilePath = "createNewTopoForm.path",
		labelMessageSourceSuffix = "userForm.label",
		buttonAlignmentPropertyKey = "center",
		buttonMessagePropertyKey = "userFormBtn.message.createTopo",
		readOnly = false )
public class ClimbingTopoSFC extends SFC {
	
	@HiddenPath
	private Integer id;

	@NotEmpty
	@Length(max = 100)
	@PlaceHolderText(message = "topoTitle.pht")
	private String title;

	
	@DateTimeFormat(pattern = "YYYY")	
	private Year editionYear;

	@ToTranslate(suffix = "isAvailable")
	@SelectInputType(enumClass = BooleanValue.class,messageSourceSuffix = ".isAvailabe", selectListName = "availableList",selectValueName = "availableValue")
	private String available;

	@Length(max = 200)
	@PlaceHolderText(message = "topoDescription.pht")
	private String topoDescription;

	@NotNull
	@SelectInputType(
			selectListName = "topoStatesList",
			selectValueName = "topoStateValue",
			entityClass = States.class,
			dtoClass = StatesDTO.class,
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "stateName")
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Year getEditionYear() {
		return editionYear;
	}

	public void setEditionYear(Year	 editionYear) {
		this.editionYear = editionYear;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getTopoDescription() {
		return topoDescription;
	}

	public void setTopoDescription(String topoDescription) {
		this.topoDescription = topoDescription;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	
	
	


}
