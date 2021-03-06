package std.fle._03_sfc.topoSFC;

import java.time.Year;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.annotations.ToTranslate;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.PlaceHolderText;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import fle.toolBox.springFormManager.annotations.inputTextArea.InputTextArea;
import std.fle._01_entity.assetsClasses.States;
import std.fle._01_entity.assetsEnum.BooleanValue;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;

@Validated
@SpringFormSettings(
		action = "createNewTopo",
		method = "post",
		name = "createNewTopoFormular",
		modelAttribute = "createTopo",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		jspFilePath = "createNewTopoForm.path",
		labelMessageSourceSuffix = "userForm.label",
		submitButtonAlignmentPropertyKey = "userFormBtn.align",
		submitButtonMessagePropertyKey = "userFormBtn.message.createTopo",
		readOnly = false )

@SpringFormSettings(
		action = "updateTopo",
		method = "post",
		name = "updateTopoFormular",
		modelAttribute = "updateTopo",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		jspFilePath = "updateTopoForm.path",
		labelMessageSourceSuffix = "userForm.label",
		submitButtonAlignmentPropertyKey = "userFormBtn.align",
		submitButtonMessagePropertyKey = "userFormBtn.message.updateTopo",
		readOnly = false )

public class ClimbingTopoSFC extends SFC {

	@HiddenPath
	private Integer id;

	@NotEmpty
	@Length(max = 100)
	@PlaceHolderText(message = "topoTitle.pht")
	private String title;


	@PastOrPresent
	@NotNull
	@DateTimeFormat(pattern = "yyyy")
	private Year editionYear;


	@SelectInputType(
			selectListName = "topoStatesList",
			selectValueName = "topoStateValue",
			entityClass = States.class,
			dtoClass = StatesDTO.class,
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "stateName",
			defaultValue = "19")
	private String state;

	@NotEmpty
	@SelectInputType(
			enumClass = BooleanValue.class,
			messageSourceSuffix = ".isAvailable",
			selectListName = "availableList",
			selectValueName = "availableValue",
			defaultValue = "")
	@ToTranslate(suffix = "isAvailable")
	private String available;

	@Length(max = 200)
	@PlaceHolderText(message = "topoDescription.pht")
	@InputTextArea(rows = 5,charByRows = 40,maxLenght = 200)
	private String topoDescription;



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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}






}
