package std.fle._02_dto.modelsDTO.climbingSiteDTO;

import fle.toolBox.classType.DTO;
import std.fle._01_entity.models.site.ClimbingSite;
import std.fle._01_entity.models.users.UsersAccountInfo;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoDTO;

public class ClimbingSiteCommentsDTO extends DTO {

	private Integer id;

	private String comment;

	private ClimbingSiteDTO climbingSite;

	private UsersAccountInfoDTO usersAccountInfo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ClimbingSiteDTO getClimbingSite() {
		return climbingSite;
	}

	public void setClimbingSite(ClimbingSiteDTO climbingSite) {
		this.climbingSite = climbingSite;
	}

	public UsersAccountInfoDTO getUsersAccountInfo() {
		return usersAccountInfo;
	}

	public void setUsersAccountInfo(UsersAccountInfoDTO usersAccountInfo) {
		this.usersAccountInfo = usersAccountInfo;
	}
	
	

}
