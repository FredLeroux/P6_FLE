package std.fle._03_sfc.climbingSiteSFC;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import fle.toolBox.springFormManager.annotations.inputTextArea.InputTextArea;

@SpringFormSettings(
		action = "updateComment",
		method = "post",
		modelAttribute = "climbingSiteComment",
		name = "climbingSiteCommentFormular",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		submitButtonMessagePropertyKey = "userFormBTN.message.postComment",
		submitButtonAlignmentPropertyKey = "userFormBtn.align",
		jspFilePath = "editCommentFormular.path",
		labelMessageSourceSuffix = "userForm.label",
		readOnly = false
		)


@Validated 
public class ClimbingSiteCommentsSFC extends SFC{

	@HiddenPath
	private Integer id;

	@NotEmpty
	@Pattern(regexp = "^[^*]*$")
	@Length(max = 500)
	@InputTextArea(rows = 5,charByRows = 100,maxLenght = 500)	
	private String comment;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
	

}
