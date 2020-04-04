package std.fle._04_associationModel._04_02_dto;

import fle.toolBox.classType.DTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoUpdateDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersInfoDTO;

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
