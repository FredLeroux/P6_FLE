package fle.toolBox.springFormManager.builder.annotationsManagement;

import java.util.ArrayList;

import fle.toolBox.exceptionsThrower.ExceptionsThrower;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;



/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote as SpringFormSettings annotation is repeatable, this class allow to
 *          generate an ArrayList of SpringSettingsAnnotationData for
 *          each @springFormSettings present in entityModel
 * @see {@link SpringFormSettingsAnnotationData }
 */
public  class SpringFormSettingsAnnotation {

	private Class<SpringFormSettings> springFormSettings = SpringFormSettings.class;

	/**
	 * 
	 * @param annotation is the annotation containing all usefull data in order to
	 *                   set a springForm
	 * @param entityModel is a annotated with one or many @SpringFormSettings class
	 * @return an ArrayList containing all @SpringFormSettings data parsed as
	 *         SpringFormSettingsAnnotationData class
	 * @see {@link SpringFormSettingsAnnotationData }
	 */
	public ArrayList<SpringFormSettingsAnnotationData> formSettingArray(Object entityModel) {
		ArrayList<SpringFormSettingsAnnotationData> formSettingArray = new ArrayList<>();
		for (SpringFormSettings setting : formHeaderSettingsAnnotation(entityModel)) {
			formSettingArray.add(springFormAnnotationData(setting));
		}
		return formSettingArray;
	}

	private SpringFormSettings[] formHeaderSettingsAnnotation(Object entityModel) {
		SpringFormSettings[] annotationsArray = entityModel.getClass().getAnnotationsByType(springFormSettings);
		ExceptionsThrower.ifNull(annotationsArray);
		return annotationsArray;
	}

	private String formName(SpringFormSettings annotation) {
		return annotation.name();
	}

	private String action(SpringFormSettings annotation) {
		return annotation.action();
	}

	private String method(SpringFormSettings annotation) {
		return annotation.method();
	}

	private String modelAttribute(SpringFormSettings annotation) {
		return annotation.modelAttribute();
	}

	private String submitButtonMessagePropertyKey(SpringFormSettings annotation) {
		return annotation.submitButtonMessagePropertyKey();
	}

	private String submitButtonAlignmentPropertyKey(SpringFormSettings annotation) {
		return annotation.submitButtonAlignmentPropertyKey();
	}

	private boolean readOnly(SpringFormSettings annotation) {
		return annotation.readOnly();
	}

	private String labelMessageSourceSuffix(SpringFormSettings annotation) {
		return annotation.labelMessageSourceSuffix();
	}

	private String jspFilePath(SpringFormSettings annotation) {
		return annotation.jspFilePath();
	}

	private String propertiesFilePath(SpringFormSettings annotation) {
		return annotation.propertiesFilePath();
	}
	
	

	private SpringFormSettingsAnnotationData springFormAnnotationData(SpringFormSettings annotation) {
		SpringFormSettingsAnnotationData data = new SpringFormSettingsAnnotationData();
		data.setConfigFile(propertiesFilePath(annotation));
		data.setFormName(formName(annotation));
		data.setAction(action(annotation));
		data.setMethod(method(annotation));
		data.setModelAttribute(modelAttribute(annotation));
		data.setReadOnly(readOnly(annotation));
		data.setSubmitButtonMessage(data.getConfigFile().getProperty(submitButtonMessagePropertyKey(annotation)));
		data.setSubmitButtonAlignment(data.getConfigFile().getProperty(submitButtonAlignmentPropertyKey(annotation)));		
		data.setLabelMessageSourceSuffix(data.getConfigFile().getProperty(labelMessageSourceSuffix(annotation)));
		data.setJspFilePath(jspFilePath(annotation));
		return data;

	}

}
