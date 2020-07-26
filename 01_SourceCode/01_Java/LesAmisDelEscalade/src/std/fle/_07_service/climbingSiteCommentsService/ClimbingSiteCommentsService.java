package std.fle._07_service.climbingSiteCommentsService;

import java.util.ArrayList;

import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteCommentsSFC;

public interface ClimbingSiteCommentsService {

	public void postComment(Integer climbingSiteId, Integer userAccountId,
			String comment);
	
	public ClimbingSiteCommentsSFC getClimbingSiteCommentsSFCForEdit(Integer id);
	
	public void updateComment(ClimbingSiteCommentsSFC climbingSiteCommentsSFC,Integer commentId, String author);
	
	public void deleteComment(ClimbingSiteCommentsSFC climbingSiteCommentsSFC,Integer commentId, String author);

	public ArrayList<String> modificationLogI18N(Integer climbingSiteCommentId);
	
}
