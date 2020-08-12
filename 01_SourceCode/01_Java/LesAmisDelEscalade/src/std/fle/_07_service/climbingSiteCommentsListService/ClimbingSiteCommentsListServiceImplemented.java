package std.fle._07_service.climbingSiteCommentsListService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._05_slo.directSLO.ClimbingSiteCommentsSLO;
import std.fle._06_dao.climbingSiteCommentsListDao.ClimbingSiteCommentsListDAO;

@Service
public class ClimbingSiteCommentsListServiceImplemented implements ClimbingSiteCommentsListService {

	@Autowired
	ClimbingSiteCommentsListDAO dao;

	@Override
	public List<ClimbingSiteCommentsSLO> getCommentsList(Integer id) {
		return dao.getCommentsListById(id);
	}

}
