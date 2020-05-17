package std.fle._02_dto.assetsClassesDTO;

import fle.toolBox.classType.DTO;

public class ClimbingLevelsDTO extends DTO {
	
	private Integer id;
	private String cotationLevel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCotationLevel() {
		return cotationLevel;
	}
	public void setCotationLevel(String cotationLevel) {
		this.cotationLevel = cotationLevel;
	}
	
	
	
}
