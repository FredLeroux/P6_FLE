package std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface;


import std.fle._01_entity._01_03_models.UsersAccountInfo;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoAuthentificatorDTO;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoDTO;
import std.fle._03_sfc._03_01_usersSFC.UsersAccountInfoSFC;
import std.fle._03_sfc._03_01_usersSFC.UsersAccountInfoUpdateSFC;
import std.fle._05_CRUDInterface.ModelsCRUD;

public interface UsersAccountInfoService extends ModelsCRUD<UsersAccountInfo, UsersAccountInfoDTO, UsersAccountInfoSFC> {

	public UsersAccountInfoUpdateSFC getUserAccountInfoUpdateById(Integer id);
	
	public UsersAccountInfoAuthentificatorDTO getAuthentificatorDTO(String login);
}
