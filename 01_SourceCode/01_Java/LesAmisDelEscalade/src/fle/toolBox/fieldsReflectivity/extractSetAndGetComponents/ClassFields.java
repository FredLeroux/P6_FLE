package fle.toolBox.fieldsReflectivity.extractSetAndGetComponents;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

import fle.toolBox.IsAnnotationPresent;


/**
 *
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote Allow to get :<br>
 * <li> a Field Array {@link #getAllFields(Object)}.
 * <li> a Field by is name {@link #getFieldByIsName(Object, String)}
 * <li> a Field ArrayList by annotation {@link #getFieldsListByAnnotation(Object, Class)}
 */
public class ClassFields {

	/**
	 *
	 * @param cOI the Class Of Interest
	 * @return a Field array containings all cOI declared fields
	 */
	public static final Field[] getAllFields(Object cOI) {
		return cOI.getClass().getDeclaredFields();
	}
	/**
	 *
	 * @param cOI the Class Of Interest
	 * @param fieldName the name of the wished field
	 * @return a Field corresponding to the field name in cOI
	 */
	public static final Field getFieldByIsName(Object cOI, String fieldName) {
		Field field = null;
		try {
			field=  cOI.getClass().getDeclaredField(fieldName);
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		return field;
	}
	/**
	 *
	 * @param <A>  extends {@link java.lang.annotation.Annotation}
	 * @param cOI  the Class of Interest
	 * @param annotationClass the annotation.class to check on field
	 * @return a Field ArrayList containing only annotation.class annotated cOI Fields
	 */
	public static final<A extends Annotation> ArrayList<Field> getFieldsListByAnnotation(Object cOI,Class<A> annotationClass){
		ArrayList<Field> fieldsListByAnnotation = new ArrayList<>();
		for(Field field: getAllFields(cOI)) {
			if(IsAnnotationPresent.onField(field, annotationClass)) {
				fieldsListByAnnotation.add(field);
			}
		}
		return fieldsListByAnnotation;
	}



}
