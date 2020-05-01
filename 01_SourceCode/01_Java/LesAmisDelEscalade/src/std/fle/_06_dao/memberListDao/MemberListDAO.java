package std.fle._06_dao.memberListDao;

import java.util.List;

import javax.transaction.Transactional;

import std.fle._05_slo.innerJoinSLO.MembersListSLO;



@Transactional
public interface MemberListDAO {
	
	public List<MembersListSLO> getList();

}
