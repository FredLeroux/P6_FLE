package fle.toolBox.springFormManager.annotations.inputTextArea;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.classType.SFC;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFields;
import std.fle._00_general.SessionVariables;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote Allow to get the limit char number using rows() and charByRows
 *          of @InputTextArea {@link #getLimitNumberChar(Field)} <br>
 *          Allow to add to model attribute containing the char limit number
 *          {@link #addTextAreaLimitToModel(ModelAndView, Object)}<br>
 *          Allow to get a linkedHashMap containing @InputTextArea information
 *          {@link #textAreaAttributeNameAndLimit(Object)}
 * 
 */
public class InputTextAreaGetLimit {

	/**
	 * 
	 * @param model  the where to add the textarea char limit
	 * @param entity the entity containing @InputTextArea annotated Field(s)
	 * @apiNote will add to model for each annotated fields, as attribute name:"
	 *          field name" concatenated with "MaxChar", and as object the char
	 *          limit Integer as follow textArea
	 *          "InputTextArea.rows()*InputTextArea.charByrow".
	 */
	public void addTextAreaLimitToModel(ModelAndView model, Object entity) {
		fields(entity).forEach(f -> model.addObject(createModelAttributeName(f), getLimitNumberChar(f)));
	}

	/**
	 * 
	 * @param entity the entity containing @InputTextArea annotated Field(s)
	 * @return a LinkedHashMap containing for each entity fields @InputTextArea
	 *         annotated, as Key "fieldName.concact("MaxChar")" Value =
	 *         "InputTextArea.maxLenght"
	 */
	public LinkedHashMap<String, Integer> textAreaAttributeNameAndLimitMap(Object entity) {
		LinkedHashMap<String, Integer> textAreaAttributeNameAndLimit = new LinkedHashMap<>();
		fields(entity).forEach(f -> addLimit(f, textAreaAttributeNameAndLimit));
		return textAreaAttributeNameAndLimit;
	}
	
	public void addTextAreaAttributeNameAndLimitMapToSession(SFC sfc,SessionVariables sessVar) {
		textAreaAttributeNameAndLimitMap(sfc)		
		.forEach((key, value) -> sessVar.addSessionVariable(key, value));
	}

	private void addLimit(Field field, LinkedHashMap<String, Integer> textAreaAttributeNameAndLimit) {
		if (field.getAnnotation(InputTextArea.class).maxLenght() != 0) {
			textAreaAttributeNameAndLimit.put(createModelAttributeName(field), getLimitNumberChar(field));
		}
	}

	/**
	 * 
	 * @param field a @InputTextArea annotated Field
	 * @return field name concatenated with "MaxChar" -> fieldNameMaxChar
	 */
	private String createModelAttributeName(Field field) {
		return field.getName().concat("MaxChar");
	}

	/**
	 * 
	 * @param field a @InputTextArea annotated Field
	 * @return the char limit Integer as follow textArea
	 *         "InputTextArea.rows()*InputTextArea.charByrow".
	 */
	public Integer getLimitNumberChar(Field field) {
		InputTextArea annotation = field.getAnnotation(InputTextArea.class);
		return annotation.maxLenght();

	}

	private ArrayList<Field> fields(Object entity) {
		return ClassFields.getFieldsListByAnnotation(entity, InputTextArea.class);
	}

}
