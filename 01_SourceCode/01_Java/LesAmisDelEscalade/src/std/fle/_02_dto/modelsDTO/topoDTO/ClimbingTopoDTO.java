package std.fle._02_dto.modelsDTO.topoDTO;

import java.time.LocalDate;

import fle.toolBox.classType.DTO;
import std.fle._01_entity.assetsClasses.States;
import std.fle._01_entity.models.users.UsersInfo;

public class ClimbingTopoDTO extends DTO {

	private Integer id;

	private String title;

	private LocalDate editionYear;

	private Boolean available;

	private String topoDescription;

	private States state;

	private UsersInfo userInfo;

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

	public LocalDate getEditionYear() {
		return editionYear;
	}

	public void setEditionYear(LocalDate editionYear) {
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

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public UsersInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UsersInfo userInfo) {
		this.userInfo = userInfo;
	}

}
