package std.fle._07_service._07_02_serviceImplemented._07_02_01_assetsServiceImplemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._01_entity._01_01_assetsClasses.ClimbingLevels;
import std.fle._02_dto._02_01_assetsClassesDTO.ClimbingLevelsDTO;
import std.fle._06_dao._06_01_daoInterface._06_01_01_assetsDao.ClimbingLevelsDAO;
import std.fle._07_service._07_01_serviceInterface._07_01_01_assetsServiceInterface.ClimbingLevelsService;
@Service
 class ClimbingLevelsServiceImplemented implements ClimbingLevelsService {
	
	@Autowired
	ClimbingLevelsDAO dao;
	
	

	@Override
	public ClimbingLevels getEntityById(Integer id) {
		return dao.getEntityById(id);
	}

	@Override
	public ClimbingLevelsDTO getDTOByID(Integer id) {
		return dao.getDTOByID(id);
	}

}
