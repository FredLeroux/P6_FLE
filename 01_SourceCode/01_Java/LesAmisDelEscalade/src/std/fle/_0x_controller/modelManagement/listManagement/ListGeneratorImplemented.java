package std.fle._0x_controller.modelManagement.listManagement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fle.toolBox.ConfigurationFileReader;
import std.fle._05_slo.innerJoinSLO.MembersListSLO;
import std.fle._07_service.memberListService.MemberListService;

@Service
public class ListGeneratorImplemented implements ListGenerator {
	

	
	@Autowired
	MemberListService memberListService;
	
	private MembersListSLO members = new MembersListSLO();
	private ConfigurationFileReader config = new ConfigurationFileReader("configuration/securitySettings/securitySettings.xml");
	
	public List<MembersListSLO> membersList(){		
		return memberListService.getList();
	}
	
	public LinkedHashMap<String,Object> elementList(){
		LinkedHashMap<String, Object> element = new LinkedHashMap<>();
		List<MembersListSLO> list = new ArrayList<>(membersList());
		list.removeIf(o->o.getPseudonyme().equals(config.getProperty("admin.pseudo")));
		element.put("list", list );
		element.put("class", members);
		element.put("editControllerURI","memberDetails");		
		return element;
	}
	
	
	
}
