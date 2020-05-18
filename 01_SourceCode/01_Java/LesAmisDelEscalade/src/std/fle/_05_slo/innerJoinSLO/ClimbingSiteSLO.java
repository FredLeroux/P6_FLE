package std.fle._05_slo.innerJoinSLO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import fle.toolBox.classType.SLO;
import fle.toolBox.dataListDisplayerTools.annotations.Operator;
import fle.toolBox.dataListDisplayerTools.annotations.ToTranslate;

@NamedQuery(name = "ClimbingSiteSLO", query = "SELECT A.id,B.stateName,C.countyName,A.climbingSiteName,A.official,A.numberOfRoutes"
		+ " FROM ClimbingSite A "
		+ " INNER JOIN States B ON A.state =B.id"
		+ " INNER JOIN Counties C ON A.county =C.id"
		+ " ORDER BY B.stateName"
		)

@Entity
public class ClimbingSiteSLO extends SLO {
	
	@Id
	private Integer id;
	@Operator(signsArray = { "=" })
	private String state;
	@Operator(signsArray = { "=" })
	private String county;
	@Operator(signsArray = { "=" })
	private String climbingSiteName;
	@Operator(signsArray = { "=" })
	@ToTranslate(suffix = ".official")
	private String official;
	@Operator(signsArray = { "=","<",">" })
	private String numberOfRoutes;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getClimbingSiteName() {
		return climbingSiteName;
	}
	public void setClimbingSiteName(String climbingSiteName) {
		this.climbingSiteName = climbingSiteName;
	}
	public String getOfficial() {
		return official;
	}
	public void setOfficial(String official) {
		this.official = official;
	}
	public String getNumberOfRoutes() {
		return numberOfRoutes;
	}
	public void setNumberOfRoutes(String numberOfRoutes) {
		this.numberOfRoutes = numberOfRoutes;
	}
	
	

}
