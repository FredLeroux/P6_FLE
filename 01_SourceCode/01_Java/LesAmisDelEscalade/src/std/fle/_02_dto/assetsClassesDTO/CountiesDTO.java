package std.fle._02_dto.assetsClassesDTO;

import fle.toolBox.classType.DTO;


public class CountiesDTO extends DTO {

	private Integer id;

	private String countyNumber;

	private String countyName;

	private StatesDTO state;

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

	public StatesDTO getState() {
		return state;
	}

	public void setState(StatesDTO state) {
		this.state = state;
	}

}
