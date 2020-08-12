package fle.toolBox.fieldsReflectivity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

import fle.toolBox.IsAnnotationPresent;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFields;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFieldsSetAndGet;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.TypeField;

//TODO 1-JAVADOC
public class ExtractSetAndGetFields<O extends Object> {

	protected O entityModel = null;

	public ExtractSetAndGetFields(O entityModel) {
		this.entityModel = entityModel;
	}

	public ExtractSetAndGetFields() {

	}

	public O getEntityModel() {
		return entityModel;
	}

	public void setEntityModel(O entityModel) {
		this.entityModel = entityModel;
	}

	/**
	 *
	 * @param <A>
	 * @param field
	 * @param annotationClass
	 * @return true if field is annotated with annotationClass otherwise false
	 * @see com.fle.tools.IsAnnotationPresent
	 */
	public <A extends Annotation> boolean isAnnotationPresence(Field field, Class<A> annotationClass) {
		return IsAnnotationPresent.onField(field, annotationClass);
	}

	/**
	 *
	 * @param <A>
	 * @param entity
	 * @param annotationClass
	 * @return true if classe is annotated with annotationClass otherwise false
	 * @see com.fle.tools.IsAnnotationPresent
	 */
	public <A extends Annotation> boolean isAnnotationPresence(O entity, Class<A> annotationClass) {
		return IsAnnotationPresent.inClass(entity, annotationClass);
	}

	/**
	 *
	 * @param <A>
	 * @param entity
	 * @param annotationClass
	 * @return true if classe is annotated with annotationClass otherwise false
	 * @see com.fle.tools.IsAnnotationPresent
	 */
	public <A extends Annotation> boolean isAnnotationPresence(Class<A> annotationClass) {
		return IsAnnotationPresent.inClass(entityModel, annotationClass);
	}

	void fillArrayListWithFieldsName(ArrayList<Field> fieldsArrayList, ArrayList<String> fieldsNameArrayList) {
		for (Field field : fieldsArrayList) {
			fieldsNameArrayList.add(field.getName());
		}
	}

	/**
	 *
	 * @param fieldName
	 * @return a java.lang.reflect.Field using is simple name as a string
	 * @see com.fle.tools.fieldsManagement.finalVersion.extractSetAndGetComponents.ClassFields
	 */
	public Field getFieldByIsName(String fieldName) {
		return ClassFields.getFieldByIsName(entityModel, fieldName);
	}

	/**
	 *
	 * @return java.lang.reflect.Field array containing all declared entityModel
	 *         Fields
	 * @see com.fle.tools.fieldsManagement.finalVersion.extractSetAndGetComponents.ClassFields
	 */
	public Field[] getAllFields() {
		return ClassFields.getAllFields(entityModel);
	}

	/**
	 *
	 * @return java.lang.reflect.Field ArrayList containing all declared entityModel
	 *         Fields
	 */
	public ArrayList<Field> fieldsArrayList() {
		ArrayList<Field> fieldsArrayList = null;
		fieldsArrayList = new ArrayList<Field>(Arrays.asList(getAllFields()));
		return fieldsArrayList;
	}

	/**
	 *
	 * @param <A>
	 * @param annotationClass
	 * @return java.lang.reflect.Field ArrayList containing all declared entityModel
	 *         Fields annotated with annotationClass
	 * @see com.fle.tools.fieldsManagement.finalVersion.extractSetAndGetComponents.ClassFields
	 */
	public <A extends Annotation> ArrayList<Field> fieldsArrayListByAnnotation(Class<A> annotationClass) {
		return ClassFields.getFieldsListByAnnotation(entityModel, annotationClass);
	}

	/**
	 *
	 * @return java.lang.String ArrayList containing all declared entityModel Fields
	 *         name
	 */
	public ArrayList<String> fieldsNameArrayList() {
		ArrayList<String> fieldsNameArrayList = new ArrayList<>();
		fillArrayListWithFieldsName(fieldsArrayList(), fieldsNameArrayList);
		return fieldsNameArrayList;
	}

	public <A extends Annotation> ArrayList<String> fieldsNameArrayListByAnnotation(Class<A> annotationClass) {
		ArrayList<String> fieldsNameArrayListByAnnotation = new ArrayList<>();
		fillArrayListWithFieldsName(fieldsArrayListByAnnotation(annotationClass), fieldsNameArrayListByAnnotation);
		return fieldsNameArrayListByAnnotation;
	}

	public void fieldSetter(Field field, Object value) {
		ClassFieldsSetAndGet.setField(entityModel, field.getName(), value);
	}

	public void fieldSetter(String fieldName, Object value) {
		ClassFieldsSetAndGet.setField(entityModel, fieldName, value);
	}

	/**
	 *
	 * @param fieldName
	 * @return field value using is name <br>
	 *         step-1 : try to find getter via PropertyDescriptor if an exception is
	 *         rised<br>
	 *         step-2 : try to find getter via iteration through Methods array <br>
	 *         Rise IllegalAccessException | IllegalArgumentException |
	 *         InvocationTargetException if method no found
	 * @Note method created following issue when using method via PropertyDescriptor
	 *       on classes(Enum) which not use setter method
	 *
	 */
	public Object getFieldValue(String fieldName) {
		return ClassFieldsSetAndGet.getFieldValue(entityModel, fieldName);
	}

	/**
	 *
	 * @param fieldName
	 * @return field value using is name <br>
	 *         step-1 : try to find getter via PropertyDescriptor, if an exception
	 *         is rised<br>
	 *         step-2 : try to find getter via iteration through Methods array <br>
	 *         Rise IllegalAccessException | IllegalArgumentException |
	 *         InvocationTargetException if method not found
	 * @Note method created following issue when using method via PropertyDescriptor
	 *       on classes(Enum) hich not use setter method
	 *
	 */
	public Object getFieldValue(Field field) {
		return ClassFieldsSetAndGet.getFieldValue(entityModel, field.getName());
	}

	public String fieldType(Field field) {
		String fieldType = null;
		fieldType = field.getType().getSimpleName();
		return fieldType;
	}

	public Class<?> fieldType(String fieldName) {
		Class<?> fieldType = null;
		fieldType = getFieldByIsName(fieldName).getType();
		return fieldType;
	}

	public String fieldTypeName(String fieldName) {
		String fieldType = null;
		fieldType = getFieldByIsName(fieldName).getType().getSimpleName();
		return fieldType;
	}

	public LinkedHashMap<String, Object> getFieldNameWhithValueMap() {
		LinkedHashMap<String, Object> fieldNameWithValueMap = new LinkedHashMap<>();
		for (String fieldName : fieldsNameArrayList()) {
			String key = fieldName;
			Object value = getFieldValue(fieldName);
			fieldNameWithValueMap.put(key, value);
		}
		return fieldNameWithValueMap;
	}

	public LinkedHashMap<String, Object> getFieldNameWhithValueMap(ArrayList<String> fieldNameList) {
		LinkedHashMap<String, Object> fieldNameWithValueMap = new LinkedHashMap<>();
		for (String fieldName : fieldNameList) {
			String key = fieldName;
			Object value = getFieldValue(fieldName);
			fieldNameWithValueMap.put(key, value);
		}
		return fieldNameWithValueMap;
	}

	public LinkedHashMap<String, Object> getFieldNameWhithValueMapAllClassFields() {
		LinkedHashMap<String, Object> fieldNameWithValueMap = new LinkedHashMap<>();
		for (String fieldName : fieldsNameArrayList()) {
			String key = fieldName;
			Object value = getFieldValue(fieldName);
			fieldNameWithValueMap.put(key, value);
		}
		return fieldNameWithValueMap;
	}

	public <A extends Annotation> LinkedHashMap<String, Object> getFieldNameWhithValueMapByAnnotation(
			Class<A> annotationClass) {
		LinkedHashMap<String, Object> fieldNameWithValueMap = new LinkedHashMap<>();
		for (String fieldName : fieldsNameArrayListByAnnotation(annotationClass)) {
			String key = fieldName;
			Object value = getFieldValue(fieldName);
			fieldNameWithValueMap.put(key, value);
		}
		return fieldNameWithValueMap;
	}

	/**
	 *
	 * @param entity
	 * @return a new instance of the entity class
	 */
	@SuppressWarnings("unchecked")
	public O newEntityInstance(O entity) {
		O newEntityInstance = null;
		;
		try {
			newEntityInstance = (O) entity.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newEntityInstance;

	}

	/**
	 * allow to create an instance of class using the type of a field
	 * @param field
	 * @return
	 */
	public Object fieldTypeClassNewInstance(Field field) {
		return TypeField.newInstance(field);
	}

	public Object fieldTypeClassNewInstance(String fieldName) {
		return TypeField.newInstance(entityModel, fieldName);
	}

	/**
	 *
	 * @param field
	 * @return a new ExtractSetAndGetFieldsV1 setted with a class type field new
	 *         instance
	 */
	public ExtractSetAndGetFields<Object> fieldClassTypeExtractor(Field field) {
		Object clazz = fieldTypeClassNewInstance(field);
		ExtractSetAndGetFields<Object> newExtractor = new ExtractSetAndGetFields<Object>(clazz);
		return newExtractor;
	}

	public ExtractSetAndGetFields<Object> fieldClassTypeExtractor(Object clazz) {

		ExtractSetAndGetFields<Object> newExtractor = new ExtractSetAndGetFields<Object>(clazz);
		return newExtractor;
	}

}
