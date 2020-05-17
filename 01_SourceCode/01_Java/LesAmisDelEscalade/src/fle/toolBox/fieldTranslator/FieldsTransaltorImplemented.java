package fle.toolBox.fieldTranslator;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.dataListDisplayerTools.annotations.ToTranslate;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFields;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFieldsSetAndGet;

//TODO javaDOC
/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote For all declared class field @ToTranslate annotated allow to
 *          translate a field value usng MessageSource property key and so
 *          Internationlizing it Note : in prperties file if the opposite is
 *          present we can do the rever i.e. if key is true.ismember -> oui then
 *          if we add the opposite oui.ismember -> true we can go in both
 *          direction fron trad to not trad vice versa
 */
@Service
public class FieldsTransaltorImplemented implements FieldsTranslator {

	@Autowired
	private LocalMessage localMessage;

	private Class<ToTranslate> transalteAnnotation = ToTranslate.class;

//add suffix to field value
	public void translateFieldValue(Object entity) {
		
		for (Field field : fields(entity)) {
			ClassFieldsSetAndGet.setField(entity, field.getName(), localMessage.message(parseValue(field, entity)));
			System.out.println(field.getName());
			
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
