package std.fle._06_dao.countiesDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.dao.DAOGenericInterface;
import std.fle._01_entity.assetsClasses.Counties;
import std.fle._02_dto.assetsClassesDTO.CountiesDTO;
@Repository
 class CountiesDAOImplemented implements CountiesDao {
	
	@Autowired
	DAOGenericInterface<Counties, CountiesDTO> dao;

	private Counties counties = new Counties();
	private CountiesDTO countiesDTO = new CountiesDTO();
	
	@Override
	public Counties getEntityById(Integer id) {		
		return dao.getEntityById(counties, id);
	}

	@Override
	public CountiesDTO getDTOByID(Integer id) {		
		return dao.getDtoByID(counties, countiesDTO, id);
	}

	

}
