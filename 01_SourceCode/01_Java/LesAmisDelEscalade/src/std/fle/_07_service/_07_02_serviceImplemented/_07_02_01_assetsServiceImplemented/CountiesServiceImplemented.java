package std.fle._07_service._07_02_serviceImplemented._07_02_01_assetsServiceImplemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._01_entity._01_01_assetsClasses.Counties;
import std.fle._02_dto._02_01_assetsClassesDTO.CountiesDTO;
import std.fle._06_dao._06_01_daoInterface._06_01_01_assetsDao.CountiesDao;
import std.fle._07_service._07_01_serviceInterface._07_01_01_assetsServiceInterface.CountiesService;
@Service
 class CountiesServiceImplemented implements CountiesService {
	
	@Autowired
	CountiesDao dao;

	@Override
	public Counties getEntityById(Integer id) {		
		return dao.getEntityById(id);
	}

	@Override
	public CountiesDTO getDTOByID(Integer id) {		
		return dao.getDTOByID(id);
	}

}
