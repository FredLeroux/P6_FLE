package std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao;


import std.fle._01_entity._01_03_models.UsersAccountInfo;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoAccessDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoAuthentificatorDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoDTO;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoSFC;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoUpdateSFC;
import std.fle._05_CRUDInterface.ModelsCRUD;

public interface UsersAccountInfoDAO extends ModelsCRUD<UsersAccountInfo, UsersAccountInfoDTO, UsersAccountInfoSFC> {

	
	public UsersAccountInfoUpdateSFC getUserAccountInfoUpdateById(Integer id);
	
	public UsersAccountInfoAuthentificatorDTO getAuthentificatorById(Integer id);
	
	public UsersAccountInfoAuthentificatorDTO getAuthentificatorDTOByLogin(String login);
	
	public UsersAccountInfo converteUpdateSFCToEntity(UsersAccountInfoUpdateSFC updatedSFC);
	
	public void updateActivationCode(String eMail, String activationCode);
	
	public boolean activateAccount(String activationCode);
	
	public UsersAccountInfoAccessDTO accountAcces(String login);
	
	public void lockAccount(Integer maxTentativeAllowed, String login);
	
	public void unLockAccountByLogin(String login);
	
	public void unLockAccountById(Integer id);
	
	public boolean isAccountActivated(String eMail);
	
	public void addResetPassCode(String login,String resetPassCode);
	
	public Integer usersAccountInfoIdByResetPassword(String resetCode);
	
	public void updatePassword(Integer id,String newPassword);
	
	public String getLoginByEmail(String eMail);
	
	
	
	
}
