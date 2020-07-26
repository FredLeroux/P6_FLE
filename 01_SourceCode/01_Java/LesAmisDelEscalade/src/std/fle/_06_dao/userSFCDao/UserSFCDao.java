package std.fle._06_dao.userSFCDao;

import javax.transaction.Transactional;

import std.fle._04_associationModel.sfc.UserSFC;

@Transactional
public interface UserSFCDao {
	
	
	public UserSFC getById(Integer id);
		
	public void save(UserSFC user);
	
	
	
	

}
