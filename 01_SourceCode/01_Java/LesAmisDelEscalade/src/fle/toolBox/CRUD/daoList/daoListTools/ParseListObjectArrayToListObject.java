package fle.toolBox.CRUD.daoList.daoListTools;

import java.util.List;

public interface ParseListObjectArrayToListObject {
	
	/**
	 * 	 
	 * @param joinClass the class to parse the Object[]
	 * @return parse a list of Object array to a list of an Object joinClass of interest as
	 *         per example a DTO or a SLO, to be use on a INNER JOIN named query in joinClass with name
	 *         = joinClass.getClass.getSimpleName.
	 */
	public<O extends Object> List<O> namedQueryParsedList(O joinClass);
	
	

}
