package fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.displayer.displayerTools.dataExtractorTools;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeSet;

import org.json.JSONArray;

import exceptions.ColumnAnnotationNotFound;
import exceptions.ModelClassNotSettedExceptions;
import exceptions.NoCorrespondingDataTypeFound;
import exceptions.NoNameInColumnAnnotationException;
import exceptions.NoSpecifiedAnnotationFoundException;
import fle.toolBox.MapToJson;
import fle.toolBox.fieldsReflectivity.ExtractSetAndGetFields;

public class CollectionElementsExtrator<O extends Object> extends ExtractSetAndGetFields<O> {

	
	private LinkedHashMap<String, TreeSet<Object>> containerToFill = new LinkedHashMap<>();

	public CollectionElementsExtrator(O entityModel) {
		super(entityModel);
	}

	/**
	 * 
	 * @param method     is the InvokeMethod.class used to generate the column names
	 *                   Arraylist
	 * @param modelClass is the Class containing @Column annoted fields
	 * @return a HashMap with keys = column names, values = new String TreeSet
	 * @throws ColumnAnnotationNotFound
	 * @throws NoNameInColumnAnnotationException
	 * @throws NoCorrespondingDataTypeFound
	 * @throws NoSpecifiedAnnotationFoundException
	 * @throws ModelClassNotSettedExceptions
	 * @Note this method provide an HashMap named container, wich is composed as key
	 *       the column name and as value a Treeset to be filled with data base
	 *       data;
	 */
	<A extends Annotation> LinkedHashMap<String, TreeSet<Object>> setContainerToFill() {
		LinkedHashMap<String, TreeSet<Object>> container = new LinkedHashMap<>();
		ArrayList<String> fieldsNamesList = fieldsNameArrayList();
		for (String str : fieldsNamesList) {
			container.put(str, new TreeSet<Object>());
		}
		return containerToFill = container;
	}

	LinkedHashMap<String, TreeSet<Object>> getContainerToFill() {
		return containerToFill;
	}

	/**
	 * 
	 * @param collection is a Class collection containing the data from a data base
	 *                   table;
	 * @param modelClass is the model class used to fill and question the table data
	 *                   base
	 * @param container  is an Hashmap composed as follow: key the column name and
	 *                   value a Treeset
	 * @param method     is the InvokeMethod.class used to generate the column
	 *                   names,fields and data base values Arraylist
	 * @return Filled container HashMap with keys = column names, values = TreeSet
	 *         of data base table data
	 * 
	 */

	private LinkedHashMap<String, TreeSet<Object>> containerFiller(List<O> collection) {
		List<O> collectiontemp = new ArrayList<O>(collection);		
		for (int i = 0; i < collectiontemp.size(); i++) {
			ExtractSetAndGetFields<O> toExtract = new ExtractSetAndGetFields<>(collectiontemp.get(i));
			for (Entry<String, Object> entry : toExtract.getFieldNameWhithValueMapAllClassFields().entrySet()) {
				getContainerToFill().get(entry.getKey()).add(entry.getValue());
			}
		}
		collectiontemp.clear();	
		return getContainerToFill();
	}


	
	public JSONArray createTableElemetsList(List<O> collection) {
		setContainerToFill();
		LinkedHashMap<String, TreeSet<Object>> containerFinal = new LinkedHashMap<>();
		JSONArray tableElementsList = new JSONArray();
		containerFinal = containerFiller(collection);
		tableElementsList = MapToJson.ConvertMapToJson(containerFinal);
		return tableElementsList;
	}

	/**
	 * use object O .toString() to parse Class O(object in collection) into string
	 * setted in Class O see (colorDto)
	 * 
	 * @param collection
	 * @return
	 */
	// TODO 2-javadoc to clarified
	public ArrayList<String> idAndValue(List<O> collection) {
		List<O> collectiontemp = new ArrayList<O>(collection);
		ArrayList<String> idAndValue = new ArrayList<>();
		for (int i = 0; i < collectiontemp.size(); i++) {
			idAndValue.add(collectiontemp.get(i).toString());
		}
		collectiontemp.clear();
		return idAndValue;
	}

}
