package std.fle._06_dao.usersAccountInfoDao;


import std.fle._01_entity.models.users.UsersAccountInfo;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoAccessDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoAuthentificatorDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoDTO;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoMemberStatusSFC;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoSFC;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoUpdateSFC;
import std.fle._0x_CRUDInterface.ModelsCRUD;

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
	
	public UsersAccountInfoMemberStatusSFC getUserAccountInfoMemberStatusById(Integer id);
	
	public void updateMemberStatus(Integer id, UsersAccountInfoMemberStatusSFC memberStatusSFC);
	
	
	
	
}
