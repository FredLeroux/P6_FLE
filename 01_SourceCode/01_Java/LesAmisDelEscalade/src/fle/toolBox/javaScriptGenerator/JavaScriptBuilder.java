package fle.toolBox.javaScriptGenerator;

import java.util.Arrays;
import java.util.LinkedHashSet;

import fle.toolBox.exceptionsThrower.ExceptionsThrower;

//TODO 1-JAVADOC
public class JavaScriptBuilder extends JavaScriptTag {

	public StringBuilder openScript(StringBuilder stringBuilder) {
		return stringBuilder.append(getScriptSourceOpenTag() + getCloseTag());
	}

	public StringBuilder closeScript(StringBuilder stringBuilder) {
		return stringBuilder.append(getScriptSourceCloseTag());
	}

	public StringBuilder addVarsFromModel(StringBuilder stringBuilder, String[] vars) {
		LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(vars));
		ExceptionsThrower.ifDifferent(set.size(), vars.length);
		set.forEach(str -> stringBuilder.append(varFromModel(str, str)));
		return stringBuilder;
	}

	public StringBuilder addVarsFromModel(StringBuilder stringBuilder, String var) {
		stringBuilder.append(varFromModel(var, var));
		return stringBuilder;
	}

	/**
	 * 
	 * @param stringBuilder
	 * @param filePath      the full file path with file name
	 * @return Stringbuilder appended with script link to JavaScript file source
	 */
	public StringBuilder openScriptWithSRC(StringBuilder stringBuilder, String filePath) {
		stringBuilder.append(getScriptSourceOpenTag());
		stringBuilder.append(" src=${pageContext.request.contextPath}/" + filePath);
		stringBuilder.append(getCloseTag());
		return stringBuilder;

	}

}
