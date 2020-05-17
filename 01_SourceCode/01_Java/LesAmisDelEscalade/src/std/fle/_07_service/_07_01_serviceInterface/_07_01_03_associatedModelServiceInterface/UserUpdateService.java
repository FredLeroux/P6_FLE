package std.fle._07_service._07_01_serviceInterface._07_01_03_associatedModelServiceInterface;

import std.fle._04_associationModel._04_03_sfc.UserUpdateSFC;

public interface UserUpdateService {
	
	public UserUpdateSFC getById(Integer id);
	
	public void update(UserUpdateSFC userUpdated);

}
