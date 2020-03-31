package std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao;

import fle.toolBox.classType.DTO;
import std.fle._01_entity._01_03_models.UsersAccountInfo;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoDTO;
import std.fle._03_sfc._03_01_usersSFC.UsersAccountInfoSFC;
import std.fle._05_CRUDInterface.ModelsCRUD;

public interface UsersAccountInfoDAO extends ModelsCRUD<UsersAccountInfo, UsersAccountInfoDTO, UsersAccountInfoSFC> {

	
	public<DA extends DTO> DA getPassPseudoAndLevel(String login);
	
}
