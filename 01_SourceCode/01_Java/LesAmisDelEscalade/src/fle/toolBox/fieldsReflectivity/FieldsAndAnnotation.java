package fle.toolBox.fieldsReflectivity;

import java.lang.annotation.Annotation;
//TODO 1-JAVADOC
public class FieldsAndAnnotation<O extends Object> extends ExtractSetAndGetFields<O> {

	public FieldsAndAnnotation() {

	}

	public FieldsAndAnnotation(O entityModel) {
		super(entityModel);
	}

	@Override
	public O getEntityModel() {
		return super.getEntityModel();
	}

	@Override
	public void setEntityModel(O entityModel) {
		super.setEntityModel(entityModel);
	}

	public <A extends Annotation> A fieldAnnotationByFieldName(String fieldName, Class<A> annotationClass) {
		A fieldAnnotationClass = getFieldByIsName(fieldName).getAnnotation(annotationClass);
		return fieldAnnotationClass;

	}

}
