package fle.toolBox.springFormManager.builder.tagLibraries.spring;

import fle.toolBox.exceptionsThrower.ExceptionsThrower;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote this class contains methods returning as string different
 *          "http://www.springframework.org/tags/form" &
 *          "http://www.springframework.org/tags" tags and allow to generate a
 *          StringBuilder used to build a Spring Formular at compile time
 * 
 */

public abstract class SpringTagFormular {

	private String tagLibFormsUri = "http://www.springframework.org/tags/form";
	private String tagLibFormsPrefix = "springForm";
	private String tagLibTagsUri = "http://www.springframework.org/tags";
	private String tagLibTagsPrefix = "springTag";
	private String styleSheetPath = null;
	private String cssFileName = null;
	private String openTagFormPrefixed = "<" + this.tagLibFormsPrefix + ":";
	private String closeTagFormPrefixed = "</" + this.tagLibFormsPrefix + ":";
	private String openTagTagsPrefixed = "<" + this.tagLibTagsPrefix + ":";
	private String closeTagTagsPrefixed = "</" + this.tagLibTagsPrefix + ":";
	private String endTagAttributes = " >";
	private String closeTag = "/>";
	private String ln = "\n";// may add <br> but I don't think is use full in a table
	private String statusError = null;
	private String labelCssClass = null;
	private String labelCssErrorClass = null;
	private String inputCssClass = null;
	private String inputCssErrorClass = null;
	private String selectCssClass = null;
	private String selectCssErrorClass = null;
	private String errorsCssClass = null;
	private String buttonCssClass = null;
	private String idAttribut = " id =";
	private String pathAttribut = " path=";
	private String codeAttribut = " code=";
	private String varAttribut = " var=";
	private String formAttribut = " form=";
	private String nameAttribut = " name=";
	private String inputReadOnly = " readonly = 'true' ";
	private String placeHolderAttribut = " placeholder=";
	private String colSpanAttribut = " colspan =";
	private String formtagName = "form";
	private String hiddenTagName = "hidden";
	private String labelTagName = "label";
	private String bindTagName = "bind";
	private String messageTagName = "message";
	private String inputTagName = "input";
	private String selectTagName = "select";
	private String errorTagName = "errors";
	private String buttonTagName = "button";
	private String passWordTagName = "password"; 

	protected String getOpenTagFormPrefixed() {
		return openTagFormPrefixed;
	}

	protected void setOpenTagFormPrefixed(String openTagFormPrefixed) {
		this.openTagFormPrefixed = openTagFormPrefixed;
	}

	protected String getCloseTagFormPrefixed() {
		return closeTagFormPrefixed;
	}

	protected void setCloseTagFormPrefixed(String closeTagFormPrefixed) {
		this.closeTagFormPrefixed = closeTagFormPrefixed;
	}

	protected String getOpenTagTagsPrefixed() {
		return openTagTagsPrefixed;
	}

	protected void setOpenTagTagsPrefixed(String openTagTagsPrefixed) {
		this.openTagTagsPrefixed = openTagTagsPrefixed;
	}

	protected String getCloseTagTagsPrefixed() {
		return closeTagTagsPrefixed;
	}

	protected void setCloseTagTagsPrefixed(String closeTagTagsPrefixed) {
		this.closeTagTagsPrefixed = closeTagTagsPrefixed;
	}

	protected String getEndTagAttributes() {
		return endTagAttributes;
	}

	protected void setEndTagAttributes(String endTagAttributes) {
		this.endTagAttributes = endTagAttributes;
	}

	protected String getCloseTag() {
		return closeTag;
	}

	protected void setCloseTag(String closeTag) {
		this.closeTag = closeTag;
	}

	protected String getLn() {
		return ln;
	}

	protected void setLn(String ln) {
		this.ln = ln;
	}

	protected String getIdAttribut() {
		return idAttribut;
	}

	protected void setIdAttribut(String idAttribut) {
		this.idAttribut = idAttribut;
	}

	protected String getVarAttribut() {
		return varAttribut;
	}

	protected String createId(String name, String componentType) {
		return getIdAttribut() + argument(name + "." + componentType);
	}

	protected String createId(String name) {
		return getIdAttribut() + argument(name);
	}

	protected void setVarAttribut(String varAttribut) {
		this.varAttribut = varAttribut;
	}

	protected String getFormAttribut() {
		return formAttribut;
	}

	protected void setFormAttribut(String formAttribut) {
		this.formAttribut = formAttribut;
	}

	protected String getNameAttribut() {
		return nameAttribut;
	}

	protected void setNameAttribut(String nameAttribut) {
		this.nameAttribut = nameAttribut;
	}

	protected String getPlaceHolderAttribut() {
		return placeHolderAttribut;
	}

	protected void setPlaceHolderAttribut(String placeHolderAttribut) {
		this.placeHolderAttribut = placeHolderAttribut;
	}

	protected String getColSpanAttribut() {
		return colSpanAttribut;
	}

	protected void setColSpanAttribut(String colSpanAttribut) {
		this.colSpanAttribut = colSpanAttribut;
	}

	protected void setStatusError(String statusError) {
		this.statusError = statusError;
	}

	protected String getBindTagName() {
		return bindTagName;
	}

	protected void setBindTagName(String bindTagName) {
		this.bindTagName = bindTagName;
	}

	protected String getButtonTagName() {
		return buttonTagName;
	}

	protected void setButtonTagName(String buttonTagName) {
		this.buttonTagName = buttonTagName;
	}

	protected String getPlaceHolder() {
		return placeHolderAttribut;
	}

	protected void setPlaceHolder(String placeHolder) {
		this.placeHolderAttribut = placeHolder;
	}

	protected String getInputTagName() {
		return inputTagName;
	}

	protected void setInputTagName(String inputTagName) {
		this.inputTagName = inputTagName;
	}

	protected String getSelectTagName() {
		return selectTagName;
	}

	protected void setSelectTagName(String selectTagName) {
		this.selectTagName = selectTagName;
	}

	protected String getCodeAttribut() {
		return codeAttribut;
	}

	protected void setCodeAttribut(String codeAttribut) {
		this.codeAttribut = codeAttribut;
	}

	protected String getMessageTagName() {
		return messageTagName;
	}

	protected void setMessageTagName(String messageTagName) {
		this.messageTagName = messageTagName;
	}

	protected String getLabelTagName() {
		return labelTagName;
	}

	protected void setLabelTagName(String labelTagName) {
		this.labelTagName = labelTagName;
	}

	protected String getFormtagName() {
		return formtagName;
	}

	protected void setFormtagName(String formtagName) {
		this.formtagName = formtagName;
	}

	protected String getHiddenTagName() {
		return hiddenTagName;
	}

	protected void setHiddenTagName(String hiddenTagName) {
		this.hiddenTagName = hiddenTagName;
	}

	protected String getPathAttribut() {
		return pathAttribut;
	}

	protected void setPathAttribut(String pathAttribut) {
		this.pathAttribut = pathAttribut;
	}

	private String argument(String argument) {
		return "'" + argument + "'";
	}

	private String htmlVar(String var) {
		return "'${" + var + "}'";
	}

	protected String openFormTag(String tagName) {
		return openTagFormPrefixed + tagName;
	}

	protected String openFormTag(String tagName, String path) {
		return openTagFormPrefixed + tagName + pathAttribut + argument(path);
	}

	protected String openFormTag(String tagName, String path, String close) {
		return openTagFormPrefixed + tagName + pathAttribut + argument(path) + close;
	}

	protected String closeFormTag(String tagName) {
		return closeTagFormPrefixed + tagName + endTagAttributes;
	}

	protected String openTagsTag(String tagName) {
		return openTagTagsPrefixed + tagName;
	}

	protected String openTagsTag(String tagName, String path, String close) {
		return openTagTagsPrefixed + tagName + pathAttribut + argument(path) + close;
	}

	protected String closeTagsTag(String tagName) {
		return closeTagTagsPrefixed + tagName + endTagAttributes;
	}

	protected String tagLibForms() {
		return "<%@ taglib uri=" + argument(tagLibFormsUri) + " prefix=" + argument(tagLibFormsPrefix) + " %>" + ln;
	}

	protected String getTagLibFormsUri() {
		return tagLibFormsUri;
	}

	protected void setTagLibFormsUri(String tagLibFormsUri) {
		this.tagLibFormsUri = tagLibFormsUri;
	}

	protected String getTagLibFormsPrefix() {
		return tagLibFormsPrefix;
	}

	protected void setTagLibFormsPrefix(String tagLibFormsPrefix) {
		this.tagLibFormsPrefix = tagLibFormsPrefix;
	}

	protected String taglibTags() {
		return "<%@ taglib uri=" + argument(tagLibTagsUri) + " prefix=" + argument(tagLibTagsPrefix) + " %>" + ln;
	}

	protected String getTagLibTagsUri() {
		return tagLibTagsUri;
	}

	protected void setTagLibTagsUri(String tagLibTagsUri) {
		this.tagLibTagsUri = tagLibTagsUri;
	}

	protected String getTagLibTagsPrefix() {
		return tagLibTagsPrefix;
	}

	protected void setTagLibTagsPrefix(String tagLibTagsPrefix) {
		this.tagLibTagsPrefix = tagLibTagsPrefix;
	}

	protected String getStyleSheetPath() {
		ExceptionsThrower.ifNull(styleSheetPath);
		return styleSheetPath;
	}

	protected void setStyleSheetPath(String styleSheetPath) {
		this.styleSheetPath = styleSheetPath;
	}

	protected String getCssFileName() {
		return cssFileName;
	}

	protected void setCssFileName(String cssFileName) {
		ExceptionsThrower.ifNull(cssFileName);
		this.cssFileName = cssFileName;
	}

	protected String addLinkedStyleSheet() {
		return "<link rel='stylesheet' type='text/css' href ='" + getStyleSheetPath() + "/" + getCssFileName() + "'/>"
				+ ln;
	}

	protected String formHeader(String action, String method, String modelAttribut, String name) {		
		return openFormTag(formtagName) + " action = " + argument(action) + " method = " + argument(method)
				+ " modelAttribute = " + argument(modelAttribut) + createId(name) + endTagAttributes + ln;
	}

	protected String formClose() {
		return closeFormTag(formtagName) + ln;
	}

	protected String tableStart() {
		return "<table>" + ln;
	}

	protected String tableStart(String tableId) {
		return "<table" + idAttribut + argument(tableId) + ">" + ln;
	}

	protected String tableEnd() {
		return "</table>" + ln;
	}

	protected String tableRowStart() {
		return "<tr>" + ln;
	}

	protected String tableRowStart(String tableRowId) {
		return "<tr" + idAttribut + argument(tableRowId) + ">" + ln;
	}

	protected String tableRowEnd() {
		return "</tr>" + ln;
	}

	protected String tableCellStart() {
		return "<td>" + ln;
	}

	protected String tableCellStart(String tableCellId) {
		return "<td" + idAttribut + argument(tableCellId) + endTagAttributes + ln;
	}

	protected String tableCellStartWithColSpan(int cellNumber, String align) {
		return "<td colspan= " + argument(Integer.toString(cellNumber)) + " align= " + align + endTagAttributes + ln;
	}

	protected String tableCellStartWithColSpan(String tableCellId, int cellNumber) {
		return "<td" + idAttribut + argument(tableCellId) + argument(Integer.toString(cellNumber)) + endTagAttributes
				+ ln;
	}

	protected String tableCellEnd() {
		return "</td>" + ln;
	}

	protected String hiddenPath(String path) {
		return openFormTag(hiddenTagName, path, closeTag) + ln;
	}

	protected String bindStart(String path) {
		return openTagsTag(bindTagName, path, closeTag) + ln;
	}

	// TODO here add springbind end
	protected String bindEnd() {
		return closeTagsTag(bindTagName);
	}

	protected String getStatusError() throws NullPointerException {
		if (statusError == null) {
			throw new NullPointerException("StatusError not setted");
		}
		return statusError;
	}

	/**
	 * this set will make getStatusError return boolean value
	 */
	protected void setStatusError() {
		this.statusError = "${status.error}";
	}

	/**
	 * This set will make getStatusError return custom true message if true, false
	 * message if fasle
	 * 
	 * @param customTrueMessage
	 * @param customFasleMessage
	 */

	protected void setStatusError(String customTrueMessage, String customFasleMessage) {
		this.statusError = "${status.error ? \"" + customTrueMessage + "\":\"" + customFasleMessage + "\"}";
	}

	protected String cssClass(String cssClass) {
		return " cssClass = " + argument(cssClass);
	}

	protected String cssErrorClass(String cssClass) {
		return " cssErrorClass = " + argument(cssClass);
	}

	protected String getLabelCssClass() throws NullPointerException {
		ExceptionsThrower.ifNull(labelCssClass);
		return labelCssClass;
	}

	protected void setLabelCssClass(String labelCssClass) {
		this.labelCssClass = cssClass(labelCssClass);
	}

	protected String getLabelCssErrorClass() throws NullPointerException {
		ExceptionsThrower.ifNull(labelCssErrorClass);
		return labelCssErrorClass;
	}

	protected void setLabelCssErrorClass(String labelCssErrorClass) {
		this.labelCssErrorClass = cssErrorClass(labelCssErrorClass);
	}

//TODO 0- modif add check empty
	protected String getInputCssClass() {
		// ExceptionsThrower.ifNull(inputCssClass);
		return inputCssClass;
	}

	protected void setInputCssClass(String inputCssClass) {
		this.inputCssClass = cssClass(inputCssClass);
	}

	protected String getInputCssErrorClass() {
		ExceptionsThrower.ifNull(inputCssErrorClass);
		return inputCssErrorClass;
	}

	protected void setInputCssErrorClass(String inputCssErrorClass) {
		this.inputCssErrorClass = cssErrorClass(inputCssErrorClass);
	}

	protected String getSelectCssClass() {
		return selectCssClass;
	}

	protected void setSelectCssClass(String selectCssClass) {
		this.selectCssClass = cssClass(selectCssClass);
	}

	protected String getSelectCssErrorClass() {
		return selectCssErrorClass;
	}

	protected void setSelectCssErrorClass(String selectCssErrorClass) {
		this.selectCssErrorClass = cssErrorClass(selectCssErrorClass);
	}

	protected String getErrorsCssClass() {
		ExceptionsThrower.ifNull(errorsCssClass);
		return errorsCssClass;
	}

	protected void setErrorsCssClass(String errorsCssClass) {
		this.errorsCssClass = cssClass(errorsCssClass);
	}

	protected String getButtonCssClass() {
		ExceptionsThrower.ifNull(buttonCssClass);
		return buttonCssClass;
	}

	protected void setButtonCssClass(String buttonCssClass) {
		this.buttonCssClass = " class= " + argument(buttonCssClass);
	}

	protected String label(String path, String text) {
		return openFormTag(labelTagName, path, endTagAttributes) + text + closeFormTag(labelTagName) + ln;

	}

	protected String labelCssClass(String path, String text) throws NullPointerException {

		return openFormTag(labelTagName, path) + getLabelCssClass() + endTagAttributes + text
				+ closeFormTag(labelTagName) + ln;
	}

	protected String labelCssClassCssErrorClass(String path, String text) throws NullPointerException {
		return openFormTag(labelTagName, path) + getLabelCssClass() + getLabelCssErrorClass() + endTagAttributes + text
				+ closeFormTag(labelTagName) + ln;
	}

	protected String message(String code) {
		ExceptionsThrower.ifNull(code);
		return openTagsTag(messageTagName) + codeAttribut + argument(code) + closeTag;
	}

	protected String messageWithStatusError(String code) throws NullPointerException {
		return openTagsTag(messageTagName) + codeAttribut + argument(code) + closeTag + getStatusError() + ln;
	}

	protected String messageWithVar(String code, String varName) {
		return openTagsTag(messageTagName) + codeAttribut + argument(code) + varAttribut + argument(varName) + closeTag
				+ ln;
	}

	protected String hiddenStatusErrorCell(String cellId) throws NullPointerException {
		return "<td " + idAttribut + argument(cellId) + "hidden=" + argument("true") + endTagAttributes
				+ getStatusError() + tableCellEnd() + ln;
	}

	/**
	 * 
	 * @param path is the path to the entity model field i.e. for a field in a
	 *             simple entity model is id path is the fieldName id
	 * @return
	 */
	protected String input(String path) {
		return openFormTag(inputTagName, path, closeTag) + ln;
	}

	protected String inputCssClass(String path) {
		return openFormTag(inputTagName, path) + getInputCssClass() + closeTag + ln;
	}

	protected String inputCssClassCssErrorClass(String path) {
		return openFormTag(inputTagName, path) + getInputCssClass() + getInputCssErrorClass() + closeTag + ln;
	}

	protected String inputReadOnly(String path) {
		return openFormTag(inputTagName, path) + inputReadOnly + closeTag + ln;
	}

	protected String inputCssClassReadOnly(String path) {
		return openFormTag(inputTagName, path) + getInputCssClass() + inputReadOnly + closeTag + ln;
	}

	protected String inputCssClassCssErrorClassReadOnly(String path) {
		return openFormTag(inputTagName, path) + getInputCssClass() + getInputCssErrorClass() + inputReadOnly + closeTag
				+ ln;
	}

	protected String inputPLaceHolder(String path, String placeHolderTxt) {
		return openFormTag(inputTagName, path) + placeHolderAttribut + argument(placeHolderTxt) + closeTag + ln;
	}

	protected String inputCssClassPlaceHolder(String path, String placeHolderTxt) {
		return openFormTag(inputTagName, path) + getInputCssClass() + placeHolderAttribut + argument(placeHolderTxt)
				+ closeTag + ln;
	}

	protected String inputCssClassCssErrorClassPlaceHolder(String path, String placeHolderTxt) {
		return openFormTag(inputTagName, path) + getInputCssClass() + getInputCssErrorClass() + placeHolderAttribut
				+ argument(placeHolderTxt) + closeTag + ln;
	}

	protected String inputTagMessagePlaceHolder(String path, String code) {
		StringBuilder inputFinal = new StringBuilder();
		String varName = code.replace(" ", ".").replace(".", "");
		String message = messageWithVar(code, varName) + ln;
		String input = openFormTag(inputTagName, path) + placeHolderAttribut + htmlVar(varName) + closeTag + ln;
		inputFinal.append(message);
		inputFinal.append(input);
		return inputFinal.toString();
	}

	protected String inputCssClassTagMessagePlaceHolder(String path, String code) {
		StringBuilder inputFinal = new StringBuilder();
		String varName = code.replace(" ", ".").replace(".", "");
		String message = messageWithVar(code, varName) + ln;
		String input = openFormTag(inputTagName, path) + getInputCssClass() + placeHolderAttribut + htmlVar(varName)
				+ closeTag + ln;
		inputFinal.append(message);
		inputFinal.append(input);
		return inputFinal.toString();
	}

	protected String inputCssClassCssErrorClassTagMessagePlaceHolder(String path, String code) {
		StringBuilder inputFinal = new StringBuilder();
		String varName = code.replace(" ", ".").replace(".", "");
		String message = messageWithVar(code, varName) + ln;
		String input = openFormTag(inputTagName, path) + getInputCssClass() + getInputCssErrorClass()
				+ placeHolderAttribut + htmlVar(varName) + closeTag + ln;
		inputFinal.append(message);
		inputFinal.append(input);
		return inputFinal.toString();
	}
	
	

	protected String select(String path, String targetForm) {
		return openFormTag(selectTagName, path) + createId(path, selectTagName) + getFormAttribut()
				+ argument(targetForm) + closeTag + ln;
	}

	protected String selectCssClass(String path, String targetForm) {
		return openFormTag(selectTagName, path) + createId(path, selectTagName) + getFormAttribut()
				+ argument(targetForm) + getSelectCssClass() + closeTag + ln;
	}

	protected String selectCssClassCssErrorClass(String path, String targetForm) {
		return openFormTag(selectTagName, path) + createId(path, selectTagName) + getFormAttribut()
				+ argument(targetForm) + getSelectCssClass() + getSelectCssErrorClass() + closeTag + ln;
	}
	
	protected String passWord(String path) {
		return openFormTag(passWordTagName, path, closeTag) + ln;
	}

	protected String passWordCssClass(String path) {
		return openFormTag(passWordTagName, path) + getInputCssClass() + closeTag + ln;
	}

	protected String passWordCssClassCssErrorClass(String path) {
		return openFormTag(passWordTagName, path) + getInputCssClass() + getInputCssErrorClass() + closeTag + ln;
	}
	
	protected String passWordCssClassCssErrorClassTagMessagePlaceHolder(String path, String code) {
		StringBuilder passWordInputFinal = new StringBuilder();
		String varName = code.replace(" ", ".").replace(".", "");
		String message = messageWithVar(code, varName) + ln;
		String input = openFormTag(passWordTagName, path) + getInputCssClass() + getInputCssErrorClass()
				+ placeHolderAttribut + htmlVar(varName) + closeTag + ln;
		passWordInputFinal.append(message);
		passWordInputFinal.append(input);
		return passWordInputFinal.toString();
	}

	protected String errors(String path) {
		return openFormTag(errorTagName, path) + getErrorsCssClass() + closeTag + ln;
	}

	protected String inputButton(String buttonText) {
		return openFormTag(buttonTagName) + getButtonCssClass() + endTagAttributes + message(buttonText)
				+ closeFormTag(buttonTagName) + ln;
	}

}
