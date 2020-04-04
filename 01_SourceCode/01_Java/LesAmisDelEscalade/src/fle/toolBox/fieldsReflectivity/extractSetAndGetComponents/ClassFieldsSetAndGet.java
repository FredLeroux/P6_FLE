package fle.toolBox.fieldsReflectivity.extractSetAndGetComponents;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassFieldsSetAndGet {

	public static  void setField(Object cOI, String fieldName, Object value) {
		Method fieldSetter = propertyDesc(cOI, fieldName).getWriteMethod();
		try {
			fieldSetter.invoke(cOI, value);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static  Object getFieldValue(Object cOI, String fieldName) {
		Object value = null;
		try {
			value = fieldGetter(cOI, fieldName).invoke(cOI);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			try {
				value = fieldGetterViaGetMethods(cOI, fieldName).invoke(cOI);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return value;
	}

	private static Method fieldGetter(Object cOI, String fieldName) {
		return propertyDesc(cOI, fieldName).getReadMethod();
	}

	public static Method fieldGetterViaGetMethods(Object cOI, String fieldName) {
		Method[] methods = cOI.getClass().getMethods();
		Method fieldGetter = null;
		for (Method methode : methods) {
			if (methode.getName().toLowerCase().contains("get" + fieldName)) {
				fieldGetter = methode;
			}
		}
		return fieldGetter;
	}

	private static PropertyDescriptor propertyDesc(Object cOI, String fieldName) {
		PropertyDescriptor propertyDesc = null;
		try {
			propertyDesc = new PropertyDescriptor(fieldName, cOI.getClass());
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertyDesc;
	}

}
