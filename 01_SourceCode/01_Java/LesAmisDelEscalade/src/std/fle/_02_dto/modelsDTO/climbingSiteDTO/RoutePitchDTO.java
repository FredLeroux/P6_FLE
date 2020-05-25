package std.fle._02_dto.modelsDTO.climbingSiteDTO;

import fle.toolBox.classType.DTO;
import std.fle._02_dto.assetsClassesDTO.ClimbingLevelsDTO;

public class RoutePitchDTO extends DTO {
	
	private Integer id;
	
	private Integer pitchNumber;
	
	private ClimbingLevelsDTO climbingLevels;
	
	private SiteRoutesDTO siteRoutes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPitchNumber() {
		return pitchNumber;
	}

	public void setPitchNumber(Integer pitchNumber) {
		this.pitchNumber = pitchNumber;
	}

	public ClimbingLevelsDTO getClimbingLevels() {
		return climbingLevels;
	}

	public void setClimbingLevels(ClimbingLevelsDTO climbingLevels) {
		this.climbingLevels = climbingLevels;
	}

	public SiteRoutesDTO getSiteRoutes() {
		return siteRoutes;
	}

	public void setSiteRoutes(SiteRoutesDTO siteRoutes) {
		this.siteRoutes = siteRoutes;
	}

	
	
	
	

}
