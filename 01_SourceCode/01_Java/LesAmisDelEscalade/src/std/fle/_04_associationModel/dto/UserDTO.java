package std.fle._04_associationModel.dto;

import fle.toolBox.classType.DTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO.UsersInfoDTO;

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
