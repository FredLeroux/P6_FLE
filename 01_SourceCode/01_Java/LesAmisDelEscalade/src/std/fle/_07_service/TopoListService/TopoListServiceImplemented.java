package std.fle._07_service.TopoListService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._05_slo.innerJoinSLO.TopoBorrowSLO;
import std.fle._05_slo.innerJoinSLO.TopoListSLO;
import std.fle._05_slo.innerJoinSLO.TopoMineListSLO;
import std.fle._06_dao.topoListDao.TopoListDAO;

@Service
public class TopoListServiceImplemented implements TopoListService {
	
	@Autowired
	TopoListDAO dao;
	
	@Override
	public List<TopoListSLO> getAllTopoList(){
		return dao.getAllTopoList();
	}

	@Override
	public List<TopoMineListSLO> getMineTopo(Integer loggedUserId) {
		return dao.getMineTopo(loggedUserId);
	}
	
	@Override
	public List<TopoBorrowSLO> getBorrowingDemandList(Integer loggedUserId) {		
		return dao.getBorrowingDemandList(loggedUserId);
	}



	

}
