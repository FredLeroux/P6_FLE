package std.fle._01_entity.models.topo;

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
import std.fle._01_entity.models.users.UsersInfo;

@Entity
@Table(name = "topo_lending",schema = "cliff")
public class TopoLending extends ENT {

	private static final long serialVersionUID = -6580782049678414529L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "climbing_topo_fk")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private ClimbingTopo climbingTopo;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "lender_user_info_fk")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private UsersInfo lenderUserInfo;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "borrower_user_info_fk")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private UsersInfo borrowerUserInfo;
	
	@Column(name = "lending_status")
	private String lendingStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClimbingTopo getClimbingTopo() {
		return climbingTopo;
	}

	public void setClimbingTopo(ClimbingTopo climbingTopo) {
		this.climbingTopo = climbingTopo;
	}

	public UsersInfo getLenderUserInfo() {
		return lenderUserInfo;
	}

	public void setLenderUserInfo(UsersInfo lenderUserInfo) {
		this.lenderUserInfo = lenderUserInfo;
	}

	public UsersInfo getBorrowerUserInfo() {
		return borrowerUserInfo;
	}

	public void setBorrowerUserInfo(UsersInfo borrowerUserInfo) {
		this.borrowerUserInfo = borrowerUserInfo;
	}

	public String getLendingStatus() {
		return lendingStatus;
	}

	public void setLendingStatus(String lendingStatus) {
		this.lendingStatus = lendingStatus;
	}
	
	

}
