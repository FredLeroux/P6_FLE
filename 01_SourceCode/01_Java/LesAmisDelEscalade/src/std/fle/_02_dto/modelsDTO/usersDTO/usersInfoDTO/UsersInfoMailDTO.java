package std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO;

import fle.toolBox.classType.DTO;

public class UsersInfoMailDTO extends DTO {
	
	private Integer id;
	
	private String email;

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
	
	
}
