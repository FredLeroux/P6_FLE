package std.fle._06_dao.climbingSiteCommentsDao;

import javax.transaction.Transactional;

@Transactional
public interface ClimbingSiteCommentsDAO {

	
	public void postComment(Integer climbingSiteId, Integer userAccountId,
			String comment);
}
