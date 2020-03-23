package std.fle._04_associationModel._04_02_dto;

import fle.toolBox.classType.DTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersInfoDTO;

public class UserDTO extends DTO {

	private UsersInfoDTO usersInfoDTO;
	
	private UsersAccountInfoDTO usersAccountInfoDTO;

	public UsersInfoDTO getUsersInfoDTO() {
		return usersInfoDTO;
	}

	public void setUsersInfoDTO(UsersInfoDTO usersInfoDTO) {
		this.usersInfoDTO = usersInfoDTO;
	}

	public UsersAccountInfoDTO getUsersAccountInfoDTO() {
		return usersAccountInfoDTO;
	}

	public void setUsersAccountInfoDTO(UsersAccountInfoDTO usersAccountInfoDTO) {
		this.usersAccountInfoDTO = usersAccountInfoDTO;
	}
	
}
