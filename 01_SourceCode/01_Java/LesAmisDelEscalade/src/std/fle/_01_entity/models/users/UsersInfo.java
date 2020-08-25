package std.fle._01_entity.models.users;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import fle.toolBox.classType.ENT;
import std.fle._01_entity.assetsClasses.ClimbingLevels;
import std.fle._01_entity.assetsClasses.Counties;
import std.fle._01_entity.assetsClasses.States;
import std.fle._01_entity.models.topo.ClimbingTopo;
import std.fle._01_entity.models.topo.TopoLending;

@Entity
@Table(name = "users_info", schema = "cliff")
public class UsersInfo extends ENT implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8778656555947368495L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_address")
	private String email;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "gender")
	private String gender;

	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "french_state_fk")
	private States state;

	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "french_county_fk")
	private Counties county;

	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "french_climbing_level_fk")
	private ClimbingLevels climbingLevel;

	@OneToOne
	@JoinColumn(name = "account_info_fk")
	private UsersAccountInfo userAccountInfo;

	@OneToMany(mappedBy = "userInfo",cascade = CascadeType.ALL)
	private List<ClimbingTopo> climbingTopos;

	@OneToMany(mappedBy = "lenderUserInfo",cascade = CascadeType.ALL)
	private List<TopoLending> topoLendingLender;

	@OneToMany(mappedBy = "borrowerUserInfo",cascade = CascadeType.ALL)
	private List<TopoLending> topoLendingBorrower;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public ClimbingLevels getClimbingLevel() {
		return climbingLevel;
	}

	public void setClimbingLevel(ClimbingLevels climbingLevel) {
		this.climbingLevel = climbingLevel;
	}

	public UsersAccountInfo getUserAccountInfo() {
		return userAccountInfo;
	}

	public void setUserAccountInfo(UsersAccountInfo userAccountInfo) {
		this.userAccountInfo = userAccountInfo;
	}



	public List<ClimbingTopo> getClimbingTopos() {
		return climbingTopos;
	}

	public void setClimbingTopos(List<ClimbingTopo> climbingTopos) {
		this.climbingTopos = climbingTopos;
	}

	public List<TopoLending> getTopoLendingLender() {
		return topoLendingLender;
	}

	public void setTopoLendingLender(List<TopoLending> topoLendingLender) {
		this.topoLendingLender = topoLendingLender;
	}

	public List<TopoLending> getTopoLendingBorrower() {
		return topoLendingBorrower;
	}

	public void setTopoLendingBorrower(List<TopoLending> topoLendingBorrower) {
		this.topoLendingBorrower = topoLendingBorrower;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((climbingLevel == null) ? 0 : climbingLevel.hashCode());
		result = prime * result + ((county == null) ? 0 : county.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsersInfo other = (UsersInfo) obj;
		if (climbingLevel == null) {
			if (other.climbingLevel != null)
				return false;
		} else if (!climbingLevel.equals(other.climbingLevel))
			return false;
		if (county == null) {
			if (other.county != null)
				return false;
		} else if (!county.equals(other.county))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

}
