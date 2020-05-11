package std.fle._06_dao._06_02_daoImplemented._06_02_02_modelDaoImplemented;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.dao.DAOGenericInterface;
import fle.toolBox.CRUD.daoList.DAOListGeneric;
import fle.toolBox.classType.SLO;
import std.fle._01_entity.models.users.UsersAccountInfo;
import std.fle._01_entity.models.users.UsersInfo;
import std.fle._02_dto.assetsClassesDTO.ClimbingLevelsDTO;
import std.fle._02_dto.assetsClassesDTO.CountiesDTO;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO.UsersInfoDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO.UsersInfoMailDTO;
import std.fle._03_sfc.usersInfoSFC.UsersInfoSFC;
import std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao.UsersInfoDAO;
import std.fle._07_service._07_01_serviceInterface._07_01_01_assetsServiceInterface.ClimbingLevelsService;
import std.fle._07_service._07_01_serviceInterface._07_01_01_assetsServiceInterface.CountiesService;
import std.fle._07_service._07_01_serviceInterface._07_01_01_assetsServiceInterface.StatesService;

@Repository
public class UsersInfoDaoImplemented implements UsersInfoDAO {

	@Autowired
	SessionFactory fact;

	@Autowired
	DAOGenericInterface<UsersInfo, UsersInfoDTO> dao;
	
	@Autowired
	DAOListGeneric daoList;

	@Autowired
	ClimbingLevelsService climbing;

	@Autowired
	CountiesService counties;

	@Autowired
	StatesService states;

	private UsersInfo usersInfo = new UsersInfo();
	private UsersInfoDTO usersInfoDTO = new UsersInfoDTO();
	private UsersInfoMailDTO usersInfoMailDTO = new UsersInfoMailDTO();
	private UsersInfoSFC usersInfoSFC = new UsersInfoSFC();
	private StatesDTO statesDTO = null;
	private CountiesDTO countiesDTO = null;
	private ClimbingLevelsDTO climbingLevelDTO = null;
	private UsersAccountInfo accountInfo = new UsersAccountInfo();
	private UsersAccountInfoDTO accountInfoDTO = new UsersAccountInfoDTO();

	@Override
	public UsersInfo getEntityById(Integer id) {
		return fact.getCurrentSession().get(UsersInfo.class, id);
	}

	@Override
	public UsersInfoDTO getDTOByID(Integer id) {
		return dao.getDtoByID(usersInfo, usersInfoDTO, id);
	}

	@Override
	public UsersInfoSFC getSFCById(Integer id) {
		UsersInfoDTO dto = dao.getDTOByForeignerKey("userAccountInfo", id, usersInfo, usersInfoDTO);
		UsersInfoSFC sfc = dao.converter().converDTOToSFC(dto, usersInfoSFC);
		setForeignKeys(dto, sfc);
		return sfc;
	}

	@Override
	public void save(UsersInfo entity) {
		dao.save(entity);

	}

	@Override
	public UsersInfo postTransactionTreatment(UsersInfoSFC userInfoSFC) {
		UsersInfoDTO dto = dao.converter().converSFCToDTO(userInfoSFC, usersInfoDTO);
		conditionnalAssetsValues(userInfoSFC, dto);
		fillAssets(dto);
		return dao.converter().convertDTOToEntity(dto, usersInfo);
	}

	private void conditionnalAssetsValues(UsersInfoSFC userInfoSFC, UsersInfoDTO dto) {
		if (userInfoSFC.getGender().isEmpty()) {
			dto.setGender(null);
		}

		if (userInfoSFC.getStateId() != null) {
			statesDTO = states.getDTOByID(userInfoSFC.getStateId());
		} else {
			statesDTO = null;
		}
		if (userInfoSFC.getCountyId() != null) {
			countiesDTO = counties.getDTOByID(userInfoSFC.getCountyId());
		} else {
			countiesDTO = null;
		}
		if (userInfoSFC.getClimbingLevelId() != null) {
			climbingLevelDTO = climbing.getDTOByID(userInfoSFC.getClimbingLevelId());
		} else {
			climbingLevelDTO = null;
		}
	}

	private void fillAssets(UsersInfoDTO dto) {
		dto.setState(statesDTO);
		dto.setCounty(countiesDTO);
		dto.setClimbingLevel(climbingLevelDTO);
	}

	private void setForeignKeys(UsersInfoDTO dto, UsersInfoSFC sfc) {
		if (dto.getState() == null) {
			sfc.setStateId(null);
		} else {
			sfc.setStateId(dto.getState().getId());
		}
		if (dto.getCounty() == null) {
			sfc.setCountyId(null);
		} else {
			sfc.setCountyId(dto.getCounty().getId());
		}
		if (dto.getClimbingLevel() == null) {
			sfc.setClimbingLevelId(null);
		} else {
			sfc.setClimbingLevelId(dto.getClimbingLevel().getId());
		}

	}

	@Override
	public void updateSFC(UsersInfoSFC SFCObject) {
		UsersInfoDTO dto = getDTOByID(SFCObject.getId());
		conditionnalAssetsValues(SFCObject, dto);
		fillAssets(dto);
		UsersInfo user = dao.converter().convertDTOToEntity(dto, usersInfo);
		dao.update(user);
	}

	@Override
	public void updateEntity(UsersInfo entity) {
		dao.update(entity);

	}

	@Override
	public void updateDTO(UsersInfoDTO DTOClass) {
		dao.updateDTO(usersInfo, DTOClass);

	}

	@Override
	@SuppressWarnings("unused")
	public boolean isEmailExist(String eMail) {
		try {

			UsersInfoMailDTO dto = dao.getSpecificDTOWhereCondition("email", eMail, usersInfo, usersInfoMailDTO);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public String getAccountEmailByLogin(String login) {
		UsersAccountInfoDTO accountinfoDto = dao.getSpecificEntitySpecificDTOWhereCondition("login", login, accountInfo,
				accountInfoDTO);
		UsersInfoMailDTO dto = dao.getSpecificDTOByForeignerKey("userAccountInfo", accountinfoDto.getId(), usersInfo,
				usersInfoMailDTO);
		return dto.getEmail();

	}

	@Override
	public<L extends SLO> List<L> getList(L joinClass, String suffix) {	
		return daoList.getInnerJoinListI18N(joinClass);
	}

}
