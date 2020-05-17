package fle.toolBox.springFormManager.selectInputManagement.annotationManagement;

import java.lang.reflect.Field;

import fle.toolBox.fieldsReflectivity.AssociatedModelManagement;
import fle.toolBox.fieldsReflectivity.ExtractSetAndGetFields;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import fle.toolBox.springFormManager.annotations.entityModelAssociation.EntityModelAssociation;



public abstract class SelectInputBasis{

	protected Class<EntityModelAssociation> entityModelAssociation = EntityModelAssociation.class;
	protected Class<SelectInputType> selectInputAnnotation = SelectInputType.class;
	protected AssociatedModelManagement<Object> fieldManager = null;

	

	
	

	protected AssociatedModelManagement<Object> getFieldManager() {
		return fieldManager;
	}

	protected void setFieldManager(Object entityModel) {
		this.fieldManager = new AssociatedModelManagement<Object>(entityModel);
	}

	
	/**
	 * 
	 * @return true if Object O(entityModel) contains EntityModelAssociation annotation otherwise false 
	 */
	protected boolean isAssociatedModel() {
		return fieldManager.isAnnotationPresence(entityModelAssociation);
	}
	
	
	/**
	 * 
	 * @param fOI   = field Of Interest is a class type field
	 * @param clazz is the value of fOI
	 * @return different ExtractSetAndGetFields&lt;O&gt; instanciated Class, in function of need<br>
	 *         - if register data use an empty class(field) to set an empty value of
	 *         the selectlist<br>
	 *         - if edit/update data use a filled class(clazz) to set the value of
	 *         the selectList
	 */
	protected ExtractSetAndGetFields<Object> extract(Field fOI) {
		ExtractSetAndGetFields<Object> extract = null;
		Object clazz = fieldManager.getFieldValue(fOI);
		if (clazz == null) {
			extract = fieldManager.fieldClassTypeExtractor(fOI);
		} else {
			extract = fieldManager.fieldClassTypeExtractor(clazz);
		}
		return extract;
	}
	
	
	
	
/**
 * 
 * @param fOI field of interest SelectInputType annotated 
 * @return SelectInputType annotation, null if fOI is not annotated with SelectInputType
 */
	protected SelectInputType getAnnotation(Field fOI) {
		return fOI.getAnnotation(SelectInputType.class);
	}

	
	
	
	
}
