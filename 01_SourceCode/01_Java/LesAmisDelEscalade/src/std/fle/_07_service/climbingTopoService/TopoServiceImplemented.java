package std.fle._07_service.climbingTopoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._02_dto.modelsDTO.topoDTO.TopoLendingDTO;
import std.fle._03_sfc.topoSFC.ClimbingTopoDisplaySFC;
import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;
import std.fle._06_dao.topoDao.TopoDAO;

@Service
public class TopoServiceImplemented implements TopoService {

	@Autowired
	TopoDAO topoDao;

	@Override
	public void saveNewTopo(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId) {
		topoDao.saveNewTopo(climbingTopoSFC, loggedUserId);
	}
	
	@Override
	public void updateClimbingTopo(ClimbingTopoSFC climbingTopoSFC, Integer loggedUserId) {
		topoDao.updateClimbingTopo(climbingTopoSFC,loggedUserId);		
	}
	
	@Override
	public ClimbingTopoSFC getClimbingTopoSFC(Integer id) {
		return topoDao.getClimbingTopoSFC(id);
	}

	@Override
	public ClimbingTopoDisplaySFC getClimbingTopoDisplayDTO(Integer id) {
		return topoDao.getClimbingTopoDisplaySFC(id);
	}

	@Override
	public void borrowThisTopo(Integer topoId, Integer loggedUserId, String pseudo) {
		topoDao.borrowThisTopo(topoId, loggedUserId, pseudo);

	}

	@Override
	public String getOwnerMail(String ownerPseudo) {
		return topoDao.getOwnerEmail(ownerPseudo);
	}
	
	@Override
	public TopoLendingDTO getTopoLendingById(Integer id) {		
		return topoDao.getTopoLendingById(id);
	}

	@Override
	public String getOwnerEmailViaTopoLending(Integer topoLendingId) {
		return topoDao.getOwnerEmailViaTopoLending(topoLendingId);
	}

	@Override
	public String getBorrowerEmail(Integer loggedUserId) {
		return topoDao.getBorrowerEmail(loggedUserId);
	}

	@Override
	public String getBorrowerEmailViaTopoLending(Integer topoLendingId) {
		return topoDao.getBorrowerEmailViaTopoLending(topoLendingId);
	}

	@Override
	public void borrowDemandAccepted(Integer id) {
		topoDao.borrowDemandAccepted(id);
	}

	@Override
	public void borrowDemandRejected(Integer id) {
		topoDao.borrowDemandRejected(id);
	}

	@Override
	public boolean lenderCheck(Integer topoLendingId, Integer loggedUserId) {
		return topoDao.lenderCheck(topoLendingId, loggedUserId);
	}

	@Override
	public void deleteTopo(Integer id) {
		topoDao.deleteTopo(id);
		
	}

	

	

	
		
	
	

}
