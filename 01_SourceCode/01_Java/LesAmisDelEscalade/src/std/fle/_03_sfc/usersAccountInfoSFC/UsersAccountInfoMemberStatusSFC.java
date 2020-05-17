package std.fle._03_sfc.usersAccountInfoSFC;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import fle.toolBox.classType.SFC;
import fle.toolBox.dataListDisplayerTools.annotations.ToTranslate;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.ReadOnlyInput;
import fle.toolBox.springFormManager.annotations.SelectInputType;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import std.fle._01_entity.assetsEnum.AccountRank;
import std.fle._01_entity.assetsEnum.BooleanValue;

@SpringFormSettings(
		action = "updateMemberStatus",
		method = "post",
		modelAttribute = "memberStatus",
		name = "updateMemberStatusForm",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		submitButtonAlignmentPropertyKey = "userFormBtn.align",
		submitButtonMessagePropertyKey = "userFormBtn.message.memberStatus",
		jspFilePath = "updateMemberStatusForm.path",
		labelMessageSourceSuffix = "userForm.label",
		
		
		readOnly = false)
public class UsersAccountInfoMemberStatusSFC extends SFC {
	
	@HiddenPath
	private Integer id;
	@ReadOnlyInput
	private String firstName;
	@ReadOnlyInput
	private String lastName;
	@ReadOnlyInput
	private String pseudonyme;		
	@ReadOnlyInput
	@DateTimeFormat(pattern = "dd  MMMM  yyyy")
	private Date signUpDate;
	//@SelectInputType(enumClass = BooleanValue.class,messageSourceSuffix = ".isMember", selectListName = "statusList", selectValueName = "statusValue")
	@ToTranslate(suffix = ".isMember")	
	@ReadOnlyInput
	private String member;
	@SelectInputType(enumClass = AccountRank.class, selectListName = "securityList", selectValueName = "securityValue",
			defaultValue = "")
	private String security;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getSignUpDate() {
		return signUpDate;
	}
	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	
	
	
	}
	
	



