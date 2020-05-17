package std.fle._02_dto.modelsDTO.climbingSiteDTO;

import fle.toolBox.classType.DTO;
import std.fle._02_dto.assetsClassesDTO.ClimbingLevelsDTO;

public class RoutePitchDTO extends DTO {

	private Integer id;

	private Integer pitchNumber;

	private SiteRoutesDTO siteRoutesDTO;

	private ClimbingLevelsDTO climbingLevelsDTO;

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

	public SiteRoutesDTO getSiteRoutesDTO() {
		return siteRoutesDTO;
	}

	public void setSiteRoutesDTO(SiteRoutesDTO siteRoutesDTO) {
		this.siteRoutesDTO = siteRoutesDTO;
	}

	public ClimbingLevelsDTO getClimbingLevelsDTO() {
		return climbingLevelsDTO;
	}

	public void setClimbingLevelsDTO(ClimbingLevelsDTO climbingLevelsDTO) {
		this.climbingLevelsDTO = climbingLevelsDTO;
	}

	

}
