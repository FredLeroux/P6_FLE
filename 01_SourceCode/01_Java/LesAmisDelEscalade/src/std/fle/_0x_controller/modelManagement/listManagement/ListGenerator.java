package std.fle._0x_controller.modelManagement.listManagement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import std.fle._05_slo.innerJoinSLO.ClimbingSiteSLO;
import std.fle._05_slo.innerJoinSLO.MembersListSLO;

public interface ListGenerator {

	public List<MembersListSLO> membersList();

	public LinkedHashMap<String, Object> getMembersList();

	public List<ClimbingSiteSLO> climbingSiteSLOs();

	public LinkedHashMap<String, Object> getClimbingSiteList();

}
