package std.fle._07_service.climbingLevelsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._01_entity.assetsClasses.ClimbingLevels;
import std.fle._02_dto.assetsClassesDTO.ClimbingLevelsDTO;
import std.fle._06_dao.climbingLevelsDao.ClimbingLevelsDAO;
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
