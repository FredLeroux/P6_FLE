package std.fle._04_associationModel._04_01_model;

import fle.toolBox.classType.ENT;
import std.fle._01_entity._01_03_models.UsersAccountInfo;
import std.fle._01_model._01_accountManagement.UserInfo;

public class User extends ENT {
	
	private UserInfo userInfo; 
	
	private UsersAccountInfo usersAccountInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UsersAccountInfo getUsersAccountInfo() {
		return usersAccountInfo;
	}

	public void setUsersAccountInfo(UsersAccountInfo usersAccountInfo) {
		this.usersAccountInfo = usersAccountInfo;
	}
	
	

}
