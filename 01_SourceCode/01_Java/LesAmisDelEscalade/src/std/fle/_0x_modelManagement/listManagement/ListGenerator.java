package std.fle._0x_modelManagement.listManagement;

import java.util.LinkedHashMap;
import java.util.List;

import std.fle._05_slo.innerJoinSLO.MembersListSLO;

public interface ListGenerator {
	
	
	public List<MembersListSLO> membersList();
	
	public LinkedHashMap<String,Object> elementList();

}
