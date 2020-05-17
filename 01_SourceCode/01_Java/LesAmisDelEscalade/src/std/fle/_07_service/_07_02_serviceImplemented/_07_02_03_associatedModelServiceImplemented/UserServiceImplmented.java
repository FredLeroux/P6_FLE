package std.fle._07_service._07_02_serviceImplemented._07_02_03_associatedModelServiceImplemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._04_associationModel._04_03_sfc.UserSFC;
import std.fle._06_dao._06_0X_sfcDao.UserSFCDao;
import std.fle._07_service._07_01_serviceInterface._07_01_03_associatedModelServiceInterface.UserService;
@Service
public class UserServiceImplmented implements UserService {
	
	@Autowired
	UserSFCDao dao;

	@Override
	public void save(UserSFC user) {
		dao.save(user);

	}

	

}
