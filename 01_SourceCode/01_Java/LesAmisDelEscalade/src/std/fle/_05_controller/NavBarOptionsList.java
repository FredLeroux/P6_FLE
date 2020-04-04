package std.fle._05_controller;

import java.util.ArrayList;

import fle.toolBox.ConfigurationFileReader;

public class NavBarOptionsList {

	private ConfigurationFileReader config;
	private String splitter = "/";

	public NavBarOptionsList(String configFilePath) {
		config = new ConfigurationFileReader(configFilePath);
	}

	public String getSplitter() {
		return splitter;
	}

	public void setSplitter(String splitter) {
		this.splitter = splitter;
	}

	public ArrayList<NavBarOptions> getAllNavBarOptions(Integer levelRequired) {
		ArrayList<NavBarOptions> navBarOptions = new ArrayList<>();
		config.forEach((key, value) -> fillArrayFunctionLevelRequired(navBarOptions, levelRequired, (String) value));
		return navBarOptions;
	}

	private void fillArrayFunctionLevelRequired(ArrayList<NavBarOptions> array, Integer levelRequired, String value) {
		if (isAccesGranted(getNavBarOptionSecurityLevel(value), levelRequired)) {
			array.add(fillNavBarOptions(value));
			
		}
	}

	private Integer getNavBarOptionSecurityLevel(String value) {
		return Integer.parseInt(navBarOptionsArg(value)[2]);
	}

	private boolean isAccesGranted(Integer securityLevel, Integer levelRequired) {
		return securityLevel >= levelRequired;
	}

	private NavBarOptions fillNavBarOptions(String value) {
		String[] strArray = navBarOptionsArg(value);
		return new NavBarOptions(strArray[0], strArray[1]);
	}

	private String[] navBarOptionsArg(String value) {
		String[] strArray = value.split(splitter);
		return strArray;
	}

}
