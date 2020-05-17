package std.fle._07_service._07_02_serviceImplemented._07_02_03_associatedModelServiceImplemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._04_associationModel._04_03_sfc.UserUpdateSFC;
import std.fle._06_dao._06_01_daoInterface._06_01_03_associationModelDao.UserUpdateDAO;
import std.fle._07_service._07_01_serviceInterface._07_01_03_associatedModelServiceInterface.UserUpdateService;
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
