package std.fle._07_service.climbingTopoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;
import std.fle._06_dao.topoDao.TopoDAO;

@Service
public class TopoServiceImplemented implements TopoService {
	
	@Autowired
	TopoDAO topoDao;

	@Override
	public void saveNewTopo(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId) {
		topoDao.saveNewTopo(climbingTopoSFC, loggedUserId);
		
	}
	
	

}
