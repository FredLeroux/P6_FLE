package std.fle._06_dao.topoDao;

import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.FredParser;
import fle.toolBox.CRUD.dao.DAOGenericInterface;
import std.fle._01_entity.models.topo.ClimbingTopo;
import std.fle._01_entity.models.users.UsersInfo;
import std.fle._02_dto.modelsDTO.topoDTO.ClimbingTopoDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO.UsersInfoDTO;
import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;
import std.fle._06_dao.statesDao.StatesDAO;

@Repository
public class TopoDaoImplemented implements TopoDAO {

	@Autowired
	DAOGenericInterface<ClimbingTopo, ClimbingTopoDTO> dao;

	@Autowired
	StatesDAO statesDAO;

	private ClimbingTopo climbingTopo = new ClimbingTopo();
	private UsersInfo usersInfo = new UsersInfo();
	private ClimbingTopoDTO climbingTopoDTO = new ClimbingTopoDTO();
	private UsersInfoDTO usersInfoDTO = new UsersInfoDTO();
	private ClimbingTopoSFC climbingTopoSFC = new ClimbingTopoSFC();

	public ClimbingTopo getClimbingENTById(Integer id) {
		return dao.getEntityByID(climbingTopo, id);
	}

	public ClimbingTopoDTO getClimbingDTOById(Integer id) {
		return dao.getDtoByID(climbingTopo, climbingTopoDTO, id);
	}

	public void saveNewTopo(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId) {
		System.out.println(setClimbingTopoDTOToSave(climbingTopoSFC, loggedUserId).getTitle());
		System.out.println(setClimbingTopoDTOToSave(climbingTopoSFC, loggedUserId).getTopoDescription());
		System.out.println(setClimbingTopoDTOToSave(climbingTopoSFC, loggedUserId).getEditionYear());
		System.out.println(setClimbingTopoDTOToSave(climbingTopoSFC, loggedUserId).getAvailable());
		System.out.println(setClimbingTopoDTOToSave(climbingTopoSFC, loggedUserId).getState().getStateName());
		System.out.println(setClimbingTopoDTOToSave(climbingTopoSFC, loggedUserId).getUserInfo().getEmail());
		ClimbingTopoDTO dto = setClimbingTopoDTOToSave(climbingTopoSFC, loggedUserId);
		System.out.println(dto.getTitle());
		System.out.println(dto.getTopoDescription());
		System.out.println(dto.getEditionYear());
		System.out.println(dto.getAvailable());
		System.out.println(dto.getState().getStateName());
		System.out.println(dto.getUserInfo().getEmail());
		ClimbingTopo entity = dao.converter().convertDTOToEntity(dto, climbingTopo);
		dao.update(entity);
	}

	private void setClimbingTopoUserInfo(ClimbingTopoDTO climbingTopoDTO, Integer loggedUserId) {
		climbingTopoDTO.setUserInfo(getUserInfoByUsersAccountInfoId(FredParser.asString(loggedUserId)));
	}

	private UsersInfoDTO getUserInfoByUsersAccountInfoId(String loggedUserId) {
		return dao.getSpecificEntitySpecificDTOWhereCondition("userAccountInfo", loggedUserId, usersInfo, usersInfoDTO);
	}

	private void setClimbingTopoState(ClimbingTopoDTO climbingTopoDTO, Integer stateId) {
		climbingTopoDTO.setState(statesDAO.getDTOByID(stateId));
	}

	private ClimbingTopoDTO setClimbingTopoDTOToSave(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId) {
		ClimbingTopoDTO dto = dao.converter().converSFCToDTO(climbingTopoSFC, climbingTopoDTO);
		setClimbingTopoState(dto, climbingTopoSFC.getState());
		setClimbingTopoUserInfo(dto, loggedUserId);	
		dto.setEditionYear(parseYearToString(climbingTopoSFC.getEditionYear()));
		return dto;
	}
	
	private String parseYearToString(Year year) {
		return FredParser.asString(year);
	}
	

}
