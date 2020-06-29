package fle.toolBox.filesManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import fle.toolBox.logger.Log4J2;

/**
 * 
 * @author Frederic Leroux
 * @note PropertyFile classe allow to set and get properties from a
 *       file.properties. <br>
 *       - the constructor give the possibility to create the properties file if
 *       needed(paramater boolean createFile)<br>
 *       -the method setProperty() allow to create a new pair (key,value),
 *       however if the key already exist this method will update the associated
 *       value
 * @important <b><u> In a context of a web application use simple constructor
 *            then in a controller wich need information from properties file
 *            use setInputStreamForWebApp() method</b></u>
 */
public class PropertyFile {

	private Properties property = new Properties();
	private String propertiesFilePath = null;
	private InputStream input = null;
	private OutputStream output = null;
	private FilesManagement file = new FilesManagement();
	private Log4J2<PropertyFile> logger = new Log4J2<PropertyFile>(this);

	public PropertyFile() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param propertiesFilePath the file where to find/save the properties file
	 * @param createFile         boolean true system will create the file, false
	 *                           file should be already in
	 */
	public PropertyFile(String propertiesFilePath, boolean createFile) {
		this.propertiesFilePath = propertiesFilePath;
		if (!createFile) {
			try {
				input = new FileInputStream(propertiesFilePath);
			} catch (FileNotFoundException e) {
				logger.log().fatal(e);
			}
		} else {
			file.createFile(propertiesFilePath);
			try {
				input = new FileInputStream(propertiesFilePath);
			} catch (FileNotFoundException e1) {
				logger.log().fatal(e1);
			}
		}

	}

	/**
	 * 
	 * @param inputStream the inputStream to set
	 */
	public PropertyFile(InputStream inputStream) {
		input = inputStream;

	}

	public String getPropertiesFilePath() {
		return propertiesFilePath;
	}

	public void setPropertiesFilePath(String propertiesFilePath) {
		this.propertiesFilePath = propertiesFilePath;
	}

	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}

	/**
	 * Allow to get the ressource file from a controller in a WebApp context
	 * 
	 * @param context
	 * @param propertiesFilePath
	 */
	public void setInputStreamForWebApp(ServletContext context, String propertiesFilePath) {
		input = context.getResourceAsStream(propertiesFilePath);
	}

	public String getProperty(String propertyKey) {
		try {
			property.load(input);
		} catch (IOException e) {
			logger.log().warn(e);
		}
		return property.getProperty(propertyKey);
	}

	/**
	 * @important <b><u>Can not be used in a WebApp context properties can be read
	 *            from WebApp not be created seem's to be logical</b></u>
	 * @param propertyKey
	 * @param propertyValue
	 */
	public void setProperty(String propertyKey, String propertyValue) {
		try {
			property.load(input);
		} catch (IOException e) {
			logger.log().warn(e);
		}
		property.setProperty(propertyKey, propertyValue);
		try {
			output = new FileOutputStream(propertiesFilePath);
		} catch (FileNotFoundException e) {
			logger.log().fatal(e);
		}
		try {
			property.store(output, null);
		} catch (IOException e) {
			logger.log().warn(e);
		}
	}

}