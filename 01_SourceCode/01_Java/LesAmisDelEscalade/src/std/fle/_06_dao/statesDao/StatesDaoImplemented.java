package std.fle._06_dao.statesDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.dao.DAOGenericInterface;
import std.fle._01_entity.assetsClasses.States;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;
@Repository
 class StatesDaoImplemented implements StatesDAO {
	
	@Autowired
	DAOGenericInterface<States, StatesDTO> dao;
	
	private States states =new States();
	private StatesDTO statesDTO = new StatesDTO();

	@Override
	public States getEntityById(Integer id) {
		return dao.getEntityById(states, id);
	}

	@Override
	public StatesDTO getDTOByID(Integer id) {		
		return dao.getDtoByID(states, statesDTO, id);
	}

}
