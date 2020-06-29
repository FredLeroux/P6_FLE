package fle.toolBox.springFormManager.limitCharCountDowJS;

import fle.toolBox.javaScriptGenerator.JavaScriptTag;

public class LimitCountDownJavaScriptFunction extends JavaScriptTag {

	public void addCountCharLeftFunction(StringBuilder stringBuilder, String displayLocId, String maxChar,
			String stringLocId) {
		stringBuilder.append(getUpdateCharLeftFunction(displayLocId, maxChar, stringLocId));
		stringBuilder.append(getCountCharLeftFunction(displayLocId, maxChar, stringLocId));

	}

	private String getUpdateCharLeftFunction(String displayLocId, String maxChar, String stringLocId) {
		String[] args = { stringToJSString(displayLocId), stringToJSString(maxChar), stringToJSString(stringLocId) };
		return jsFunction("updateCharOnInput", args);
	}
	
	private String getCountCharLeftFunction(String displayLocId, String maxChar, String stringLocId) {
		String[] args = { stringToJSString(displayLocId), stringToJSString(maxChar), stringToJSString(stringLocId) };
		return jsFunction("countCharLeft", args);
	}
	

}
