package fle.toolBox.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Log4J2<O extends Object> {
	
	private  Logger logger;
	private O clazz;
	public Log4J2(O clazz) {
		this.clazz=clazz;
	}
	
	public Logger log () {
		logger = LogManager.getLogger(clazz);
		return logger;
	}
	
	
	
	
	
	
}
