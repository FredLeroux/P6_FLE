package std.fle._06_dao._06_02_daoImplemented._06_02_03_associationModelDaoImplemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import std.fle._01_entity.models.users.UsersAccountInfo;
import std.fle._01_entity.models.users.UsersInfo;
import std.fle._04_associationModel._04_03_sfc.UserUpdateSFC;
import std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao.UsersInfoDAO;
import std.fle._06_dao._06_01_daoInterface._06_01_03_associationModelDao.UserUpdateDAO;
import std.fle._06_dao.usersAccountInfoDao.UsersAccountInfoDAO;

@Repository
public class UserUpdateDAOImplemented implements UserUpdateDAO {

	
	
	@Autowired
	UsersInfoDAO userInfoDAO;
	
	@Autowired
	UsersAccountInfoDAO accountInfoDAO;
	

	@Override
	public UserUpdateSFC getById(Integer id) {
		UserUpdateSFC sfc = new UserUpdateSFC();
		sfc.setUsersInfoSFC(userInfoDAO.getSFCById(id));
		sfc.setUsersAccountInfoUpdateSFC(accountInfoDAO.getUserAccountInfoUpdateById(id));
		return sfc;
	}
	
	@Override
	public void update(UserUpdateSFC userUpdated) {			
		UsersAccountInfo userAccountInfo = accountInfoDAO.converteUpdateSFCToEntity(userUpdated.getUsersAccountInfoUpdateSFC());
		UsersInfo userInfo = userInfoDAO.postTransactionTreatment(userUpdated.getUsersInfoSFC());
		userInfo.setUserAccountInfo(userAccountInfo);		
		userInfoDAO.updateEntity(userInfo);
		
	}

}
