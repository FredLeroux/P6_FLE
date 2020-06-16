package std.fle._05_slo.innerJoinSLO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import fle.toolBox.classType.SLO;
import fle.toolBox.dataListDisplayerTools.annotations.ToTranslate;
import fle.toolBox.dataListDisplayerTools.annotations.operator.Operator;
import fle.toolBox.dataListDisplayerTools.annotations.operator.OperatorArrays;

@NamedQuery(name = "TopoMineListSLO",
		query="SELECT A.id,B.stateName,A.title,A.editionYear,A.available"
				+ " FROM ClimbingTopo A"
				+ " INNER JOIN States B ON A.state = B.id"
				+ " WHERE A.userInfo.userAccountInfo.id = :loggedUserId"
				+ " ORDER BY B.stateName ASC"
		)

@Entity
public class TopoMineListSLO extends SLO {

	@Id
	private Integer id;

	@Operator(signsArray = OperatorArrays.EQUAL)	
	private String state;
	
	@Operator(signsArray = OperatorArrays.EQUAL)
	private String title;	
	
	@Operator(signsArray = OperatorArrays.INFERIOR_EQUAL_SUPERIOR)
	private String editionYear;	
	
	@Operator(signsArray = OperatorArrays.EQUAL)
	@ToTranslate(suffix = "isAvailable")
	private String available;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEditionYear() {
		return editionYear;
	}
	public void setEditionYear(String editionYear) {
		this.editionYear = editionYear;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	
	
	
	
}
