package std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface;

import java.util.List;

import std.fle._01_entity.models.users.UsersInfo;
import std.fle._02_dto.modelsDTO.usersDTO._02_02_01_02_usersInfoDTO.UsersInfoDTO;
import std.fle._03_sfc.usersInfoSFC.UsersInfoSFC;
import std.fle._05_slo.innerJoinSLO.MembersListSLO;
import std.fle._0x_CRUDInterface.ModelsCRUD;

public interface UsersInfoService extends ModelsCRUD<UsersInfo, UsersInfoDTO, UsersInfoSFC> {
	
	public boolean isEmailExist(String eMail);
	
	public String getAccountEmailByLogin(String login);

	public List<MembersListSLO> getList(MembersListSLO joinClass,String suffix);
}
