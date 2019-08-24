package tools.crud;

import org.hibernate.SessionFactory;

public class Crud {

	public void create(SessionFactory sessionFactory, Object entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	public Object read(SessionFactory sessionFactory, Object entity, Integer entityId) {
		return sessionFactory.getCurrentSession().get(entity.getClass(), entityId);
	}

	public Object update(SessionFactory sessionFactory, Object entity) {
		sessionFactory.getCurrentSession().update(entity);
		return entity;
	}

	public void delete(SessionFactory sessionFactory, Object entity, Integer entityId) {
		entity = sessionFactory.getCurrentSession().load(entity.getClass(), entityId);
		// TODO check this comment/* gaff au cast (Model) voir si �a marche, voir si �a
		// marche toutcours */
	}

}
