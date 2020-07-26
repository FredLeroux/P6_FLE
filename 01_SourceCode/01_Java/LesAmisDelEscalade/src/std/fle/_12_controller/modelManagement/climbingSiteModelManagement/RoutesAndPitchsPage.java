package std.fle._12_controller.modelManagement.climbingSiteModelManagement;

import java.util.List;

import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;

public class RoutesAndPitchsPage {
	
	private String routeName;
	
	private List<RoutePitchSFC> pitchsList;

	public RoutesAndPitchsPage(String routeName, List<RoutePitchSFC> pitchsList) {
		super();
		this.routeName = routeName;
		this.pitchsList = pitchsList;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public List<RoutePitchSFC> getPitchsList() {
		return pitchsList;
	}

	public void setPitchsList(List<RoutePitchSFC> pitchsList) {
		this.pitchsList = pitchsList;
	}
	
	
	
	

}
