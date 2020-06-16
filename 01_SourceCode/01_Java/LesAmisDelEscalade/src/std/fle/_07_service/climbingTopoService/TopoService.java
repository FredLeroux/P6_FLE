package std.fle._07_service.climbingTopoService;

import std.fle._02_dto.modelsDTO.topoDTO.TopoLendingDTO;
import std.fle._03_sfc.topoSFC.ClimbingTopoDisplaySFC;
import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;

public interface TopoService {

	public void saveNewTopo(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId);
	
	public void updateClimbingTopo(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId);
	
	public ClimbingTopoSFC getClimbingTopoSFC(Integer id);

	public ClimbingTopoDisplaySFC getClimbingTopoDisplayDTO(Integer id);

	public void borrowThisTopo(Integer topoId, Integer loggedUserId, String pseudo);

	public String getOwnerMail(String ownerPseudo);
	
	public TopoLendingDTO getTopoLendingById(Integer id);
	
	public String getOwnerEmailViaTopoLending(Integer topoLendingId);

	public String getBorrowerEmail(Integer loggedUserId);

	public String getBorrowerEmailViaTopoLending(Integer topoLendingId);

	public void borrowDemandAccepted(Integer id);

	public void borrowDemandRejected(Integer id);
	
	public boolean lenderCheck(Integer topoLendingId, Integer loggedUserId);
	
	public void deleteTopo(Integer id);
	
	
	

}
