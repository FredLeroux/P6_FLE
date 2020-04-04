package std.fle._03_sfc._03_01_usersSFC;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.PlaceHolderText;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.numeric.Numeric;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique.Unique;
import std.fle._01_entity._01_01_assetsClasses.ClimbingLevels;
import std.fle._01_entity._01_01_assetsClasses.Counties;
import std.fle._01_entity._01_01_assetsClasses.States;
import std.fle._01_entity._01_02_assetsEnum.Gender;
import std.fle._02_dto._02_01_assetsClassesDTO.ClimbingLevelsDTO;
import std.fle._02_dto._02_01_assetsClassesDTO.CountiesDTO;
import std.fle._02_dto._02_01_assetsClassesDTO.StatesDTO;

@Validated
public class UsersInfoSFC extends SFC {

	@HiddenPath
	private Integer id;
	
	@NotEmpty
	@PlaceHolderText(message = "firstName.pht")
	@Length(max = 30)
	private String firstName;
	
	@NotEmpty
	@PlaceHolderText(message = "lastName.pht")
	@Length(max = 30)
	private String lastName;
	
	@NotEmpty
	@PlaceHolderText(message = "email.pht")
	@Email(regexp = "^[a-zA-Z0-9+\\p{javaLetter}_/*\\.\\-]+[a-zA-Z0-9+\\p{javaLetter}_/*\\.\\-]?@[a-zA-Z0-9_\\-]{3,63}\\.[a-z]{2,4}$")
	@Length(max = 254)
	@Unique(
			entityName = "UsersInfo",
			fieldName = "email",
			modelAttributeValue = "userManagement")
	private String email;
	
	@PlaceHolderText(message = "age.pht")
	@Numeric(
			modelAttributeValue = "userManagement",
			configFilePath = "configuration/numericSettings/numericFieldsSettings.xml",
			maxDigitsKey = "age.maxDigits",
			totalDigitsKey = "age.totalDigits",
			precisionKey = "age.precision",
			acceptEmptyValue = true)
	private String age;
	
	@SelectInputType(
			selectListName = "gendersList",
			selectValueName = "genderValue",
			enumClass = Gender.class,
			messageSourceSuffix = ".name")
	private String gender;

	@SelectInputType(
			selectListName = "statesList",
			selectValueName = "stateValue",
			entityClass = States.class,
			dtoClass = StatesDTO.class,			
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "stateName",
			dependentFieldName = "countyId",
			dependentFieldNameFilteringAction = "filterCountiesList")	
	private Integer stateId;

	@SelectInputType(
			selectListName = "countiesList", 
			selectValueName = "countyValue",
			entityClass = Counties.class,
			dtoClass = CountiesDTO.class,
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "countyName",
			relationShipField =  "state",
			relationShipFieldFilter = "id",
			SFCCriterionField = "stateId"
			)
	private Integer countyId;

	@SelectInputType(
			selectListName = "climbList",
			selectValueName = "climbValue",
			entityClass = ClimbingLevels.class,
			dtoClass = ClimbingLevelsDTO.class,
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "cotationLevel")
	private Integer climbingLevelId;

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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getCountyId() {
		return countyId;
	}

	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}

	public Integer getClimbingLevelId() {
		return climbingLevelId;
	}

	public void setClimbingLevelId(Integer climbingLevelId) {
		this.climbingLevelId = climbingLevelId;
	}
	
	
	
}
