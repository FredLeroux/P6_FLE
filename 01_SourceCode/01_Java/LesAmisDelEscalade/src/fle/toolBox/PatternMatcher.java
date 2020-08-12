package fle.toolBox;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher  {



	/**
	 *
	 * @param regex
	 * @param toCheck data to test against the regex
	 * @return true if and only if toCheck match regex
	 * @throws NullPointerException
	 */
	public static final boolean isMatch(String regex,String toCheck) {
		if(regex!=null || toCheck != null) {
			Pattern pattern = Pattern.compile(regex);
			Matcher match = pattern.matcher(toCheck);
			boolean result = match.matches();
			return result;
		}else {
			throw new NullPointerException();
		}
	}

	public String patternMatcherString(String str,String regex) {
		String result = null;
		Pattern patt = Pattern.compile(regex);
		Matcher matcher = patt.matcher(str);
		if (matcher.find()) {
		    result = matcher.group();
		} else {
		    return null;
		}
		return result;
	}

}
