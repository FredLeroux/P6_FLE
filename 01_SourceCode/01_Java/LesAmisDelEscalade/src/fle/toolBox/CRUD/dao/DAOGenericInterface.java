package fle.toolBox.CRUD.dao;

import java.util.List;

import javax.transaction.Transactional;

import fle.toolBox.classType.DTO;
import fle.toolBox.classType.ENT;
import fle.toolBox.classType.SFC;
import fle.toolBox.classType.SLO;
import fle.toolBox.modelConverter.ModelConverter;

@Transactional
public interface DAOGenericInterface<E extends ENT, D extends DTO> {

	public ModelConverter converter();

	public E getEntityByID(E entity, Integer id);

	public D getDtoByID(E entity, D dtoClass, Integer id);

	public void save(E entity);

	public void saveEntity(ENT entity);

	public void saveDTO(E entity, D dtoClass);

	public void saveSFC(E entity, D dtoClass, SFC sfcClass);

	public void update(E entity);

	public void updateDTO(E entity, D DTOClass);

	public <SD extends DTO> void updateSpecificDTO(E entity, SD DTOClass);

	public <S extends SFC> void updateSFC(E entity, D DTOCLass, S SFCCLass);

	public <SD extends DTO> SD getSpecificDTOById(E entity, SD specificDTOClass, Integer id);
	
	public<O extends Object> List<O> getEntityData(O entity);

	public D getDTOWhereCondition(String fieldName, String condition, E entity, D DTOClass);

	/**
	 * 
	 * @param <DA>
	 * @param fieldName        the fieldName to search on
	 * @param condition        the value that fieldName has to meet
	 * @param entity           the origin
	 * @param specificDTOClass the specific DTO to return
	 * @return allow to return a specific DTO filled with entity value obtained on
	 *         fieldName Where condition<br>
	 *         For a DTO "PassDTO" conatining only "password" for an entity
	 *         "LogEntity" containing "login" and "password" if <br>
	 *         fieldname = "login" condition = "alpha" entity = "LogEntity"
	 *         specificDTOClass = "PassDTO" return "PassDTO.password" =
	 *         "LogEntity.password" where "LogEntity.login" = "alpha"
	 * 
	 */
	public <SD extends DTO> SD getSpecificDTOWhereCondition(String fieldName, String condition, E entity,
			SD specificDTOClass);

	/**
	 * 
	 * @param <DA>
	 * @param fieldName        the fieldName to search on
	 * @param condition        the value that fieldName has to meet
	 * @param entity           the origin wich are other than the parametized One
	 * @param specificDTOClass the specific DTO to return
	 * @return allow to return a specific DTO filled with entity value obtained on
	 *         fieldName Where condition<br>
	 *         For a DTO "PassDTO" conatining only "password" for an entity
	 *         "LogEntity" containing "login" and "password" if <br>
	 *         fieldname = "login" condition = "alpha" entity = "LogEntity"
	 *         specificDTOClass = "PassDTO" return "PassDTO.password" =
	 *         "LogEntity.password" where "LogEntity.login" = "alpha"
	 * 
	 */
	public <SE extends ENT, SD extends DTO> SD getSpecificEntitySpecificDTOWhereCondition(String fieldName,
			String condition, SE entity, SD specificDTOClass);

	/**
	 * 
	 * @param fieldName
	 * @param foreignerKey
	 * @param entity
	 * @return only one entity where fieldname is equals to foreignerkey, allow to
	 *         retrieve an entity using a column foreignerKey as example:<br>
	 *         for a userService having as foreignerkey address_id we can retrieve
	 *         the userService via the adress id .
	 */
	public E getEntityByForeignerKey(String fieldName, Integer foreignerKey, E entity);

	/**
	 * 
	 * @param fieldName
	 * @param foreignerKey
	 * @param entity
	 * @param DTOClass
	 * @return converted to DTOClass an entity generated via
	 *         {@link #getEntityByForeignerKey(String, Integer, ENT)}
	 */
	public D getDTOByForeignerKey(String fieldName, Integer foreignerKey, E entity, DTO DTOClass);

	/**
	 * 
	 * @param fieldName
	 * @param foreignerKey
	 * @param entity
	 * @param SpecificDTOClass other than the one parametized
	 * @return converted to DTOClass an entity generated via
	 *         {@link #getEntityByForeignerKey(String, Integer, ENT)}
	 */
	public <SD extends DTO> SD getSpecificDTOByForeignerKey(String fieldName, Integer foreignerKey, E entity,
			SD SpecificDTOClass);

	public <L extends SLO> List<L> getList(SLO joinClass);
	
	public void deleteById(Object toDelete,Integer id);
	
	public void removeByID(E entity,Integer id);
}
