package std.fle._05_CRUDInterface;

import javax.transaction.Transactional;

import fle.toolBox.classType.DTO;
import fle.toolBox.classType.ENT;
import fle.toolBox.classType.SFC;

@Transactional
public interface ModelsCRUD<E extends ENT,D extends DTO,S extends SFC> {
	
	public E getEntityById(Integer id);

	public D getDTOByID(Integer id);
	
	public E postTransactionTreatment(S SFCClass);

	public void save(E entity);
	
	

}
