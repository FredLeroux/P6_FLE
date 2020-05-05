package fle.toolBox.CRUD.daoList.daoListTools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.TypeNotConfiguredException;
import fle.toolBox.FredParser;
import fle.toolBox.CRUD.tools.HibernateSession;
import fle.toolBox.dateAndTime.FredDateTimeFormatter;
import fle.toolBox.dateAndTime.annotation.DateTimeRawFormat;
import fle.toolBox.fieldsReflectivity.ExtractSetAndGetFields;

@Service
public class ParseListObjectArrayToListObjectImplemented implements ParseListObjectArrayToListObject {	
	
	
	@Autowired
	HibernateSession hibernate;

	
	@Override
	@SuppressWarnings("unchecked")
	public<O extends Object> List<O> namedQueryParsedList(O joinClass) {		
		List<O> parsedList = (List<O>) queryList(joinClass).stream().map(o -> streamParser(o, joinClass)).collect(Collectors.toList());
		return parsedList;
	}
	
	
	@SuppressWarnings("unchecked")
	private<O extends Object> List<Object[]> queryList(O joinClass){
		return hibernate.session().createNamedQuery(joinClass.getClass().getSimpleName())
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	private<O extends Object> Object streamParser(Object[] object, O entityDto) {
		ExtractSetAndGetFields<O> fieldManager = new ExtractSetAndGetFields<>();
		Object dtoNewInstance = fieldManager.newEntityInstance(entityDto);
		fieldManager.setEntityModel((O) dtoNewInstance);
		ArrayList<Field> fields = fieldManager.fieldsArrayList();
		for (int i = 0; i < fields.size(); i++) {
			Field field = fields.get(i);
			fieldManager.fieldSetter(field, fieldTypeParse(field, object[i]));
		}
		return dtoNewInstance;
	}

	private Object fieldTypeParse(Field field, Object valueToParse) {
		Object value = null;
		String type = fieldTypeToString(field);		
		if (type.equals("string")) {			
			if(field.getAnnotation(DateTimeRawFormat.class) != null) {								
				value = FredDateTimeFormatter.date(field, valueToParse.toString());
			}else {
			value = valueToParse.toString();}
		} else if (type.equals("boolean")) {
			value = FredParser.asBoolean(valueToParse);
		}else {
			try {
				value = FredParser.numericParser(type, valueToParse.toString());
			} catch (TypeNotConfiguredException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	private String fieldTypeToString(Field field) {
		return field.getType().getSimpleName().toLowerCase().toString();
	}
}
