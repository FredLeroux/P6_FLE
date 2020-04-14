package std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO._02_02_01_01_usersAccountInfoDTO;

import java.util.Date;

import fle.toolBox.classType.DTO;

public class UsersAccountInfoUpdateDTO extends DTO {

	private Integer id;

	private String login;

	private String pseudonyme;

	private Date signUpDate;
	// member as string here allow to converte SFC to DTO then pass string value
	// true or false to DTO accepted by Boolean in Entity
	private String isMember;

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

	public String isMember() {
		return isMember;
	}

	public void setMember(String isMember) {
		this.isMember = isMember;
	}

}
