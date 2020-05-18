/**
 * 
 */
package fle.toolBox;

/**
 * @author Frederic Leroux <br>
 *         Parse a java String to a JavaScript String to be used on JSP <br>
 *         i.e add simple quotes to the string in order to convert it to a
 *         String for JSP files and/or to be used in JavaScript part of the JSP file,
 *         and so not be considered as a variable<br>
 * @example <br>
 *          for a String alphaString = "alpha"; returns a String to JSP File
 *          "'alpha'";
 */
public final class JspJavaScriptStringParser {

	/**
	 * 
	 * @param toParse String to surround with simple quote;
	 * @return String toParse with surrounded with simple quote
	 */
	public static String parse(String toParse) {
		String quote = "'";
		String parsed = quote.concat(toParse.concat(quote));
		return parsed;
	}

}
