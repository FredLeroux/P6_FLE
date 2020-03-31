package fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import fle.toolBox.classType.DTO;
import fle.toolBox.fieldsReflectivity.ExtractSetAndGetFields;

//TODO 0-Find another name more explicit
//TODO 1-JAVADOC
public class SelectInputLinkedListObject {

	private Field field;
	private String listName;
	private String relationShipField;
	private String relationShipFieldFilter;
	private List<DTO> list;

	public SelectInputLinkedListObject(Field field, String listName, String relationShipField, String relationShipFieldFilter,
			List<DTO> list) {
		super();
		this.field = field;
		this.listName = listName;
		this.relationShipField = relationShipField;
		this.relationShipFieldFilter = relationShipFieldFilter;
		this.list = list;

	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getMasterFieldName() {
		return relationShipField;
	}

	public void setJoinMasterdName(String joinFieldName) {
		this.relationShipField = joinFieldName;
	}

	public String getFilterByFieldName() {
		return relationShipFieldFilter;
	}

	public void setFilterByFieldName(String filterByFieldName) {
		this.relationShipFieldFilter = filterByFieldName;
	}

	public List<DTO> getList() {
		return list;
	}

	public void setList(List<DTO> list) {
		this.list = list;
	}


	public List<DTO> getFilterdListEqualsTo(Integer criterion) {
		List<DTO> listFiltered = list.stream()
				.filter(dto ->equalsCriterion(criterion,dto))
				.collect(Collectors.toList());		
		return listFiltered;
	}
	
	public List<DTO> getFilterdListGreaterThan(Integer criterion) {
		List<DTO> listFiltered = list.stream()
				.filter(dto ->greaterThanCriterion(criterion,dto))
				.collect(Collectors.toList());		
		return listFiltered;
	}
	
	public List<DTO> getFilterdListLessThan(Integer criterion) {
		List<DTO> listFiltered = list.stream()
				.filter(dto ->lessThanCriterion(criterion,dto))
				.collect(Collectors.toList());		
		return listFiltered;
	}
	
	
	/**
	 * 
	 * @param <D>
	 * @param clazz
	 * @param relationShipField
	 * @param relationShipFieldFilter
	 * @return the integer FilterByFieldName value of the masterField 
	 */
	private <D extends DTO> Integer getFilterValue(D clazz, String masterFieldName, String filterByFieldName
			) {
		ExtractSetAndGetFields<D> clazzManager = new ExtractSetAndGetFields<D>(clazz);
		Object component = clazzManager.getFieldValue(masterFieldName);
		ExtractSetAndGetFields<Object> componentManager = new ExtractSetAndGetFields<Object>(component);
		Integer value = (Integer) componentManager.getFieldValue(filterByFieldName);
		return value;
	}
	
	private boolean equalsCriterion( Integer criterion,DTO clazz){		
		return getFilterValue(clazz, relationShipField, relationShipFieldFilter).compareTo(criterion) == 0;
	}
	
	private boolean greaterThanCriterion( Integer criterion,DTO clazz){		
		return getFilterValue(clazz, relationShipField, relationShipFieldFilter).compareTo(criterion) > 0;
	}
	
	private boolean lessThanCriterion( Integer criterion,DTO clazz){		
		return getFilterValue(clazz, relationShipField, relationShipFieldFilter).compareTo(criterion) < 0;
	}

	

	

}
