package std.fle._06_dao._06_02_daoImplemented._06_02_02_modelDaoImplemented;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.DAOGenericInterface;
import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.security.bcrypt.PassWord;
import std.fle._01_entity._01_03_models.UsersAccountInfo;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoAuthentificatorDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoUpdateDTO;
import std.fle._03_sfc._03_01_usersSFC.UsersAccountInfoSFC;
import std.fle._03_sfc._03_01_usersSFC.UsersAccountInfoUpdateSFC;
import std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao.UsersAccountInfoDAO;
import std.fle._0X_security.SecurityLevel;

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
	private UsersAccountInfoSFC usersAccountInfoSFC = new UsersAccountInfoSFC();
	private UsersAccountInfoUpdateSFC updateSFC = new UsersAccountInfoUpdateSFC();

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
		encodePassWord(SFCClass, dto);
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
	public UsersAccountInfoAuthentificatorDTO getAuthentificatorDTO(String login) {
		return dao.getSpecificDTOWhereCondition("login", login, usersAccountInfo, passwordDTO);
	}

	@Override
	public UsersAccountInfoSFC getSFCById(Integer id) {
		UsersAccountInfoDTO dto = getDTOByID(id);
		UsersAccountInfoSFC sfc = dao.converter().converDTOToSFC(dto, usersAccountInfoSFC);
		return sfc;
	}

	private void setAccountDefaultValue(UsersAccountInfoDTO dto) {
		dto.setMember(false);
		dto.setLoginTentativeNumber(0);
		dto.setSecurityLevel(SecurityLevel.USER.rank());
		dto.setAccountActivationStatus(false);
		dto.setSignUpDate(new Date());
	}

	private void encodePassWord(UsersAccountInfoSFC SFCClass, UsersAccountInfoDTO dto) {
		PassWord encoder = new PassWord();
		dto.setPassword(encoder.encode(SFCClass.getPassword()));
	}

	private void parseIsMemberToString(UsersAccountInfoUpdateDTO dto, UsersAccountInfoUpdateSFC sfc) {
		if (dto.isMember().equals("true")) {
			sfc.setAssociationMember(locale.message("memberTrue.name"));
		} 
		if (dto.isMember().equals("false")){
			sfc.setAssociationMember(locale.message("memberFalse.name"));
		}
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

	private void parseIsMemberToBoolean(UsersAccountInfoUpdateDTO dto, UsersAccountInfoUpdateSFC sfc) {
		if (sfc.getAssociationMember().equals(locale.message("memberTrue.name"))) {
			dto.setMember("true");
		}
		if (sfc.getAssociationMember().equals(locale.message("memberFalse.name"))) {
			dto.setMember("false");
		}
	}

}
