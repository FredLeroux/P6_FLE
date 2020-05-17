package fle.toolBox;

import java.util.ArrayList;

import org.json.JSONArray;

import fle.toolBox.fieldsReflectivity.ExtractSetAndGetFields;
//TODO 1-JAVADOC
/**
 * 
 * @author Frederic Leroux <br>
 *         Parse an Enum class to a JSONArray as follow :<br>
 * 
 * 
 */
public class EnumToJSONArray {

	/**
	 * 
	 * @param <E>
	 * @param enumeration the Enum class of interest as example for enum Civility as
	 *                    target use Civility.class
	 * @return a JSONArray conatining simplyly each enum classe constant.toString()
	 */
	public static <E extends Enum<E>> JSONArray EnumConstantsToString(Class<E> enumeration) {
		JSONArray array = new JSONArray(enumConstantToString(enumeration));
		return array;
	}

	/**
	 * 
	 * @param <E>         Enum type
	 * @param enumeration the Enum class of interest as example for enum Civility as
	 *                    target use Civility.class
	 * @param splitter    the symbole or whatever charatcer to split key and value
	 * @return for each enum constant values using toString() (override method) a
	 *         JSONArray as follow : <br>
	 *         {"[value[index]"splitter"value[index]",["value[index+1]"splitter"value[index+1]",....]}
	 */
	protected static <E extends Enum<E>> JSONArray EnumConstantsToString(Class<E> enumeration, String splitter) {
		JSONArray array = new JSONArray();
		for (int i = 0; i < enumeration.getEnumConstants().length; i++) {
			String value = enumeration.getEnumConstants()[i].toString();
			array.put(value + splitter + value);
		}
		return array;
	}

	/**
	 * 
	 * @param <E>         Enum type
	 * @param enumeration the Enum class of interest as example for enum Civility as
	 *                    target use Civility.class
	 * @param splitter    the symbole or whatever charatcer to split key and value
	 * @param fieldName   the fieldname to get from Enum class
	 * @return for each enum constant values using toString() (override method) a
	 *         JSONArray as follow : <br>
	 *         {"index i"splitter"EnumConstant[i].getFieldName",["index
	 *         i+1"splitter"EnumConstant[i+1].getFieldName",....]}
	 */
	public static <E extends Enum<E>> JSONArray getEnumSpecficArg(Class<E> enumeration, String fieldName) {
		ExtractSetAndGetFields<E> extract = null;
		JSONArray array = new JSONArray();
		for (int i = 0; i < enumeration.getEnumConstants().length; i++) {
			extract = new ExtractSetAndGetFields<E>(enumeration.getEnumConstants()[i]);
			array.put(extract.getFieldValue(fieldName));
		}
		return array;

	}

	public static <E extends Enum<E>> ArrayList<String> getEnumSpecficArgArrayList(Class<E> enumeration,
			String fieldName) {
		ExtractSetAndGetFields<E> extract = null;
		ArrayList<String> array = new ArrayList<>();
		for (int i = 0; i < enumeration.getEnumConstants().length; i++) {
			extract = new ExtractSetAndGetFields<E>(enumeration.getEnumConstants()[i]);
			array.add((String) extract.getFieldValue(fieldName));
		}
		return array;

	}

	public static <E extends Enum<E>> ArrayList<String> enumConstantToString(Class<E> enumeration) {
		ArrayList<String> array = new ArrayList<>();
		for (int i = 0; i < enumeration.getEnumConstants().length; i++) {
			String value = enumeration.getEnumConstants()[i].toString();
			array.add(value);
		}
		return array;
	}

	@SuppressWarnings("unchecked")
	public static <E extends Enum<E>, O extends Object> ArrayList<O> enumConstantObject(Class<E> enumeration) {
		ArrayList<O> array = new ArrayList<>();
		for (int i = 0; i < enumeration.getEnumConstants().length; i++) {
			array.add((O) enumeration.getEnumConstants()[i]);
		}
		return array;
	}

}
