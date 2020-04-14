package std.fle._06_dao._06_0X_sfcDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.DAOGenericInterface;
import std.fle._01_entity._01_03_models.UsersAccountInfo;
import std.fle._01_entity._01_03_models.UsersInfo;
import std.fle._04_associationModel._04_01_model.User;
import std.fle._04_associationModel._04_02_dto.UserDTO;
import std.fle._04_associationModel._04_03_sfc.UserSFC;
import std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao.UsersAccountInfoDAO;
import std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao.UsersInfoDAO;

@Repository
public class UserSFCDAOImplemnted implements UserSFCDao {

	@Autowired
	DAOGenericInterface<User, UserDTO> dao;

	@Autowired
	UsersInfoDAO userInfoDAO;

	@Autowired
	UsersAccountInfoDAO accountInfoDAO;

	@Override
	public void save(UserSFC user) {
		UsersAccountInfo userAccountInfo = accountInfoDAO.postTransactionTreatment(user.getUsersAccountInfoSFC());
		UsersInfo userInfo = userInfoDAO.postTransactionTreatment(user.getUsersInfoSFC());
		userInfo.setUserAccountInfo(userAccountInfo);
		userAccountInfo.setUserInfo(userInfo);
		accountInfoDAO.save(userAccountInfo);
	}

	@Override
	public UserSFC getById(Integer id) {
		UserSFC sfc = new UserSFC();
		sfc.setUsersInfoSFC(userInfoDAO.getSFCById(id));
		sfc.setUsersAccountInfoSFC(accountInfoDAO.getSFCById(id));
		return sfc;
	}

	

}
