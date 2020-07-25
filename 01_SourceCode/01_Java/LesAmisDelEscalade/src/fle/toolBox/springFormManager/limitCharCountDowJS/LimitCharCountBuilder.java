package fle.toolBox.springFormManager.limitCharCountDowJS;

import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import fle.toolBox.FredParser;
import fle.toolBox.IsAnnotationPresent;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFields;
import fle.toolBox.filesManagement.FilesManagement;
import fle.toolBox.javaScriptGenerator.JavaScriptBuilder;
import fle.toolBox.springFormManager.annotations.entityModelAssociation.EntityModelAssociation;
import fle.toolBox.springFormManager.annotations.inputTextArea.InputTextArea;

public class LimitCharCountBuilder {

	private JavaScriptBuilder JSBuilder = new JavaScriptBuilder();
	private LimitCountDownJavaScriptFunction function = new LimitCountDownJavaScriptFunction();
	private FilesManagement filesManagement = new FilesManagement();
	private String JSFunctionFileSrcPath = "WEB-INF/classes/fle/toolBox/springFormManager/limitCharCountDowJS/LimitCharCount.js";
	private String JSFunctionFileDestPath = "resources/jsToolsKit/";
	private String JSFunctionFileName = "LimitCharCount.js";
	private boolean isSRCSet = false;

	public void addLimitCharCountDown(ServletContext context, StringBuilder stringBuilder, Object entity) {
		isSRCSet = false;
		if (IsAnnotationPresent.inClass(entity, EntityModelAssociation.class)) {
			for (Field field : ClassFields.getAllFields(entity)) {
				Object clazz = field.getClass();
				copyFileAndAppendSRC(context, stringBuilder, clazz);
				JSBuilder.openScript(stringBuilder);
				for (Field subField : ClassFields.getAllFields(clazz)) {
					if (IsAnnotationPresent.onField(subField, InputTextArea.class)) {
						function.addCountCharLeftFunction(stringBuilder, displayLocId(subField), maxChar(subField),
								field.getName().concat(".").concat(subField.getName()));
					}
				}
				JSBuilder.closeScript(stringBuilder);
			}
		} else {
			copyFileAndAppendSRC(context, stringBuilder, entity);
			JSBuilder.openScript(stringBuilder);
			for (Field field : ClassFields.getAllFields(entity)) {
				if (IsAnnotationPresent.onField(field, InputTextArea.class)) {
					function.addCountCharLeftFunction(stringBuilder, displayLocId(field), maxChar(field),
							field.getName());
				}
			}
			JSBuilder.closeScript(stringBuilder);
		}

	}

	private void copyFileAndAppendSRC(ServletContext context, StringBuilder stringBuilder, Object entity) {
		if (textAreaInputPresent(entity)) {
			addJSFunctionFile(context, stringBuilder);
			appendJSSrc(stringBuilder);
		}
	}

	private boolean textAreaInputPresent(Object entity) {
		if (fields(entity) != null) {
			return true;
		} else {
			return false;
		}
	}

	private void addJSFunctionFile(ServletContext context, StringBuilder stringBuilder) {
		filesManagement.copyFileAndCreateDir(context, JSFunctionFileSrcPath, JSFunctionFileDestPath,
				JSFunctionFileName);
	}

	private ArrayList<Field> fields(Object entity) {
		return ClassFields.getFieldsListByAnnotation(entity, InputTextArea.class);
	}

	private void appendJSSrc(StringBuilder stringBuilder) {
		if (isSRCSet == false) {
			JSBuilder.openScriptWithSRC(stringBuilder, JSFunctionFileDestPath.concat(JSFunctionFileName));
			JSBuilder.closeScript(stringBuilder);
			isSRCSet = true;
		}
	}

	private String displayLocId(Field field) {
		return field.getName().concat("MaxChar");
	}

	private String maxChar(Field field) {
		return FredParser.asString(field.getAnnotation(InputTextArea.class).maxLenght());
	}

}
