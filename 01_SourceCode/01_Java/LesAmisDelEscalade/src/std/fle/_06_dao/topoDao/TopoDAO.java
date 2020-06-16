package std.fle._06_dao.topoDao;

import javax.transaction.Transactional;

import std.fle._02_dto.modelsDTO.topoDTO.TopoLendingDTO;
import std.fle._03_sfc.topoSFC.ClimbingTopoDisplaySFC;
import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;

@Transactional
public interface TopoDAO {

	public void saveNewTopo(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId);

	public void updateClimbingTopo(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId);

	public ClimbingTopoSFC getClimbingTopoSFC(Integer id);

	public ClimbingTopoDisplaySFC getClimbingTopoDisplaySFC(Integer id);

	public void borrowThisTopo(Integer topoId, Integer loggedUserId, String pseudo);

	public String getOwnerEmail(String ownerPseudo);

	public TopoLendingDTO getTopoLendingById(Integer id);

	public String getOwnerEmailViaTopoLending(Integer topoLendingId);

	public String getBorrowerEmail(Integer loggedUserId);

	public String getBorrowerEmailViaTopoLending(Integer topoLendingId);

	public void borrowDemandAccepted(Integer id);

	public void borrowDemandRejected(Integer id);

	public boolean lenderCheck(Integer topoLendingId, Integer loggedUserId);
	
	public void deleteTopo(Integer id);

}
