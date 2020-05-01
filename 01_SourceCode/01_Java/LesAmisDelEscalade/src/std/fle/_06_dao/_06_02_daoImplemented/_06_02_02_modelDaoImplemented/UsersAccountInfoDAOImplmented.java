package std.fle._06_dao._06_02_daoImplemented._06_02_02_modelDaoImplemented;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.dao.DAOGenericInterface;
import fle.toolBox.Internationalization.LocalMessage;
import std.fle._01_entity._01_02_assetsEnum.SecurityLevel;
import std.fle._01_entity._01_03_models.UsersAccountInfo;
import std.fle._01_entity._01_03_models.UsersInfo;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoAccessDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoAuthentificatorDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoUpdateDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO._02_02_01_02_usersInfoDTO.UsersInfoUsersAccountInfoDTO;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoSFC;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoUpdateSFC;
import std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao.UsersAccountInfoDAO;

@Repository
public class UsersAccountInfoDAOImplmented implements UsersAccountInfoDAO {

	@Autowired
	DAOGenericInterface<UsersAccountInfo, UsersAccountInfoDTO> dao;

	@Autowired
	LocalMessage locale;

	private UsersAccountInfo usersAccountInfo = new UsersAccountInfo();
	private UsersAccountInfoDTO usersAccountInfoDTO = new UsersAccountInfoDTO();
	private UsersAccountInfoAuthentificatorDTO passwordDTO = new UsersAccountInfoAuthentificatorDTO();
	private UsersAccountInfoUpdateDTO updateDTO = new UsersAccountInfoUpdateDTO();
	private UsersInfoUsersAccountInfoDTO usersAccountInfoDTOViaUsersInfo = new UsersInfoUsersAccountInfoDTO();
	private UsersAccountInfoAccessDTO accountAccess = new UsersAccountInfoAccessDTO();
	private UsersAccountInfoSFC usersAccountInfoSFC = new UsersAccountInfoSFC();
	private UsersAccountInfoUpdateSFC updateSFC = new UsersAccountInfoUpdateSFC();
	private UsersInfo usersInfo = new UsersInfo();

	@Override
	public UsersAccountInfo getEntityById(Integer id) {
		return dao.getEntityByID(usersAccountInfo, id);
	}

	@Override
	public UsersAccountInfoDTO getDTOByID(Integer id) {
		return dao.getDtoByID(usersAccountInfo, usersAccountInfoDTO, id);
	}

	@Override
	public UsersAccountInfo postTransactionTreatment(UsersAccountInfoSFC SFCClass) {
		UsersAccountInfoDTO dto = dao.converter().converSFCToDTO(SFCClass, usersAccountInfoDTO);
		setAccountDefaultValue(dto);		
		return dao.converter().convertDTOToEntity(dto, usersAccountInfo);
	}

	@Override
	public void save(UsersAccountInfo entity) {
		dao.save(entity);

	}

	@Override
	public UsersAccountInfoUpdateSFC getUserAccountInfoUpdateById(Integer id) {
		UsersAccountInfoUpdateDTO dto = dao.getSpecificDTOById(usersAccountInfo, updateDTO, id);
		UsersAccountInfoUpdateSFC sfc = dao.converter().converDTOToSFC(dto, updateSFC);
		parseIsMemberToString(dto, sfc);
		return sfc;
	}
	
	@Override
	public UsersAccountInfoAuthentificatorDTO getAuthentificatorById(Integer id) {
		return dao.getSpecificDTOById(usersAccountInfo, passwordDTO, id);
	}

	@Override
	public UsersAccountInfoAuthentificatorDTO getAuthentificatorDTOByLogin(String login) {
		return dao.getSpecificDTOWhereCondition("login", login, usersAccountInfo, passwordDTO);
	}

	@Override
	public UsersAccountInfoSFC getSFCById(Integer id) {
		UsersAccountInfoDTO dto = getDTOByID(id);
		UsersAccountInfoSFC sfc = dao.converter().converDTOToSFC(dto, usersAccountInfoSFC);
		return sfc;
	}

	@Override
	public void updateSFC(UsersAccountInfoSFC SFCObject) {
		dao.updateSFC(usersAccountInfo, usersAccountInfoDTO, SFCObject);

	}

	@Override
	public void updateEntity(UsersAccountInfo entity) {
		dao.update(entity);

	}

	@Override
	public void updateDTO(UsersAccountInfoDTO DTOClass) {
		dao.updateDTO(usersAccountInfo, DTOClass);

	}

	@Override
	public UsersAccountInfo converteUpdateSFCToEntity(UsersAccountInfoUpdateSFC updatedSFC) {
		UsersAccountInfoUpdateDTO dto = dao.converter().converSFCToDTO(updatedSFC, updateDTO);
		parseIsMemberToBoolean(dto, updatedSFC);
		return dao.converter().convertDTOToEntity(dto, usersAccountInfo);
	}

	@Override
	public boolean activateAccount(String activationCode) {
		UsersAccountInfoDTO dto = null;
		try {
			dto = dao.getSpecificDTOWhereCondition("activationCode", activationCode, usersAccountInfo,
					usersAccountInfoDTO);
		} catch (Exception e) {
			return false;
		}
		if (dto.isAccountActivationStatus()) {
			return false;
		} else {
			dto.setAccountActivationStatus(true);
			dao.updateDTO(usersAccountInfo, dto);
			return true;
		}
	}

	@Override
	public UsersAccountInfoAccessDTO accountAcces(String login) {
		return dao.getSpecificDTOWhereCondition("login", login, usersAccountInfo, accountAccess);
	}

	@Override
	public boolean isAccountActivated(String eMail) {
		return accountAccessByEmail(eMail).getAccountActivationStatus();

	}

	@Override
	public void lockAccount(Integer maxTentativeAllowed, String login) {
		UsersAccountInfoDTO dto = accountInfoDTOByLogin(login);
		dto.setLoginTentativeNumber(maxTentativeAllowed);		
		dao.updateDTO(usersAccountInfo, dto);
	}

	@Override
	public void unLockAccountByLogin(String login) {
		UsersAccountInfoDTO dto = accountInfoDTOByLogin(login);
		unlockAccount(dto);
	}
	
	@Override
	public void unLockAccountById(Integer id) {
		UsersAccountInfoDTO dto = getDTOByID(id);
		unlockAccount(dto);
		
	}

	@Override
	public void updateActivationCode(String eMail, String activationCode) {
		UsersAccountInfoDTO dto1 = accountInfoDTOByEMail(eMail);
		dto1.setActivationCode(activationCode);
		dao.updateDTO(usersAccountInfo, dto1);
	}
	
	@Override
	public Integer usersAccountInfoIdByResetPassword(String resetCode) {
		UsersAccountInfoDTO dto = null;
		try {
			dto = accountInfoDTOByResetCode(resetCode);
		} catch (Exception e) {
			return null;
		}
		if(dto.getPasswordResetCode()==null) {
			return null;
		}else {
			dto.setPasswordResetCode(null);
			dao.updateDTO(usersAccountInfo, dto);
			return dto.getId(); 
		}
	}
	@Override
	public void updatePassword(Integer id,String newPassword) {
		UsersAccountInfoDTO dto = dao.getDtoByID(usersAccountInfo, usersAccountInfoDTO, id);		
		dto.setPassword(newPassword);
		dao.updateDTO(usersAccountInfo, dto);
	}
	
	@Override
	public void addResetPassCode(String eMail,String resetPassCode) {
		UsersAccountInfoDTO dto =accountInfoDTOByEMail(eMail);
		dto.setPasswordResetCode(resetPassCode);
		dao.updateDTO(usersAccountInfo, dto);
	}
	
	@Override
	public String getLoginByEmail(String eMail) {
		return usersAccountInfoDTOByEmail(eMail).getUserAccountInfo().getLogin();
	}

	private void setAccountDefaultValue(UsersAccountInfoDTO dto) {
		dto.setMember(false);
		dto.setLoginTentativeNumber(0);
		dto.setSecurityLevel(SecurityLevel.USER.rank());
		dto.setAccountActivationStatus(false);
		dto.setSignUpDate(new Date());
	}

	

	private void parseIsMemberToString(UsersAccountInfoUpdateDTO dto, UsersAccountInfoUpdateSFC sfc) {
		if (dto.isMember().equals("true")) {
			sfc.setAssociationMember(locale.message("memberTrue.name"));
		}
		if (dto.isMember().equals("false")) {
			sfc.setAssociationMember(locale.message("memberFalse.name"));
		}
	}

	private UsersInfoUsersAccountInfoDTO usersAccountInfoDTOByEmail(String eMail) {
		return dao.getSpecificEntitySpecificDTOWhereCondition("email", eMail, usersInfo, usersAccountInfoDTOViaUsersInfo);
	}

	private UsersAccountInfoDTO accountInfoDTOByLogin(String login) {
		return dao.getSpecificDTOWhereCondition("login", login, usersAccountInfo, usersAccountInfoDTO);
	}
	
	private UsersAccountInfoDTO accountInfoDTOByEMail(String eMail) {
		return usersAccountInfoDTOByEmail(eMail).getUserAccountInfo();
	}
	
	
	private UsersAccountInfoDTO accountInfoDTOByResetCode(String resetCode) {
		return dao.getDTOWhereCondition("passwordResetCode", resetCode, usersAccountInfo, usersAccountInfoDTO);
	}
	
	

	private UsersAccountInfoAccessDTO accountAccessByEmail(String eMail) {
		return dao.getSpecificDTOById(usersAccountInfo, accountAccess,
				usersAccountInfoDTOByEmail(eMail).getUserAccountInfo().getId());
	}

	private void parseIsMemberToBoolean(UsersAccountInfoUpdateDTO dto, UsersAccountInfoUpdateSFC sfc) {
		if (sfc.getAssociationMember().equals(locale.message("memberTrue.name"))) {
			dto.setMember("true");
		}
		if (sfc.getAssociationMember().equals(locale.message("memberFalse.name"))) {
			dto.setMember("false");
		}
	}
	
	private void unlockAccount(UsersAccountInfoDTO dto) {
		dto.setLoginTentativeNumber(0);
		dao.updateDTO(usersAccountInfo, dto);
	}

}
