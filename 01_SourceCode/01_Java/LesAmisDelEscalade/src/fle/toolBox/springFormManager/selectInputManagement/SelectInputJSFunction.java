package fle.toolBox.springFormManager.selectInputManagement;

import java.lang.reflect.Field;

import fle.toolBox.fieldsReflectivity.ExtractSetAndGetFields;
import fle.toolBox.javaScriptGenerator.JavaScriptBuilder;
import fle.toolBox.springFormManager.selectInputManagement.annotationManagement.SelectInputBoolean;
import fle.toolBox.springFormManager.selectInputManagement.javascriptFunctions.selectOptions.JsFunctionSelectOptions;

public class SelectInputJSFunction<O extends Object> extends SelectInputBoolean {

	private JavaScriptBuilder JSBuilder = new JavaScriptBuilder();
	private JsFunctionSelectOptions selectJs = new JsFunctionSelectOptions();
	// private String splitter = MessageSourceAssets.SPLITTER.toString();
	// private String defaultValue = MessageSourceAssets.DEFAULT_VALUE.toString();

	public void addSelectInputJSFunction(O COI, StringBuilder stringBuilder, String formName) {
		String entityName = null;
		setFieldManager(COI);
		JSBuilder.openScript(stringBuilder);
		stringBuilder.append(selectJs.selectJSFunctions());
		if (isAssociatedModel()) {
			for (Field field : fieldManager.getAllFields()) {
				entityName = getEntityName(field);
				ExtractSetAndGetFields<Object> extract = extract(field);
				for (Field subField : extract.fieldsArrayListByAnnotation(selectInputAnnotation)) {
					addSelectInputOptions(entityName, subField, stringBuilder);
					;
					addSelectOnchangeAttribute(stringBuilder, entityName, subField, extract, formName);
				}
			}
		} else {
			for (Field field : fieldManager.fieldsArrayListByAnnotation(selectInputAnnotation)) {
				entityName = getEntityName(field);
				addSelectInputOptions(entityName, field, stringBuilder);
				addSelectOnchangeAttribute(stringBuilder, entityName, field, getFieldManager(), formName);
				;
			}
		}
		JSBuilder.closeScript(stringBuilder);
	}

	private void addSelectOnchangeAttribute(StringBuilder stringBuilder, String entityName, Field fOI,
			ExtractSetAndGetFields<Object> extract, String formName) {
		if (isDependentFieldName(fOI)) {
			String formAction = filteringAction(fOI);
			String dependentListName = getDependentSelectListName(extract, fOI);
			selectJs.addSelectOnchangeAttribute(stringBuilder, entityName, fOI, formName, formAction,
					dependentListName);
			;
		}
	}

	private String getDependentSelectListName(ExtractSetAndGetFields<Object> extract, Field fOI) {
		return selectListName(dependentField(extract, fOI));
	}

	private void addSelectInputOptions(String entityName, Field field, StringBuilder stringBuilder) {
		String selectDefaultValue = defaultValue(field);
		String selectSplitter = splitter(field);
		String listVarName = selectListName(field);
		String fieldName = field.getName();
		String valueToSetVarName = getAnnotation(field).selectValueName();
		JSBuilder.addVarsFromModel(stringBuilder, listVarName);
		JSBuilder.addVarsFromModel(stringBuilder, valueToSetVarName);
		selectJs.addSelectOptionsListAndValue(stringBuilder, entityName, selectDefaultValue, selectSplitter,
				listVarName, fieldName, valueToSetVarName);
	}
//TODO 1-JAVADOC to clarify
	/**
	 * 
	 * @param fOI
	 * @return in case of associated model entityName is the name of the class type
	 *         field i.e if a class is an association containing Alpha alpha abd
	 *         Beta beta entitynames will be alpha and beta and each field of for
	 *         example alpha will be identified in form as follow
	 *         alpha.alphafieldName so we have entityName.fieldName
	 */
	private String getEntityName(Field fOI) {

		if (isAssociatedModel()) {
			return fOI.getName();
		} else {
			return "none";
		}
	}
}
