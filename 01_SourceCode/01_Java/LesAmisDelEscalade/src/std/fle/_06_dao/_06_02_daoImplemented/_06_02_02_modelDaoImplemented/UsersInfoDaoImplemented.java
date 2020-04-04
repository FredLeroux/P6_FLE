package std.fle._06_dao._06_02_daoImplemented._06_02_02_modelDaoImplemented;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.DAOGenericInterface;
import std.fle._01_entity._01_03_models.UsersInfo;
import std.fle._02_dto._02_01_assetsClassesDTO.ClimbingLevelsDTO;
import std.fle._02_dto._02_01_assetsClassesDTO.CountiesDTO;
import std.fle._02_dto._02_01_assetsClassesDTO.StatesDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersInfoDTO;
import std.fle._03_sfc._03_01_usersSFC.UsersInfoSFC;
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
	ClimbingLevelsService climbing;

	@Autowired
	CountiesService counties;

	@Autowired
	StatesService states;

	private UsersInfo usersInfo = new UsersInfo();
	private UsersInfoDTO usersInfoDTO = new UsersInfoDTO();
	private UsersInfoSFC usersInfoSFC = new UsersInfoSFC();
	private StatesDTO statesDTO = null;
	private CountiesDTO countiesDTO = null;
	private ClimbingLevelsDTO climbingLevelDTO = null;

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
		}
		if (userInfoSFC.getCountyId() != null) {
			countiesDTO = counties.getDTOByID(userInfoSFC.getCountyId());
		}
		if (userInfoSFC.getClimbingLevelId() != null) {
			climbingLevelDTO = climbing.getDTOByID(userInfoSFC.getClimbingLevelId());
		}
	}

	private void fillAssets(UsersInfoDTO dto) {
		dto.setState(statesDTO);
		dto.setCounty(countiesDTO);
		dto.setClimbingLevel(climbingLevelDTO);
	}

	private void setForeignKeys(UsersInfoDTO dto, UsersInfoSFC sfc) {		
		if (dto.getState()==null) {
			sfc.setStateId(null);
		} else {
			sfc.setStateId(dto.getState().getId());
		}
		if (dto.getCounty() == null) {
			sfc.setCountyId(null);
		} else {
			sfc.setCountyId(dto.getCounty().getId());
		}
		if (dto.getClimbingLevel()==null) {
			sfc.setClimbingLevelId(null);
		} else {
			sfc.setClimbingLevelId(dto.getClimbingLevel().getId());
		}

	}

	@Override
	public void updateSFC(UsersInfoSFC SFCObject) {
		UsersInfoDTO dto= getDTOByID(SFCObject.getId());
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

	

}
