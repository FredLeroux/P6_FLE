package std.fle._02_dto.modelsDTO.topoDTO;

import fle.toolBox.classType.DTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO.UsersInfoToTopoDTO;

public class TopoLendingDTO extends DTO {

	private Integer id;

	private ClimbingTopoDTO climbingTopo;

	private UsersInfoToTopoDTO lenderUserInfo;

	private UsersInfoToTopoDTO borrowerUserInfo;

	private String lendingStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClimbingTopoDTO getClimbingTopo() {
		return climbingTopo;
	}

	public void setClimbingTopo(ClimbingTopoDTO climbingTopo) {
		this.climbingTopo = climbingTopo;
	}

	public UsersInfoToTopoDTO getLenderUserInfo() {
		return lenderUserInfo;
	}

	public void setLenderUserInfo(UsersInfoToTopoDTO lenderUserInfo) {
		this.lenderUserInfo = lenderUserInfo;
	}

	public UsersInfoToTopoDTO getBorrowerUserInfo() {
		return borrowerUserInfo;
	}

	public void setBorrowerUserInfo(UsersInfoToTopoDTO borrowerUserInfo) {
		this.borrowerUserInfo = borrowerUserInfo;
	}

	public String getLendingStatus() {
		return lendingStatus;
	}

	public void setLendingStatus(String lendingStatus) {
		this.lendingStatus = lendingStatus;
	}

}
