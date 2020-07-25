package std.fle._07_service.userUpdateService;

import std.fle._04_associationModel.sfc.UserUpdateSFC;

public interface UserUpdateService {
	
	public UserUpdateSFC getById(Integer id);
	
	public void update(UserUpdateSFC userUpdated);

}
