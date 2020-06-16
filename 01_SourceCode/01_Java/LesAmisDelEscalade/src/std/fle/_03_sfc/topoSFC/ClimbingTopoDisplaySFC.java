package std.fle._03_sfc.topoSFC;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.ReadOnlyInput;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import fle.toolBox.springFormManager.annotations.inputTextArea.InputTextArea;

@SpringFormSettings(
		action = "borrowThisTopo", 
		method = "post", 
		name = "displayTopoFormular", 
		modelAttribute = "displayTopo", 
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml", 
		jspFilePath = "displayTopoForm.path", 
		labelMessageSourceSuffix = "userForm.label", 
		submitButtonAlignmentPropertyKey = "center", 
		submitButtonMessagePropertyKey = "userFormBtn.message.borrowThisTopo", 
		readOnly = false)

public class ClimbingTopoDisplaySFC extends SFC{

	@HiddenPath
	private Integer id;

	@ReadOnlyInput
	private String title;

	@ReadOnlyInput
	private String editionYear;

	@ReadOnlyInput
	private String state;
	
	@ReadOnlyInput
	private String owner;

	@InputTextArea(rows = 5, charByRows = 40, readOnly = true)
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

	public String getEditionYear() {
		return editionYear;
	}

	public void setEditionYear(String editionYear) {
		this.editionYear = editionYear;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTopoDescription() {
		return topoDescription;
	}

	public void setTopoDescription(String topoDescription) {
		this.topoDescription = topoDescription;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	

}
