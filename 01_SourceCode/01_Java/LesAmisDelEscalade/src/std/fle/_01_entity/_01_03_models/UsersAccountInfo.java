package std.fle._01_entity._01_03_models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fle.toolBox.classType.ENT;

@Entity
@Table(name = "users_account_info")
public class UsersAccountInfo extends ENT implements Serializable {

	private static final long serialVersionUID = 9044155488919897403L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "login")
	private String login;	
	@Column(name = "password")
	private String password;
	@Column(name = "pseudonyme")
	private String pseudonyme;
	@Column(name ="sing_up_date")
	private Date signUpDate;
	@Column(name ="login_tentative_number")
	private Integer loginTentativeNumber = 0;	
	@Column(name= "security_level")
	private String securityLevel;
	@Column(name = "account_activation_status")
	private String accountActivationStatus;	
	@Column (name = "is_member")
	private boolean isMember;
	
	@OneToOne(mappedBy =  "userAccountInfo",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private UsersInfo userInfo;

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

	
	public String getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(String securityLevel) {
		this.securityLevel = securityLevel;
	}

	public String getAccountActivationStatus() {
		return accountActivationStatus;
	}

	public void setAccountActivationStatus(String accountActivationStatus) {
		this.accountActivationStatus = accountActivationStatus;
	}
	
	

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public UsersInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UsersInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
	
	

}
