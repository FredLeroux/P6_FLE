package std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO;

import fle.toolBox.classType.DTO;

public class UsersAccountInfoToTopoDTO extends DTO {
	
	private Integer id;

	private String pseudonyme;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPseudonyme() {
		return pseudonyme;
	}

	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

	

}
