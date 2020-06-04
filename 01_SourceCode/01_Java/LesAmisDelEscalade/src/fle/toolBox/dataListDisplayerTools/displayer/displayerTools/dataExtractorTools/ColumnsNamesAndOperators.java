package fle.toolBox.dataListDisplayerTools.displayer.displayerTools.dataExtractorTools;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.context.MessageSource;

import fle.toolBox.Internationalization.Internationalization;
import fle.toolBox.dataListDisplayerTools.annotations.NotAListFilter;
import fle.toolBox.dataListDisplayerTools.annotations.operator.Operator;
import fle.toolBox.fieldsReflectivity.FieldsAndAnnotation;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFields;
import fle.toolBox.springFormManager.annotations.HiddenPath;

/**
 * 
 * @author Frederic Leroux <br>
 *
 * @param <O> the model class of interest
 * @Note Create a string ArrayList containing:<br>
 *       - Columns Field Name<br>
 *       - internationalyzed Columns Names and Operator Names
 */
public class ColumnsNamesAndOperators<O extends Object> {

	private Internationalization inter = new Internationalization();
	private FieldsAndAnnotation<O> fieldManager = new FieldsAndAnnotation<O>();
	private final static String SUFFIX = "name";
	private O entityModel;

	/**
	 * @Constructor Instaciate the ColumnsNamesAndOperators class with :<br>
	 *              The parmater type O class.<br>
	 *              The suffix for internationalization by default ".name".<br>
	 * @param entityModel The parmater type O class.
	 */
	public ColumnsNamesAndOperators(O entityModel) {
		setInternationalizationSuffix(SUFFIX);
		this.entityModel = entityModel;
	}

	public void setInternationalizationSuffix(String suffix) {
		inter.setSuffix(suffix);
	}

	private Class<Column> column = Column.class;
	private Class<Operator> operator = Operator.class;
	private String splitter = "/";
	private String hide = "hide";

	ArrayList<String> EntityModelFieldsNameList() {
		return fieldManager.fieldsNameArrayList();
	}

	/**
	 * 
	 * @return the field annotated with HiddenPath annotation
	 */
	ArrayList<String> hiddenPathFieldsList() {
		return fieldManager.fieldsNameArrayListByAnnotation(HiddenPath.class);
	}

	ArrayList<String> operatorFields() {
		return fieldManager.fieldsNameArrayListByAnnotation(operator);
	}

	String[] OperatorArray(String fieldName) {
		return fieldManager.fieldAnnotationByFieldName(fieldName, operator).signsArray().getSignsArray();
	}

	public JSONArray createColumnsNamesAndOperatorsListV2(MessageSource messageSource) {
		FieldsAndAnnotation<O> info = new FieldsAndAnnotation<O>(entityModel);
		JSONArray columnsNamesAndOperatorsList = new JSONArray();
		ArrayList<String> fieldsNameList = info.fieldsNameArrayListByAnnotation(column);

		for (int i = 0; i < fieldsNameList.size(); i++) {
			String fieldName = fieldsNameList.get(i);
			String columnNameInLocalLang = inter.messI18n(inter.createKey(fieldName), messageSource);
			String[] operatorTbl = info.fieldAnnotationByFieldName(fieldName, operator).signsArray().getSignsArray();
			for (int j = 0; j < operatorTbl.length; j++) {
				String operator = operatorTbl[j];
				String operatorNameInLocalLang = inter.messI18n(inter.createKey(operator), messageSource);
				columnsNamesAndOperatorsList.put(fieldName + splitter + columnNameInLocalLang + splitter + operator
						+ splitter + operatorNameInLocalLang);
			}
		}

		return columnsNamesAndOperatorsList;
	}

	public JSONArray columnsAndOperatorsListI18N(HttpServletRequest request, MessageSource messageSource) {
		fieldManager.setEntityModel(entityModel);
		JSONArray columnsAndOperatorsListI18N = new JSONArray();
		for (String fieldName : operatorFields()) {
			String columnI18N = inter.messI18n(inter.createKey(fieldName), messageSource);
			for (String operator : OperatorArray(fieldName)) {
				String operatorNameI18N = inter.messI18n(inter.createKey(operator), messageSource);
				columnsAndOperatorsListI18N
						.put(fieldName + splitter + columnI18N + splitter + operator + splitter + operatorNameI18N);
			}
		}
		addNotAFilterFields(columnsAndOperatorsListI18N, messageSource);
		return columnsAndOperatorsListI18N;
	}

	

	public JSONArray columnsAndOperatorsListI18NWithHiddenPath(HttpServletRequest request,
			MessageSource messageSource) {
		fieldManager.setEntityModel(entityModel);
		JSONArray columnsAndOperatorsListI18N = new JSONArray();
		for (String hiddenField : hiddenPathFieldsList()) {
			columnsAndOperatorsListI18N.put(hide + splitter + hiddenField);
		}
		for (String fieldName : operatorFields()) {
			String columnI18N = inter.messI18n(inter.createKey(fieldName), messageSource);
			for (String operator : OperatorArray(fieldName)) {
				String operatorNameI18N = inter.messI18n(inter.createKey(operator), messageSource);
				columnsAndOperatorsListI18N
						.put(fieldName + splitter + columnI18N + splitter + operator + splitter + operatorNameI18N);
			}
		}
		addNotAFilterFields(columnsAndOperatorsListI18N, messageSource);
		return columnsAndOperatorsListI18N;
	}
	
	
	private void addNotAFilterFields(JSONArray columnsAndOperatorsListI18N,MessageSource messageSource) {
		for (String fieldName : notAListFilterFieldsNameList()) {
			String columnI18N = inter.messI18n(inter.createKey(fieldName), messageSource);			
				columnsAndOperatorsListI18N
						.put(fieldName.concat(".notAFilter") + splitter + columnI18N + splitter + "none" + splitter + "none" );
			
		}
	}

	private ArrayList<String> notAListFilterFieldsNameList() {
		ArrayList<String> notAListFilterFieldsNameList = new ArrayList<>();
		ClassFields.getFieldsListByAnnotation(entityModel, NotAListFilter.class)
			.forEach(f -> notAListFilterFieldsNameList.add(f.getName()));
		return notAListFilterFieldsNameList;
	}

}
