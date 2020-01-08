package std.fle;

import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import fle.toolBox.filesManagement.PropertiesToHashMap;

public class Config {
	final static String JSP_COMPOMENTS_PATH_SRC = "/resources/01_properties/jspPath.properties";
	
	
	public static Map<String,String> jspCompomentsPath(ServletContext context) {
		PropertiesToHashMap prop = new PropertiesToHashMap(context, JSP_COMPOMENTS_PATH_SRC);
		return prop.getPropertiesToHashMap();
	}

}
