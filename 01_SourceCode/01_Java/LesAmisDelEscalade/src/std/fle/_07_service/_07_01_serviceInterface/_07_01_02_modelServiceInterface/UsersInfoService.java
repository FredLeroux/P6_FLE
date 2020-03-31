package std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface;

import std.fle._01_entity._01_03_models.UsersInfo;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersInfoDTO;
import std.fle._03_sfc._03_01_usersSFC.UsersInfoSFC;
import std.fle._05_CRUDInterface.ModelsCRUD;

public interface UsersInfoService extends ModelsCRUD<UsersInfo, UsersInfoDTO, UsersInfoSFC> {

}
