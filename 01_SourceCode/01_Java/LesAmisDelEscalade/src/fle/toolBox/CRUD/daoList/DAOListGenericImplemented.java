package fle.toolBox.CRUD.daoList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.daoList.daoListTools.ListElementTransLator;
import fle.toolBox.CRUD.daoList.daoListTools.ParseListObjectArrayToListObject;
import fle.toolBox.classType.SLO;

@Repository
public class DAOListGenericImplemented implements DAOListGeneric {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ParseListObjectArrayToListObject listParser;

	@Autowired
	private ListElementTransLator translator;

	
	@Override
	public <L extends SLO> List<L> getInnerJoinList(L SLOClass) {
		return  listParser.namedQueryParsedList(SLOClass);
	}

	@Override
	public <L extends SLO> List<L> getInnerJoinListI18N(L SLOClass) {		
		List<L> toTrad = null;
		toTrad = getInnerJoinList(SLOClass);
		return translator.listI18N(toTrad);
	}
	
	@Override
	public<L extends SLO> List<L> getInnerJoinListById(L SLOClass,String namedQueryParameter, Integer id ){
		return listParser.namedQueryWithIdParameterParsedList(SLOClass, namedQueryParameter, id);
	}
	
	@Override
	public<L extends SLO> List<L> getInnerJoinListByIdI18N(L SLOClass,String namedQueryParameter, Integer id){
		List<L> toTrad = null;
		toTrad = getInnerJoinListById(SLOClass, namedQueryParameter, id);
		return translator.listI18N(toTrad);
	}
	/**
	 * 
	 * @param <O> 
	 * @param entity the Hibernate entity representing db table
	 * @param clause the entity field representing the db column
	 * @param value the value to search on clause (db column)
	 * @return a list of entity where clause = value
	 */
	@SuppressWarnings("unchecked")
	@Override
	public<O extends Object> List<O> getListOfObjectWhere(O entity,String clause,Object value){
		return session().createQuery("FROM "+ entity.getClass().getName() +" T WHERE T."+clause +"=" + value).getResultList();
	}
	
	@Override
	public<O extends Object> List<O> getI18NListOfObjectWhere(O entity,String clause,Object value){
		return translator.listI18N(getListOfObjectWhere(entity, clause, value));
	}
	
	
	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	

}
