package fle.toolBox.miscellaneous;

import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote set and load a properties file (xml or properties) via constructor.
 *          As class extends Properties.class all Properties methods are
 *          directly accessible
 * @see {@link #ConfigurationFileReader}
 * 
 *
 */
public class ConfigurationFileReader extends Properties {

	private static final long serialVersionUID = 304869985860375497L;

	private InputStream inStream;

	/**
	 * 
	 * @param path is the path to the configfile example for a configfile
	 *             configuration.properties in classpath package config path will be
	 *             "config/configuration.properties"
	 */
	public ConfigurationFileReader(String path) {
		setInStream(path);
		loadPropertiesFile(path);
	}

	private void setInStream(String path) {
		this.inStream = getClass().getClassLoader().getResourceAsStream(path);
	}

	private void loadPropertiesFile(String path) {
		try {
			if (path.toLowerCase().contains("xml")) {
				this.loadFromXML(inStream);
			} else {
				this.load(inStream);
			}
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
