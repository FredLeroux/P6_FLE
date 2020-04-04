package std.fle._04_associationModel._04_01_model;

import fle.toolBox.classType.ENT;
import std.fle._01_entity._01_03_models.UsersAccountInfo;
import std.fle._01_entity._01_03_models.UsersInfo;


public class User extends ENT {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3959278804970979531L;

	private UsersInfo userInfo; 
	
	private UsersAccountInfo usersAccountInfo;

	public UsersInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UsersInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UsersAccountInfo getUsersAccountInfo() {
		return usersAccountInfo;
	}

	public void setUsersAccountInfo(UsersAccountInfo usersAccountInfo) {
		this.usersAccountInfo = usersAccountInfo;
	}
	
	

}
