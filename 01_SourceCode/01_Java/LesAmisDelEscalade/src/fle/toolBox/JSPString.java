/**
 * 
 */
package fle.toolBox;

/**
 * @author Frederic Leroux <br>
 *         Parse a java String to a JSP String<br>
 *         i.e add simple quotes to the string in order to convert it to a
 *         String for JSP files and so not be considered as a variable<br>
 * @example <br>
 *          for a String alphaString = "alpha"; returns a String to JSP File
 *          "'alpha'";
 */
public final class JSPString {
	
	/**
	 * 
	 * @param toParse String to surround with simple quote;
	 * @return String toParse with surrounded with simple quote
	 */
	public static String parse(String toParse) {
		String quote = "'";
		String parsed = quote.concat(toParse.concat(quote));
		return  parsed;
	}

}
