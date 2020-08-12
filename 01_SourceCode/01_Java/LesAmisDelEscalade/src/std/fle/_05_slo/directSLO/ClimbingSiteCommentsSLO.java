package std.fle._05_slo.directSLO;

import java.time.format.FormatStyle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import fle.toolBox.classType.SLO;
import fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.annotations.NotAListFilter;
import fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.annotations.operator.Operator;
import fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.annotations.operator.OperatorArrays;
import fle.toolBox.dateAndTime.annotation.DateTimeRawFormat;

@NamedQuery(name = "ClimbingSiteCommentsSLO",
query = "SELECT A.id,A.commentAuthor,A.postDate,A.comment"
		+ " FROM ClimbingSiteComments A"
		+ " WHERE A.climbingSite.id = :siteId"
		+ " ORDER BY A.postDate DESC")


@Entity
public class ClimbingSiteCommentsSLO extends SLO {

	@Id
	private Integer id;


	@Operator(signsArray = OperatorArrays.EQUAL)
	private String commentAuthor;

	@Operator(signsArray = OperatorArrays.INFERIOR_EQUAL_SUPERIOR )
	@DateTimeRawFormat(dateFormatStyle = FormatStyle.LONG,rawFormatPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	private String postDate;

	@NotAListFilter
	private String comment;


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

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getCommentAuthor() {
		return commentAuthor;
	}

	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}





}
