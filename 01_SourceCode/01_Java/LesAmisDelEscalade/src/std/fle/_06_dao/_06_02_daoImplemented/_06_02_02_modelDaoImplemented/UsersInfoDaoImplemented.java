package std.fle._06_dao._06_02_daoImplemented._06_02_02_modelDaoImplemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.DAOGenericInterface;
import fle.toolBox.modelConverter.ModelConverter;
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
	DAOGenericInterface<UsersInfo, UsersInfoDTO> dao;

	@Autowired
	ClimbingLevelsService climbing;

	@Autowired
	CountiesService counties;

	@Autowired
	StatesService states;

	
	private UsersInfo userInfo = new UsersInfo();
	private UsersInfoDTO usersInfoDTO = new UsersInfoDTO();
	private StatesDTO statesDTO = null;
	private CountiesDTO countiesDTO = null;
	private ClimbingLevelsDTO climbingLevelDTO = null;

	@Override
	public UsersInfo getEntityById(Integer id) {
		return dao.getEntityByID(userInfo, id);
	}

	@Override
	public UsersInfoDTO getDTOByID(Integer id) {
		return dao.getDtoByID(userInfo, usersInfoDTO, id);
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
		return dao.converter().convertDTOToEntity(dto, userInfo);
	}

	private void conditionnalAssetsValues(UsersInfoSFC userInfoSFC, UsersInfoDTO dto) {
		if (userInfoSFC.getGenderValue().isEmpty()) {
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

}
