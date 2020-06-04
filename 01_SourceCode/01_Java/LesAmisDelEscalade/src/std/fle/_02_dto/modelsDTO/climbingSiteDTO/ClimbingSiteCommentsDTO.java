package std.fle._02_dto.modelsDTO.climbingSiteDTO;

import java.time.LocalDateTime;

import fle.toolBox.classType.DTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoDTO;

public class ClimbingSiteCommentsDTO extends DTO {

	private Integer id;

	private String comment;

	private LocalDateTime postDate;

	private ClimbingSiteDTO climbingSite;

	private UsersAccountInfoDTO usersAccountInfo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
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
