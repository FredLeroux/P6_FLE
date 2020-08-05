package std.fle._05_slo.innerJoinSLO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import fle.toolBox.classType.SLO;
import fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.annotations.ToTranslate;
import fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.annotations.operator.Operator;
import fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.annotations.operator.OperatorArrays;


@NamedQuery(name = "TopoBorrowSLO",
query="SELECT A.id,B.title,C.userAccountInfo.pseudonyme,A.lendingStatus"
		+ " FROM TopoLending A"
		+ " INNER JOIN ClimbingTopo B ON A.climbingTopo = B.id"
		+ " INNER JOIN UsersInfo C ON A.borrowerUserInfo = C.id"
		+ " WHERE A.lenderUserInfo.userAccountInfo.id = :loggedUserId "
		+ " ORDER BY A.lendingStatus DESC"
)

@Entity
public class TopoBorrowSLO extends SLO {

	@Id
	private Integer id;
	
	@Operator(signsArray = OperatorArrays.EQUAL)
	private String climbingTopo;
	
	@Operator(signsArray = OperatorArrays.EQUAL)
	private String borrowerUserInfo;
	
	@Operator(signsArray = OperatorArrays.EQUAL)
	@ToTranslate(suffix = "name")
	private String lendingStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClimbingTopo() {
		return climbingTopo;
	}

	public void setClimbingTopo(String climbingTopo) {
		this.climbingTopo = climbingTopo;
	}

	public String getBorrowerUserInfo() {
		return borrowerUserInfo;
	}

	public void setBorrowerUserInfo(String borrowerUserInfo) {
		this.borrowerUserInfo = borrowerUserInfo;
	}

	public String getLendingStatus() {
		return lendingStatus;
	}

	public void setLendingStatus(String lendingStatus) {
		this.lendingStatus = lendingStatus;
	}

}
