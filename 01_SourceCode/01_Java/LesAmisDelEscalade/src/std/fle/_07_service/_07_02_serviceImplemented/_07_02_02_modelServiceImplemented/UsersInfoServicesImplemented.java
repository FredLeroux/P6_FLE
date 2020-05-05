package std.fle._07_service._07_02_serviceImplemented._07_02_02_modelServiceImplemented;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._01_entity.models.users.UsersInfo;
import std.fle._02_dto.modelsDTO.usersDTO._02_02_01_02_usersInfoDTO.UsersInfoDTO;
import std.fle._03_sfc.usersInfoSFC.UsersInfoSFC;
import std.fle._05_slo.innerJoinSLO.MembersListSLO;
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

	@Override
	public UsersInfoSFC getSFCById(Integer id) {		
		return dao.getSFCById(id);
	}

	@Override
	public void updateSFC(UsersInfoSFC SFCObject) {
		dao.updateSFC(SFCObject);
		
	}

	@Override
	public void updateEntity(UsersInfo entity) {
		dao.updateEntity(entity);
		
	}

	@Override
	public void updateDTO(UsersInfoDTO DTOClass) {
		dao.updateDTO(DTOClass);
		
	}

	@Override
	public boolean isEmailExist(String eMail) {		
		return dao.isEmailExist(eMail);
	}

	@Override
	public String getAccountEmailByLogin(String login) {		
		return dao.getAccountEmailByLogin(login);
	}

	@Override
	public List<MembersListSLO> getList(MembersListSLO joinClass,String suffix) {
		
		return dao.getList(joinClass,suffix);
	}
	
	

	

}
