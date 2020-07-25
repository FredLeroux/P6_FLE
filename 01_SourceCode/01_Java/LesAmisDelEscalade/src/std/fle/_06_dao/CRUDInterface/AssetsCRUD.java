package std.fle._06_dao.CRUDInterface;



import javax.transaction.Transactional;

import fle.toolBox.classType.DTO;
import fle.toolBox.classType.ENT;

@Transactional
public interface AssetsCRUD<E extends ENT, D extends DTO> {

	public E getEntityById(Integer id);

	public D getDTOByID(Integer id);
}
