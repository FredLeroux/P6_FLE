package std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO;

import fle.toolBox.classType.DTO;

public class UsersAccountInfoAuthentificatorDTO extends DTO {

	private String password;
	private Integer securityLevel;
	private String pseudonyme;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(Integer securityLevel) {
		this.securityLevel = securityLevel;
	}

	public String getPseudonyme() {
		return pseudonyme;
	}

	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

}
