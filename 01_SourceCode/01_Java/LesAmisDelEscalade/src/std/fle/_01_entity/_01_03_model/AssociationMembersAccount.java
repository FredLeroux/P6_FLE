package std.fle._01_entity._01_03_model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@NamedQuery(name = "highestAccountNumber",
query = "SELECT MAX(a.member_number)"
		+ " FROM association_members_account a")

//@Entity
//@Table(name ="association_members_accounts")
public class AssociationMembersAccount {
	
	private Integer id;
	
	private String menberAccount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenberAccount() {
		return menberAccount;
	}

	public void setMenberAccount(String menberAccount) {
		this.menberAccount = menberAccount;
	}
	
	

}
