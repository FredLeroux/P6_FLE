package fle.toolBox.springFormManager.selectInputManagement.controllerClass.selectInputDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.classType.DTO;
import fle.toolBox.classType.ENT;
import fle.toolBox.classType.SFC;
import fle.toolBox.fieldsReflectivity.ExtractSetAndGetFields;
import fle.toolBox.modelConverter.ModelConverter;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectOptions;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectOptionsInterface;



@Repository
public class SelectInputDAOImpl implements SelectInputDAO {
	private ModelConverter converter = new ModelConverter();

	@Autowired
	SessionFactory sessionFactory;
	
	
	
	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	
	private <T extends ENT, D extends DTO> List<D> entityListToDTOListConverter(List<T> entityList, D dto) {
		List<D> dtoList = entityList.stream().map(e -> converter.convertEntityToDTO(e, dto))
				.collect(Collectors.toList());
		return dtoList;
	}

	private <D extends DTO, S extends SFC> List<S> dtoListToSFCListConverter(List<D> dtoList, S sfc) {	
		List<S> sfcList = dtoList.stream().map(d -> converter.convertDTOToSFC(d, sfc))
				.collect(Collectors.toList());
		return sfcList;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public <T extends ENT> List<T> tableRawData(String query) {
		List<T> entityList = session().createQuery(query).getResultList();		
		return entityList;
	}
	

	@Override
	public <T extends ENT, D extends DTO> List<D> selectInputDTOList(List<T> entityList, D dto) {
		return entityListToDTOListConverter(entityList, dto);
	}

	@Override
	public <T extends ENT, D extends DTO> List<D> selectInputDTOList(String query, D dto) {
		List<T> entityList = tableRawData(query);
		return entityListToDTOListConverter(entityList, dto);
	}

	@Override
	public <D extends DTO, S extends SFC> List<S> selectInputSFCList(List<D> dtoList, S sfc) {
		return dtoListToSFCListConverter(dtoList, sfc);
	}

	@Override
	public <T extends ENT, D extends DTO, S extends SFC> List<S> selectInputSFCList(String query, D dto, S sfc) {
		List<T> entityList = tableRawData(query);
		List<D> dtoList = entityListToDTOListConverter(entityList, dto);
		return dtoListToSFCListConverter(dtoList, sfc);
	}
	@Override
	public <T extends ENT> ArrayList<SelectOptionsInterface> selectInputOptionsList(String query,
			String valueFieldName, String displayValueFieldName) {
		List<T> entityList = tableRawData(query);
		ArrayList<SelectOptionsInterface> list = (ArrayList<SelectOptionsInterface>) entityList.stream()
				.map(t -> selectOptionMapper(t, valueFieldName, displayValueFieldName)).collect(Collectors.toList());
		return list;
	}

	private <T extends ENT> ExtractSetAndGetFields<T> extract(T entity) {
		return new ExtractSetAndGetFields<T>(entity);
	}

	private <T extends ENT> Object fieldValue(T entity, String fieldName) {
		return extract(entity).getFieldValue(fieldName);
	}

	private <T extends ENT> SelectOptionsInterface selectOptionMapper(T entity, String valueFieldName,
			String displayValueFieldName) {
		String value = String.valueOf(fieldValue(entity, valueFieldName));
		String displayValue = String.valueOf(fieldValue(entity, displayValueFieldName));
		return new SelectOptions(value, displayValue);
	}

}
