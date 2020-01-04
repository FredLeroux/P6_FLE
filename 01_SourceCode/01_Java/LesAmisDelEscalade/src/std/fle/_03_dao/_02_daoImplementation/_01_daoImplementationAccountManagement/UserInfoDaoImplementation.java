package std.fle._03_dao._02_daoImplementation._01_daoImplementationAccountManagement;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import std.fle._01_model._01_accountManagement.UserInfo;
import std.fle._03_dao._01_daoInterface._01_daoInterfaceAccountManagement.UserInfoDaoInterface;
import tools.crud.Crud;

@Repository
public class UserInfoDaoImplementation implements UserInfoDaoInterface {

	Crud crud = new Crud();
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createUserInfo(UserInfo userInfo) {
		crud.create(sessionFactory, userInfo);

	}

	@Override
	public String readUserInfo(UserInfo userInfo, Integer userInfoId) {
		// TODO Auto-generated method stub
		return null;
	}

}
