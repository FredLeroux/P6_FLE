package std.fle._05_slo.innerJoinSLO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import fle.toolBox.classType.SLO;
import fle.toolBox.dataListDisplayerTools.annotations.NotAListFilter;
import fle.toolBox.dataListDisplayerTools.annotations.Operator;

@NamedQuery(name = "ClimbingSiteCommentsSLO",
query = "SELECT A.id,B.pseudonyme,A.comment"
		+ " FROM ClimbingSiteComments A"
		+ " INNER JOIN UsersAccountInfo B ON A.usersAccountInfo = B.id"
		+ " WHERE A.climbingSite.id = :siteId")
//WHERE A.id = :siteId

/*"SELECT A.id,C.pseudonyme,A.comment"
+ " FROM ClimbingSiteComments A"
+ " WHERE A.climbingSite.id = :siteId"
//+ " INNER JOIN ClimbingSite B ON A.climbingSiteName.id = B.id"
+ " INNER JOIN UsersAccountInfo C ON A.userName =C.id "
)*/



@Entity
public class ClimbingSiteCommentsSLO extends SLO {
	
	@Id
	private Integer id;	
	@Operator(signsArray = {"="})
	private String userName;	
	@NotAListFilter
	private String comment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

/*	public String getClimbingSiteName() {
		return climbingSiteName;
	}

	public void setClimbingSiteName(String climbingSiteName) {
		this.climbingSiteName = climbingSiteName;
	}
*/
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	

}
