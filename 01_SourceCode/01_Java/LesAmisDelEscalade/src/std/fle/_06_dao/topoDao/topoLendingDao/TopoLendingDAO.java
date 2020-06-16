package std.fle._06_dao.topoDao.topoLendingDao;

import javax.transaction.Transactional;

import std.fle._02_dto.modelsDTO.topoDTO.ClimbingTopoDTO;
import std.fle._02_dto.modelsDTO.topoDTO.TopoLendingDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO.UsersInfoToTopoDTO;

@Transactional
public interface TopoLendingDAO {

	public void saveTopoLending(UsersInfoToTopoDTO lenderUsersInfoDTO, UsersInfoToTopoDTO borrowerUsersInfoDTO,
			ClimbingTopoDTO climbingTopoDTO);

	public void updateTopoLendingBorrowDemandAccepted(Integer id);

	public void updateTopoLendingBorrowDemandRejected(Integer id);

	public String getBorrowerEmailAddress(Integer id);

	public String getLenderEmailAddress(Integer id);
	
	public String getBorrowerPseudo(Integer id);

	public String getLenderPseudo(Integer id);

	public TopoLendingDTO getTopoLendingDTOById(Integer id);

}
