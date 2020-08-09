package fle.toolBox.navBarManagement;

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

	/**
	 *
	 * @param accountSecurityLevel the logged account level security
	 * @return an array containing available option function of account rank
	 * @Note this function will allow only options list which have a security level
	 *       highest or equals to account le (important more high is the security
	 *       level less rigths are given)
	 */
	public ArrayList<NavBarOptions> getAllNavBarOptions(Integer accountSecurityLevel) {
		ArrayList<NavBarOptions> navBarOptions = new ArrayList<>();
		config.forEach(
				(key, value) -> fillArrayFunctionaccountSecurityLevel(navBarOptions, accountSecurityLevel, value));

		return (ArrayList<NavBarOptions>) sortNavBarOptionsList(navBarOptions);
	}

	private void fillArrayFunctionaccountSecurityLevel(ArrayList<NavBarOptions> array, Integer accountSecurityLevel,
			Object value) {
		if (isAccesGranted(getNavBarOptionSecurityLevel(value.toString()), accountSecurityLevel)) {
			array.add(fillNavBarOptions(value.toString()));

		}
	}

	private List<NavBarOptions> sortNavBarOptionsList(List<NavBarOptions> navBarOptions) {
		return navBarOptions.stream().sorted((n1, n2) -> n1.getPosition() - n2.getPosition())
				.collect(Collectors.toList());
	}

	private Integer getNavBarOptionSecurityLevel(String value) {
		return Integer.parseInt(navBarOptionsArg(value)[4]);
	}

	private boolean isAccesGranted(Integer securityLevel, Integer accountSecurityLevel) {
		return securityLevel >= accountSecurityLevel;
	}

	private NavBarOptions fillNavBarOptions(String value) {
		String[] strArray = navBarOptionsArg(value);
		return new NavBarOptions(strArray[0], strArray[1], strArray[2], FredParser.toInteger(strArray[3]));
	}

	private String[] navBarOptionsArg(String value) {
		String[] strArray = value.split(splitter);
		return strArray;
	}

}
