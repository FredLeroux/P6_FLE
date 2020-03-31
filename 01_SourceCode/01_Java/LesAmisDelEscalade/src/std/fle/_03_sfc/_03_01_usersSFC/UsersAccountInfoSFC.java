package std.fle._03_sfc._03_01_usersSFC;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.PassWordField;
import fle.toolBox.springFormManager.annotations.PlaceHolderText;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique.Unique;

@Validated
public class UsersAccountInfoSFC extends SFC {

	@HiddenPath
	private Integer id;
	
	@NotEmpty
	@Unique(
			entityName = "UsersAccountInfo", 
			fieldName = "login", 
			modelAttributeValue = "userManagement")
	@Length(
			min = 6,
			max = 254)
	@PlaceHolderText(message = "login.pht")
	private String login;
	
	@NotEmpty
	@Length(
			min = 8,
			max = 16)
	@PassWordField
	@PlaceHolderText(message = "password.pht")
	private String password;

	@NotEmpty
	@Unique(
			entityName = "UsersAccountInfo",
			fieldName = "pseudonyme",
			modelAttributeValue = "userManagement")
	@Length(min = 6, max= 254)
	@PlaceHolderText(message = "pseudonyme.pht")
	private String pseudonyme;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPseudonyme() {
		return pseudonyme;
	}

	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

	

	

	

	

	
	
}
