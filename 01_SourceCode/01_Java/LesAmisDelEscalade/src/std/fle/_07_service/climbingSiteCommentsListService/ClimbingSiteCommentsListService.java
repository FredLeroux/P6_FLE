package std.fle._07_service.climbingSiteCommentsListService;

import java.util.List;

import std.fle._05_slo.directSLO.ClimbingSiteCommentsSLO;

public interface ClimbingSiteCommentsListService {

	public List<ClimbingSiteCommentsSLO> getCommentsList(Integer id);

}
