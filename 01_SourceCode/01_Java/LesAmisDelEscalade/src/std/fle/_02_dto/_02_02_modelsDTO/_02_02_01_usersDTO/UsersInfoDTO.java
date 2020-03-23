package std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO;

import fle.toolBox.classType.DTO;
import std.fle._01_entity._01_01_assetsClasses.ClimbingLevels;
import std.fle._01_entity._01_01_assetsClasses.Counties;
import std.fle._01_entity._01_01_assetsClasses.States;

public class UsersInfoDTO extends DTO{

	private Integer id;

	private String firstName;

	private String lastName;

	private String email;

	private Integer age;

	private String gender;

	private States state;

	private Counties county;

	private ClimbingLevels climbingLevel;

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

}
