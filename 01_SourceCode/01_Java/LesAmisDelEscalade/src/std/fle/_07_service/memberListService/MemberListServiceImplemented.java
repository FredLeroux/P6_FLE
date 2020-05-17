package std.fle._07_service.memberListService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._05_slo.innerJoinSLO.MembersListSLO;
import std.fle._06_dao.memberListDao.MemberListDAO;

@Service
public class MemberListServiceImplemented implements MemberListService {

	@Autowired
	MemberListDAO dao;
	
	@Override
	public List<MembersListSLO> getList() {		
		return dao.getList();
	}
	
	

}
