package std.fle._05_controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fle.toolBox.ConfigurationFileReader;
import fle.toolBox.FredParser;

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
		
		return (ArrayList<NavBarOptions>) sortNavBarOptionsList(navBarOptions);
	}

	private void fillArrayFunctionLevelRequired(ArrayList<NavBarOptions> array, Integer levelRequired, String value) {
		if (isAccesGranted(getNavBarOptionSecurityLevel(value), levelRequired)) {
			array.add(fillNavBarOptions(value));			

		}
	}
	
	private List<NavBarOptions>  sortNavBarOptionsList(List<NavBarOptions> navBarOptions) {
		return navBarOptions.stream()
				.sorted((n1,n2)->n1.getPosition()-n2.getPosition()).collect(Collectors.toList());
			}

	private Integer getNavBarOptionSecurityLevel(String value) {
		return Integer.parseInt(navBarOptionsArg(value)[3]);
	}

	private boolean isAccesGranted(Integer securityLevel, Integer levelRequired) {
		return securityLevel >= levelRequired;
	}

	private NavBarOptions fillNavBarOptions(String value) {
		String[] strArray = navBarOptionsArg(value);
		System.out.println( FredParser.toInteger(strArray[2]));
		return new NavBarOptions(strArray[0], strArray[1], FredParser.toInteger(strArray[2]));
	}

	private String[] navBarOptionsArg(String value) {
		String[] strArray = value.split(splitter);
		return strArray;
	}

}
