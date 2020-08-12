package std.fle._06_dao.topoDao;

import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.FredParser;
import fle.toolBox.CRUD.dao.DAOGenericInterface;
import std.fle._01_entity.models.topo.ClimbingTopo;
import std.fle._01_entity.models.users.UsersInfo;
import std.fle._02_dto.modelsDTO.topoDTO.ClimbingTopoDTO;
import std.fle._02_dto.modelsDTO.topoDTO.ClimbingTopoDisplayDTO;
import std.fle._02_dto.modelsDTO.topoDTO.TopoLendingDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO.UsersInfoDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO.UsersInfoToTopoDTO;
import std.fle._03_sfc.topoSFC.ClimbingTopoDisplaySFC;
import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;
import std.fle._06_dao.statesDao.StatesDAO;
import std.fle._06_dao.topoDao.topoLendingDao.TopoLendingDAO;

@Repository
public class TopoDaoImplemented implements TopoDAO {

	@Autowired
	private DAOGenericInterface<ClimbingTopo, ClimbingTopoDTO> dao;

	@Autowired
	private TopoLendingDAO topoLendingDAO;

	@Autowired
	private StatesDAO statesDAO;

	private ClimbingTopo climbingTopo = new ClimbingTopo();
	private UsersInfo usersInfo = new UsersInfo();
	private ClimbingTopoDTO climbingTopoDTO = new ClimbingTopoDTO();
	private ClimbingTopoDisplayDTO climbingTopoDisplayDTO = new ClimbingTopoDisplayDTO();
	private UsersInfoDTO usersInfoDTO = new UsersInfoDTO();
	private UsersInfoToTopoDTO usersInfoToTopoDTO = new UsersInfoToTopoDTO();
	private ClimbingTopoDisplaySFC climbingTopoDisplaySFC = new ClimbingTopoDisplaySFC();

	public ClimbingTopo getClimbingENTById(Integer id) {
		return dao.getEntityById(climbingTopo, id);
	}

	public ClimbingTopoDTO getClimbingDTOById(Integer id) {
		return dao.getDtoByID(climbingTopo, climbingTopoDTO, id);
	}

	@Override
	public void saveNewTopo(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId) {
		ClimbingTopoDTO dto = setClimbingTopoDTOToSave(climbingTopoSFC, loggedUserId);
		ClimbingTopo entity = dao.converter().convertDTOToEntity(dto, climbingTopo);
		dao.save(entity);
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
		ClimbingTopoDTO dto = dao.converter().convertSFCToDTO(climbingTopoSFC, climbingTopoDTO);
		setClimbingDTOSaveOrUpdate(dto, climbingTopoSFC, loggedUserId);
		return dto;
	}

	private String parseYearToString(Year year) {
		return FredParser.asString(year);
	}

	@Override
	public void updateClimbingTopo(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId) {
		ClimbingTopoDTO dto = climbingTopoDTOUpdate(climbingTopoSFC, loggedUserId);
		ClimbingTopo entity = dao.converter().convertDTOToEntity(dto, climbingTopo);
		dao.update(entity);
	}

	private ClimbingTopoDTO climbingTopoDTOUpdate(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId) {
		ClimbingTopoDTO dto = dao.converter().convertSFCToDTO(climbingTopoSFC, climbingTopoDTO);
		setClimbingDTOSaveOrUpdate(dto, climbingTopoSFC, loggedUserId);
		return dto;
	}

	private void setClimbingDTOSaveOrUpdate(ClimbingTopoDTO dto, ClimbingTopoSFC sfc, Integer loggedUserId) {
		setClimbingTopoState(dto, FredParser.toInteger(sfc.getState()));
		setClimbingTopoUserInfo(dto, loggedUserId);
		dto.setEditionYear(parseYearToString(sfc.getEditionYear()));
	}

	@Override
	public ClimbingTopoSFC getClimbingTopoSFC(Integer id) {
		ClimbingTopoDTO dto = getClimbingTopoDTO(id);
		ClimbingTopoSFC sfc = new ClimbingTopoSFC();
		sfc.setId(dto.getId());
		sfc.setTitle(dto.getTitle());
		sfc.setEditionYear(FredParser.toYear(dto.getEditionYear()));
		sfc.setState(FredParser.asString(dto.getState().getId()));
		sfc.setAvailable(dto.getAvailable().toString());
		sfc.setTopoDescription(dto.getTopoDescription());
		return sfc;
	}

	@Override
	public ClimbingTopoDisplaySFC getClimbingTopoDisplaySFC(Integer id) {
		ClimbingTopoDisplayDTO dto = getClimbingTopoDipslayDTO(id);
		ClimbingTopoDisplaySFC sfc = dao.converter().convertDTOToSFC(dto, climbingTopoDisplaySFC);
		sfc.setOwner(getOwner(dto));
		sfc.setState(getStateName(dto));
		return sfc;
	}

	private String getOwner(ClimbingTopoDisplayDTO dto) {
		return dto.getUserInfo().getUserAccountInfo().getPseudonyme();
	}

	private String getStateName(ClimbingTopoDisplayDTO dto) {
		return statesDAO.getDTOByID(dto.getState().getId()).getStateName();
	}

	private ClimbingTopoDisplayDTO getClimbingTopoDipslayDTO(Integer id) {
		return dao.getSpecificDTOById(climbingTopo, climbingTopoDisplayDTO, id);
	}

	@Override
	public void borrowThisTopo(Integer topoId, Integer loggedUserId, String pseudo) {
		ClimbingTopoDTO dto = climbingTopoDTOSetted(topoId, false);
		dao.updateDTO(climbingTopo, dto);
		topoLendingDAO.saveTopoLending(getLenderUserInfoByOwnerpseudo(pseudo),
				getBorrowerUserInfoByLoginId(loggedUserId), dto);
	}

	@Override
	public void borrowDemandAccepted(Integer id) {
		topoLendingDAO.updateTopoLendingBorrowDemandAccepted(id);
	}

	@Override
	public void borrowDemandRejected(Integer id) {
		ClimbingTopoDTO dto = climbingTopoDTOSetted(topoLendingDAO.getTopoLendingDTOById(id).getClimbingTopo().getId(),
				true);
		dao.updateDTO(climbingTopo, dto);
		topoLendingDAO.updateTopoLendingBorrowDemandRejected(id);
	}

	private ClimbingTopoDTO climbingTopoDTOSetted(Integer topoId, Boolean isAvailable) {
		ClimbingTopoDTO dto = getClimbingTopoDTO(topoId);
		dto.setAvailable(isAvailable);
		return dto;
	}

	@Override
	public String getOwnerEmail(String ownerPseudo) {
		return getLenderUserInfoByOwnerpseudo(ownerPseudo).getEmail();
	}

	@Override
	public String getOwnerEmailViaTopoLending(Integer topoLendingId) {
		return topoLendingDAO.getLenderEmailAddress(topoLendingId);
	}

	@Override
	public String getBorrowerEmail(Integer loggedUserId) {
		return getBorrowerUserInfoByLoginId(loggedUserId).getEmail();
	}

	@Override
	public String getBorrowerEmailViaTopoLending(Integer topoLendingId) {
		return topoLendingDAO.getBorrowerEmailAddress(topoLendingId);
	}

	private UsersInfoToTopoDTO getLenderUserInfoByOwnerpseudo(String pseudo) {
		return dao.getSpecificEntitySpecificDTOWhereCondition("userAccountInfo.pseudonyme", pseudo, usersInfo,
				usersInfoToTopoDTO);
	}

	private UsersInfoToTopoDTO getBorrowerUserInfoByLoginId(Integer loggedUserId) {
		return dao.getSpecificEntitySpecificDTOWhereCondition("userAccountInfo.id", FredParser.asString(loggedUserId),
				usersInfo, usersInfoToTopoDTO);
	}

	private ClimbingTopoDTO getClimbingTopoDTO(Integer id) {
		return dao.converter().convertEntityToDTO(getClimbingTopoById(id), climbingTopoDTO);
	}

	private ClimbingTopo getClimbingTopoById(Integer id) {
		return dao.getEntityById(climbingTopo, id);
	}

	@Override
	public boolean lenderCheck(Integer topoLendingId, Integer loggedUserId) {
		return getUserInfoByUsersAccountInfoId(FredParser.asString(loggedUserId)).getEmail()
				.equals(topoLendingDAO.getLenderEmailAddress(topoLendingId));
	}

	@Override
	public TopoLendingDTO getTopoLendingById(Integer id) {
		return topoLendingDAO.getTopoLendingDTOById(id);
	}

	@Override
	public void deleteTopo(Integer id) {
		dao.removeByID(climbingTopo, id);
	}

}
