package std.fle._06_dao.topoListDao;

import java.util.List;

import javax.transaction.Transactional;

import std.fle._05_slo.innerJoinSLO.TopoBorrowSLO;
import std.fle._05_slo.innerJoinSLO.TopoListSLO;
import std.fle._05_slo.innerJoinSLO.TopoMineListSLO;


@Transactional
public interface TopoListDAO {
	
	public List<TopoListSLO> getAllTopoList();
	
	public List<TopoMineListSLO> getMineTopo(Integer loggedUserId);
	
	public List<TopoBorrowSLO> getBorrowingDemandList(Integer loggedUserId);

}
