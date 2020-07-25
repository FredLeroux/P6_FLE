package std.fle._06_dao.climbingLevelsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.dao.DAOGenericInterface;
import std.fle._01_entity.assetsClasses.ClimbingLevels;
import std.fle._02_dto.assetsClassesDTO.ClimbingLevelsDTO;

@Repository
class ClimbingLevelsDAOImplemented implements ClimbingLevelsDAO {

	@Autowired
	DAOGenericInterface<ClimbingLevels, ClimbingLevelsDTO> dao;
	
	private ClimbingLevels climbingLevels = new ClimbingLevels();
	private ClimbingLevelsDTO climbingLevelsDTO = new ClimbingLevelsDTO();
	
	@Override
	public ClimbingLevels getEntityById(Integer id) {
		return dao.getEntityById(climbingLevels, id);
	}

	@Override
	public ClimbingLevelsDTO getDTOByID(Integer id) {
		return dao.getDtoByID(climbingLevels, climbingLevelsDTO, id);
	}

}
