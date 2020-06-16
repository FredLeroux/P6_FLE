package std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO;

import fle.toolBox.classType.DTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoToTopoDTO;

public class UsersInfoToTopoDTO extends DTO {
	
	private Integer id;
	
	private String email;
	
	private UsersAccountInfoToTopoDTO userAccountInfo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UsersAccountInfoToTopoDTO getUserAccountInfo() {
		return userAccountInfo;
	}

	public void setUserAccountInfo(UsersAccountInfoToTopoDTO userAccountInfo) {
		this.userAccountInfo = userAccountInfo;
	}
	
	

}
