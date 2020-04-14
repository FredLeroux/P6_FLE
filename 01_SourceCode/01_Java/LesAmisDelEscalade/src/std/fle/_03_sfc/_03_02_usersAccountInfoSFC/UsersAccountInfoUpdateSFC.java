package std.fle._03_sfc._03_02_usersAccountInfoSFC;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.ReadOnlyInput;

public class UsersAccountInfoUpdateSFC extends SFC {

	@HiddenPath
	private Integer id;

	@ReadOnlyInput
	private String login;

	@ReadOnlyInput
	private String pseudonyme;

	@ReadOnlyInput
	@DateTimeFormat(pattern = "dd . MMMM . yyyy")
	private Date signUpDate;

	@ReadOnlyInput
	private String associationMember;

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

	public String getPseudonyme() {
		return pseudonyme;
	}

	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

	public Date getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}

	public String getAssociationMember() {
		return associationMember;
	}

	public void setAssociationMember(String associationMember) {
		this.associationMember = associationMember;
	}

	

	

}
