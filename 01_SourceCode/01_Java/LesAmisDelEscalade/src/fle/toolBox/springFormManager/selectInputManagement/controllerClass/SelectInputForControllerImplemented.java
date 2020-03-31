package fle.toolBox.springFormManager.selectInputManagement.controllerClass;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.FredParser;
import fle.toolBox.fieldsReflectivity.ExtractSetAndGetFields;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectInputLinkedListObject;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectInputListAndValue;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectOptionsInterface;



@Service
public class SelectInputForControllerImplemented extends SelectInputListAndValue implements SelectInputForController {

	@Autowired
	HttpServletRequest request;

	private LinkedHashMap<String, JSONArray> listToAddToModel = new LinkedHashMap<>();
	private LinkedHashMap<String, Object> valueToAddToModel = new LinkedHashMap<>();	
	private ArrayList<SelectInputLinkedListObject> linkedList = new ArrayList<>();
	private String listName;
	private String criterion;

	@Override
	public LinkedHashMap<String, JSONArray> listToAddToModel(Object cOI) {
		setFieldManager(cOI);
		if (isAssociatedModel()) {
			for (Field field : getFieldManager().getAllFields()) {
				for (Field subClassField : extract(field).fieldsArrayListByAnnotation(selectInputAnnotation)) {
					addSelectOptions(subClassField);
					addLinkedListToListToAddToModel(subClassField);
				}
			}
		} else {
			for (Field field : getFieldManager().fieldsArrayListByAnnotation(selectInputAnnotation)) {
				addSelectOptions(field);
				addLinkedListToListToAddToModel(field);
			}
		}
		return listToAddToModel;
	}

	@Override
	public LinkedHashMap<String, JSONArray> listToAddToModelFiltered() {
		listName = request.getParameter("listName");
		criterion = request.getParameter("criterion");
		for (SelectInputLinkedListObject o : linkedList) {
			if (o.getListName().equals(listName)) {
				listToAddToModel.put(listName,
						valueAndDisplayValueConvertToJSON(
								selectInputListConverter(o.getField(),
										o.getFilterdListEqualsTo(FredParser.toInteger(criterion))),
								messageSourceSuffix(o.getField()),splitter(o.getField())));
			}
		}
		return listToAddToModel;
	}

	@Override
	public LinkedHashMap<String, Object> valuesToAddToModel(Object cOI) {
		setFieldManager(cOI);
		if (isAssociatedModel()) {
			for (Field field : getFieldManager().getAllFields()) {
				ExtractSetAndGetFields<Object> extract = extract(field);
				for (Field subClassField : extract(field).fieldsArrayListByAnnotation(selectInputAnnotation)) {
					addValueFromObject(valueToAddToModel, subClassField, extract);
				}
			}
		} else {
			for (Field field : getFieldManager().fieldsArrayListByAnnotation(selectInputAnnotation)) {
				addValueFromObject(valueToAddToModel, field);
			}
		}
		return valueToAddToModel;
	}

	@Override
	public void upDateSelectListAndValue(Object cOI, ModelAndView model) {
		if (!request.getParameter("criterion").isEmpty()) {
			model.addAllObjects(listToAddToModelFiltered());
		} else {
			model.addAllObjects(listToAddToModel(cOI));
		}
		LinkedHashMap<String, Object> value = valuesToAddToModel(cOI);
		cleanValueToAddToModel(value);
		model.addAllObjects(value);
		model.addObject("formError","'false'");
	}

	@Override
	public void selectListAndValueOnBindingError(Object cOI, ModelAndView model) {		
			model.addAllObjects(listToAddToModelFiltered());			
		LinkedHashMap<String, Object> value = valuesToAddToModel(cOI);
		//cleanValueToAddToModel(value);
		model.addAllObjects(value);
		model.addObject("formError","'true'");
	}

	@Override
	public void addSelectListsAndValues(Object cOI, ModelAndView model) {
		model.addAllObjects(listToAddToModel(cOI));
		model.addAllObjects(valuesToAddToModel(cOI));
		model.addObject("formError","'false'");
	}
	@Override
	public boolean formError() {
		if(request.getParameter("formError").equals("true")) {
			return true;
		}
		else {
			return false;
		}
	}

	private void cleanValueToAddToModel(LinkedHashMap<String, Object> valueMap) {
		for (SelectInputLinkedListObject o : linkedList) {
			valueMap.forEach((key, value) -> valueMap.put(key, cleanValue(key, selectValueName(o.getField()), value)));
		}
	}

	private Object cleanValue(String key, String SelectValueName, Object value) {

		if (key.equals(SelectValueName)) {
			value = "'empty'";
		}
		return value;
	}

	private void addSelectOptions(Field fOI) {
		if (!isLinkedList(fOI)) {
			if (isFromMessageSource(fOI)) {
				selectOptions(selectListName(fOI), listOrderedByDisplayValueI18N(fOI), messageSourceSuffix(fOI),splitter(fOI));
			} else {
				selectOptions(selectListName(fOI), listOrderedByDisplayValue(fOI), messageSourceSuffix(fOI),splitter(fOI));
			}
		}
	}

	private JSONArray emptyJSONArray() {
		JSONArray array = new JSONArray();
		// array.put(SpringFormAssets.EMPTY_VALUE.toString());
		return array;
	}

	private void addLinkedListToListToAddToModel(Field fOI) {
		if (isLinkedList(fOI)) {
			addSelectInputLinkedListObject(fOI);
			listToAddToModel.put(selectListName(fOI), emptyJSONArray());
		}

	}

	public ArrayList<SelectInputLinkedListObject> getLinkedList() {
		return linkedList;
	}

	private void addSelectInputLinkedListObject(Field fOI) {
		linkedList.add(new SelectInputLinkedListObject(fOI, selectListName(fOI), relationShipField(fOI),
				relationShipFieldFilter(fOI), selectInputDTOList(fOI)));
	}

	private void selectOptions(String key, ArrayList<SelectOptionsInterface> s, String suffix,String splitter) {
		listToAddToModel.put(key, valueAndDisplayValueConvertToJSON(s, suffix,splitter));
	}

	private String valueAndDisplayValue(SelectOptionsInterface select,String splitter) {
		return select.getValue().concat(splitter).concat(select.getDisplayValue());
	}

	private String valueAndDisplayValueI18N(SelectOptionsInterface select, String suffix,String splitter) {
		return select.getValue().concat(splitter).concat(select.getDisplayValueI18N(messageSource, suffix));
	}

	private JSONArray valueAndDisplayValueConvertToJSON(ArrayList<SelectOptionsInterface> toConvert, String suffix,String splitter) {
		JSONArray converted = new JSONArray();
		for (SelectOptionsInterface s : toConvert) {
			if (suffix.equals("")) {
				converted.put(valueAndDisplayValue(s,splitter));
			} else {
				converted.put(valueAndDisplayValueI18N(s, suffix,splitter));
			}
		}
		return converted;
	}

}
