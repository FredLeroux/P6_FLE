package std.fle._01_entity.models.site;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fle.toolBox.classType.ENT;

@Entity
@Table(name = "climbing_site_comments", schema = "cliff")
public class ClimbingSiteComments extends ENT {

	/**
	 *
	 */
	private static final long serialVersionUID = 28840530513804341L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "comment")
	private String comment;

	@Column(name = "post_date")
	private LocalDateTime postDate;

	@Column(name = "comment_author")
	private String commentAuthor;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "climbing_site_fk")
	private ClimbingSite climbingSite;

	@OneToMany(mappedBy = "climbingSiteComments",cascade = CascadeType.ALL)
	private List<CommentsModificationLog> commentsModificationLog;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public LocalDateTime getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ClimbingSite getClimbingSite() {
		return climbingSite;
	}

	public void setClimbingSite(ClimbingSite climbingSite) {
		this.climbingSite = climbingSite;
	}

	public String getCommentAuthor() {
		return commentAuthor;
	}

	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}

	public List<CommentsModificationLog> getCommentsModificationLog() {
		return commentsModificationLog;
	}

	public void setCommentsModificationLog(List<CommentsModificationLog> commentsModificationLog) {
		this.commentsModificationLog = commentsModificationLog;
	}







}
