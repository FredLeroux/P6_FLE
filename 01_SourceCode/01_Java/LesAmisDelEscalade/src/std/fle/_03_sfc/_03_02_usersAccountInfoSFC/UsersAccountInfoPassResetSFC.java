package std.fle._03_sfc._03_02_usersAccountInfoSFC;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.PassWordField;
import fle.toolBox.springFormManager.annotations.PlaceHolderText;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;

@SpringFormSettings
(action = "resetPassword",
method = "post",
modelAttribute = "resetPass",
name = "resetPassFormular",
propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
buttonAlignmentPropertyKey = "userFormBtn.align",
buttonMessagePropertyKey = "userFormBtn.message.resetPass",
jspFilePath = "resetPassForm.path",
labelMessageSourceSuffix = "resetPassForm.label",
readOnly = false)

@Validated
public class UsersAccountInfoPassResetSFC extends SFC {

	@HiddenPath
	private Integer ghost;

	@NotEmpty
	@Length(min = 8, max = 16)
	@PassWordField
	@PlaceHolderText(message = "password1.pht")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$")
	private String password;

	public Integer getGhost() {
		return ghost;		
	}

	public void setGhost(Integer ghost) {
		this.ghost = ghost;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
