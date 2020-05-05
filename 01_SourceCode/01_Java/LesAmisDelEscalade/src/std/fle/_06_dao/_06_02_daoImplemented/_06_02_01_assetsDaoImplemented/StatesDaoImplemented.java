package std.fle._06_dao._06_02_daoImplemented._06_02_01_assetsDaoImplemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.dao.DAOGenericInterface;
import std.fle._01_entity.assetsClasses.States;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;
import std.fle._06_dao._06_01_daoInterface._06_01_01_assetsDao.StatesDAO;
@Repository
 class StatesDaoImplemented implements StatesDAO {
	
	@Autowired
	DAOGenericInterface<States, StatesDTO> dao;
	
	private States states =new States();
	private StatesDTO statesDTO = new StatesDTO();

	@Override
	public States getEntityById(Integer id) {
		return dao.getEntityByID(states, id);
	}

	@Override
	public StatesDTO getDTOByID(Integer id) {		
		return dao.getDtoByID(states, statesDTO, id);
	}

}
