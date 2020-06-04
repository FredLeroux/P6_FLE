package fle.toolBox.fieldTranslator;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.dataListDisplayerTools.annotations.ToTranslate;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFields;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFieldsSetAndGet;



@Service
public class FieldsTransaltorImplemented implements FieldsTranslator {

	@Autowired
	private LocalMessage localMessage;

	private Class<ToTranslate> transalteAnnotation = ToTranslate.class;

//add suffix to field value
	@Override
	public void translateFieldValue(Object entity) {
		
		for (Field field : fields(entity)) {
			ClassFieldsSetAndGet.setField(entity, field.getName(), localMessage.message(parseValue(field, entity)));
			
			
		}
	}
	

	private ArrayList<Field> fields(Object entity) {
		return ClassFields.getFieldsListByAnnotation(entity, transalteAnnotation);
	}

	private String suffix(Field field) {
		return field.getAnnotation(transalteAnnotation).suffix();
	}

	private String fieldValue(Field field, Object cOI) {
		return (String) ClassFieldsSetAndGet.getFieldValue(cOI, field.getName());
	}

	private String parseValue(Field field, Object cOI) {		
		return fieldValue(field, cOI).concat(suffix(field));
	}



}
