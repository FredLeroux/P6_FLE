package std.fle._02_dto.modelsDTO.climbingSiteDTO;

import java.time.LocalDateTime;

import fle.toolBox.classType.DTO;

public class CommentsModificationLogDTO extends DTO {

	private Integer id;

	private LocalDateTime modificationDate;

	private String author;

	private String commentBefore;

	private ClimbingSiteCommentsDTO climbingSiteComments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(LocalDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCommentBefore() {
		return commentBefore;
	}

	public void setCommentBefore(String commentBefore) {
		this.commentBefore = commentBefore;
	}

	public ClimbingSiteCommentsDTO getClimbingSiteComments() {
		return climbingSiteComments;
	}

	public void setClimbingSiteComments(ClimbingSiteCommentsDTO climbingSiteComments) {
		this.climbingSiteComments = climbingSiteComments;
	}

}
