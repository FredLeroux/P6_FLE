package std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO;

import java.util.Date;

import fle.toolBox.classType.DTO;

public class UsersAccountInfoUpdateDTO extends DTO {

	private Integer id;

	private String login;

	private String pseudonyme;

	private Date signUpDate;
	
	private Boolean member;

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

	public Boolean getMember() {
		return member;
	}

	public void setMember(Boolean member) {
		this.member = member;
	}

}
