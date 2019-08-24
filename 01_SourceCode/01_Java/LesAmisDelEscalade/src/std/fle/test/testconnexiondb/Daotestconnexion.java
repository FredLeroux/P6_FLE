package std.fle.test.testconnexiondb;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import tools.crud.Crud;

@Repository
public class Daotestconnexion {

	
Crud crud = new Crud();
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void createTestConnexion(TestConnexionDb  test) {
		crud.create(sessionFactory, test);

	}

	
	public String readTestConnexion(TestConnexionDb test, Integer testoId) {
		// TODO Auto-generated method stub
		return null;
	}
}
