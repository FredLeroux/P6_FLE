package fle.toolBox.springFormManager.builder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import fle.toolBox.IsAnnotationPresent;
import fle.toolBox.exceptionsThrower.ExceptionsThrower;
import fle.toolBox.fieldsReflectivity.AssociatedModelManagement;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.PassWordField;
import fle.toolBox.springFormManager.annotations.PlaceHolderText;
import fle.toolBox.springFormManager.annotations.ReadOnlyInput;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import fle.toolBox.springFormManager.annotations.entityModelAssociation.EntityModelAssociation;
import fle.toolBox.springFormManager.builder.annotationsManagement.SpringFormSettingsAnnotation;
import fle.toolBox.springFormManager.builder.annotationsManagement.SpringFormSettingsAnnotationData;
import fle.toolBox.springFormManager.builder.configurationClass.SpringFormCssConfig;
import fle.toolBox.springFormManager.builder.tagLibraries.spring.SpringTagFormular;

public class SpringFormStringBuilder<O extends Object> extends SpringTagFormular {

	private Class<SelectInputType> selectAnnotation = SelectInputType.class;
	private Class<HiddenPath> hiddenPathAnnotation = HiddenPath.class;
	private Class<PlaceHolderText> placeHolderAnnotation = PlaceHolderText.class;
	private Class<EntityModelAssociation> entityModelAssociation = EntityModelAssociation.class;
	private Class<ReadOnlyInput> readOnlyInputAnnotation = ReadOnlyInput.class;
	private Class<PassWordField> passWordAnnotation = PassWordField.class;
	private AssociatedModelManagement<O> fieldManager = null;
	private O entityModel;
	private ArrayList<String> fieldsNamesList = new ArrayList<>();
	private ArrayList<String> fieldsNamesListlabel = new ArrayList<>();
	private StringBuilder stringBuilder = new StringBuilder();
	private boolean isFieldSetInForm = false;
	private String action = null;
	private String method = null;
	private String modelAttribut = null;
	private String formName = null;
	private boolean readOnly = false;
	private String formButtonMessage = null;
	private String formButtonAlignment = null;
	private String labelMessageSourceSuffix = null;
	private String lineBreak = "<br>";
	private SpringFormCssConfig springFormCssConfig = null;
	private SpringFormSettingsAnnotation formsettings = new SpringFormSettingsAnnotation();

	private boolean associatedModel;

	public SpringFormStringBuilder(O entityModel) {
		fieldManager = new AssociatedModelManagement<O>(entityModel);
		this.associatedModel = fieldManager.isAnnotationPresence(entityModel, entityModelAssociation);
		this.entityModel = entityModel;
		if (!associatedModel) {
			fieldsNamesList = fieldManager.fieldsNameArrayList();
			fieldsNamesListlabel = fieldsNamesList;
		} else {
			fieldsNamesList = fieldManager.AssociatedModelFieldsName(true);
			fieldsNamesListlabel = new ArrayList<>(fieldManager.AssociatedModelFieldsName(false));
		}

	}

	public ArrayList<SpringRawFormular> springRawFormulars() {
		ArrayList<SpringRawFormular> springFormular = new ArrayList<>();
		for (SpringFormSettingsAnnotationData data : formsettings.formSettingArray(entityModel)) {
			stringBuilder = new StringBuilder();
			setFormData(data);
			springFormTags();
			springFormParameters();
			linkToStyleSheet();
			formStart();
			for (int i = 0; i < fieldsNamesList.size(); i++) {
				String fieldName = fieldsNamesList.get(i);
				addField(i, fieldName, data.isReadOnly());
			}
			addButton();
			formEnd();
			springFormular.add(new SpringRawFormular(data.getJspFilePath(), data.getFormName(), stringBuilder));
		}
		return springFormular;

	}

	private String input(String fieldName, boolean readOnly) {
		String input = null;
		if (readOnly == false) {
			LinkedHashMap<String, String> placeHolder = placeHolderAnnotatedFieldMap();
			if (placeHolder.containsKey(fieldName)) {
				input = inputCssClassCssErrorClassTagMessagePlaceHolder(fieldName, placeHolder.get(fieldName));
			} else {
				input = inputCssClassCssErrorClass(fieldName);
			}
		} else {
			input = inputCssClassCssErrorClassReadOnly(fieldName);
		}
		return input;
	}

	private String label(String fieldName, int i) {
		String path = fieldName;
		String labelName = fieldsNamesListlabel.get(i);
		String label = labelCssClassCssErrorClass(path, message(labelName.concat(labelMessageSourceSuffix)));
		return label;
	}

	private String error(String fieldName) {
		return errors(fieldName);
	}

	/**
	 * 
	 * @param <A>
	 * @param annotationClass
	 * @return a string array list containing all fields annotated whith
	 *         annotationClass<br>
	 *         this method will manage simple classe as well as associated classes
	 */
	<A extends Annotation> ArrayList<String> annotatedFieldList(Class<A> annotationClass) {
		boolean entityName = true;
		Class<A> annotation = (Class<A>) annotationClass;
		ArrayList<String> annotatedFieldList = new ArrayList<>();
		if (associatedModel) {
			annotatedFieldList = fieldManager.AssociatedModelFieldsName(annotation, entityName);
		} else {
			for (Field field : fieldManager.fieldsArrayListByAnnotation(annotation)) {
				annotatedFieldList.add(field.getName());
			}
		}
		return annotatedFieldList;
	}

//TODO 1-JAVADOC add javadoc cette method extrai dans un hasmap en clef le nom du chanp et en valuer le message a mettre dans le place holder
	private LinkedHashMap<String, String> placeHolderAnnotatedFieldMap() {
		LinkedHashMap<String, String> annotatedFieldMap = new LinkedHashMap<>();
		for (Field field : fieldManager.getAllFields()) {
			if (associatedModel) {
				for (Field clazzField : fieldManager.fieldClassTypeExtractor(field)
						.fieldsArrayListByAnnotation(placeHolderAnnotation)) {
					annotatedFieldMap.put(field.getName() + "." + clazzField.getName(),
							clazzField.getAnnotation(placeHolderAnnotation).message());
				}
			} else {
				if (IsAnnotationPresent.onField(field, placeHolderAnnotation)) {
					annotatedFieldMap.put(field.getName(), field.getAnnotation(placeHolderAnnotation).message());
				}
			}
		}
		return annotatedFieldMap;
	}

	private <A extends Annotation> ArrayList<String> selectFieldList() {
		ArrayList<String> selectFieldList = new ArrayList<>();
		selectFieldList = annotatedFieldList(selectAnnotation);
		return selectFieldList;
	}

	private <A extends Annotation> ArrayList<String> hiddenPathFieldList() {
		ArrayList<String> hiddenPathFieldList = new ArrayList<>();
		hiddenPathFieldList = annotatedFieldList(hiddenPathAnnotation);
		ExceptionsThrower.ifEmpty(hiddenPathFieldList);
		return hiddenPathFieldList;
	}

	private <A extends Annotation> ArrayList<String> readOnlyInputFieldList() {
		ArrayList<String> readOnlyInputFieldList = new ArrayList<>();
		readOnlyInputFieldList = annotatedFieldList(readOnlyInputAnnotation);
		return readOnlyInputFieldList;
	}

	private <A extends Annotation> ArrayList<String> passWordInputFieldList() {
		ArrayList<String> passWordInputFieldList = new ArrayList<>();
		passWordInputFieldList = annotatedFieldList((passWordAnnotation));
		return passWordInputFieldList;
	}

	private void springFormParameters() {
		setStyleSheetPath(springFormCssConfig.getStyleSheetPath());
		setCssFileName(springFormCssConfig.getCssFileName());
		setLabelCssClass(springFormCssConfig.getLabelStyle());
		setLabelCssErrorClass(springFormCssConfig.getLabelErrorStyle());
		setInputCssClass(springFormCssConfig.getInputStyle());
		setInputCssErrorClass(springFormCssConfig.getInputStyleError());
		setSelectCssClass(springFormCssConfig.getSelectStyle());
		setSelectCssErrorClass(springFormCssConfig.getSelectStyleError());
		setErrorsCssClass(springFormCssConfig.getErrorStyle());
		setButtonCssClass(springFormCssConfig.getButtonStyle());

	}

	private void addCell(String component) {
		stringBuilder.append(tableCellStart());
		stringBuilder.append(component);
		stringBuilder.append(tableCellEnd());
	}

	private void springFormTags() {
		stringBuilder.append(tagLibForms());
		stringBuilder.append(taglibTags());
	}

	private void linkToStyleSheet() {
		stringBuilder.append(addLinkedStyleSheet());
	}

	private void formStart() {
		if (readOnly) {
			action = "none";
			method = "get";
		}
		stringBuilder.append(formHeader(action, method, modelAttribut, formName));
		stringBuilder.append(tableStart());
	}

	private void formEnd() {
		stringBuilder.append(tableEnd());
		stringBuilder.append(formClose());
		stringBuilder.append(lineBreak);
		stringBuilder.append(lineBreak);
		stringBuilder.append(lineBreak);
	}

	private void addHiddenPath(String fieldName) {
		if (hiddenPathFieldList().contains(fieldName)) {
			addCell(hiddenPath(fieldName));
			fieldSetInFormIsTrue();
		}
	}

	private void addSelectField(String fieldName) {
		if (selectFieldList().contains(fieldName)) {
			addCell(selectCssClassCssErrorClass(fieldName, formName));
			fieldSetInFormIsTrue();
		}
	}

	private void addReadOnlyInputField(String fieldName) {
		if (readOnlyInputFieldList().contains(fieldName)) {
			addCell(input(fieldName, true));
			fieldSetInFormIsTrue();
		}
	}

	private void addPassWordInputField(String fieldName) {
		if (passWordInputFieldList().contains(fieldName)) {
			LinkedHashMap<String, String> placeHolder = placeHolderAnnotatedFieldMap();
			if (placeHolder.containsKey(fieldName)) {
				addCell(passWordCssClassCssErrorClassTagMessagePlaceHolder(fieldName, placeHolder.get(fieldName)));
			} else {
				addCell(passWordCssClassCssErrorClass(fieldName));
			}
			fieldSetInFormIsTrue();
		}
	}

	private void addField(int i, String fieldName, boolean readOnly) {

		stringBuilder.append(tableRowStart());
		addHiddenPath(fieldName);
		if (!isFieldSetInForm) {
			addCell(label(fieldName, i));
			addSelectField(fieldName);
			addReadOnlyInputField(fieldName);
			addPassWordInputField(fieldName);
			if (!isFieldSetInForm) {
				addCell(input(fieldName, readOnly));
			}
			addCell(error(fieldName));
			stringBuilder.append(tableRowEnd());
		}
		fieldSetInFormIsFalse();

	}

	private void addButton() {
		if (!readOnly) {
			stringBuilder.append(tableRowStart());
			stringBuilder.append(tableCellStartWithColSpan(3, formButtonAlignment));
			stringBuilder.append(inputButton(formButtonMessage));
			stringBuilder.append(tableCellEnd());
			stringBuilder.append(tableRowEnd());
		}
	}

	private void setFormData(SpringFormSettingsAnnotationData data) {
		formName = data.getFormName();
		action = data.getAction();
		method = data.getMethod();
		modelAttribut = data.getModelAttribute();
		readOnly = data.isReadOnly();
		labelMessageSourceSuffix = data.getLabelMessageSourceSuffix();
		formButtonMessage = data.getButtonMessage();
		formButtonAlignment = data.getButtonAlignment();

	}

	public void setSpringFormCssConfig(SpringFormCssConfig springFormCssConfig) {
		this.springFormCssConfig = springFormCssConfig;
	}

	private void fieldSetInFormIsTrue() {
		isFieldSetInForm = true;
	}

	private void fieldSetInFormIsFalse() {
		isFieldSetInForm = false;
	}

}
