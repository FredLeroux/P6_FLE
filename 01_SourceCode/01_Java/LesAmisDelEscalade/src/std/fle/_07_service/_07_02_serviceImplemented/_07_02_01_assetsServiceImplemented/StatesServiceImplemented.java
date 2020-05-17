package std.fle._07_service._07_02_serviceImplemented._07_02_01_assetsServiceImplemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._01_entity.assetsClasses.States;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;
import std.fle._06_dao.statesDao.StatesDAO;
import std.fle._07_service._07_01_serviceInterface._07_01_01_assetsServiceInterface.StatesService;
@Service
class StatesServiceImplemented implements StatesService {

	@Autowired
	StatesDAO dao;
	
	@Override
	public States getEntityById(Integer id) {		
		return dao.getEntityById(id);
	}

	@Override
	public StatesDTO getDTOByID(Integer id) {		
		return dao.getDTOByID(id);
	}

}
