package fle.toolBox.CRUD.daoList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.daoList.daoListTools.ListElementTransLator;
import fle.toolBox.CRUD.daoList.daoListTools.ParseListObjectArrayToListObject;
import fle.toolBox.classType.SLO;

@Repository
public class DAOListGenericImplemented implements DAOListGeneric {

	@Autowired
	ParseListObjectArrayToListObject listParser;

	@Autowired
	ListElementTransLator translator;

	
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
	
	
	

	

}
