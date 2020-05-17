package std.fle._02_dto.modelsDTO.climbingSiteDTO;

import java.util.List;

import fle.toolBox.classType.DTO;
import std.fle._01_entity.models.site.RoutePitch;

public class SiteRoutesDTO extends DTO {

	private Integer id;

	private String routeName;

	private ClimbingSiteDTO climbingSite;

	private List<RoutePitchDTO> routePitchs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public ClimbingSiteDTO getClimbingSite() {
		return climbingSite;
	}

	public void setClimbingSite(ClimbingSiteDTO climbingSite) {
		this.climbingSite = climbingSite;
	}

	public List<RoutePitchDTO> getRoutePitchs() {
		return routePitchs;
	}

	public void setRoutePitchs(List<RoutePitchDTO> routePitchs) {
		this.routePitchs = routePitchs;
	}



}
