package fle.toolBox;

import java.util.ArrayList;

public class StringExtractor {

	PatternMatcher matcher = new PatternMatcher();
	String regex = "[a-zA-Z0-9\\p{javaLetter}_\\s]+";
	String operatorRegex = "=|<|>|>=|<=";

	/**
	 * 
	 * @param str   is the string to test against regex
	 * @param regex is regex
	 * @return the string matching regex extratacted from the begining of the
	 *         string, return null if no matche;
	 *         <li>example 1: <br>
	 *         str = ((string=data)) <br>
	 *         regex = [a-z] <br>
	 *         result = 'string'
	 *         <li>example 2: <br>
	 *         str = ((string=data)) <br>
	 *         regex = [=] <br>
	 *         result = =
	 */
	public String extractorForward(String str, String regex) throws NullPointerException {
		String result = null;
		int start = -1;
		int end = 0;
		for (int i = 0; i < str.length(); i++) {
			StringBuffer buf = new StringBuffer();
			buf.append(str.charAt(i));
			if (start == -1) {
				if (matcher.patternMatcher(regex, buf.toString())) {
					start = i;
				} else {
					start = -1;
				}
			} else {
				if (end == 0) {
					if (!matcher.patternMatcher(regex, buf.toString())) {
						end = i;
					} else {
						end = 0;
					}
				}
			}
		}
		if (end == 0 && start > 0) {
			end = str.length();

		} else {
			result = null;
		}
		try {
			result = str.substring(start, end);
		} catch (Exception e) {
			throw new NullPointerException("No matche");
		}

		return result;
	}

	/**
	 * 
	 * @param str   is the string to test against regex
	 * @param regex is regex
	 * @return the string matching regex extratacted from the end of the string
	 *         <li>example: <br>
	 *         str = ((string=data)) <br>
	 *         regex = [a-z] <br>
	 *         result = data
	 */
	public String extractorReverse(String str, String regex) {
		String result = null;
		int start = 0;
		int end = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			StringBuffer buf = new StringBuffer();
			buf.append(str.charAt(i));
			if (end == 0) {
				if (matcher.patternMatcher(regex, buf.toString())) {
					end = i + 1;
				} else {
					end = 0;
				}
			} else {
				if (start == 0) {
					if (!matcher.patternMatcher(regex, buf.toString())) {
						start = i + 1;
					} else {
						start = 0;
					}
				}
			}
		}
		try {
			result = str.substring(start, end);
		} catch (Exception e) {
			throw new NullPointerException("No matche");
		}

		return result;
	}

	// TODO 1-JAVADOC clarified javadoc
	/**
	 * 
	 * @param str
	 * @param regex
	 * @return an ArrayList containing argument splitted from str and the operator
	 *         used to split
	 */
	public ArrayList<String> simpleExtractor(String str, String regex) {
		ArrayList<String> arl = new ArrayList<String>();
		String operator = matcher.patternMatcherString(str, regex);
		String[] array = str.split(regex);
		for (String s : array) {
			arl.add(s);
		}
		arl.add(operator);
		return arl;
	}

}
