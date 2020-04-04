package std.fle._06_dao._06_02_daoImplemented._06_02_03_associationModelDaoImplemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.modelConverter.ModelConverter;
import std.fle._01_entity._01_03_models.UsersAccountInfo;
import std.fle._01_entity._01_03_models.UsersInfo;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoAuthentificatorDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoUpdateDTO;
import std.fle._03_sfc._03_01_usersSFC.UsersAccountInfoSFC;
import std.fle._03_sfc._03_01_usersSFC.UsersAccountInfoUpdateSFC;
import std.fle._04_associationModel._04_03_sfc.UserUpdateSFC;
import std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao.UsersAccountInfoDAO;
import std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao.UsersInfoDAO;
import std.fle._06_dao._06_01_daoInterface._06_01_03_associationModelDao.UserUpdateDAO;

@Repository
public class UserUpdateDAOImplemented implements UserUpdateDAO {
	
	private ModelConverter converter = new ModelConverter();
	
	private UsersAccountInfo usersAccountInfo = new UsersAccountInfo();
	private UsersAccountInfoDTO usersAccountInfoDTO = new UsersAccountInfoDTO();
	private UsersAccountInfoAuthentificatorDTO passwordDTO = new UsersAccountInfoAuthentificatorDTO();
	private UsersAccountInfoUpdateDTO updateDTO = new UsersAccountInfoUpdateDTO();
	private UsersAccountInfoSFC usersAccountInfoSFC = new UsersAccountInfoSFC();
	private UsersAccountInfoUpdateSFC updateSFC = new UsersAccountInfoUpdateSFC();
	
	
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
