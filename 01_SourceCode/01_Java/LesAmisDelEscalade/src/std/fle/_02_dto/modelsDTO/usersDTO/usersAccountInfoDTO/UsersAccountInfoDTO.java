package std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO;

import java.util.Date;

import fle.toolBox.classType.DTO;

/**
 * 
 * @author Frederic Leroux <br>
 * @apiNote basis dto must be used in descending action(from front to database)
 *          in order to avoid null exception.
 */
public class UsersAccountInfoDTO extends DTO {

	private Integer id;

	private String login;

	private String password;

	private String pseudonyme;

	private Date signUpDate;

	private Integer loginTentativeNumber;

	private Integer securityLevel;

	private Boolean accountActivationStatus;

	private Boolean member;

	private String activationCode;

	private String passwordResetCode;

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

	public Boolean getAccountActivationStatus() {
		return accountActivationStatus;
	}

	public void setAccountActivationStatus(Boolean accountActivationStatus) {
		this.accountActivationStatus = accountActivationStatus;
	}

	public Boolean getMember() {
		return member;
	}

	public void setMember(Boolean member) {
		this.member = member;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public String getPasswordResetCode() {
		return passwordResetCode;
	}

	public void setPasswordResetCode(String passwordResetCode) {
		this.passwordResetCode = passwordResetCode;
	}

}
