package fle.toolBox.fieldsReflectivity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * 
 * @author Frederic Leroux <br>
 *
 * @param <O> Class which have as fields entities classes.<br>
 *            O class has to contain entities fields annotated
 *            "@AssociatedEntityModel"(custom annotation)<br>
 *            Entities have to contains fields annotated "@Column" with name
 *            value setted.
 * @see {@link FieldsAndAnnotation}
 * 
 */
public class AssociatedModelManagement<O extends Object> extends FieldsAndAnnotation<O> {

	public AssociatedModelManagement(O entityModel) {
		super(entityModel);
		// TODO Auto-generated constructor stub
	}

	public <A extends Annotation> LinkedHashMap<Field, ArrayList<Field>> associatedModelFields(Class<A> annotationClass) {
		LinkedHashMap<Field, ArrayList<Field>> modelsFields = new LinkedHashMap<>();
		for (Field classField : fieldsArrayList()) {			
			modelsFields.put(classField, fieldClassTypeExtractor(classField).fieldsArrayListByAnnotation(annotationClass));
		}		
		return modelsFields;
	}
	
	private void iterateThroughValue(Field key, ArrayList<Field> value,ArrayList<String> modelsFieldsNames,boolean withEntitiesNames) {
		for(Field field:value) {
			fillArrayList(entityName(key, withEntitiesNames), field.getName(), modelsFieldsNames);
		}
	}

	public <A extends Annotation> ArrayList<String> AssociatedModelFieldsName(Class<A> annotationClass,
			boolean withEntitiesNames) {
		ArrayList<String> modelsFieldsNames = new ArrayList<>();
		associatedModelFields(annotationClass).forEach(
				(key, value) -> iterateThroughValue(key, value, modelsFieldsNames, withEntitiesNames));
		return modelsFieldsNames;
	}

	

	// TODO 0-Urgent change name causse this method allow to use associated model or
	// not non c pas vrai mais comme elle extends fau trouver unb autre nom plus
	// generique car on peut tou gerer a partir de la
	public ArrayList<String> AssociatedModelFieldsName(boolean withEntitiesNames) {
		ArrayList<String> modelsFieldsNames = new ArrayList<>();
		for (Field classField : fieldsArrayList()) {
			for (String entityFieldName : fieldClassTypeExtractor(classField).fieldsNameArrayList()) {
				fillArrayList(entityName(classField, withEntitiesNames), entityFieldName, modelsFieldsNames);
			}
		}
		return modelsFieldsNames;
	}

	public ArrayList<Field> getAllAssociatedModelsFields() {
		ArrayList<Field> modelsFields = new ArrayList<>();
		for (Field classField : fieldsArrayList()) {
			for (Field entityField : fieldClassTypeExtractor(classField).getAllFields()) {
				modelsFields.add(entityField);
			}
		}
		return modelsFields;
	}

	private String entityName(Field classField, boolean withEntitiesNames) {
		String entityName = withEntitiesNames ? classField.getName() : null;
		return entityName;
	}

	private void fillArrayList(String entityName, String entityFieldName, ArrayList<String> list) {
		if (entityName != null) {
			list.add(entityName + "." + entityFieldName);
		} else {
			list.add(entityFieldName);
		}
	}

}
