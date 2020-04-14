package std.fle._03_sfc._03_01_usersInfoSFC;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.PlaceHolderText;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;

@SpringFormSettings(
		action = "newActivationCode",
		method = "post", 
		modelAttribute = "userMail", 
		name = "userMailFormular", 
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		buttonAlignmentPropertyKey = "userFormBtn.align", 
		buttonMessagePropertyKey = "userFormBtn.message.reSend", 
		jspFilePath = "userMailForm.path", 
		labelMessageSourceSuffix = "userForm.label",		 
		readOnly = false)
@Validated
public class UsersInfoMailSFC extends SFC {

	@HiddenPath
	private Integer id;
	
	@NotEmpty
	@PlaceHolderText(message = "email1.pht")
	@Email(regexp = "^[a-zA-Z0-9+\\p{javaLetter}_/*\\.\\-]+[a-zA-Z0-9+\\p{javaLetter}_/*\\.\\-]?@[a-zA-Z0-9_\\-]{3,63}\\.[a-z]{2,4}$")
	@Length(max = 254)		
	private String email;
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
