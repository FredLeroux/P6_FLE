package std.fle._06_dao.topoDao;

import javax.transaction.Transactional;

import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;

@Transactional
public interface TopoDAO {

	public void saveNewTopo(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId);
}
