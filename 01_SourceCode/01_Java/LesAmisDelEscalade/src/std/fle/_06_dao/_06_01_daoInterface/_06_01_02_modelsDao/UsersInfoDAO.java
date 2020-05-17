package std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao;

import java.util.List;

import fle.toolBox.classType.SLO;
import std.fle._01_entity.models.users.UsersInfo;
import std.fle._02_dto.modelsDTO.usersDTO.usersInfoDTO.UsersInfoDTO;
import std.fle._03_sfc.usersInfoSFC.UsersInfoSFC;
import std.fle._0x_CRUDInterface.ModelsCRUD;

public interface UsersInfoDAO extends ModelsCRUD<UsersInfo, UsersInfoDTO,UsersInfoSFC> {
	
	public boolean isEmailExist(String eMail);
	
	public String getAccountEmailByLogin(String login);
	
	public<L extends SLO> List<L> getList(L joinClass,String suffix);

}
