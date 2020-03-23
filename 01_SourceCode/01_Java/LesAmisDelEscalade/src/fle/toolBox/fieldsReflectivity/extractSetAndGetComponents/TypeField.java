package fle.toolBox.fieldsReflectivity.extractSetAndGetComponents;

import java.lang.reflect.Field;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote Allow to create a Class new instance of a field type.<br>
 * <li> By using directly the target Field or his Name.
 *
 */
public class TypeField {
	
	public static final Object newInstance(Field field) {
		return classTypeNewInstance(field);
	}
	
	public static final Object newInstance(Object cOI,String fieldName) {
		Field field = ClassFields.getFieldByIsName(cOI, fieldName);
		return classTypeNewInstance(field);
	}
	
	private static Object classTypeNewInstance(Field fOI) {
		Object clazz = null;
		try {
			clazz = Class.forName(fOI.getType().getName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clazz;
	}

}
