package std.fle._06_dao._06_0X_sfcDao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.classType.SFC;
import std.fle._04_associationModel._04_03_sfc.UserSFC;

@Transactional
public interface UserSFCDao {
	
	
	
		
	public void save(UserSFC user);	
	
	

}
