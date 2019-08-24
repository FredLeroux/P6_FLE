package std.fle.test.testconnexiondb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceTestConnexionDb {

	@Autowired
	private Daotestconnexion testconnexion;
	
	@Transactional
	public void createTestConnexion(TestConnexionDb  test) {
		testconnexion.createTestConnexion(test);
	}
	
}
