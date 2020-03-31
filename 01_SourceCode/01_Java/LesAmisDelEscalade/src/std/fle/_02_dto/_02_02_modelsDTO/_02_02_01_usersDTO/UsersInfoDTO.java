package std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO;

import fle.toolBox.classType.DTO;

import std.fle._02_dto._02_01_assetsClassesDTO.ClimbingLevelsDTO;
import std.fle._02_dto._02_01_assetsClassesDTO.CountiesDTO;
import std.fle._02_dto._02_01_assetsClassesDTO.StatesDTO;

public class UsersInfoDTO extends DTO {

	private Integer id;

	private String firstName;

	private String lastName;

	private String email;

	private Integer age;

	private String gender;

	private StatesDTO state;

	private CountiesDTO county;

	private ClimbingLevelsDTO climbingLevel;

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

	public StatesDTO getState() {
		return state;
	}

	public void setState(StatesDTO state) {
		this.state = state;
	}

	public CountiesDTO getCounty() {
		return county;
	}

	public void setCounty(CountiesDTO county) {
		this.county = county;
	}

	public ClimbingLevelsDTO getClimbingLevel() {
		return climbingLevel;
	}

	public void setClimbingLevel(ClimbingLevelsDTO climbingLevel) {
		this.climbingLevel = climbingLevel;
	}

}
