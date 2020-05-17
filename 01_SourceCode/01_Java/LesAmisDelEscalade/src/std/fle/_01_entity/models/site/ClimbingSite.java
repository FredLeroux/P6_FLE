package std.fle._01_entity.models.site;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import fle.toolBox.classType.ENT;
import std.fle._01_entity.assetsClasses.Counties;
import std.fle._01_entity.assetsClasses.States;

@Entity
@Table(name = "climbing_site", schema = "cliff")
public class ClimbingSite extends ENT {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2676843279455141121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "climbing_site_name")
	private String climbingSiteName;

	@Column(name = "site_description")
	private String siteDescription;

	@Column(name = "altitude")
	private Integer altitude;

	@Column(name = "height_min")
	private Integer heightMin;

	@Column(name = "height_max")
	private Integer heightMax;

	@Column(name = "number_of_routes")
	private Integer numberOfRoutes;

	@Column(name = "access_to_site")
	private String accessToSite;

	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "french_state_fk")
	private States state;

	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "french_county_fk")
	private Counties county;
	
	@OneToMany(mappedBy = "climbingSite",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<SiteRoutes> sitesRoutes;
	
	@Column(name="official")
	private Boolean official;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClimbingSiteName() {
		return climbingSiteName;
	}

	public void setClimbingSiteName(String climbingSiteName) {
		this.climbingSiteName = climbingSiteName;
	}

	public String getSiteDescription() {
		return siteDescription;
	}

	public void setSiteDescription(String siteDescription) {
		this.siteDescription = siteDescription;
	}

	public Integer getAltitude() {
		return altitude;
	}

	public void setAltitude(Integer altitude) {
		this.altitude = altitude;
	}

	public Integer getHeightMin() {
		return heightMin;
	}

	public void setHeightMin(Integer heightMin) {
		this.heightMin = heightMin;
	}

	public Integer getHeightMax() {
		return heightMax;
	}

	public void setHeightMax(Integer heightMax) {
		this.heightMax = heightMax;
	}

	public Integer getNumberOfRoutes() {
		return numberOfRoutes;
	}

	public void setNumberOfRoutes(Integer numberOfRoutes) {
		this.numberOfRoutes = numberOfRoutes;
	}

	public String getAccessToSite() {
		return accessToSite;
	}

	public void setAccessToSite(String accessToSite) {
		this.accessToSite = accessToSite;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public Counties getCounty() {
		return county;
	}

	public void setCounty(Counties county) {
		this.county = county;
	}

	public List<SiteRoutes> getSitesRoutes() {
		return sitesRoutes;
	}

	public void setSitesRoutes(List<SiteRoutes> sitesRoutes) {
		this.sitesRoutes = sitesRoutes;
	}

	public Boolean getOfficial() {
		return official;
	}

	public void setOfficial(Boolean official) {
		this.official = official;
	}
	
	
	
	
	
	

}
