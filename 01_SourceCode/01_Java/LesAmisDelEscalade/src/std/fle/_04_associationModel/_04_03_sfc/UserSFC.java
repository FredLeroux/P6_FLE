package std.fle._04_associationModel._04_03_sfc;

import javax.validation.Valid;



import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import fle.toolBox.springFormManager.annotations.entityModelAssociation.EntityModelAssociation;
import std.fle._03_sfc._03_01_usersSFC.UserInfoSFC;
import std.fle._03_sfc._03_01_usersSFC.UsersAccountInfoSFC;

@EntityModelAssociation
@SpringFormSettings(
		action = "userCreation",
		method = "post", 
		modelAttribute = "userManagement", 
		name = "userFormular", 
		propertiesFilePath = "configuration/springFormSettings.xml",
		buttonAlignmentPropertyKey = "userFormBtn.align", 
		buttonMessagePropertyKey = "userFormBtn.message", 
		jspFilePath = "/resources/02_templatesJsp/02_02_form/userForm.jsp", 
		labelMessageSourceSuffix = "userForm.Label",		 
		readOnly = false)
public class UserSFC extends SFC {

	@Valid
	private UserInfoSFC userInfoSFC;
	@Valid
	private UsersAccountInfoSFC usersAccountInfoSFC;

	public UserInfoSFC getUserInfoSFC() {
		return userInfoSFC;
	}

	public void setUserInfoSFC(UserInfoSFC userInfoSFC) {
		this.userInfoSFC = userInfoSFC;
	}

	public UsersAccountInfoSFC getUsersAccountInfoSFC() {
		return usersAccountInfoSFC;
	}

	public void setUsersAccountInfoSFC(UsersAccountInfoSFC usersAccountInfoSFC) {
		this.usersAccountInfoSFC = usersAccountInfoSFC;
	}

}
