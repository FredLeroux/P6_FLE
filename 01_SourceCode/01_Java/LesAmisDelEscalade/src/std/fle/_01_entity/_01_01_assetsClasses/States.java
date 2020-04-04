package std.fle._01_entity._01_01_assetsClasses;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import fle.toolBox.classType.ENT;
import std.fle._01_entity._01_03_models.UsersInfo;

@Entity
@Table(name = "french_states", schema = "cliff")
public class States extends ENT implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8202326579466179009L;

	@Id
	private Integer id;

	@Column(name = "state_number")
	private Integer stateNumber;

	@Column(name = "state_name")
	private String stateName;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "state")	 
	@OnDelete(action = OnDeleteAction.NO_ACTION) 	
	private List<UsersInfo> usersInfo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStateNumber() {
		return stateNumber;
	}

	public void setStateNumber(Integer stateNumber) {
		this.stateNumber = stateNumber;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<UsersInfo> getUsersInfo() {
		return usersInfo;
	}

	public void setUsersInfo(List<UsersInfo> usersInfo) {
		this.usersInfo = usersInfo;
	}
	
	

}
