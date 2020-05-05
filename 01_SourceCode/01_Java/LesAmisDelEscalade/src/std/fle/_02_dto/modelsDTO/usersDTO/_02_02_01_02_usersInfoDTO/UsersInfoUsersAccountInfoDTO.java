package std.fle._02_dto.modelsDTO.usersDTO._02_02_01_02_usersInfoDTO;

import fle.toolBox.classType.DTO;
import std.fle._02_dto.modelsDTO.usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoDTO;

public class UsersInfoUsersAccountInfoDTO extends DTO {

	
	private UsersAccountInfoDTO userAccountInfoDTO;

	public UsersAccountInfoDTO getUserAccountInfo() {
		return userAccountInfoDTO;
	}

	public void setUserAccountInfo(UsersAccountInfoDTO userAccountInfo) {
		this.userAccountInfoDTO = userAccountInfo;
	}
	
	
	
}
