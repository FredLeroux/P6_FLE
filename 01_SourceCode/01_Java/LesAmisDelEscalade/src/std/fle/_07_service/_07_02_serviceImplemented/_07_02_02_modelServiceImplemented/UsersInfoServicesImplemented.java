package std.fle._07_service._07_02_serviceImplemented._07_02_02_modelServiceImplemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._01_entity._01_03_models.UsersInfo;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersInfoDTO;
import std.fle._03_sfc._03_01_usersSFC.UsersInfoSFC;
import std.fle._06_dao._06_01_daoInterface._06_01_02_modelsDao.UsersInfoDAO;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersInfoService;

@Service
public class UsersInfoServicesImplemented implements UsersInfoService {
	
	@Autowired
	UsersInfoDAO dao;

	@Override
	public UsersInfo getEntityById(Integer id) {		
		return dao.getEntityById(id);
	}

	@Override
	public UsersInfoDTO getDTOByID(Integer id) {		
		return dao.getDTOByID(id);
	}

	@Override
	public UsersInfo postTransactionTreatment(UsersInfoSFC SFCClass) {		
		return dao.postTransactionTreatment(SFCClass);
	}

	@Override
	public void save(UsersInfo entity) {
		dao.save(entity);

	}

}
