package std.fle._01_model._01_accountManagement;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ColumnDefault;

import fle.toolBox.classType.ENT;

@Entity
@Table(name = "lade_user_info")
public class UserInfo extends ENT implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5178752208233204545L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name", length = 25, nullable = false)
	@NotEmpty(message = "firstNameEmpty")
	private String firstName;

	@Column(name = "last_name", length = 25, nullable = false)
	@NotEmpty(message = "lastNameEmpty")
	private String lastName;

	@Column(name = "email", length = 35, nullable = false, unique = true)
	@NotEmpty(message = "emailEmpty")
	@Email(regexp = "^[a-zA-Z0-9_/*\\.\\-]+\\p{javaLetter}+[a-zA-Z0-9_/*\\-]+\\p{javaLetter}+@[a-zA-Z0-9\\.\\-]+\\p{javaLetter}+[a-z]$", message = "emailWrongFormat")
	private String email;

	@Column(name = "climbing_level", length = 3)
	@ColumnDefault("na")
	private String climbingLevel;

	@Column(name = "country", length = 25)
	@ColumnDefault("na")
	private String country;

	@Column(name = "region", length = 25)
	@ColumnDefault("na")
	private String region;

	@Column(name = "age", length = 2)
	@ColumnDefault("na")
	private int age;

	@Column(name = "sex", length = 1)
	@ColumnDefault("na")
	@Pattern(regexp = "F||M", message = "wrongSex")
	private char sex;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getClimbingLevel() {
		return climbingLevel;
	}

	public void setClimbingLevel(String climbingLevel) {
		this.climbingLevel = climbingLevel;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	
	
}
