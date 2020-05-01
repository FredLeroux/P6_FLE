package fle.toolBox.dataListDisplayerTools.displayer.displayerTools.listManagementTools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import exceptions.TypeNotConfiguredException;
import fle.toolBox.StringExtractor;

abstract class FilterAndSortListViaJava<O extends Object> extends ComparatorAndPredicate<O> {

	private String regexDigits = "^\\d+\\.\\d*$";
	private StringExtractor extract = new StringExtractor();
	private String regexString = "[a-zA-Z0-9\\p{javaLetter}_\\s\\-\\.]";
	private String regexOperator = "=|<|>|>=|<=";

	public FilterAndSortListViaJava(O entityModel) {
		super(entityModel);
	}

	protected String getRegexDigits() {
		return regexDigits;
	}

	protected void setRegexDigits(String regexDigits) {
		this.regexDigits = regexDigits;
	}

	protected String getRegexString() {
		return regexString;
	}

	protected void setRegexString(String regexString) {
		this.regexString = regexString;
	}

	protected String getRegexOperator() {
		return regexOperator;
	}

	protected void setRegexOperator(String regexOperator) {
		this.regexOperator = regexOperator;
	}

	List<O> applyPredicate(List<O> tofiltre, Predicate<O> predicateToApply) {
		return tofiltre.stream().filter(predicateToApply).collect(Collectors.toList());
	}

	// TODO change to protected both
	protected void sortNaturalOrderByField(String fieldName, List<O> list, O modelUsed) {

		Comparator<O> comparator = null;
		try {
			comparator = fredComparator(fieldName);
		} catch (TypeNotConfiguredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(list, comparator);
		
	}

	protected void sortReverseOrderByField(String fieldName, List<O> list, O modelUsed) {
		Comparator<O> comparator = null;

		try {
			comparator = fredComparator(fieldName);
		} catch (TypeNotConfiguredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(list, comparator.reversed());
	}

	String criterionExtractor(String fullSentence, String regexString) {
		String criterion = null;
		try {
			criterion = extract.extractorReverse(fullSentence, regexString);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return criterion;
	}

	String fieldNameExtarctor(String fullSentence, String regexString) {
		String fieldName = null;
		try {
			fieldName = extract.extractorForward(fullSentence, regexString);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fieldName;
	}

	String operatorExtarctor(String fullSentence, String regexOperator) {
		String operator = null;
		try {
			operator = extract.extractorForward(fullSentence, regexOperator);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operator;
	}

	protected List<O> listFiltration(List<O> list, String fullCriterion, O javaClass) {
		List<O> filteredAndSortedList = new ArrayList<O>();
		String criterion = null;
		String fieldName = null;
		String operator = null;
		Predicate<O> predicate = null;
		criterion = criterionExtractor(fullCriterion, getRegexString());
		fieldName = fieldNameExtarctor(fullCriterion, getRegexString());
		operator = operatorExtarctor(fullCriterion, getRegexOperator());
		try {
			predicate = fredPredicate(criterion, fieldName, operator);
		} catch (TypeNotConfiguredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		filteredAndSortedList = applyPredicate(list, predicate);
		return filteredAndSortedList;
	}

}
