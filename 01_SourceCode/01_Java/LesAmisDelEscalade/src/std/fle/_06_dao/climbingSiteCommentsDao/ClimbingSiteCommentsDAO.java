package std.fle._06_dao.climbingSiteCommentsDao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteCommentsSFC;

@Transactional
public interface ClimbingSiteCommentsDAO {

	
	public void postComment(Integer climbingSiteId, Integer userAccountId,
			String comment);
	
	public ClimbingSiteCommentsSFC getClimbingSiteCommentsSFCForEdit(Integer id);
	
	public void updateComment(ClimbingSiteCommentsSFC climbingSiteCommentsSFC,Integer commentId, String author);
	
	public void deleteComment(ClimbingSiteCommentsSFC climbingSiteCommentsSFC,Integer commentId, String author);

	public ArrayList<String> modificationLogI18N(Integer climbingSiteCommentId);
}
