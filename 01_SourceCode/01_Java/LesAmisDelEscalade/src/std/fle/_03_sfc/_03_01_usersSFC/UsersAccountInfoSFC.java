package std.fle._03_sfc._03_01_usersSFC;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
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
	private String login;
	
	@NotEmpty
	@Length(
			min = 8,
			max = 16)
	private String password;

	@NotEmpty
	@Unique(
			entityName = "UsersAccountInfo",
			fieldName = "pseudonyme",
			modelAttributeValue = "userManagement")
	@Length(min = 6, max= 254)
	private String pseudonyme;

	

	

	

	

	
	
}
