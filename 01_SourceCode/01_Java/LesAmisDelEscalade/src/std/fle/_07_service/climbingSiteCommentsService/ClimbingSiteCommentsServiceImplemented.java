package std.fle._07_service.climbingSiteCommentsService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteCommentsSFC;
import std.fle._06_dao.climbingSiteCommentsDao.ClimbingSiteCommentsDAO;

@Service
public class ClimbingSiteCommentsServiceImplemented implements ClimbingSiteCommentsService {

	@Autowired
	ClimbingSiteCommentsDAO dao;

	@Override
	public void postComment(Integer climbingSiteId, Integer userAccountId, String comment) {
		dao.postComment(climbingSiteId, userAccountId, comment);
	}

	@Override
	public ClimbingSiteCommentsSFC getClimbingSiteCommentsSFCForEdit(Integer id) {
		return dao.getClimbingSiteCommentsSFCForEdit(id);
	}

	@Override
	public void updateComment(ClimbingSiteCommentsSFC climbingSiteCommentsSFC, Integer commentId, String author) {
		dao.updateComment(climbingSiteCommentsSFC, commentId, author);
	}

	@Override
	public void deleteComment(ClimbingSiteCommentsSFC climbingSiteCommentsSFC, Integer commentId, String author) {
		dao.deleteComment(climbingSiteCommentsSFC, commentId, author);
	}

	@Override
	public ArrayList<String> modificationLogI18N(Integer climbingSiteCommentId) {
		return dao.modificationLogI18N(climbingSiteCommentId);
	}

}
