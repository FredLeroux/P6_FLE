package std.fle._02_dto.modelsDTO.climbingSiteDTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import fle.toolBox.classType.DTO;
import std.fle._01_entity.assetsClasses.ClimbingLevels;
import std.fle._01_entity.models.site.SiteRoutes;

public class RoutePitchDTO extends DTO {

	private Integer id;

	private Integer pitchNumber;

//	private SiteRoutes siteRoutes;
	
	// private ClimbingLevels climbingLevels;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pitchNumber == null) ? 0 : pitchNumber.hashCode());
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
		RoutePitchDTO other = (RoutePitchDTO) obj;
		if (pitchNumber == null) {
			if (other.pitchNumber != null)
				return false;
		} else if (!pitchNumber.equals(other.pitchNumber))
			return false;
		return true;
	}

/*	public SiteRoutes getSiteRoutes() {
		return siteRoutes;
	}

	public void setSiteRoutes(SiteRoutes siteRoutes) {
		this.siteRoutes = siteRoutes;
	}*/

	
	

}
