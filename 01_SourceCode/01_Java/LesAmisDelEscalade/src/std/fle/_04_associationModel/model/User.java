package std.fle._04_associationModel.model;

import fle.toolBox.classType.ENT;
import std.fle._01_entity.models.users.UsersAccountInfo;
import std.fle._01_entity.models.users.UsersInfo;


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
