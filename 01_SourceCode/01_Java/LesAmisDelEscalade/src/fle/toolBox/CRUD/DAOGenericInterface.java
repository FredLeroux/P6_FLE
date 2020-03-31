package fle.toolBox.CRUD;

import javax.transaction.Transactional;

import fle.toolBox.classType.DTO;
import fle.toolBox.classType.ENT;
import fle.toolBox.modelConverter.ModelConverter;

@Transactional
public interface DAOGenericInterface<E extends ENT, D extends DTO> {

	public ModelConverter converter();

	public E getEntityByID(E entity, Integer id);

	public D getDtoByID(E entity, D dtoClass, Integer id);

	public void save(E entity);

	public void saveEntity(ENT entity);
	
	public<DA extends DTO> DA getSpecificsValue(String fieldName, String condition, E entity, DTO toGet);

}
