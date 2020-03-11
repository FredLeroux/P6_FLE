package fle.toolBox.filesManagement;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;

import javax.servlet.ServletContext;



import fle.toolBox.logger.Log4J2;

public class PropertiesToHashMap  {

	

	private Properties prop = new Properties();
	private PropertyFile propertyFile = new PropertyFile();
	private Log4J2<PropertiesToHashMap> logger = new Log4J2<PropertiesToHashMap>(this);
	
	public PropertiesToHashMap(ServletContext context, String propertiesFilePath) {
		propertyFile.setInputStreamForWebApp(context, propertiesFilePath);
	}
	
	private Properties prop() {		
		try {
			prop.load(propertyFile.getInput());
		} catch (IOException e) {
			logger.log().fatal(e);
		}		
		return prop;
	}
	
	public LinkedHashMap<String, String> getPropertiesToHashMap() {
		LinkedHashMap<String, String>  map = new LinkedHashMap<>();
		prop().forEach((key,value)-> map.put(key.toString(), value.toString()));
		return map;
		
	}
	
	
}
