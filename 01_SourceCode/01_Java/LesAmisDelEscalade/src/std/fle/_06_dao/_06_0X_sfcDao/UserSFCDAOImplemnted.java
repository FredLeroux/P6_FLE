package std.fle._06_dao._06_0X_sfcDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.DAOGenericInterface;
import std.fle._01_entity._01_03_models.UsersAccountInfo;
import std.fle._01_entity._01_03_models.UsersInfo;
import std.fle._04_associationModel._04_01_model.User;
import std.fle._04_associationModel._04_02_dto.UserDTO;
import std.fle._04_associationModel._04_03_sfc.UserSFC;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersAccountInfoService;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersInfoService;

@Repository
public class UserSFCDAOImplemnted implements UserSFCDao {

	@Autowired
	DAOGenericInterface<User, UserDTO> dao;

	@Autowired
	UsersInfoService userInfoService;

	@Autowired
	UsersAccountInfoService accountInfoService;

	@Override
	public void save(UserSFC user) {
		UsersAccountInfo userAccountInfo = accountInfoService.postTransactionTreatment(user.getUsersAccountInfoSFC());
		UsersInfo userInfo = userInfoService.postTransactionTreatment(user.getUsersInfoSFC());
		userInfo.setUserAccountInfo(userAccountInfo);
		userAccountInfo.setUserInfo(userInfo);
		accountInfoService.save(userAccountInfo);
	}

}
