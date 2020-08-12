package std.fle._06_dao.climbingSiteCommentsListDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.daoList.DAOListGeneric;
import std.fle._05_slo.directSLO.ClimbingSiteCommentsSLO;

@Repository
public class ClimbingSiteCommentsListDAOImplemented implements ClimbingSiteCommentsListDAO {

	@Autowired
	DAOListGeneric dao;
	
	
	private ClimbingSiteCommentsSLO climbingSiteCommentsSLO =new ClimbingSiteCommentsSLO();
	
	@Override
	public List<ClimbingSiteCommentsSLO> getCommentsListById(Integer id) {		
		return dao.getInnerJoinListByIdI18N(climbingSiteCommentsSLO, "siteId", id);
	}
	
	
}
