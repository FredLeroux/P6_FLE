package std.fle._01_entity.models.site;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import fle.toolBox.classType.ENT;
import std.fle._01_entity.assetsClasses.ClimbingLevels;

@Entity
@Table(name = "route_pitch", schema = "cliff")
public class RoutePitch extends ENT {
	
	
	private static final long serialVersionUID = -6989511966381442698L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "pitch_number")
	private Integer pitchNumber;	

	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "french_climbing_level_fk")
	private ClimbingLevels climbingLevels;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "site_route_fk")
	private SiteRoutes siteRoutes;

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

	public SiteRoutes getSiteRoutes() {
		return siteRoutes;
	}

	public void setSiteRoutes(SiteRoutes siteRoutes) {
		this.siteRoutes = siteRoutes;
	}

	public ClimbingLevels getClimbingLevels() {
		return climbingLevels;
	}

	public void setClimbingLevels(ClimbingLevels climbingLevels) {
		this.climbingLevels = climbingLevels;
	}

}
