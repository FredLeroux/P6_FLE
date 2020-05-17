package fle.toolBox.javaScriptGenerator;

import fle.toolBox.exceptionsThrower.ExceptionsThrower;

//TODO 1-JAVADOC
/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * 
 */
public abstract class JavaScriptTag {

	protected String ln = "\n";
	protected String scriptSourceOpenTag = "<script type='text/javascript'";
	protected String scriptSourceCloseTag = "</script>";
	protected String closeTag = ">";
	protected String sourceAttribute = " src= ";
	protected String charsetAttribute = " charset= ";
	protected String sourcePath = null;
	protected String javaScriptFileName = null;
	protected String charSet = "UTF-8";

	protected String getScriptSourceOpenTag() {
		return scriptSourceOpenTag;
	}

	protected String getScriptSourceCloseTag() {
		return scriptSourceCloseTag;
	}

	protected String getCloseTag() {
		return closeTag;
	}

	protected String getSourcePath() {
		ExceptionsThrower.ifNull(sourceAttribute);
		return sourcePath;
	}

	protected void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	protected String getJavaScriptFileName() {
		ExceptionsThrower.ifNull(javaScriptFileName);
		return javaScriptFileName;
	}

	/**
	 * 
	 * @param javaScriptFileName = Only name w/o .js
	 */
	protected void setJavaScriptFileName(String javaScriptFileName) {
		this.javaScriptFileName = "/" + javaScriptFileName + ".js";
	}

	/**
	 * 
	 * @return by default UTF-8
	 */
	protected String getCharSet() {
		return charSet;
	}

	/**
	 * 
	 * @param charSet by default set to UTF-8
	 */
	protected void setCharSet(String charSet) {
		this.charSet = charSet;
	}

	protected String javaScriptFileSrc() {
		return scriptSourceOpenTag + sourceAttribute + "'" + getSourcePath() + getJavaScriptFileName() + "'"
				+ charsetAttribute + "'" + getCharSet() + "'" + closeTag + scriptSourceCloseTag;
	}

	protected String var(String varName, String varObject) {
		return "var " + varName + "=" + varObject;
	}

	protected String varFromModel(String varName, String varModelObject) {
		return "var " + varName + "= ${" + varModelObject + "};" + ln;
	}

	/**
	 * stringToJSString = string to JavaScript String
	 * 
	 * @param str
	 * @return "'" + str +"'" = 'str' -> for JavaScript string
	 */
	protected String stringToJSString(String str) {
		return "'" + str + "'";
	}

	protected String jsFunction(String jsFunctionName, String[] jsFunctionArgs) {
		StringBuilder str = new StringBuilder();
		int length = jsFunctionArgs.length;
		if (length > 1) {
			for (int i = 0; i < length; i++) {
				if (i != (length - 1)) {
					str.append(jsFunctionArgs[i] + ",");
				} else {
					str.append(jsFunctionArgs[i]);
				}
			}
		} else {
			str.append(jsFunctionArgs[0]);
		}
		return jsFunctionName + "(" + str.toString() + ");" + ln;

	}

}
