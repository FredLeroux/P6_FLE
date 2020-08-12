package std.fle._12_controller.listManagement;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import std.fle._05_slo.directSLO.ClimbingSiteCommentsSLO;
import std.fle._05_slo.innerJoinSLO.ClimbingSiteSLO;
import std.fle._05_slo.innerJoinSLO.MembersListSLO;
import std.fle._05_slo.innerJoinSLO.TopoListSLO;
import std.fle._05_slo.innerJoinSLO.TopoMineListSLO;

public interface ListGenerator {

	public List<MembersListSLO> membersList();

	public LinkedHashMap<String, Object> getMembersList(String listType);

	public List<ClimbingSiteSLO> climbingSiteSLOs();

	public List<TopoListSLO> topoSLOs();

	public LinkedHashMap<String, Object> getClimbingSiteListShow(String listType);

	public LinkedHashMap<String,Object> getClimbingSiteListEdit(String listType);

	public List<ClimbingSiteCommentsSLO> climbingSiteCommentsSLOs(Integer id);

	public LinkedHashMap<String,Object> getclimbingSiteCommentsSLOList(Integer id,HttpServletRequest request,String listType);

	public LinkedHashMap<String,Object> getTopoSLOList(String listType);

	public LinkedHashMap<String, Object> getTopoSLOsLoggedOwnerExcludedList(HttpServletRequest request,String listType);

	public List<TopoMineListSLO> topoMines(HttpServletRequest request);

	public LinkedHashMap<String, Object> getTopoMineSLOList(HttpServletRequest request,String listType);

}
