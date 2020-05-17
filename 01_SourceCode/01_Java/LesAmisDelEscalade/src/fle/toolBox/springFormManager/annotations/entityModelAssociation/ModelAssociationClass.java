package fle.toolBox.springFormManager.annotations.entityModelAssociation;

import fle.toolBox.IsAnnotationPresent;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote allow to determinate if a Class is @EntityModelAssociation
 *          annotated.
 * @see {@link#check(Object)} , {@link com.fle.tools.IsAnnotationPresent}
 */
public class ModelAssociationClass {

	/**
	 * 
	 * @param cOI the Class Of Interest to check @EntityModelAssociation presence.
	 * @return <b>If</b> a Class is annotated <b>@EntityModelAssociation</b><br>
	 *         return <b>true</b><br>
	 *         else <b>false</b>.
	 */
	public static final boolean check(Object cOI) {
		return IsAnnotationPresent.inClass(cOI, EntityModelAssociation.class);
	/*	if (cOI.getClass().getAnnotation(EntityModelAssociation.class) != null) {
			return true;
		} else {
			return false;
		}*/
	}
}
