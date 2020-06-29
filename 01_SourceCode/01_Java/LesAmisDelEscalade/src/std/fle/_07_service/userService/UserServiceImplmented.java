package std.fle._07_service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._04_associationModel.sfc.UserSFC;
import std.fle._06_dao.userSFCDao.UserSFCDao;
@Service
public class UserServiceImplmented implements UserService {
	
	@Autowired
	UserSFCDao dao;

	@Override
	public void save(UserSFC user) {
		dao.save(user);

	}

	

}
