package std.fle._07_service.usersAccountInfoService;

import std.fle._01_entity.models.users.UsersAccountInfo;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoAccessDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoAuthentificatorDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoDTO;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoMemberStatusSFC;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoSFC;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoUpdateSFC;
import std.fle._06_dao.CRUDInterface.ModelsCRUD;

public interface UsersAccountInfoService
		extends ModelsCRUD<UsersAccountInfo, UsersAccountInfoDTO, UsersAccountInfoSFC> {

	public UsersAccountInfoUpdateSFC getUserAccountInfoUpdateById(Integer id);

	public UsersAccountInfoAuthentificatorDTO getAuthentificatorById(Integer id);

	public UsersAccountInfoAuthentificatorDTO getAuthentificatorDTOByLogin(String login);

	/**
	 * 
	 * @param eMail
	 * @param activationCode Allow to retrieve only UserAccountInfo Object from
	 *                       UsersInfo using email via converter to DTO
	 *                       UserInfoAccountFKDTO, retrive the userAccountInfoDTO
	 *                       object via is id, and save/update the activation code.
	 */
	public void updateActivationCode(String eMail, String activationCode);

	public boolean activateAccount(String activationCode);

	public UsersAccountInfoAccessDTO accountAcces(String login);

	/**
	 * 
	 * @param maxTentativeAllowed
	 * @param login               set Object UsersAccountInfo.loginTentativeNumber
	 *                            (via login) to max allowed and so allow to lock
	 *                            account
	 * 
	 */
	public void lockAccount(Integer maxTentativeAllowed, String login);

	public void unLockAccountByLogin(String login);

	public void unLockAccountById(Integer id);

	public boolean isAccountActivated(String eMail);

	public void addResetPassCode(String login, String resetPassCode);

	public Integer usersAccountInfoIdByResetPassword(String resetCode);

	public void updatePassword(Integer id, String newPassword);

	public String getLoginByEmail(String eMail);

	public UsersAccountInfoMemberStatusSFC getUserAccountInfoMemberStatusById(Integer id);

	public void updateMemberStatus(Integer id, UsersAccountInfoMemberStatusSFC memberStatusSFC);
	
	public void deleteAccount(Integer id);

}
