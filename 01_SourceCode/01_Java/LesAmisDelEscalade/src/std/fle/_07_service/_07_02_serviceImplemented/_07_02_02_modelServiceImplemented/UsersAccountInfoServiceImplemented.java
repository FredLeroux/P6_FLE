package std.fle._07_service._07_02_serviceImplemented._07_02_02_modelServiceImplemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fle.toolBox.classType.DTO;
import std.fle._01_entity._01_03_models.UsersAccountInfo;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoDTO;
import std.fle._03_sfc._03_01_usersSFC.UsersAccountInfoSFC;
import std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao.UsersAccountInfoDAO;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersAccountInfoService;
@Service
public class UsersAccountInfoServiceImplemented implements UsersAccountInfoService {
	
	@Autowired
	UsersAccountInfoDAO dao;

	@Override
	public UsersAccountInfo getEntityById(Integer id) {
		return dao.getEntityById(id);
	}

	@Override
	public UsersAccountInfoDTO getDTOByID(Integer id) {
		return dao.getDTOByID(id);
	}

	@Override
	public UsersAccountInfo postTransactionTreatment(UsersAccountInfoSFC SFCClass) {
		return dao.postTransactionTreatment(SFCClass);
	}

	@Override
	public void save(UsersAccountInfo entity) {
		dao.save(entity);

	}

	@Override
	public<DA extends DTO> DA getPassPseudoAndLevel(String login) {
		return dao.getPassPseudoAndLevel(login);
	}

	

}
