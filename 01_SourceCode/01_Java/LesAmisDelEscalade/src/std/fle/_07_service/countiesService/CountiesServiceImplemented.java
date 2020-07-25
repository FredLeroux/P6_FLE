package std.fle._07_service.countiesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._01_entity.assetsClasses.Counties;
import std.fle._02_dto.assetsClassesDTO.CountiesDTO;
import std.fle._06_dao.countiesDao.CountiesDao;
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
