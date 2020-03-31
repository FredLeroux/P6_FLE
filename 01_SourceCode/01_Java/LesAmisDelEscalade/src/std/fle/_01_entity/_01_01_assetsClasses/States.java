package std.fle._01_entity._01_01_assetsClasses;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import fle.toolBox.classType.ENT;

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

}
