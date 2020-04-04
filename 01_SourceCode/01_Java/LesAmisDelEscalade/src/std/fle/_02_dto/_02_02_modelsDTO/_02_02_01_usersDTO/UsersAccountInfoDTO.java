package std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO;

import java.util.Date;

import fle.toolBox.classType.DTO;

public class UsersAccountInfoDTO extends DTO {

	private Integer id;

	private String login;

	private String password;

	private String pseudonyme;

	private Date signUpDate;

	private Integer loginTentativeNumber;

	private Integer securityLevel;

	private Boolean accountActivationStatus;

	private Boolean isMember;

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

	public Date getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}

	public Integer getLoginTentativeNumber() {
		return loginTentativeNumber;
	}

	public void setLoginTentativeNumber(Integer loginTentativeNumber) {
		this.loginTentativeNumber = loginTentativeNumber;
	}

	public Integer getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(Integer securityLevel) {
		this.securityLevel = securityLevel;
	}

	
	public Boolean isAccountActivationStatus() {
		return accountActivationStatus;
	}

	public void setAccountActivationStatus(Boolean accountActivationStatus) {
		this.accountActivationStatus = accountActivationStatus;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(Boolean isMember) {
		this.isMember = isMember;
	}
	
}
