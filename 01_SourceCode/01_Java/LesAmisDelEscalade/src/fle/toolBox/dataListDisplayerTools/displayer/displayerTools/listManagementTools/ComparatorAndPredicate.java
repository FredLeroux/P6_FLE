package fle.toolBox.dataListDisplayerTools.displayer.displayerTools.listManagementTools;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Comparator;
import java.util.function.Predicate;

import exceptions.TypeNotConfiguredException;
import fle.toolBox.FredParser;
import fle.toolBox.dateAndTime.annotation.DateTimeRawFormat;
import fle.toolBox.fieldsReflectivity.ExtractSetAndGetFields;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFields;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFieldsSetAndGet;

/**
 * 
 * @author Frederic Leroux <br>
 *
 * @version : 1.0
 *
 * @param <O> the model (javaClass) used
 */
public class ComparatorAndPredicate<O extends Object> extends ExtractSetAndGetFields<O> {

	private String str = "string";
	private String doubleNum = "double";
	private String intNum = "int";
	private String integer = "integer";
	private String floatNum = "float";
	private String longNum = "long";
	private String equalsOperator = "=";
	private String greaterThanOperator = ">";
	private String lessThanOperator = "<";
	private Class<DateTimeRawFormat> dateTimeRawFormat = DateTimeRawFormat.class;

	public ComparatorAndPredicate(O entityModel) {
		super(entityModel);
	}

	/**
	 * 
	 * @return by default "="
	 */
	protected String getEqualsOperator() {
		return equalsOperator;
	}

	protected void setEqualsOperator(String equalsOperator) {
		this.equalsOperator = equalsOperator;
	}

	/**
	 * 
	 * @return by default ">"
	 */
	protected String getGreaterThanOperator() {
		return greaterThanOperator;
	}

	protected void setGreaterThanOperator(String greaterThanOperator) {
		this.greaterThanOperator = greaterThanOperator;
	}

	/**
	 * 
	 * @return by default "<"
	 */
	protected String getLessThanOperator() {
		return lessThanOperator;
	}

	protected void setLessThanOperator(String lessThanOperator) {
		this.lessThanOperator = lessThanOperator;
	}

	String fieldValue(String fieldName, O javaClass) {
		return (String) ClassFieldsSetAndGet.getFieldValue(javaClass, fieldName);
	}

//TODO CHEK Here if not work
	/*
	 * public String fieldTypeT(String fieldName) { String type =
	 * fieldTypeName(fieldName); return type; }
	 */
//, O javaClass
	public Comparator<O> fredComparator(String fieldName) throws TypeNotConfiguredException {

		String fieldType = fieldTypeName(fieldName).toLowerCase();
	
		Comparator<O> fredComparator = null;
		boolean check = false;
		if (isFieldDate(fieldName)) {
			fredComparator = comparatorStringDate(fieldName,formatStyleOnAnnotation(fieldName));			
			check = true;
		} else if (fieldType.equals(str)) {
			fredComparator = comparatorString(fieldName);
			System.out.println("if annotation date below this has to not be here");
			check = true;
		} else if (fieldType.equals(integer) || fieldType.equals(intNum)) {
			fredComparator = comparatorInteger(fieldName);
			check = true;
		} else if (fieldType.toLowerCase().equals(doubleNum)) {
			fredComparator = comparatorDouble(fieldName);
			check = true;
		} else if (fieldType.equals(longNum)) {
			fredComparator = comparatorLong(fieldName);
			check = true;
		} else if (fieldType.equals(floatNum)) {
			fredComparator = comparatorFloat(fieldName);
			check = true;
		} else if (!check) {
			throw new TypeNotConfiguredException();
		}
		return fredComparator;
	}

	// ,O javaClass
	public Predicate<O> fredPredicate(String criterion, String fieldName, String operator)
			throws TypeNotConfiguredException {
		String fieldType = fieldTypeName(fieldName).toLowerCase();/// fieldType(fieldName, javaClass).toLowerCase();
		System.out.println(fieldName + " type = " + fieldType);
		boolean check = false;
		Predicate<O> fredPredicate = null;
		if (fieldType.equals(str)) {
			fredPredicate = predicateString(criterion, fieldName, operator);
			check = true;
		} else if (fieldType.equals(integer) || fieldType.equals(intNum)) {
			fredPredicate = predicateInteger(criterion, fieldName, operator);
			check = true;
		} else if (fieldType.equals(doubleNum)) {
			fredPredicate = predicateDouble(criterion, fieldName, operator);
			check = true;
		} else if (fieldType.equals(longNum)) {
			fredPredicate = predicateLong(criterion, fieldName, operator);
			check = true;
		} else if (fieldType.equals(floatNum)) {
			fredPredicate = predicateFloat(criterion, fieldName, operator);
			check = true;
		} else if (!check) {
			throw new TypeNotConfiguredException();
		}
		return fredPredicate;
	}

	/*
	 * My Comparator functioning and expectation: case of list of object (class).
	 * Used with collection sort to specified sorting on specific list element.
	 * Instanciate 2 class (suposed to have settter and getter) (O o1,O o2) then
	 * perform the comparison : example for string (o1.getString().compareTo(
	 * 02.getString())) this comparison will give -1(o1<o2), 0(o1==o2),1(o1>o2) and
	 * comparator will sort in function of this results -1 -> o1 before o2, 1 -> o1
	 * after o2, 0 -> o2 after o1. So comparator is a boolean waitin for negative or
	 * possitive int, and will sort in function of results. Finally in case of
	 * numbers compare, the right way to use comparator is to perform a substarction
	 * of o1-o2 and comparator will analyse the int by is sign neg or pos, and
	 * perform sorting. Note to get revese use comparator.reversed()) with
	 * Collections.sort(list,comparator.reversed()) THe following comparators as to
	 * be used with Collections.sort and will compare parsed values function of
	 * field type. Thus methos use Java 8 lambda expression
	 * 
	 * another way to do it is to create class implements comparator then override
	 * comparator and set the rule for each fields, from my point of view too long
	 * too boring
	 * 
	 * 
	 * 
	 */
	Comparator<O> comparatorString(String fieldName) {
		Comparator<O> comparator = null;
		comparator = (O o1, O o2) -> fieldValue(fieldName, o1).compareTo(fieldValue(fieldName, o2));
		return comparator;
	}

	Comparator<O> comparatorInteger(String fieldName) {
		Comparator<O> comparator = null;
		comparator = (O o1, O o2) -> FredParser.toInt(fieldValue(fieldName, o1))
				- FredParser.toInt(fieldValue(fieldName, o2));
		return comparator;
	}

//TODO 0-URGENT correct all other than double
	Comparator<O> comparatorDouble(String fieldName) {
		Comparator<O> comparator = null;
		comparator = (O o1, O o2) -> FredParser.toDouble(fieldValue(fieldName, o1))
				.compareTo(FredParser.toDouble(fieldValue(fieldName, o2)));
		return comparator;
	}

	Comparator<O> comparatorLong(String fieldName) {
		Comparator<O> comparator = null;
		comparator = (O o1, O o2) -> FredParser.intValue(
				(FredParser.toLong(fieldValue(fieldName, o1)) - FredParser.toLong(fieldValue(fieldName, o2))));
		return comparator;
	}

	Comparator<O> comparatorFloat(String fieldName) {
		Comparator<O> comparator = null;
		comparator = (O o1, O o2) -> FredParser.intValue(
				(FredParser.toFloat(fieldValue(fieldName, o1)) - FredParser.toFloat(fieldValue(fieldName, o2))));
		return comparator;
	}

	Comparator<O> comparatorStringDate(String fieldName, FormatStyle formatStyle) {
		Comparator<O> comparator = null;
		System.out.println("Comparator" + fieldName);
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(formatStyle);
		comparator = (O o1, O o2) ->  LocalDate.parse(fieldValue(fieldName, o1),dtf)
				.compareTo(LocalDate.parse(fieldValue(fieldName, o2),dtf));		
		return comparator;
	}

	Predicate<O> predicateString(String criterion, String fieldName, String operator) {
		Predicate<O> predicate = null;
		if (operator.equals(getEqualsOperator())) {
			predicate = (O) -> fieldValue(fieldName, O).compareTo(criterion) == 0;
		} else if (operator.equals(getGreaterThanOperator())) {
			predicate = (O) -> fieldValue(fieldName, O).compareTo(criterion) > 0;
		} else if (operator.equals(getLessThanOperator())) {
			predicate = (O) -> fieldValue(fieldName, O).compareTo(criterion) < 0;
		}
		return predicate;

	}

	Predicate<O> predicateInteger(String criterion, String fieldName, String operator) {
		Predicate<O> predicate = null;
		if (operator.equals(getEqualsOperator())) {
			predicate = (O) -> FredParser.toInt(criterion) == FredParser.toInt(fieldValue(fieldName, O));
		} else if (operator.equals(getGreaterThanOperator())) {
			predicate = (O) -> FredParser.toInt(criterion) < FredParser.toInt(fieldValue(fieldName, O));
		} else if (operator.equals(getLessThanOperator())) {
			predicate = (O) -> FredParser.toInt(criterion) > FredParser.toInt(fieldValue(fieldName, O));
		}
		return predicate;
	}

	// TODO 0-Done 1-change all appart int and intger like this double pay attention
	// to the direction what is at left and right think well
	Predicate<O> predicateDouble(String criterion, String fieldName, String operator) {
		Predicate<O> predicate = null;
		if (operator.equals(getEqualsOperator())) {
			predicate = (
					O) -> FredParser.toDouble(fieldValue(fieldName, O)).compareTo(FredParser.toDouble(criterion)) == 0;
		} else if (operator.equals(getGreaterThanOperator())) {
			predicate = (
					O) -> FredParser.toDouble(fieldValue(fieldName, O)).compareTo(FredParser.toDouble(criterion)) > 0;
		} else if (operator.equals(getLessThanOperator())) {
			predicate = (
					O) -> FredParser.toDouble(fieldValue(fieldName, O)).compareTo(FredParser.toDouble(criterion)) < 0;
		}
		return predicate;
	}

	Predicate<O> predicateLong(String criterion, String fieldName, String operator) {
		Predicate<O> predicate = null;
		if (operator.equals(getEqualsOperator())) {
			predicate = (O) -> FredParser.toLong(fieldValue(fieldName, O)).compareTo(FredParser.toLong(criterion)) == 0;
		} else if (operator.equals(getGreaterThanOperator())) {
			predicate = (O) -> FredParser.toLong(fieldValue(fieldName, O)).compareTo(FredParser.toLong(criterion)) > 0;
		} else if (operator.equals(getLessThanOperator())) {
			predicate = (O) -> FredParser.toLong(fieldValue(fieldName, O)).compareTo(FredParser.toLong(criterion)) < 0;
		}
		return predicate;
	}

	Predicate<O> predicateFloat(String criterion, String fieldName, String operator) {
		Predicate<O> predicate = null;
		if (operator.equals(getEqualsOperator())) {
			predicate = (
					O) -> FredParser.toFloat(fieldValue(fieldName, O)).compareTo(FredParser.toFloat(criterion)) == 0;
		} else if (operator.equals(getGreaterThanOperator())) {
			predicate = (
					O) -> FredParser.toFloat(fieldValue(fieldName, O)).compareTo(FredParser.toFloat(criterion)) > 0;
		} else if (operator.equals(getLessThanOperator())) {
			predicate = (
					O) -> FredParser.toFloat(fieldValue(fieldName, O)).compareTo(FredParser.toFloat(criterion)) < 0;
		}
		return predicate;
	}
	
	private Field field(String fieldName) {
		return ClassFields.getFieldByIsName(entityModel, fieldName);
	}

	private Boolean isFieldDate(String fieldName) {
		return isAnnotationPresence(field(fieldName),dateTimeRawFormat);
	}
	
	private FormatStyle formatStyleOnAnnotation(String fieldName) {
		return field(fieldName).getAnnotation(dateTimeRawFormat).dateFormatStyle();
	}

}
