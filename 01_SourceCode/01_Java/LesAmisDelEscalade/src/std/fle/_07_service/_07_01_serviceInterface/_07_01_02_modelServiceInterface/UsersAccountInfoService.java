package std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface;

import std.fle._01_entity._01_03_models.UsersAccountInfo;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoAccessDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoAuthentificatorDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoDTO;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoSFC;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoUpdateSFC;
import std.fle._05_CRUDInterface.ModelsCRUD;

public interface UsersAccountInfoService
		extends ModelsCRUD<UsersAccountInfo, UsersAccountInfoDTO, UsersAccountInfoSFC> {

	public UsersAccountInfoUpdateSFC getUserAccountInfoUpdateById(Integer id);

	public UsersAccountInfoAuthentificatorDTO getAuthentificatorDTO(String login);

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

	public void addResetPassCode(String login,String resetPassCode);
	
	public Integer usersAccountInfoIdByResetPassword(String resetCode);

	public void updatePassword(Integer id, String newPassword);

}
