package std.fle._07_service.userUpdateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._04_associationModel.sfc.UserUpdateSFC;
import std.fle._06_dao.userUpdateDao.UserUpdateDAO;
@Service
public class UserUpdateServiceImplemented implements UserUpdateService {

	@Autowired
	UserUpdateDAO dao;
	
	
	@Override
	public UserUpdateSFC getById(Integer id) {	
		return dao.getById(id) ;
	}


	@Override
	public void update(UserUpdateSFC userUpdated) {
		dao.update(userUpdated);
		
	}

}
