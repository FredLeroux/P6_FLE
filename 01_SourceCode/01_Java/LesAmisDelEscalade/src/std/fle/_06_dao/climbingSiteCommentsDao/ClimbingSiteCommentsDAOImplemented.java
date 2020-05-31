package std.fle._06_dao.climbingSiteCommentsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.CRUD.dao.DAOGenericInterface;
import std.fle._01_entity.models.site.ClimbingSiteComments;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.ClimbingSiteCommentsDTO;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.ClimbingSiteDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoDTO;
import std.fle._06_dao.climbingSiteDao.ClimbingSiteDAO;
import std.fle._06_dao.usersAccountInfoDao.UsersAccountInfoDAO;

@Repository
public class ClimbingSiteCommentsDAOImplemented implements ClimbingSiteCommentsDAO {

	@Autowired
	private DAOGenericInterface<ClimbingSiteComments, ClimbingSiteCommentsDTO> dao;

	@Autowired
	private ClimbingSiteDAO siteDao;

	@Autowired
	private UsersAccountInfoDAO userDao;

	private ClimbingSiteComments climbingSiteComments = new ClimbingSiteComments();

	
	@Override
	public void postComment(Integer climbingSiteId, Integer userAccountId, String comment) {
		dao.saveDTO(climbingSiteComments, climbingSiteCommentsDTO(climbingSiteId, userAccountId, comment));
	}

	private ClimbingSiteCommentsDTO climbingSiteCommentsDTO(Integer climbingSiteId, Integer userAccountId,
			String comment) {
		ClimbingSiteCommentsDTO dto = new ClimbingSiteCommentsDTO();
		dto.setClimbingSite(climbingSiteDTO(climbingSiteId));
		dto.setUsersAccountInfo(usersAccountInfoDTO(userAccountId));
		dto.setComment(comment);
		return dto;
	}

	private ClimbingSiteDTO climbingSiteDTO(Integer climbingSiteId) {
		ClimbingSiteDTO dto = siteDao.getClimbingSiteDTOById(climbingSiteId);		
		return dto;
	}

	private UsersAccountInfoDTO usersAccountInfoDTO(Integer userAccountId) {
		UsersAccountInfoDTO dto = userDao.getDTOByID(userAccountId);		
		return dto;
	}

}
