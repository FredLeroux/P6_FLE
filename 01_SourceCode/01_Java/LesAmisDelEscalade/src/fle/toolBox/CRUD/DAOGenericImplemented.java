package fle.toolBox.CRUD;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.classType.DTO;
import fle.toolBox.classType.ENT;
import fle.toolBox.classType.SFC;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFieldsSetAndGet;
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
	public<DA extends DTO> DA getSpecificsValue(String fieldName, String condition, E entity, DTO toGet) {
		Query query = session().createQuery(
				"FROM " + entity.getClass().getName() 
				+ " T WHERE T." + fieldName 
				+ "=" + hibernateQueryArg(condition));
		E newEntity = (E) query.getSingleResult();
		return (DA) converter.convertEntityToDTO(newEntity, toGet);
	}

}
