package std.fle._04_associationModel.sfc;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import fle.toolBox.springFormManager.annotations.entityModelAssociation.EntityModelAssociation;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoSFC;
import std.fle._03_sfc.usersInfoSFC.UsersInfoSFC;

@Validated
@EntityModelAssociation
@SpringFormSettings(
		action = "userCreation",
		method = "post",
		modelAttribute = "userManagement",
		name = "userRegisterFormular",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		submitButtonAlignmentPropertyKey = "userFormBtn.align",
		submitButtonMessagePropertyKey = "userFormBtn.message.register",
		jspFilePath = "userRegisterForm.path",
		labelMessageSourceSuffix = "userForm.label",
		readOnly = false)
public class UserSFC extends SFC {

	@Valid
	private UsersInfoSFC usersInfoSFC;
	@Valid
	private UsersAccountInfoSFC usersAccountInfoSFC;

	public UsersInfoSFC getUsersInfoSFC() {
		return usersInfoSFC;
	}

	public void setUsersInfoSFC(UsersInfoSFC usersInfoSFC) {
		this.usersInfoSFC = usersInfoSFC;
	}

	public UsersAccountInfoSFC getUsersAccountInfoSFC() {
		return usersAccountInfoSFC;
	}

	public void setUsersAccountInfoSFC(UsersAccountInfoSFC usersAccountInfoSFC) {
		this.usersAccountInfoSFC = usersAccountInfoSFC;
	}

}
