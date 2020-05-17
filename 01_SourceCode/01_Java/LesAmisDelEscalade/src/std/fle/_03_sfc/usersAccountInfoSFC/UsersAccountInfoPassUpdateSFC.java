package std.fle._03_sfc.usersAccountInfoSFC;

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
(action = "updatePassword",
method = "post",
modelAttribute = "updatePass",
name = "updatePassFormular",
propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
submitButtonAlignmentPropertyKey = "userFormBtn.align",
submitButtonMessagePropertyKey = "userFormBtn.message.resetPass",
jspFilePath = "updatePassForm.path",
labelMessageSourceSuffix = "resetPassForm.label",
readOnly = false)

@Validated
public class UsersAccountInfoPassUpdateSFC extends SFC {

	@HiddenPath
	private Integer ghost;

	@NotEmpty
	@Length(min = 8, max = 16)
	@PassWordField
	@PlaceHolderText(message = "password.pht")
	private String oldPassword;

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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
