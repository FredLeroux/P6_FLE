package std.fle._06_dao._06_01_daoInterface._06_01_03_associationModelDao;

import javax.transaction.Transactional;

import std.fle._04_associationModel._04_03_sfc.UserUpdateSFC;

@Transactional
public interface UserUpdateDAO {

	public UserUpdateSFC getById(Integer id);
	
	public void update(UserUpdateSFC userUpdated);
	
}
