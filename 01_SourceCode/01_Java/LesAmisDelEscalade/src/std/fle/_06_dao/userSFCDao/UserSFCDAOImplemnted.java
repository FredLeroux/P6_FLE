package std.fle._06_dao.userSFCDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.dao.DAOGenericInterface;
import std.fle._01_entity.models.users.UsersAccountInfo;
import std.fle._01_entity.models.users.UsersInfo;
import std.fle._04_associationModel.dto.UserDTO;
import std.fle._04_associationModel.model.User;
import std.fle._04_associationModel.sfc.UserSFC;
import std.fle._06_dao.usersAccountInfoDao.UsersAccountInfoDAO;
import std.fle._06_dao.usersInfoDao.UsersInfoDAO;

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
