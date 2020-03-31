package std.fle._01_entity._01_03_models;



import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import fle.toolBox.classType.ENT;
import std.fle._01_entity._01_01_assetsClasses.ClimbingLevels;
import std.fle._01_entity._01_01_assetsClasses.Counties;
import std.fle._01_entity._01_01_assetsClasses.States;

@Entity
@DynamicUpdate
@Table(name = "users_info",schema = "cliff")
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
	@Column(name = "age")
	private Integer age;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

}
