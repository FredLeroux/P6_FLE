package std.fle._01_entity.models.site;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fle.toolBox.classType.ENT;

@Entity
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

}
