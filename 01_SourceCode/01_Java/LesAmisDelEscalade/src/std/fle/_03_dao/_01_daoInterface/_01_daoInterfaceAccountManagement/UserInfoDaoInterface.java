package std.fle._03_dao._01_daoInterface._01_daoInterfaceAccountManagement;

import std.fle._01_model._01_accountManagement.UserInfo;

public interface UserInfoDaoInterface {

	public void createUserInfo(UserInfo userInfo);
	
	public String readUserInfo(UserInfo userInfo, Integer userInfoId);
	
}
