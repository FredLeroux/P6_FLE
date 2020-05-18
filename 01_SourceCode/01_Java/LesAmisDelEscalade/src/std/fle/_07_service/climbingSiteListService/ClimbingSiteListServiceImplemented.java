package std.fle._07_service.climbingSiteListService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._05_slo.innerJoinSLO.ClimbingSiteSLO;
import std.fle._06_dao.climbingList.ClimbingSiteListDAO;

@Service
public class ClimbingSiteListServiceImplemented implements ClimbingSiteListService{
	
	@Autowired
	ClimbingSiteListDAO dao;

	@Override
	public List<ClimbingSiteSLO> getList() {		
		return dao.getList();
	}
	
	
	

}
