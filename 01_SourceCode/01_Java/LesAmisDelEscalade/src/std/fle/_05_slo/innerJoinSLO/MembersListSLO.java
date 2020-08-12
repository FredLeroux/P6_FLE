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

@NamedQuery(name = "MembersListSLO", query = "SELECT  B.id,B.pseudonyme,B.signUpDate,B.member,B.securityLevel"
		+ " FROM UsersInfo A INNER JOIN  UsersAccountInfo B ON A.userAccountInfo = B.id ORDER by B.signUpDate")

@Entity
public class MembersListSLO extends SLO {

	@Id
	private Integer Id;


	@Operator(signsArray = OperatorArrays.EQUAL)
	private String pseudonyme;
	@Operator(signsArray = OperatorArrays.EQUAL)
	@DateTimeRawFormat(dateFormatStyle = FormatStyle.LONG)
	private String signUpDate;
	@Operator(signsArray = OperatorArrays.EQUAL)
	@ToTranslate(suffix = "isMember")
	private String member;
	@Operator(signsArray = OperatorArrays.EQUAL)
	@ToTranslate(suffix = "name")
	private String securityLevel;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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

	public String getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(String securityLevel) {
		this.securityLevel = securityLevel;
	}






}
