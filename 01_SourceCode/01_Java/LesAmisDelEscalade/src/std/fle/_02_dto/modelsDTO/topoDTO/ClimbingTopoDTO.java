package std.fle._02_dto.modelsDTO.topoDTO;

import fle.toolBox.classType.DTO;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO.UsersInfoDTO;

public class ClimbingTopoDTO extends DTO {

	private Integer id;

	private String title;

	private String editionYear;

	private Boolean available;

	private String topoDescription;

	private StatesDTO state;

	private UsersInfoDTO userInfo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEditionYear() {
		return editionYear;
	}

	public void setEditionYear(String editionYear) {
		this.editionYear = editionYear;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getTopoDescription() {
		return topoDescription;
	}

	public void setTopoDescription(String topoDescription) {
		this.topoDescription = topoDescription;
	}

	public StatesDTO getState() {
		return state;
	}

	public void setState(StatesDTO state) {
		this.state = state;
	}

	public UsersInfoDTO getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UsersInfoDTO userInfo) {
		this.userInfo = userInfo;
	}

}
