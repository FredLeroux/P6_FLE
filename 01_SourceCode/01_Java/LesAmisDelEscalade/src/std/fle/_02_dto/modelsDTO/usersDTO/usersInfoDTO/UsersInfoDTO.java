package std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO;

import java.util.Date;

import fle.toolBox.classType.DTO;
import std.fle._02_dto.assetsClassesDTO.ClimbingLevelsDTO;
import std.fle._02_dto.assetsClassesDTO.CountiesDTO;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;

public class UsersInfoDTO extends DTO {

	private Integer id;

	private String firstName;

	private String lastName;

	private String email;

	private Date birthDate;

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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
