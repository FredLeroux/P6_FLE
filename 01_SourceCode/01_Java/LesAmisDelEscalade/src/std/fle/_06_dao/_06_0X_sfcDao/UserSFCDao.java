package std.fle._06_dao._06_0X_sfcDao;

import javax.transaction.Transactional;

import std.fle._04_associationModel._04_03_sfc.UserSFC;

@Transactional
public interface UserSFCDao {
	
	
	public UserSFC getById(Integer id);
		
	public void save(UserSFC user);	
	
	

}
