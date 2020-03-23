package std.fle._02_dto._02_01_assetsClassesDTO;

import fle.toolBox.classType.DTO;
import std.fle._01_entity._01_01_assetsClasses.States;

public class CountiesDTO extends DTO {

	private Integer id;

	private String countyNumber;

	private String countyName;

	private States state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountyNumber() {
		return countyNumber;
	}

	public void setCountyNumber(String countyNumber) {
		this.countyNumber = countyNumber;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

}
