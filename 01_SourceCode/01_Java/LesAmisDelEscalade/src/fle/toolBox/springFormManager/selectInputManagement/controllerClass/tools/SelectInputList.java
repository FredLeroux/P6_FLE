package fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import fle.toolBox.EnumToJSONArray;
import fle.toolBox.classType.DTO;
import fle.toolBox.fieldsReflectivity.ExtractSetAndGetFields;
import fle.toolBox.springFormManager.selectInputManagement.annotationManagement.SelectInputBoolean;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.selectInputService.SelectInputService;
//TODO 1-JAVADOC
public class SelectInputList extends SelectInputBoolean {

	@Autowired
	SelectInputService selectService;
	
	

	protected <S extends SelectOptionsInterface> ArrayList<S> getSelectOptionsList(Field field) {		
		if (isSourceTypeEnum(field)) {
			return enumToList(field);
		} else {
			return dataBaseTableToList(field);
		}

	}

	
	private <E extends Enum<E>, S extends SelectOptionsInterface> ArrayList<S> enumToList(Field field) {		
		Class<E> enumClass = enumClass(field);
		return  EnumToJSONArray.enumConstantObject(enumClass);
	}

	protected <S extends SelectOptionsInterface> ArrayList<S> dataBaseTableToList(Field field) {
		return selectInputListConverter(field);
	}

	private <D extends DTO> ExtractSetAndGetFields<D> extract(D dto) {
		return new ExtractSetAndGetFields<D>(dto);
	}

	private <D extends DTO> Object fieldValue(D dto, String fieldName) {
		
		return extract(dto).getFieldValue(fieldName);
	}

	private <D extends DTO> SelectOptions selectOptionMapper(D dto, String valueFieldName,
			String displayValueFieldName) {
		String value = String.valueOf(fieldValue(dto, valueFieldName));
		String displayValue = String.valueOf(fieldValue(dto, displayValueFieldName));
		SelectOptions select = new SelectOptions(value, displayValue);
		return select;
	}

	protected <D extends DTO> List<D> selectInputDTOList(Field field) {
		return selectService.selectInputDTOList(getQuery(field), dtoClass(field));
	}
	
	private String getQuery(Field field) {
		return " FROM ".concat(entityClassName(field)); 
	}

	@SuppressWarnings("unchecked")
	private <S extends SelectOptionsInterface> ArrayList<S> selectInputListConverter(Field field) {		
		String value = optionValueFieldName(field);
		String displayValue = optionDisplayValueFieldName(field);
		return (ArrayList<S>) selectInputDTOList(field).stream().map(d -> selectOptionMapper(d, value, displayValue))
				.collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	protected <S extends SelectOptionsInterface> ArrayList<S> selectInputListConverter(Field field, List<DTO> list) {
		String value = optionValueFieldName(field);
		String displayValue = optionDisplayValueFieldName(field);
		return (ArrayList<S>) list.stream().map(d -> selectOptionMapper(d, value, displayValue))
				.collect(Collectors.toList());
	}

}
