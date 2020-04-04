package fle.toolBox.CRUD;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.classType.DTO;
import fle.toolBox.classType.ENT;
import fle.toolBox.classType.SFC;
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
	public E getEntityByID(E entity, Integer id) {
		return (E) session().get(entity.getClass(), id);
	}

	@Override
	public D getDtoByID(E entity, D dtoClass, Integer id) {
		return (D) converter.convertEntityToDTO(getEntityByID(entity, id), dtoClass);
	}

	public void save(E entity) {
		session().save(entity);
	}

	public void saveEntity(ENT entity) {
		session().save(entity);
	}

	public void saveDTO(E entity, D dtoClass) {
		save((E) converter.convertDTOToEntity(dtoClass, entity));
	}

	public void saveSFC(E entity, D dtoClass, SFC sfcClass) {
		save((E) converter.convertDTOToEntity(converter.converSFCToDTO(sfcClass, dtoClass), entity));
	}
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public <SD extends DTO> SD getSpecificDTOWhereCondition(String fieldName, String condition, E entity, SD specificDTOClass) {
		Query query = session().createQuery(
				"FROM " + entity.getClass().getName() + " T WHERE T." + fieldName + "=" + hibernateQueryArg(condition));
		E newEntity = (E) query.getSingleResult();
		return (SD) converter.convertEntityToDTO(newEntity, specificDTOClass);
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
	public D getDTOByForeignerKey(String fieldName, Integer foreignerKey, E entity,DTO DTOClass) {
		return (D) converter.convertEntityToDTO(getEntityByForeignerKey(fieldName, foreignerKey, entity), DTOClass);
	}

	@Override
	public <SD extends DTO> SD getSpecificDTOById(E entity, SD specificDTOClass,Integer id) {		
		return converter.convertEntityToDTO(getEntityByID(entity, id), specificDTOClass);
	}
	@Override
	public void update(E entity) {
		session().merge(entity);
	}
	@Override
	public void updateDTO(E entity, D DTOCLass) {
		session().update(converter.convertDTOToEntity(DTOCLass, entity));
	}
	@Override
	public<S extends SFC> void updateSFC(E entity, D DTOCLass, S SFCCLass) {
		session().update(converter.convertDTOToEntity(converter.converSFCToDTO(SFCCLass, DTOCLass), entity));
	}

}
