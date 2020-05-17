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

import fle.toolBox.classType.ENT;

@Entity
@Table(name = "site_routes", schema = "cliff")
public class SiteRoutes extends ENT {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1668613752097339690L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "route_name")
	private String routeName;
	
	@OneToMany(mappedBy = "siteRoutes",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<RoutePitch> routePitchs;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "climbing_site_fk")
	private ClimbingSite climbingSite;
	
	

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

	public ClimbingSite getClimbingSite() {
		return climbingSite;
	}

	public void setClimbingSite(ClimbingSite climbingSite) {
		this.climbingSite = climbingSite;
	}

	public List<RoutePitch> getRoutePitchs() {
		return routePitchs;
	}

	public void setRoutePitchs(List<RoutePitch> routePitchs) {
		this.routePitchs = routePitchs;
	}
	
	

}
