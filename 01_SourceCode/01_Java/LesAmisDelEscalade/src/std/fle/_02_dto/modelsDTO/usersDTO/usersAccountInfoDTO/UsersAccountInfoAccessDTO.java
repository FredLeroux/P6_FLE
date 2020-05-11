package std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO;

import fle.toolBox.classType.DTO;

public class UsersAccountInfoAccessDTO extends DTO {

	
	private Integer loginTentativeNumber;
	
	private Boolean accountActivationStatus;
	
	private String passwordResetCode;

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

	public String getPasswordResetCode() {
		return passwordResetCode;
	}

	public void setPasswordResetCode(String passwordResetCode) {
		this.passwordResetCode = passwordResetCode;
	}
	
	
	
}
