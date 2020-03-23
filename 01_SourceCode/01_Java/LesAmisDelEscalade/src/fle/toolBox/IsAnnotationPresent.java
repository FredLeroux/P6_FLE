package fle.toolBox;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote Check if an annotation is present :<br>
 *          <li>in Class {@link #inClass(Object, Class)}
 */
public class IsAnnotationPresent {
	/**
	 * 
	 * @param annotation
	 * @return true if annotation is != null esle false
	 */
	private static boolean isPresent(Annotation annotation) {
		return annotation != null;
	}

	/**
	 * 
	 * @param <A>             extends {@link java.lang.annotation.Annotation}
	 * @param cOI             the Class Of Interest.
	 * @param annotationClass the annotation.class to check presence.
	 * @return true if annotation is present in cOI else false.
	 */
	public static final <A extends Annotation> boolean inClass(Object cOI, Class<A> annotationClass) {
		return isPresent(cOI.getClass().getAnnotation(annotationClass));
	}

	/**
	 * 
	 * @param <A>             extends {@link java.lang.annotation.Annotation}
	 * @param fOI             the Field Of Interest.
	 * @param annotationClass the annotation.class to check presence
	 * @return true if annotation is present on fOI else false.
	 */
	public static final <A extends Annotation> boolean onField(Field fOI, Class<A> annotationClass) {
		return isPresent(fOI.getAnnotation(annotationClass));
	}

}
