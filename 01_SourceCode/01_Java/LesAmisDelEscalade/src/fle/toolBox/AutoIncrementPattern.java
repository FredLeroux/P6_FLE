package fle.toolBox;

import java.text.DecimalFormat;

import fle.toolBox.FredParser;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0 <br>
 * @allow to increment a string pattern in function of last entry <br>
 *        example for a string as follow : <br>
 *        String fmi0001 use reverse = true <br>
 *        return fmi0002.
 * @note Significant digits are set automatically function of present digits
 *       number.<br>
 *       example a string test001 wil have 3 significant digits another with
 *       test10 will have 2 significant digits
 */
public class AutoIncrementPattern {

	private static StringExtractor extract = new StringExtractor();

	private static String num;
	private static Integer incrementAmount = 1;

	/**
	 * 
	 * @param lastEntry the string to be incremented(+1) *
	 * @param reverse   use true if Integer to be incremented is a this end of the
	 *                  string otherwise flase
	 * @default incremanation by default is +1
	 * @example AutoIncrementPattern.autoIncrement(<b>"fmi0001"</b>,true)<br>
	 *          will return string <b>fmi0002</b><br>
	 *          AutoIncrementPattern.autoIncrement(<b>"0010_+/fmi"</b>,false)<br>
	 *          will return string <b>0011_+/fmi</b><br>
	 *
	 */
	public static String autoIncrement(String lastEntry, boolean reverse) {
		return newEntry(lastEntry, extractInteger(lastEntry, reverse), increment());
	}

	/**
	 * 
	 * @param lastEntry      the string to be incremented(+1) *
	 * @param reverse        use true if Integer to be incremented is a this end of
	 *                       the string otherwise flase
	 * @param incrementation allow to set the incrementation amount
	 * @example AutoIncrementPattern.autoIncrement(<b>"fmi0001"</b>,true,10)<br>
	 *          will return string <b>fmi0011</b><br>
	 *          AutoIncrementPattern.autoIncrement(<b>"0010_+/fmi"</b>,false,5)<br>
	 *          will return string <b>0015_+/fmi</b><br>
	 */
	public static String autoIncrement(String lastEntry, boolean reverse, Integer incrementation) {
		incrementAmount = incrementation;
		return newEntry(lastEntry, extractInteger(lastEntry, reverse), increment());
	}

	private static String extractInteger(String lastEntry, boolean reverse) {
		String regexNum = "[0-9]";
		if (reverse) {
			num = extract.extractorReverse(lastEntry, regexNum);
		} else {
			num = extract.extractorForward(lastEntry, regexNum);
		}
		return num;
	}

	private static String increment() {
		String newNum = null;
		StringBuilder significantDigits = new StringBuilder();
		for (int i = 0; i < num.length(); i++) {
			significantDigits.append("0");
		}
		Integer Increment = FredParser.toInteger(num) + incrementAmount;
		newNum = new DecimalFormat(significantDigits.toString()).format(Increment);
		return newNum;
	}

	private static String newEntry(String lastEntry, String num, String newNum) {
		return lastEntry.replace(num, newNum);
	}

}
