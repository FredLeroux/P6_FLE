package std.fle._06_dao._06_02_daoImplemented._06_02_02_modelDaoImplemented;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.FredParser;
import fle.toolBox.CRUD.DAOGenericInterface;
import fle.toolBox.classType.DTO;
import fle.toolBox.security.bcrypt.PassWord;
import std.fle._01_entity._01_03_models.UsersAccountInfo;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoAuthentificatorDTO;
import std.fle._03_sfc._03_01_usersSFC.UsersAccountInfoSFC;
import std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao.UsersAccountInfoDAO;
import std.fle._0X_security.SecurityLevel;

@Repository
public class UsersAccountInfoDAOImplmented implements UsersAccountInfoDAO {

	@Autowired
	DAOGenericInterface<UsersAccountInfo, UsersAccountInfoDTO> dao;

	private UsersAccountInfo usersAccountInfo = new UsersAccountInfo();
	private UsersAccountInfoDTO usersAccountInfoDTO = new UsersAccountInfoDTO();
	private UsersAccountInfoAuthentificatorDTO passwordDTO = new UsersAccountInfoAuthentificatorDTO();

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

	private void setAccountDefaultValue(UsersAccountInfoDTO dto) {
		dto.setMember(false);
		dto.setLoginTentativeNumber(0);
		dto.setSecurityLevel(SecurityLevel.VISITOR.rank());
		dto.setAccountActivationStatus(false);
		dto.setSignUpDate(new Date());
	}

	private void encodePassWord(UsersAccountInfoSFC SFCClass, UsersAccountInfoDTO dto) {
		PassWord encoder = new PassWord();
		dto.setPassword(encoder.encode(SFCClass.getPassword()));
	}

	
	@Override
	public<DA extends DTO> DA getPassPseudoAndLevel(String login) {		
		return dao.getSpecificsValue("login", login, usersAccountInfo, passwordDTO);
	}

	

}
