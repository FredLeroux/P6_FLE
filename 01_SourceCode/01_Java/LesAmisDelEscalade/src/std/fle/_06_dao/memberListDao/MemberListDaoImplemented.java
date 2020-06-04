package std.fle._06_dao.memberListDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.daoList.DAOListGeneric;
import std.fle._05_slo.innerJoinSLO.MembersListSLO;

@Repository
public class MemberListDaoImplemented implements MemberListDAO {
	
	
	@Autowired
	DAOListGeneric dao;
	
	private MembersListSLO membersListSLO = new MembersListSLO();
	
	@Override
	public List<MembersListSLO> getList() {
		return dao.getInnerJoinListI18N(membersListSLO);
	}
	
	

}
