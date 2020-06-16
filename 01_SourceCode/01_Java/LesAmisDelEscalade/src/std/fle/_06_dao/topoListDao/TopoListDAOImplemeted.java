package std.fle._06_dao.topoListDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.daoList.DAOListGeneric;
import std.fle._05_slo.innerJoinSLO.TopoBorrowSLO;
import std.fle._05_slo.innerJoinSLO.TopoListSLO;
import std.fle._05_slo.innerJoinSLO.TopoMineListSLO;

@Repository
public class TopoListDAOImplemeted implements TopoListDAO {

	@Autowired
	DAOListGeneric dao;

	private TopoListSLO topoListSLO = new TopoListSLO();
	private TopoMineListSLO TopoMineListSLO = new TopoMineListSLO();
	private TopoBorrowSLO topoBorrowSLO = new TopoBorrowSLO();

	@Override
	public List<TopoListSLO> getAllTopoList() {
		return dao.getInnerJoinList(topoListSLO);
	}

	@Override
	public List<TopoMineListSLO> getMineTopo(Integer loggedUserId) {
		return dao.getInnerJoinListByIdI18N(TopoMineListSLO, "loggedUserId", loggedUserId);
	}

	@Override
	public List<TopoBorrowSLO> getBorrowingDemandList(Integer loggedUserId) {
		return dao.getInnerJoinListByIdI18N(topoBorrowSLO, "loggedUserId", loggedUserId);
	}

}
