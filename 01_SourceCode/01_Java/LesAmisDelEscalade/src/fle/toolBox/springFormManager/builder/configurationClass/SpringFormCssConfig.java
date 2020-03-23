package fle.toolBox.springFormManager.builder.configurationClass;

import fle.toolBox.ConfigurationFileReader;
/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote allow to set the needed Spring Form css information via configuration file.
 * @see {@link #cssConfigFile}
 */
public class SpringFormCssConfig {

	private String styleSheetPath;
	private String cssFileName;
	private String labelStyle;
	private String labelErrorStyle;
	private String inputStyle;
	private String inputStyleError;
	private String selectStyle;
	private String selectStyleError;
	private String errorStyle;
	private String buttonStyle;
	private ConfigurationFileReader cssConfig;

	public String getStyleSheetPath() {
		return styleSheetPath;
	}

	public String getCssFileName() {
		return cssFileName;
	}

	public String getLabelStyle() {
		return labelStyle;
	}

	public String getLabelErrorStyle() {
		return labelErrorStyle;
	}

	public String getInputStyle() {
		return inputStyle;
	}

	public String getInputStyleError() {
		return inputStyleError;
	}

	public String getSelectStyle() {
		return selectStyle;
	}

	public String getSelectStyleError() {
		return selectStyleError;
	}

	public String getErrorStyle() {
		return errorStyle;
	}

	public String getButtonStyle() {
		return buttonStyle;
	}

	/**
	 * 
	 * @param path the configuration file path
	 * @return this class with a ConfigurationFileReader instanciated.
	 * and so allow settings via configuration file.
	 * @see {@link ConfigurationFileReader }
	 */
	public SpringFormCssConfig cssConfigFile(String path) {
		cssConfig = new ConfigurationFileReader(path);
		return this;
	}
	
	
	public SpringFormCssConfig styleSheetPath(String propertyKey) {
		styleSheetPath = cssConfig.getProperty(propertyKey);
		return this;
	}

	
	public SpringFormCssConfig selectStyleError(String propertyKey) {
		selectStyleError = cssConfig.getProperty(propertyKey);
		return this;
	}

	
	public SpringFormCssConfig selectStyle(String propertyKey) {
		selectStyle = cssConfig.getProperty(propertyKey);
		return this;
	}

	
	public SpringFormCssConfig labelStyle(String propertyKey) {
		labelStyle = cssConfig.getProperty(propertyKey);
		return this;
	}

	
	public SpringFormCssConfig labelErrorStyle(String propertyKey) {
		System.out.println(cssConfig.getProperty(propertyKey));
		labelErrorStyle = cssConfig.getProperty(propertyKey);
		return this;
	}

	
	public SpringFormCssConfig inputStyleError(String propertyKey) {
		inputStyleError = cssConfig.getProperty(propertyKey);
		return this;
	}

	
	public SpringFormCssConfig inputStyle(String propertyKey) {
		inputStyle = cssConfig.getProperty(propertyKey);
		return this;
	}

	
	public SpringFormCssConfig errorStyle(String propertyKey) {
		errorStyle = cssConfig.getProperty(propertyKey);
		return this;
	}

	
	public SpringFormCssConfig cssFileName(String propertyKey) {
		cssFileName = cssConfig.getProperty(propertyKey);
		return this;
	}

	
	public SpringFormCssConfig buttonStyle(String propertyKey) {
		buttonStyle = cssConfig.getProperty(propertyKey);
		return this;
	}

	


}
