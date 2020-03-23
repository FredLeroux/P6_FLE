package std.fle._02_dto._02_01_assetsClassesDTO;

import fle.toolBox.classType.DTO;

public class StatesDTO extends DTO {

	private Integer id;

	private Integer stateNumber;

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
