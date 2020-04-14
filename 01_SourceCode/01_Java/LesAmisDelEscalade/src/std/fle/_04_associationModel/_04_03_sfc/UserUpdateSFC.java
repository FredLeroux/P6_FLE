package std.fle._04_associationModel._04_03_sfc;

import javax.validation.Valid;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import fle.toolBox.springFormManager.annotations.entityModelAssociation.EntityModelAssociation;
import std.fle._03_sfc._03_01_usersInfoSFC.UsersInfoSFC;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoUpdateSFC;

@EntityModelAssociation
@SpringFormSettings(
		action = "userUpdate",
		method = "post", 
		modelAttribute = "userManagement", 
		name = "userUpdateFormular", 
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		buttonAlignmentPropertyKey = "userFormBtn.align", 
		buttonMessagePropertyKey = "userFormBtn.message.update", 
		jspFilePath = "userUpdateForm.path", 
		labelMessageSourceSuffix = "userForm.label",		 
		readOnly = false)
public class UserUpdateSFC extends SFC {
	
	@Valid
	private UsersInfoSFC usersInfoSFC;
	
	private UsersAccountInfoUpdateSFC usersAccountInfoUpdateSFC;

	public UsersInfoSFC getUsersInfoSFC() {
		return usersInfoSFC;
	}

	public void setUsersInfoSFC(UsersInfoSFC usersInfoSFC) {
		this.usersInfoSFC = usersInfoSFC;
	}

	public UsersAccountInfoUpdateSFC getUsersAccountInfoUpdateSFC() {
		return usersAccountInfoUpdateSFC;
	}

	public void setUsersAccountInfoUpdateSFC(UsersAccountInfoUpdateSFC usersAccountInfoUpdateSFC) {
		this.usersAccountInfoUpdateSFC = usersAccountInfoUpdateSFC;
	} 
	
	
	

}
