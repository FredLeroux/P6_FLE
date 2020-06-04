package fle.toolBox;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote contains some extrators to use on a string<br>
 * {@link #extractorForward(String, String)}<br>
 * {@link #extractorReverse(String, String)}<br>
 * {@link #extractAllAfterLastIndexOf(String, String)}
 *
 */

public class StringExtractor {

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
				if (PatternMatcher.isMatch(regex, buf.toString())) {
					start = i;
				} else {
					start = -1;
				}
			} else {
				if (end == 0) {
					if (!PatternMatcher.isMatch(regex, buf.toString())) {
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
				if (PatternMatcher.isMatch(regex, buf.toString())) {
					end = i + 1;
				} else {
					end = 0;
				}
			} else {
				if (start == 0) {
					if (!PatternMatcher.isMatch(regex, buf.toString())) {
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

	/**
	 * 
	 * @param sourceString the string wher to extract substring
	 * @param toFind       the char or charsequence wich will define the begining of
	 *                     the substring, this methos is exclusive and will not
	 *                     enclose "toFind" in the substring.<br>
	 *                     Example: <br>
	 *                     for a string "alpha.beta.gamma"
	 *                     this method will return  "gamma" with "toFind" = ".".
	 *                     
	 * @return a substring stating after the last index of toFind.
	 */
	public String extractAllAfterLastIndexOf(String sourceString, String toFind) {
		return sourceString.substring(lastIndexOfCharInString(sourceString, toFind));
	}

	private Integer lastIndexOfCharInString(String sourceString, String toFind) {
		return sourceString.lastIndexOf(toFind)+1;
	}

}
