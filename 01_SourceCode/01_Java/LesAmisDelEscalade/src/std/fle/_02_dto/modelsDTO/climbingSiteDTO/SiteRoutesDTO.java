package std.fle._02_dto.modelsDTO.climbingSiteDTO;

import fle.toolBox.classType.DTO;

public class SiteRoutesDTO extends DTO {

	private Integer id;

	private String routeName;

	private ClimbingSiteDTO climbingSite;

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

	public void setClimbingSiteDTO(ClimbingSiteDTO climbingSiteDTO) {
		this.climbingSite = climbingSiteDTO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((routeName == null) ? 0 : routeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SiteRoutesDTO other = (SiteRoutesDTO) obj;
		if (routeName == null) {
			if (other.routeName != null)
				return false;
		} else if (!routeName.equals(other.routeName))
			return false;
		return true;
	}
	
	

}
