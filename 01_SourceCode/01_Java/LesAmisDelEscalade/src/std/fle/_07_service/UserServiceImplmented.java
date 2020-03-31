package std.fle._07_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._04_associationModel._04_03_sfc.UserSFC;
import std.fle._06_dao._06_0X_sfcDao.UserSFCDao;
@Service
public class UserServiceImplmented implements UserService {
	
	@Autowired
	UserSFCDao dao;

	@Override
	public void save(UserSFC user) {
		dao.save(user);

	}

}
