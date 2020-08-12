package std.fle._02_dto.modelsDTO.climbingSiteDTO;

import java.time.LocalDateTime;

import fle.toolBox.classType.DTO;

public class ClimbingSiteCommentsDTO extends DTO {

	private Integer id;

	private String commentAuthor;

	private LocalDateTime postDate;

	private String comment;

	private ClimbingSiteDTO climbingSite;

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

	public String getCommentAuthor() {
		return commentAuthor;
	}

	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}



}
