package std.fle._07_service.usersAccountInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._01_entity.models.users.UsersAccountInfo;
import std.fle._02_dto.modelsDTO.usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoAccessDTO;
import std.fle._02_dto.modelsDTO.usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoAuthentificatorDTO;
import std.fle._02_dto.modelsDTO.usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoDTO;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoMemberStatusSFC;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoSFC;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoUpdateSFC;
import std.fle._06_dao.usersAccountInfoDao.UsersAccountInfoDAO;

@Service
public class UsersAccountInfoServiceImplemented implements UsersAccountInfoService {

	@Autowired
	UsersAccountInfoDAO dao;

	@Override
	public UsersAccountInfo getEntityById(Integer id) {
		return dao.getEntityById(id);
	}

	@Override
	public UsersAccountInfoDTO getDTOByID(Integer id) {
		return dao.getDTOByID(id);
	}

	@Override
	public UsersAccountInfo postTransactionTreatment(UsersAccountInfoSFC SFCClass) {
		return dao.postTransactionTreatment(SFCClass);
	}

	@Override
	public void save(UsersAccountInfo entity) {
		dao.save(entity);

	}
	
	@Override
	public UsersAccountInfoAuthentificatorDTO getAuthentificatorById(Integer id) {		
		return dao.getAuthentificatorById(id);
	}

	@Override
	public UsersAccountInfoAuthentificatorDTO getAuthentificatorDTOByLogin(String login) {
		return dao.getAuthentificatorDTOByLogin(login);
	}

	@Override
	public UsersAccountInfoSFC getSFCById(Integer id) {
		return dao.getSFCById(id);
	}

	@Override
	public UsersAccountInfoUpdateSFC getUserAccountInfoUpdateById(Integer id) {
		return dao.getUserAccountInfoUpdateById(id);
	}

	@Override
	public void updateSFC(UsersAccountInfoSFC SFCObject) {
		dao.updateSFC(SFCObject);

	}

	@Override
	public void updateEntity(UsersAccountInfo entity) {
		dao.updateEntity(entity);

	}

	@Override
	public void updateDTO(UsersAccountInfoDTO DTOClass) {
		dao.updateDTO(DTOClass);

	}

	@Override
	public void updateActivationCode(String eMail, String activationCode) {
		dao.updateActivationCode(eMail, activationCode);

	}

	@Override
	public boolean activateAccount(String activationCode) {
		return dao.activateAccount(activationCode);
	}

	@Override
	public UsersAccountInfoAccessDTO accountAcces(String login) {
		return dao.accountAcces(login);
	}

	@Override
	public void lockAccount(Integer maxTentativeAllowed, String login) {
		dao.lockAccount(maxTentativeAllowed, login);
	}

	@Override
	public void unLockAccountByLogin(String login) {
		dao.unLockAccountByLogin(login);
	}
	
	@Override
	public void unLockAccountById(Integer id) {
		dao.unLockAccountById(id);
	}
	
	

	@Override
	public boolean isAccountActivated(String eMail) {		
		return dao.isAccountActivated(eMail);
	}

	@Override
	public Integer usersAccountInfoIdByResetPassword(String resetCode) {
		return dao.usersAccountInfoIdByResetPassword(resetCode);
	}

	@Override
	public void updatePassword(Integer id, String newPassword) {
		dao.updatePassword(id, newPassword);
		
	}

	@Override
	public void addResetPassCode(String login, String resetPassCode) {
		dao.addResetPassCode(login, resetPassCode);
		
	}

	@Override
	public String getLoginByEmail(String eMail) {		
		return dao.getLoginByEmail(eMail);
	}

	@Override
	public UsersAccountInfoMemberStatusSFC getUserAccountInfoMemberStatusById(Integer id) {		
		return dao.getUserAccountInfoMemberStatusById(id);
	}

	@Override
	public void updateMemberStatus(Integer id, String memberStatusSFC) {
		dao.updateMemberStatus(id, memberStatusSFC);
		
	}



}
