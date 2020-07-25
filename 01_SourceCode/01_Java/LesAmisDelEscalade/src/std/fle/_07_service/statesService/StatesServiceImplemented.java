package std.fle._07_service.statesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._01_entity.assetsClasses.States;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;
import std.fle._06_dao.statesDao.StatesDAO;
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
