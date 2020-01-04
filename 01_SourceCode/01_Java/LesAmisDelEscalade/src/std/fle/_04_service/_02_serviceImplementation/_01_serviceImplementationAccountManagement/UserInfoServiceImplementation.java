package std.fle._04_service._02_serviceImplementation._01_serviceImplementationAccountManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import std.fle._01_model._01_accountManagement.UserInfo;
import std.fle._03_dao._01_daoInterface._01_daoInterfaceAccountManagement.UserInfoDaoInterface;
import std.fle._04_service._01_serviceInterface._01_serviceInterfaceAccountManagement.UserInfoServiceInterface;

@Service
@Transactional
public class UserInfoServiceImplementation implements UserInfoServiceInterface {

	@Autowired
	private UserInfoDaoInterface userInfoDao;
	
	
	@Override
	@Transactional
	public void createUserInfo(UserInfo userInfo) {
		userInfoDao.createUserInfo(userInfo);

	}

	@Override
	public String readUserInfo(UserInfo userInfo, Integer userInfoId) {
		// TODO Auto-generated method stub
		return null;
	}

}
