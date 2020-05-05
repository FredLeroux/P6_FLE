package std.fle._04_associationModel._04_02_dto;

import fle.toolBox.classType.DTO;
import std.fle._02_dto.modelsDTO.usersDTO._02_02_01_01_usersAccountInfoDTO.UsersAccountInfoUpdateDTO;
import std.fle._02_dto.modelsDTO.usersDTO._02_02_01_02_usersInfoDTO.UsersInfoDTO;

public class UserUpdateDTO extends DTO {

	private UsersInfoDTO usersInfoDTO;

	private UsersAccountInfoUpdateDTO userAccountInfoUpdateDTO;

	public UsersInfoDTO getUsersInfoDTO() {
		return usersInfoDTO;
	}

	public void setUsersInfoDTO(UsersInfoDTO usersInfoDTO) {
		this.usersInfoDTO = usersInfoDTO;
	}

	public UsersAccountInfoUpdateDTO getUserAccountInfoUpdateDTO() {
		return userAccountInfoUpdateDTO;
	}

	public void setUserAccountInfoUpdateDTO(UsersAccountInfoUpdateDTO userAccountInfoUpdateDTO) {
		this.userAccountInfoUpdateDTO = userAccountInfoUpdateDTO;
	}

}
