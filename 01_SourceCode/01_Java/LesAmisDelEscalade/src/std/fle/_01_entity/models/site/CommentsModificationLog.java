package std.fle._01_entity.models.site;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fle.toolBox.classType.ENT;

@Entity
@Table(name = "climbing_site_comment_modification_log", schema = "cliff")
public class CommentsModificationLog extends ENT {

	private static final long serialVersionUID = 7982656396760751814L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "modificatio_date")
	private LocalDateTime modificationDate;

	@Column(name = "author")
	private String author;
	
	@Column(name = "comment_before_modification" )
	private String commentBefore;

	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "climbing_site_comment_fk")
	private ClimbingSiteComments climbingSiteComments;

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

	public ClimbingSiteComments getClimbingSiteComments() {
		return climbingSiteComments;
	}

	public void setClimbingSiteComments(ClimbingSiteComments climbingSiteComments) {
		this.climbingSiteComments = climbingSiteComments;
	}

}
