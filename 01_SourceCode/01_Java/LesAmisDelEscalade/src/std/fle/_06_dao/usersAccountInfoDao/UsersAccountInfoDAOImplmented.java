package std.fle._06_dao.usersAccountInfoDao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.FredParser;
import fle.toolBox.CRUD.dao.DAOGenericInterface;
import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.fieldTranslator.FieldsTranslator;
import fle.toolBox.localeKeyToBoolean.StringToBoolean;
import std.fle._01_entity.models.users.UsersAccountInfo;
import std.fle._01_entity.models.users.UsersInfo;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoAccessDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoAuthentificatorDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoUpdateDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountinfoMemberStatusDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO.UsersInfoUsersAccountInfoDTO;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoMemberStatusSFC;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoSFC;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoUpdateSFC;
import std.fle._0X_security.SecurityLevel;

@Repository
public class UsersAccountInfoDAOImplmented implements UsersAccountInfoDAO {

	@Autowired
	DAOGenericInterface<UsersAccountInfo, UsersAccountInfoDTO> dao;

	@Autowired
	LocalMessage locale;

	@Autowired
	FieldsTranslator fieldsTranslator;

	@Autowired
	StringToBoolean localKeyToBoolean;

	private UsersAccountInfo usersAccountInfo = new UsersAccountInfo();
	private UsersAccountInfoDTO usersAccountInfoDTO = new UsersAccountInfoDTO();
	private UsersAccountInfoAuthentificatorDTO passwordDTO = new UsersAccountInfoAuthentificatorDTO();
	private UsersAccountInfoUpdateDTO updateDTO = new UsersAccountInfoUpdateDTO();
	private UsersInfoUsersAccountInfoDTO usersAccountInfoDTOViaUsersInfo = new UsersInfoUsersAccountInfoDTO();
	private UsersAccountInfoAccessDTO accountAccess = new UsersAccountInfoAccessDTO();
	private UsersAccountinfoMemberStatusDTO usersAccountinfoMemberStatusDTO = new UsersAccountinfoMemberStatusDTO();
	private UsersAccountInfoSFC usersAccountInfoSFC = new UsersAccountInfoSFC();
	private UsersAccountInfoUpdateSFC updateSFC = new UsersAccountInfoUpdateSFC();
	private UsersAccountInfoMemberStatusSFC usersAccountInfoMemberStatusSFC = new UsersAccountInfoMemberStatusSFC();
	private UsersInfo usersInfo = new UsersInfo();

	@Override
	public UsersAccountInfo getEntityById(Integer id) {
		return dao.getEntityById(usersAccountInfo, id);
	}

	@Override
	public UsersAccountInfoDTO getDTOByID(Integer id) {
		return dao.getDtoByID(usersAccountInfo, usersAccountInfoDTO, id);
	}

	@Override
	public UsersAccountInfo postTransactionTreatment(UsersAccountInfoSFC SFCClass) {
		UsersAccountInfoDTO dto = dao.converter().convertSFCToDTO(SFCClass, usersAccountInfoDTO);
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
		UsersAccountInfoUpdateSFC sfc = dao.converter().convertDTOToSFC(dto, updateSFC);
		sfc.setAccountMemberStatus(dto.getMember().toString());
		fieldsTranslator.translateFieldValue(sfc);
		return sfc;
	}

	@Override
	public UsersAccountInfoMemberStatusSFC getUserAccountInfoMemberStatusById(Integer id) {
		UsersAccountinfoMemberStatusDTO dto = dao.getSpecificDTOById(usersAccountInfo, usersAccountinfoMemberStatusDTO,
				id);
		UsersAccountInfoMemberStatusSFC sfc = dao.converter().convertDTOToSFC(dto, usersAccountInfoMemberStatusSFC);
		fieldsTranslator.translateFieldValue(sfc);
		return sfc;
	}

	@Override
	public void updateMemberStatus(Integer id, UsersAccountInfoMemberStatusSFC memberStatusSFC) {
		UsersAccountInfoDTO dto = getDTOByID(id);
		//dto.setMember(memberStatusSFCToDTO(memberStatusSFC));
		//setSecurityLevelFunctionOfMemberStatus(dto);
		if(FredParser.toInteger(memberStatusSFC.getSecurity())>1) {
			dto.setMember(false);
		}else {
			dto.setMember(true);
		}
		dto.setSecurityLevel(FredParser.toInteger(memberStatusSFC.getSecurity()));
		
		
		dao.updateDTO(usersAccountInfo, dto);
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
		UsersAccountInfoSFC sfc = dao.converter().convertDTOToSFC(dto, usersAccountInfoSFC);
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

	// TODO find another way to avoid retranscript field find use redirect in
	// controller instead of page url
	@Override
	public UsersAccountInfo converteUpdateSFCToEntity(UsersAccountInfoUpdateSFC updatedSFC) {
		UsersAccountInfoUpdateDTO dto = dao.converter()
				.convertSFCToDTO(converteSFCMembersStatusValueToBooleanValue(updatedSFC), updateDTO);
		return dao.converter().convertDTOToEntity(dto, usersAccountInfo);
	}

//TODO think about annotation to manage this
	private UsersAccountInfoUpdateSFC converteSFCMembersStatusValueToBooleanValue(
			UsersAccountInfoUpdateSFC updatedSFC) {
		UsersAccountInfoUpdateSFC sfc = updatedSFC;
		sfc.setAccountMemberStatus(memberStatusSFCToDTO(updatedSFC.getAccountMemberStatus()).toString());
		return sfc;
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
		if (dto.getAccountActivationStatus()) {
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
		if (dto.getPasswordResetCode() == null) {
			return null;
		} else {
			dto.setPasswordResetCode(null);
			dao.updateDTO(usersAccountInfo, dto);
			return dto.getId();
		}
	}

	@Override
	public void updatePassword(Integer id, String newPassword) {
		UsersAccountInfoDTO dto = dao.getDtoByID(usersAccountInfo, usersAccountInfoDTO, id);
		dto.setPassword(newPassword);
		dao.updateDTO(usersAccountInfo, dto);
	}

	@Override
	public void addResetPassCode(String eMail, String resetPassCode) {
		UsersAccountInfoDTO dto = accountInfoDTOByEMail(eMail);
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

	private UsersInfoUsersAccountInfoDTO usersAccountInfoDTOByEmail(String eMail) {
		return dao.getSpecificEntitySpecificDTOWhereCondition("email", eMail, usersInfo,
				usersAccountInfoDTOViaUsersInfo);
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

	private void unlockAccount(UsersAccountInfoDTO dto) {
		dto.setLoginTentativeNumber(0);
		dao.updateDTO(usersAccountInfo, dto);
	}
	
	/**
	 * 
	 * @return SFC memberStatus String to DTO Boolean memberStatus
	 */
	private Boolean memberStatusSFCToDTO(String toConvert) {
		return localKeyToBoolean.localKey(toConvert, "true.isMember", "false.isMember");
	}
	
	@Override
	public void deleteAccount(Integer id) {
		dao.removeByID(usersAccountInfo, id);
	}
	
	
}
