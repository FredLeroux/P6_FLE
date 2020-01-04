package std.fle._04_service._01_serviceInterface._01_serviceInterfaceAccountManagement;

import std.fle._01_model._01_accountManagement.UserInfo;

public interface UserInfoServiceInterface {
	
	public void createUserInfo(UserInfo userInfo);
	
	public String readUserInfo(UserInfo userInfo, Integer userInfoId);
}
