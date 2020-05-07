package std.fle._06_dao.topoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.FredParser;
import fle.toolBox.CRUD.dao.DAOGenericInterface;
import std.fle._01_entity.models.topo.ClimbingTopo;
import std.fle._01_entity.models.users.UsersInfo;
import std.fle._02_dto.modelsDTO.topoDTO.ClimbingTopoDTO;
import std.fle._02_dto.modelsDTO.usersDTO._02_02_01_02_usersInfoDTO.UsersInfoDTO;
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
	
	
	public ClimbingTopo getClimbingENTById(Integer id){
		return dao.getEntityByID(climbingTopo, id);
	}
	
	public ClimbingTopoDTO getClimbingDTOById(Integer id) {
		return dao.getDtoByID(climbingTopo, climbingTopoDTO, id);
	}
	
	public void saveNewTopo(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId) {
		ClimbingTopoDTO dto = dao.converter().converSFCToDTO(climbingTopoSFC, climbingTopoDTO);
		setClimbingTopoState(dto,1 );//climbingTopoSFC.getState();
		setClimbingTopoUserInfo(dto, loggedUserId);
		System.out.println(dto.getState().getStateName());
		System.out.println(dto.getUserInfo().getEmail());
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
	
	
	
	
}
