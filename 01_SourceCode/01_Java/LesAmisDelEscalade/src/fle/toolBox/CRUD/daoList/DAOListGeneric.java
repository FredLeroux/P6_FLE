package fle.toolBox.CRUD.daoList;

import java.util.List;

import javax.transaction.Transactional;

import fle.toolBox.classType.SLO;

@Transactional
public interface DAOListGeneric {
	
	public <L extends SLO> List<L> getInnerJoinList(L SLOClass);
	
	public <L extends SLO> List<L> getInnerJoinListI18N(L SLOClass);
	
	
}
