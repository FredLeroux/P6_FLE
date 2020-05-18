package std.fle._06_dao.climbingList;

import java.util.List;

import javax.transaction.Transactional;

import std.fle._05_slo.innerJoinSLO.ClimbingSiteSLO;

@Transactional
public interface ClimbingSiteListDAO {
	
	public List<ClimbingSiteSLO> getList();

}
