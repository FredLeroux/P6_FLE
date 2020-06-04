package fle.toolBox.springFormManager.builder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

import fle.toolBox.FredParser;
import fle.toolBox.IsAnnotationPresent;
import fle.toolBox.exceptionsThrower.ExceptionsThrower;
import fle.toolBox.fieldsReflectivity.AssociatedModelManagement;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.PassWordField;
import fle.toolBox.springFormManager.annotations.PlaceHolderText;
import fle.toolBox.springFormManager.annotations.ReadOnlyInput;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import fle.toolBox.springFormManager.annotations.actionButtons.SpringFormActionButton;
import fle.toolBox.springFormManager.annotations.entityModelAssociation.EntityModelAssociation;
import fle.toolBox.springFormManager.annotations.inputTextArea.InputTextArea;
import fle.toolBox.springFormManager.builder.annotationsManagement.InputTextAreaAnnotation;
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
	private Class<InputTextArea> texteAreaAnnotation = InputTextArea.class;
	private Class<SpringFormActionButton> actionButtonAnnotation = SpringFormActionButton.class;
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
			addButton(data.getFormName());
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
			input = inputCssClassReadOnly(fieldName);
		}
		return input;
	}

	private String label(String fieldName, int i) {

		String path = fieldName;
		String labelName = fieldsNamesListlabel.get(i);
		if (actionButtonFieldMap().containsKey(fieldName)) {
			return actionButtonLabelCssClass(message(labelName.concat(labelMessageSourceSuffix)));
		}
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
	 *         this method will manager simple classe as well as associated classes
	 */
	private <A extends Annotation> ArrayList<String> annotatedFieldNameList(Class<A> annotationClass) {
		boolean entityName = true;
		Class<A> annotation = annotationClass;
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

	private LinkedHashMap<String, InputTextAreaAnnotation> InputTextAreaAnnotationFieldMap() {
		LinkedHashMap<String, InputTextAreaAnnotation> annotatedFieldMap = new LinkedHashMap<>();
		for (Field field : fieldManager.getAllFields()) {
			if (associatedModel) {
				for (Field clazzField : fieldManager.fieldClassTypeExtractor(field)
						.fieldsArrayListByAnnotation(texteAreaAnnotation)) {
					annotatedFieldMap.put(field.getName() + "." + clazzField.getName(),
							inputTextAreaAnnotation(clazzField));
				}
			} else {
				if (IsAnnotationPresent.onField(field, texteAreaAnnotation)) {
					annotatedFieldMap.put(field.getName(), inputTextAreaAnnotation(field));
				}
			}
		}
		return annotatedFieldMap;
	}

	private LinkedHashMap<String, String> actionButtonFieldMap() {
		LinkedHashMap<String, String> annotatedFieldMap = new LinkedHashMap<>();
		for (Field field : fieldManager.getAllFields()) {
			if (associatedModel) {
				for (Field clazzField : fieldManager.fieldClassTypeExtractor(field)
						.fieldsArrayListByAnnotation(actionButtonAnnotation)) {
					annotatedFieldMap.put(field.getName() + "." + clazzField.getName(),
							clazzField.getAnnotation(actionButtonAnnotation).displayMessagePropertyKey());
				}
			} else {
				if (IsAnnotationPresent.onField(field, actionButtonAnnotation)) {
					annotatedFieldMap.put(field.getName(),
							field.getAnnotation(actionButtonAnnotation).displayMessagePropertyKey());
				}
			}
		}
		return annotatedFieldMap;
	}

	private InputTextAreaAnnotation inputTextAreaAnnotation(Field clazzField) {
		InputTextArea fieldInputTextArea = clazzField.getAnnotation(texteAreaAnnotation);
		return new InputTextAreaAnnotation(fieldInputTextArea.rows(), fieldInputTextArea.charByRows(),
				fieldInputTextArea.readOnly());
	}

	private <A extends Annotation> ArrayList<String> selectFieldList() {
		ArrayList<String> selectFieldList = new ArrayList<>();
		selectFieldList = annotatedFieldNameList(selectAnnotation);
		return selectFieldList;
	}

	private <A extends Annotation> ArrayList<String> hiddenPathFieldList() {
		ArrayList<String> hiddenPathFieldList = new ArrayList<>();
		hiddenPathFieldList = annotatedFieldNameList(hiddenPathAnnotation);
		ExceptionsThrower.ifEmpty(hiddenPathFieldList);
		return hiddenPathFieldList;
	}

	private <A extends Annotation> ArrayList<String> readOnlyInputFieldList(String formName) {
		ArrayList<String> readOnlyInputFieldList = new ArrayList<>();
		if (associatedModel) {
			fieldManager.associatedModelFields(readOnlyInputAnnotation).forEach((key, value) -> {
				for (Field field : value) {
					if (readOnlyFormList(field).isEmpty()) {
						readOnlyInputFieldList.add(key.getName().concat(".").concat(field.getName()));
					} else {
						if (readOnlyFormList(field).contains(formName)) {
							readOnlyInputFieldList.add(key.getName().concat(".").concat(field.getName()));
						}
					}
				}
			});
		}
		for (Field field : fieldManager.fieldsArrayListByAnnotation(readOnlyInputAnnotation)) {
			if (readOnlyFormList(field).isEmpty()) {
				readOnlyInputFieldList.add(field.getName());
			} else {
				if (readOnlyFormList(field).contains(formName)) {
					readOnlyInputFieldList.add(field.getName());
				}
			}
		}
		return readOnlyInputFieldList;
	}

	private ArrayList<String> readOnlyFormList(Field field) {
		ArrayList<String> list = new ArrayList<>(
				Arrays.asList(field.getAnnotation(readOnlyInputAnnotation).applyToForm()));
		return list;
	}

	private <A extends Annotation> ArrayList<String> passWordInputFieldList() {
		ArrayList<String> passWordInputFieldList = new ArrayList<>();
		passWordInputFieldList = annotatedFieldNameList((passWordAnnotation));
		return passWordInputFieldList;
	}

	private void springFormParameters() {
		setStyleSheetPath(springFormCssConfig.getStyleSheetPath());
		setCssFileName(springFormCssConfig.getCssFileName());
		setLabelCssClass(springFormCssConfig.getLabelStyle());
		setLabelClass(springFormCssConfig.getLabelStyle());
		setLabelCssErrorClass(springFormCssConfig.getLabelErrorStyle());
		setInputCssClass(springFormCssConfig.getInputStyle());
		setInputCssErrorClass(springFormCssConfig.getInputStyleError());
		setSelectCssClass(springFormCssConfig.getSelectStyle());
		setSelectCssErrorClass(springFormCssConfig.getSelectStyleError());
		setErrorsCssClass(springFormCssConfig.getErrorStyle());
		setButtonCssClass(springFormCssConfig.getButtonStyle());
		setTableCssClass(springFormCssConfig.getTableStyle());
		setTrCssClass(springFormCssConfig.getTrStyle());
		setTdCssClass(springFormCssConfig.getTdStyle());

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
		/*
		 * stringBuilder.append(lineBreak); stringBuilder.append(lineBreak);
		 */
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
		if (readOnlyInputFieldList(formName).contains(fieldName)) {
			addCell(input(fieldName, true));
			fieldSetInFormIsTrue();
		}
	}

	private void addPassWordInputField(String fieldName) {
		if (passWordInputFieldList().contains(fieldName)) {
			LinkedHashMap<String, String> placeHolder = placeHolderAnnotatedFieldMap();
			if (placeHolder.containsKey(fieldName)) {
				addCell(passWordCssClassCssErrorClassTagMessagePlaceHolderToggleDisplay(fieldName,
						placeHolder.get(fieldName)));
			} else {
				addCell(passWordCssClassCssErrorClass(fieldName));
			}
			fieldSetInFormIsTrue();
		}
	}

	private void addTextArea(String fieldName) {
		LinkedHashMap<String, String> placeHolder = placeHolderAnnotatedFieldMap();
		LinkedHashMap<String, InputTextAreaAnnotation> textArea = InputTextAreaAnnotationFieldMap();
		if (textArea.containsKey(fieldName)) {
			String rows = FredParser.asString(textArea.get(fieldName).getRows());
			String cols = FredParser.asString(textArea.get(fieldName).getCols());
			boolean readOnly = textArea.get(fieldName).isReadOnly();
			if (placeHolder.containsKey(fieldName)) {
				addCell(textAreaCssClassCssErrorClassTagMessagePlaceHolder(fieldName, placeHolder.get(fieldName), rows,
						cols));
			} else {
				if (!readOnly) {
					addCell(textAreaCssClassCssErrorClass(fieldName, rows, cols));
				} else {
					addCell(textAreaCssClassReadOnly(fieldName, rows, cols));
				}
			}
			fieldSetInFormIsTrue();
		}
	}

	private void addSpringFormActionButton(String fieldName) {
		if (actionButtonFieldMap().containsKey(fieldName)) {
			addCell(actionButton(fieldName, actionButtonFieldMap().get(fieldName)));
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
			addTextArea(fieldName);
			addSpringFormActionButton(fieldName);
			if (!isFieldSetInForm) {
				addCell(input(fieldName, readOnly));
			}
			if (!readOnly) {
				addCell(error(fieldName));
			}
			stringBuilder.append(tableRowEnd());
		}
		fieldSetInFormIsFalse();

	}

	private void addButton(String name) {
		if (!readOnly) {
			stringBuilder.append(tableRowStart());
			stringBuilder.append(tableCellStartWithColSpan(3, formButtonAlignment));
			stringBuilder.append(inputButton(formButtonMessage, name));
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
