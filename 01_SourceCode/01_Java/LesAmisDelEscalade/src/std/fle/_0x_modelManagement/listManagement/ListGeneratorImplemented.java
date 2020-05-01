package std.fle._0x_modelManagement.listManagement;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fle.toolBox.CRUD.daoList.DAOListGeneric;
import std.fle._05_slo.innerJoinSLO.MembersListSLO;
import std.fle._06_dao.memberListDao.MemberListDAO;
import std.fle._07_service.memberListService.MemberListService;

@Service
public class ListGeneratorImplemented implements ListGenerator {
	

	
	@Autowired
	MemberListService memberListService;
	
	private MembersListSLO members = new MembersListSLO();
	
	public List<MembersListSLO> membersList(){
		return memberListService.getList();
	}
	
	public LinkedHashMap<String,Object> elementList(){
		LinkedHashMap<String, Object> element = new LinkedHashMap<>();
		element.put("list", membersList());
		element.put("class", members);
		element.put("editControllerURI","memberDetails");
		return element;
	}
	
	
	
}
