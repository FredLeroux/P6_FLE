package std.fle._07_service.TopoListService;

import java.util.List;

import std.fle._05_slo.innerJoinSLO.TopoBorrowSLO;
import std.fle._05_slo.innerJoinSLO.TopoListSLO;
import std.fle._05_slo.innerJoinSLO.TopoMineListSLO;

public interface TopoListService {
	
	public List<TopoListSLO> getAllTopoList();
	
	public List<TopoMineListSLO> getMineTopo(Integer loggedUserId);
	
	public List<TopoBorrowSLO> getBorrowingDemandList(Integer loggedUserId);

}
