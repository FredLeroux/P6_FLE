package std.fle._03_sfc._03_01_usersSFC;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.PlaceHolderText;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.numeric.Numeric;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique.Unique;
import std.fle._01_entity._01_02_assetsEnum.Gender;
import std.fle._02_dto._02_01_assetsClassesDTO.ClimbingLevelsDTO;
import std.fle._02_dto._02_01_assetsClassesDTO.CountiesDTO;
import std.fle._02_dto._02_01_assetsClassesDTO.StatesDTO;

@Validated
public class UserInfoSFC extends SFC {

	@HiddenPath
	private Integer id;
	
	@PlaceHolderText(message = "firstName.pht")
	@Length(max = 30)
	private String firstName;
	
	@PlaceHolderText(message = "lastName.pht")
	@Length(max = 30)
	private String lastName;
	
	@PlaceHolderText(message = "email.pht")
	@Email
	@Length(max = 254)
	@Unique(
			entityName = "UsersInfo",
			fieldName = "email",
			modelAttributeValue = "userManagement")
	private String email;
	
	@PlaceHolderText(message = "age.pht")
	@Numeric(
			modelAttributeValue = "userManagement",
			configFilePath = "configiration/numericFieldsSettings.xml",
			maxDigitsKey = "age.maxDigits",
			totalDigitsKey = "age.totalDigits",
			precisionKey = "age.precision")
	private String age;
	
	@SelectInputType(
			selectListName = "gendersList",
			selectValueName = "genderVlaue",
			enumClass = Gender.class)
	private String genderValue;

	@SelectInputType(
			selectListName = "statesList",
			selectValueName = "stateValue",
			dtoClass = StatesDTO.class,
			configFilePath = "configurations/formQueries/formQueries.xml",
			configFileQueryHQLKey = "states.hql",
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "stateName",
			dependentFieldName = "countyId",
			dependentFieldNameFilteringAction = "filterDependentList")	
	private Integer stateId;

	@SelectInputType(
			selectListName = "countiesList", 
			selectValueName = "countyValue",
			dtoClass = CountiesDTO.class,
			configFilePath = "configurations/formQueries/formQueries.xml",
			configFileQueryHQLKey = "counties.hql",
			optionValueFieldName = "id",
			optionDisplayValueFieldName = "countyName",
			masterFieldName = "stateId",
			filterByMasterObjectFieldName = "id"
			)
	private Integer countyId;

	@SelectInputType(
			selectListName = "climbList",
			selectValueName = "climbValue",
			dtoClass = ClimbingLevelsDTO.class,
			configFilePath = "configurations/formQueries/formQueries.xml",
			configFileQueryHQLKey = "climb.hql" )
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

	public String getGenderValue() {
		return genderValue;
	}

	public void setGenderValue(String genderValue) {
		this.genderValue = genderValue;
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
