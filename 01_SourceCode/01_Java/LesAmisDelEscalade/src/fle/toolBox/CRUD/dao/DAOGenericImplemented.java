package fle.toolBox.CRUD.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.PatternMatcher;
import fle.toolBox.CRUD.daoList.daoListTools.ParseListObjectArrayToListObjectImplemented;
import fle.toolBox.classType.DTO;
import fle.toolBox.classType.ENT;
import fle.toolBox.classType.SFC;
import fle.toolBox.classType.SLO;
import fle.toolBox.modelConverter.ModelConverter;

@Repository
class DAOGenericImplemented<E extends ENT, D extends DTO> implements DAOGenericInterface<E, D> {

	@Autowired
	SessionFactory sessionFactory;

	private ModelConverter converter = new ModelConverter();

	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	private String hibernateQueryArg(String asQueryArg) {
		return "'" + asQueryArg + "'";
	}

	@Override
	public ModelConverter converter() {
		return converter;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getEntityById(E entity, Integer id) {
		return (E) session().get(entity.getClass(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public<SE extends Object> SE getSpecificEntityById(SE entity, Integer id) {
		return (SE) session().get(entity.getClass(), id);
	}



	@Override
	public D getDtoByID(E entity, D dtoClass, Integer id) {
		entity = getEntityById(entity, id);
		D dto = converter.convertEntityToDTO(entity, dtoClass);
		return dto;
	}

	@Override
	public void save(E entity) {
		session().save(entity);
	}

	@Override
	public void saveEntity(ENT entity) {
		session().save(entity);
	}

	@Override
	public void saveDTO(E entity, D dtoClass) {
		save(converter.convertDTOToEntity(dtoClass, entity));
	}
	@SuppressWarnings("unchecked")
	@Override
	public<SE extends Object,SD extends Object> void saveSpecificDTO(SE entityClass, SD DTOClass) {
		SD dto = (SD) converter().convertSourceToDestinationType(DTOClass, entityClass);
		session().save(dto);

	}

	@Override
	public void saveSFC(E entity, D dtoClass, SFC sfcClass) {
		save(converter.convertDTOToEntity(converter.convertSFCToDTO(sfcClass, dtoClass), entity));
	}



	@Override
	public void update(E entity) {
		session().merge(entity);
	}

	@Override
	public void updateDTO(E entity, D DTOClass) {
		session().merge(converter.convertDTOToEntity(DTOClass, entity));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <SD extends DTO> SD getSpecificDTOWhereCondition(String fieldName, String condition, E entity,
			SD specificDTOClass) {
		E newEntity = (E) query(fieldName, condition, entity).getSingleResult();
		return converter.convertEntityToDTO(newEntity, specificDTOClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <SE extends ENT, SD extends DTO> SD getSpecificEntitySpecificDTOWhereCondition(String fieldName,
			String condition, SE entity, SD specificDTOClass) {
		SE newEntity = (SE) query(fieldName, condition, entity).getSingleResult();
		return converter.convertEntityToDTO(newEntity, specificDTOClass);
	}

	@Override
	@SuppressWarnings("unchecked")
	public E getEntityByForeignerKey(String fieldName, Integer foreignerKey, E entity) {
		Query query = session()
				.createQuery("FROM " + entity.getClass().getName() + " T WHERE T." + fieldName + "=" + foreignerKey);
		return (E) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public D getDTOByForeignerKey(String fieldName, Integer foreignerKey, E entity, DTO DTOClass) {
		return (D) converter.convertEntityToDTO(getEntityByForeignerKey(fieldName, foreignerKey, entity), DTOClass);
	}

	@Override
	public <SD extends DTO> SD getSpecificDTOByForeignerKey(String fieldName, Integer foreignerKey, E entity,
			SD SpecificDTOClass) {
		return converter.convertEntityToDTO(getEntityByForeignerKey(fieldName, foreignerKey, entity),
				SpecificDTOClass);
	}

	@Override
	public <SD extends DTO> SD getSpecificDTOById(E entity, SD specificDTOClass, Integer id) {
		return converter.convertEntityToDTO(getEntityById(entity, id), specificDTOClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <SE extends ENT,SD extends DTO> SD getSpecificEntitySpecificDTOById(SE entity, SD specificDTOClass, Integer id) {
		return (SD) converter.convertSourceToDestinationType(getSpecificEntityById(entity, id), specificDTOClass);
	}

	@Override
	public <S extends SFC> void updateSFC(E entity, D DTOCLass, S SFCCLass) {
		session().merge(converter.convertDTOToEntity(converter.convertSFCToDTO(SFCCLass, DTOCLass), entity));
	}

	@Override
	public <SD extends DTO> void updateSpecificDTO(E entity, SD DTOClass) {
		session().merge(converter.convertDTOToEntity(DTOClass, entity));

	}

	@SuppressWarnings("unchecked")
	@Override
	public D getDTOWhereCondition(String fieldName, String condition, E entity, D DTOClass) {
		E newEntity = (E) query(fieldName, condition, entity).getSingleResult();
		return converter.convertEntityToDTO(newEntity, DTOClass);
	}


	@SuppressWarnings("unchecked")
	@Override
	public<O extends Object> List<O> getEntityData(O entity){
		return session().createQuery("SELECT FROM "+ entity.getClass().getSimpleName()).getResultList();
	}

	//TODO CHECK IF IT IS NEEDED
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getList(SLO joinClass) {
		ParseListObjectArrayToListObjectImplemented parser = new ParseListObjectArrayToListObjectImplemented();
		return parser.namedQueryParsedList(joinClass);
	}
	@Override
	public void deleteById(Object toDelete,Integer id) {
		session().createQuery("DELETE FROM "+toDelete.getClass().getSimpleName()+ " T WHERE T.id = "+id ).executeUpdate();
	}

	@Override
	public void removeByID(E entity,Integer id) {
		session().remove(getEntityById(entity, id));
	}

	private Query query(String fieldName,String condition, Object entity) {
		Query query = null;
		if (PatternMatcher.isMatch("^[\\d]*$", condition)) {
			query = session().createQuery("FROM " + entity.getClass().getName() + " T WHERE T." + fieldName + "="
					+ hibernateQueryArg(condition));
		} else {
			query = session().createQuery("FROM " + entity.getClass().getName() + " T WHERE LOWER(T." + fieldName
					+ ")=LOWER(" + hibernateQueryArg(condition) + ")");
		}
		return query;
	}

}
