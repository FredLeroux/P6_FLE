package std.fle._06_dao.userUpdateDao;

import javax.transaction.Transactional;

import std.fle._04_associationModel.sfc.UserUpdateSFC;

@Transactional
public interface UserUpdateDAO {

	public UserUpdateSFC getById(Integer id);
	
	public void update(UserUpdateSFC userUpdated);
	
}
