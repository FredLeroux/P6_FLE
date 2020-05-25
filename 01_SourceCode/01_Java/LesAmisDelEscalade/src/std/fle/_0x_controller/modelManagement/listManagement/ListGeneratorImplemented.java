package std.fle._0x_controller.modelManagement.listManagement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fle.toolBox.ConfigurationFileReader;
import std.fle._05_slo.innerJoinSLO.ClimbingSiteSLO;
import std.fle._05_slo.innerJoinSLO.MembersListSLO;
import std.fle._07_service.climbingSiteListService.ClimbingSiteListService;
import std.fle._07_service.memberListService.MemberListService;

@Service
public class ListGeneratorImplemented implements ListGenerator {
	

	
	@Autowired
	MemberListService memberListService;
	
	@Autowired
	ClimbingSiteListService climbingSiteListService;
	
	private MembersListSLO members = new MembersListSLO();
	private ClimbingSiteSLO climbingSiteSLO = new ClimbingSiteSLO();
	private ConfigurationFileReader config = new ConfigurationFileReader("configuration/securitySettings/securitySettings.xml");
	
	@Override
	public List<MembersListSLO> membersList(){		
		return memberListService.getList();
	}
	
	@Override
	public List<ClimbingSiteSLO> climbingSiteSLOs(){
		return climbingSiteListService.getList();
	}
	
	@Override
	public LinkedHashMap<String,Object> getMembersList(){
		List<MembersListSLO> list = new ArrayList<>(membersList());
		list.removeIf(o->o.getPseudonyme().equals(config.getProperty("admin.pseudo")));			
		return map(list, members, "memberDetails");
	}
	
	@Override
	public LinkedHashMap<String,Object> getClimbingSiteListShow(){
		return climbingSiteListGeneric("climbingSiteDetails");
	}
	
	@Override
	public LinkedHashMap<String,Object> getClimbingSiteListEdit(){
		return climbingSiteListGeneric("climbingSiteEdit");
	}
	
	
	
	private LinkedHashMap<String, Object> map(List<?> list, Object clazz,String editControllerURI) {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("list", list );
		map.put("class", clazz);
		map.put("editControllerURI",editControllerURI);	
		return map;
	}
	
	private LinkedHashMap<String,Object> climbingSiteListGeneric(String editControllerURI ){
		List<ClimbingSiteSLO> list = new ArrayList<>(climbingSiteSLOs());
		return map(list, climbingSiteSLO, editControllerURI);
	}
	
	
	
}
