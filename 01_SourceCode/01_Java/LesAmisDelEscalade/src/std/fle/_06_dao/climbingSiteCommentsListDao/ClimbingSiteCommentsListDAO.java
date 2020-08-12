package std.fle._06_dao.climbingSiteCommentsListDao;

import java.util.List;

import javax.transaction.Transactional;

import std.fle._05_slo.directSLO.ClimbingSiteCommentsSLO;

@Transactional
public interface ClimbingSiteCommentsListDAO {

	
	public List<ClimbingSiteCommentsSLO> getCommentsListById(Integer id);
}
