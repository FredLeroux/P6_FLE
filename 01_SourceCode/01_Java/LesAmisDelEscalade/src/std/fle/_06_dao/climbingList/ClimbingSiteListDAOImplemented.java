package std.fle._06_dao.climbingList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.daoList.DAOListGeneric;
import std.fle._05_slo.innerJoinSLO.ClimbingSiteSLO;

@Repository
public class ClimbingSiteListDAOImplemented implements ClimbingSiteListDAO {

	@Autowired
	DAOListGeneric dao;
	
	private ClimbingSiteSLO climBingSiteSLO = new ClimbingSiteSLO();
	
	public List<ClimbingSiteSLO> getList(){
		return dao.getInnerJoinListI18N(climBingSiteSLO);
	}
	
	
}
