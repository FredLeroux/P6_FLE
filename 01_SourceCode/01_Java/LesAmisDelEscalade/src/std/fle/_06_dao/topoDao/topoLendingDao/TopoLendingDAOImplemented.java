package std.fle._06_dao.topoDao.topoLendingDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.dao.DAOGenericInterface;
import std.fle._01_entity.assetsEnum.LendingStatus;
import std.fle._01_entity.models.topo.TopoLending;
import std.fle._02_dto.modelsDTO.topoDTO.ClimbingTopoDTO;
import std.fle._02_dto.modelsDTO.topoDTO.TopoLendingDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO.UsersInfoToTopoDTO;

@Repository
public class TopoLendingDAOImplemented implements TopoLendingDAO {

	@Autowired
	private DAOGenericInterface<TopoLending, TopoLendingDTO> dao;

	private TopoLending topoLending = new TopoLending();
	private TopoLendingDTO topoLendingDTO = new TopoLendingDTO();

	@Override
	public void saveTopoLending(UsersInfoToTopoDTO lenderUsersInfoDTO, UsersInfoToTopoDTO borrowerUsersInfoDTO,
			ClimbingTopoDTO climbingTopoDTO) {
		dao.saveDTO(topoLending, topoLendingDTOSetted(lenderUsersInfoDTO, borrowerUsersInfoDTO, climbingTopoDTO));
	}

	private TopoLendingDTO topoLendingDTOSetted(UsersInfoToTopoDTO lenderUsersInfoDTO, UsersInfoToTopoDTO borrowerUsersInfoDTO,
			ClimbingTopoDTO climbingTopoDTO) {
		TopoLendingDTO dto = new TopoLendingDTO();
		dto.setClimbingTopo(climbingTopoDTO);
		dto.setBorrowerUserInfo(borrowerUsersInfoDTO);
		dto.setLenderUserInfo(lenderUsersInfoDTO);
		dto.setLendingStatus(LendingStatus.WAITING.toString());
		return dto;
	}

	@Override
	public void updateTopoLendingBorrowDemandAccepted(Integer id) {
		TopoLendingDTO dto = getTopoLendingDTOById(id);
		setBorrowDemandAccepted(dto);
		dao.updateDTO(topoLending, dto);
	}

	@Override
	public void updateTopoLendingBorrowDemandRejected(Integer id) {
		TopoLendingDTO dto = getTopoLendingDTOById(id);
		setBorrowDemandRejected(dto);
		//setClimbingTopoAvailable(dto);
		dao.updateDTO(topoLending, dto);
	}

	private void setBorrowDemandAccepted(TopoLendingDTO dto) {
		dto.setLendingStatus(LendingStatus.ACCEPTED.toString());
	}

	private void setBorrowDemandRejected(TopoLendingDTO dto) {
		dto.setLendingStatus(LendingStatus.REJECTED.toString());
	}

	private void setClimbingTopoAvailable(TopoLendingDTO dto) {
		dto.getClimbingTopo().setAvailable(true);
	}

	@Override
	public String getBorrowerEmailAddress(Integer id) {
		return getTopoLendingDTOById(id).getBorrowerUserInfo().getEmail();
	}

	@Override
	public String getLenderEmailAddress(Integer id) {
		return getTopoLendingDTOById(id).getLenderUserInfo().getEmail();
	}
	
	@Override
	public String getBorrowerPseudo(Integer id) {
		return getTopoLendingDTOById(id).getBorrowerUserInfo().getUserAccountInfo().getPseudonyme();
	}
	
	@Override
	public String getLenderPseudo(Integer id) {
		return getTopoLendingDTOById(id).getLenderUserInfo().getUserAccountInfo().getPseudonyme();
	}

	
	
	@Override
	public TopoLendingDTO getTopoLendingDTOById(Integer id) {
		return dao.getDtoByID(topoLending, topoLendingDTO, id);
	}
	
	

}
