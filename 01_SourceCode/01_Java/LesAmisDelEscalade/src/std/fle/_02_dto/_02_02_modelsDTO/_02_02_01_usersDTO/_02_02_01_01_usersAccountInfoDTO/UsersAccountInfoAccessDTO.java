package std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO._02_02_01_01_usersAccountInfoDTO;

import fle.toolBox.classType.DTO;

public class UsersAccountInfoAccessDTO extends DTO {

	
	private Integer loginTentativeNumber;
	
	private Boolean accountActivationStatus;

	public Integer getLoginTentativeNumber() {
		return loginTentativeNumber;
	}

	public void setLoginTentativeNumber(Integer loginTentativeNumber) {
		this.loginTentativeNumber = loginTentativeNumber;
	}

	public Boolean getAccountActivationStatus() {
		return accountActivationStatus;
	}

	public void setAccountActivationStatus(Boolean accountActivationStatus) {
		this.accountActivationStatus = accountActivationStatus;
	}
	
	
}
