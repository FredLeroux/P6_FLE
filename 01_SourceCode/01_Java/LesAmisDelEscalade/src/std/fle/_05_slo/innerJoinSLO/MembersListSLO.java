package std.fle._05_slo.innerJoinSLO;

import java.time.format.FormatStyle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import fle.toolBox.classType.SLO;
import fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.annotations.ToTranslate;
import fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.annotations.operator.Operator;
import fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.annotations.operator.OperatorArrays;
import fle.toolBox.dateAndTime.annotation.DateTimeRawFormat;

@NamedQuery(name = "MembersListSLO", query = "SELECT  B.id,A.firstName,A.lastName,B.pseudonyme,B.signUpDate,B.member"
		+ " FROM UsersInfo A INNER JOIN  UsersAccountInfo B ON A.userAccountInfo = B.id ORDER by B.signUpDate")

@Entity
public class MembersListSLO extends SLO {

	@Id
	private Integer Id;

	@Operator(signsArray = OperatorArrays.EQUAL)
	private String firstName;
	@Operator(signsArray = OperatorArrays.EQUAL)
	private String lastName;
	@Operator(signsArray = OperatorArrays.EQUAL)
	private String pseudonyme;
	@Operator(signsArray = OperatorArrays.EQUAL)
	@DateTimeRawFormat(dateFormatStyle = FormatStyle.LONG)
	private String signUpDate;
	@Operator(signsArray = OperatorArrays.EQUAL)
	@ToTranslate(suffix = "isMember")
	private String member;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPseudonyme() {
		return pseudonyme;
	}

	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

	public String  getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(String   signUpDate) {
		this.signUpDate = signUpDate;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	
	
}
