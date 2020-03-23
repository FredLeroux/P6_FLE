package fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique.IsUniqueGenericInterface;

/**
 * 
 * @author Frederic Leroux <br>
 *	@see {@link IsUniqueGenericInterface} and  {@link IsUniqueGenericInterface#columnElementsList(String, String)}
 */
@Repository
public class IsUniqueDaoImplemented implements IsUniqueDao {

	@Autowired
	SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	
	public List<Object> columnElementsList(String fieldName, String entityName) {
		@SuppressWarnings("unchecked")
		List<Object> columnElements = getSession().createQuery("SELECT T." + fieldName + " FROM " + entityName + " T")
				.getResultList();
		return columnElements;
	}

}
