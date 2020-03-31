package std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao;

import std.fle._01_entity._01_03_models.UsersInfo;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersInfoDTO;
import std.fle._03_sfc._03_01_usersSFC.UsersInfoSFC;
import std.fle._05_CRUDInterface.ModelsCRUD;

public interface UsersInfoDAO extends ModelsCRUD<UsersInfo, UsersInfoDTO,UsersInfoSFC> {

}
