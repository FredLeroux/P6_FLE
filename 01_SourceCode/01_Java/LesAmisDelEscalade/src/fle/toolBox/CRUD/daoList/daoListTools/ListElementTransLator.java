package fle.toolBox.CRUD.daoList.daoListTools;

import java.util.List;

public interface ListElementTransLator {
	
	public<O extends Object> List<O> listI18N(List<O> list);

}
