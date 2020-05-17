package fle.toolBox.CRUD.tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HibernateSessionImplemented implements HibernateSession {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Session session() {
		return sessionFactory.getCurrentSession();
	}

}
