package std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO;

import fle.toolBox.classType.DTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoDTO;

public class UsersInfoUsersAccountInfoDTO extends DTO {

	
	private UsersAccountInfoDTO userAccountInfoDTO;

	public UsersAccountInfoDTO getUserAccountInfo() {
		return userAccountInfoDTO;
	}

	public void setUserAccountInfo(UsersAccountInfoDTO userAccountInfo) {
		this.userAccountInfoDTO = userAccountInfo;
	}
	
	
	
}
