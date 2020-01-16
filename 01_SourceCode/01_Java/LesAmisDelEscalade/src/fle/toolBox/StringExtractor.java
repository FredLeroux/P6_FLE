package fle.toolBox;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExtractor {

	PatternMatcher matcher = new PatternMatcher();
	String regex = "[a-zA-Z0-9\\p{javaLetter}_\\s]+";
	String operatorRegex = "=|<|>|>=|<=";

	/**
	 * @author Frederic Leroux
	 * @Note extract all character as a string before the operators '='or '<' or '>'
	 * @param str string containings character sequence of interest before an
	 *            operator (see operator list in note)
	 * @return
	 */
	/**
	 * 
	 * @param str
	 * @return
	 */
	// TODO supress
	public String extractBeforeOperator(String str) {
		int stringStart = 0;
		int checkEqualsOperator = str.indexOf("=");
		int checkInferiorOperator = str.indexOf("<");
		int checkSuperiorOperator = str.indexOf(">");
		Pattern regex = Pattern.compile("[a-zA-Z0-9\\p{javaLetter}_]+");
		Matcher letterMatch = regex.matcher(str);
		if (letterMatch.find()) {
			stringStart = letterMatch.start();
		}
		if (checkEqualsOperator == -1 && (checkInferiorOperator != 0 || checkSuperiorOperator != 0)) {
			int end = 0;
			if (checkSuperiorOperator > 0) {
				end = checkSuperiorOperator;
			} else {
				end = checkInferiorOperator;
			}
			return str.substring(stringStart, end);
		}

		else if (checkSuperiorOperator != 0 && checkSuperiorOperator < checkEqualsOperator
				&& checkSuperiorOperator != -1) {
			return str.substring(stringStart, checkSuperiorOperator);
		} else if (checkInferiorOperator != 0 && checkInferiorOperator < checkEqualsOperator
				&& checkInferiorOperator != -1) {
			return str.substring(stringStart, checkInferiorOperator);
		} else {
			return str.substring(stringStart, checkEqualsOperator);
		}

	}

	// TODO supress
	public String extractAfterOperator(String str) {
		int stringEnd = 0;
		int checkEqualsOperator = str.indexOf("=");
		int checkInferiorOperator = str.indexOf("<");
		int checkSuperiorOperator = str.indexOf(">");
		boolean bool;
		String strRegex = "[a-zA-Z0-9\\p{javaLetter}_\\s]+";
		String sortOut = null;
		String returnStr = null;
		Pattern regex = Pattern.compile(strRegex);
		Matcher letterMatch = regex.matcher(str);
		while (letterMatch.find()) {
			stringEnd = letterMatch.end();
		}
		if (checkEqualsOperator == -1 && (checkInferiorOperator != 0 || checkSuperiorOperator != 0)) {
			int start = 0;
			if (checkSuperiorOperator > 0) {
				start = checkSuperiorOperator + 1;
			} else {
				start = checkInferiorOperator + 1;
			}
			sortOut = str.substring(start, stringEnd);
			returnStr = sortOut;

		} else {
			if (checkEqualsOperator + 1 >= stringEnd) {
				returnStr = "";
			} else {
				sortOut = str.substring(checkEqualsOperator + 1, stringEnd);
				returnStr = sortOut;
			}
		}

		if ((returnStr.length() == 0) || (returnStr == null) || (returnStr.equals("null"))
				|| returnStr.equals("undefined")) {
			return returnStr = null;
		}
		Matcher letterMatch1 = regex.matcher(sortOut);
		bool = letterMatch1.matches();
		if (!bool) {
			throw new IllegalArgumentException("regex not respected");
		} else {
			return returnStr;
		}
	}

	// TODO supress
	public String extractOperator(String str) {
		StringBuffer operator = new StringBuffer();
		int checkEqualsOperator = str.indexOf("=");
		int checkInferiorOperator = str.indexOf("<");
		int checkSuperiorOperator = str.indexOf(">");
		if (checkEqualsOperator == -1 && (checkInferiorOperator != 0 || checkSuperiorOperator != 0)) {
			if (checkInferiorOperator != 0 && checkInferiorOperator != -1) {
				return operator.append(str.charAt(checkInferiorOperator)).toString();
			} else {
				return operator.append(str.charAt(checkSuperiorOperator)).toString();
			}
		} else if (checkSuperiorOperator != 0 && checkSuperiorOperator != -1 && checkEqualsOperator != 0
				&& checkInferiorOperator == -1) {
			operator.append(str.charAt(checkSuperiorOperator));
			operator.append(str.charAt(checkEqualsOperator));
			return operator.toString();
		} else if (checkInferiorOperator != 0 && checkInferiorOperator != -1 && checkEqualsOperator != 0
				&& checkSuperiorOperator == -1) {
			operator.append(str.charAt(checkInferiorOperator));
			operator.append(str.charAt(checkEqualsOperator));
			return operator.toString();
		} else {
			return operator.append(str.charAt(checkEqualsOperator)).toString();
		}

	}

	
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
		for (int i = str.length()-1; i >= 0; i--) {
			StringBuffer buf = new StringBuffer();
			buf.append(str.charAt(i));
			if (end == 0) {
				if (matcher.patternMatcher(regex, buf.toString())) {
					end = i+1 ;
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

	
	// TODO clarified javadoc
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
