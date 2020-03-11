package fle.toolBox.fieldsReflectivity;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
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

	private <A extends Annotation> boolean isPresence(Annotation annotation) {
		boolean isAnnotationPresence = true;
		if (annotation == null) {
			isAnnotationPresence = false;
		}
		return isAnnotationPresence;
	}

	/**
	 * 
	 * @param <A>
	 * @param field
	 * @param annotationClass
	 * @return true if field is annotated with annotationClass otherwise false
	 */
	public <A extends Annotation> boolean isAnnotationPresence(Field field, Class<A> annotationClass) {
		Annotation presence = field.getAnnotation(annotationClass);
		return isPresence(presence);
	}

	/**
	 * 
	 * @param <A>
	 * @param entity
	 * @param annotationClass
	 * @return true if classe is annotated with annotationClass otherwise false
	 */
	public <A extends Annotation> boolean isAnnotationPresence(O entity, Class<A> annotationClass) {
		Annotation presence = entity.getClass().getAnnotation(annotationClass);
		return isPresence(presence);
	}

	/**
	 * 
	 * @param <A>
	 * @param entity
	 * @param annotationClass
	 * @return true if classe is annotated with annotationClass otherwise false
	 */
	public <A extends Annotation> boolean isAnnotationPresence(Class<A> annotationClass) {
		Annotation presence = entityModel.getClass().getAnnotation(annotationClass);
		return isPresence(presence);
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
	 */
	public Field getFieldByIsName(String fieldName) {
		Field field = null;
		try {
			field = entityModel.getClass().getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return field;
	}

	/**
	 * 
	 * @return java.lang.reflect.Field array containing all declared entityModel
	 *         Fields
	 */
	public Field[] getAllFields() {
		Field[] allFields = null;
		allFields = entityModel.getClass().getDeclaredFields();
		return allFields;
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
	 */
	public <A extends Annotation> ArrayList<Field> fieldsArrayListByAnnotation(Class<A> annotationClass) {
		ArrayList<Field> fieldsArrayListByAnnotation = new ArrayList<>();
		for (Field field : getAllFields()) {
			if (isAnnotationPresence(field, annotationClass)) {
				fieldsArrayListByAnnotation.add(field);
			}
		}
		return fieldsArrayListByAnnotation;
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

	PropertyDescriptor propertyDesc(String fieldName) throws IntrospectionException {
		PropertyDescriptor propertyDesc = null;
		propertyDesc = new PropertyDescriptor(fieldName, entityModel.getClass());
		return propertyDesc;
	}

	public void fieldSetter(Field field, Object value) {
		Method fieldSetter = null;
		try {
			fieldSetter = propertyDesc(field.getName()).getWriteMethod();
		} catch (IntrospectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fieldSetter.invoke(entityModel, value);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fieldSetter(String fieldName, Object value) {
		Method fieldSetter = null;
		try {
			fieldSetter = propertyDesc(fieldName).getWriteMethod();
		} catch (IntrospectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fieldSetter.invoke(entityModel, value);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param field
	 * @return getter method using PropertyDescriptor
	 * @throws IntrospectionException
	 */
	Method fieldGetter(Field field) throws IntrospectionException {
		Method fieldGetter = null;
		fieldGetter = propertyDesc(field.getName()).getReadMethod();
		return fieldGetter;
	}

	/**
	 * 
	 * @param fieldName
	 * @return getter method using PropertyDescriptor
	 * @throws IntrospectionException
	 */
	Method fieldGetter(String fieldName) throws IntrospectionException {
		Method fieldGetter = null;
		fieldGetter = propertyDesc(fieldName).getReadMethod();
		return fieldGetter;
	}

	Method fieldGetterViaGetMethods(Field field) {
		Method[] methods = entityModel.getClass().getMethods();
		Method fieldGetter = null;
		for (Method met : methods) {
			if (met.getName().toLowerCase().contains("get" + field)) {
				fieldGetter = met;
			}
		}
		return fieldGetter;
	}

	/**
	 * 
	 * @param fieldName
	 * @return return getter method usin iteration on methods array
	 */
	Method fieldGetterViaGetMethods(String fieldName) {
		Method[] methods = entityModel.getClass().getMethods();
		Method fieldGetter = null;
		for (Method met : methods) {
			if (met.getName().toLowerCase().contains("get" + fieldName.toLowerCase())) {
				fieldGetter = met;
			}
		}

		return fieldGetter;
	}

	public Object getFieldValue(Field field) {
		Object value = null;
		try {
			value = fieldGetter(field).invoke(entityModel);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	public Object getFieldValue(String fieldName) {
		Object value = null;
		try {
			value = fieldGetter(fieldName).invoke(entityModel);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	public Object getFieldValueViaGetMethods(Field field) {
		Object value = null;
		try {
			value = fieldGetterViaGetMethods(field).invoke(entityModel);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 
	 * @param fieldName
	 * @return field value using field name
	 * @Note this method iterate through a Method array, to use if not setter
	 *       methods are present in target classe
	 */
	public Object getFieldValueViaGetMethods(String fieldName) {
		Object value = null;
		try {
			value = fieldGetterViaGetMethods(fieldName).invoke(entityModel);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
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
	 *       on classes(Enum) xhich not use setter method
	 * 
	 */
	public Object getFieldValueUltimate(String fieldName) {
		Object value = null;
		try {
			value = fieldGetter(fieldName).invoke(entityModel);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IntrospectionException e) {
			try {
				value = fieldGetterViaGetMethods(fieldName).invoke(entityModel);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return value;
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
	public Object getFieldValueUltimate(Field field) {
		Object value = null;
		try {
			value = fieldGetter(field).invoke(entityModel);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IntrospectionException e) {
			try {
				value = fieldGetterViaGetMethods(field).invoke(entityModel);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return value;
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
	 * allow to create an instance of class using the type of a field //TODO
	 * 2-Clarified
	 * 
	 * @param field
	 * @return
	 */
	public Object fieldTypeClassNewInstance(Field field) {
		return newInstance(field);
	}

	public Object fieldTypeClassNewInstance(String fieldName) {
		Field field = getFieldByIsName(fieldName);
		return newInstance(field);
	}

	private Object newInstance(Field field) {
		Object clazz = null;
		try {
			clazz = Class.forName(field.getType().getName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clazz;
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
