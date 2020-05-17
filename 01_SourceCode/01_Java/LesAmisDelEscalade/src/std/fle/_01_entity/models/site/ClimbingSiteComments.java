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

import fle.toolBox.classType.ENT;
import std.fle._01_entity.models.users.UsersAccountInfo;

@Entity
@Table(name = "climbing_site_comments", schema = "cliff")
public class ClimbingSiteComments extends ENT {

	/**
	 * 
	 */
	private static final long serialVersionUID = 28840530513804341L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "comment")
	private String comment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "climbing_site_fk")
	private ClimbingSite climbingSite;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_account_info_fk")
	private UsersAccountInfo usersAccountInfo;

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

	public ClimbingSite getClimbingSite() {
		return climbingSite;
	}

	public void setClimbingSite(ClimbingSite climbingSite) {
		this.climbingSite = climbingSite;
	}

	public UsersAccountInfo getUsersAccountInfo() {
		return usersAccountInfo;
	}

	public void setUsersAccountInfo(UsersAccountInfo usersAccountInfo) {
		this.usersAccountInfo = usersAccountInfo;
	}
	
	
	

}
