package fle.toolBox.springFormManager.builder.annotationsManagement;

import fle.toolBox.ConfigurationFileReader;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote class containing all data from a SpringFormSettings annotation
 */
public class SpringFormSettingsAnnotationData {
	private String formName;
	private String action;
	private String method;
	private String modelAttribute;
	private String buttonMessage;
	private String buttonAlignment;
	private boolean readOnly;
	private String jspFilePath;
	private String labelMessageSourceSuffix;	
	private ConfigurationFileReader configFile;

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getModelAttribute() {
		return modelAttribute;
	}

	public void setModelAttribute(String modelAttribute) {
		this.modelAttribute = modelAttribute;
	}

	public String getButtonMessage() {
		return buttonMessage;
	}

	public void setButtonMessage(String buttonMessage) {
		this.buttonMessage = buttonMessage;
	}

	public String getButtonAlignment() {
		return buttonAlignment;
	}

	public void setButtonAlignment(String buttonAlignment) {
		this.buttonAlignment = buttonAlignment;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public String getJspFilePath() {
		return jspFilePath;
	}

	public void setJspFilePath(String jspFilePath) {
		if(configFile.getProperty(jspFilePath)==null) {
			this.jspFilePath = jspFilePath;
		}else {
			this.jspFilePath = configFile.getProperty(jspFilePath);
		}
		
	}

	public String getLabelMessageSourceSuffix() {
		return labelMessageSourceSuffix;
	}

	public void setLabelMessageSourceSuffix(String labelMessageSourceSuffix) {
		this.labelMessageSourceSuffix = labelMessageSourceSuffix;
	}

	public ConfigurationFileReader getConfigFile() {
		return configFile;
	}

	public void setConfigFile(String propertiesFilePath) {
		this.configFile = new ConfigurationFileReader(propertiesFilePath);
	}

	
}
