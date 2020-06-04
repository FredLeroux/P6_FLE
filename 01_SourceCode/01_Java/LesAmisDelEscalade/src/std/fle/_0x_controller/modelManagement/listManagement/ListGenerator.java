package std.fle._0x_controller.modelManagement.listManagement;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import std.fle._05_slo.innerJoinSLO.ClimbingSiteCommentsSLO;
import std.fle._05_slo.innerJoinSLO.ClimbingSiteSLO;
import std.fle._05_slo.innerJoinSLO.MembersListSLO;

public interface ListGenerator {

	public List<MembersListSLO> membersList();

	public LinkedHashMap<String, Object> getMembersList();	

	public List<ClimbingSiteSLO> climbingSiteSLOs();

	public LinkedHashMap<String, Object> getClimbingSiteListShow();
	
	public LinkedHashMap<String,Object> getClimbingSiteListEdit();
	
	public List<ClimbingSiteCommentsSLO> climbingSiteCommentsSLOs(Integer id);
	
	public LinkedHashMap<String,Object> getclimbingSiteCommentsSLOList(Integer id,HttpServletRequest request);

}
