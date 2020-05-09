package std.fle._07_service.climbingTopoService;

import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;

public interface TopoService {
	
	public void saveNewTopo(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId);

}
