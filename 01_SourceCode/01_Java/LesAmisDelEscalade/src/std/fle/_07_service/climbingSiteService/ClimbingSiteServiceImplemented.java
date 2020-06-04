package std.fle._07_service.climbingSiteService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import std.fle._02_dto.modelsDTO.climbingSiteDTO.ClimbingSiteDTO;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.RoutePitchDTO;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteDisplaySFC;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;
import std.fle._06_dao.climbingSiteDao.ClimbingSiteDAO;

@Service
public class ClimbingSiteServiceImplemented implements ClinbingSiteService {

	@Autowired
	private ClimbingSiteDAO dao;
	
	@Override
	public void saveClimbingSite(ClimbingSiteSFC climbingSiteSFC, Map<String, SiteRoutesSFC> siteRoutesMap,
			Map<String, List<RoutePitchSFC>> routePitchsMap) {
		dao.saveClimbingSite(climbingSiteSFC, siteRoutesMap, routePitchsMap);
		
	}

	@Override
	public void updateClimbingSite(ClimbingSiteSFC climbingSiteSFC, Map<String, SiteRoutesSFC> siteRoutesMap,
			Map<String, List<RoutePitchSFC>> routePitchsMap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClimbingSiteDisplaySFC getClimbingSiteDisplaySFCById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void climbingSiteDelete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RoutePitchDTO> sortedRoutePitchsDTOList(String key, Map<String, List<RoutePitchSFC>> routePitchsMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoutePitchSFC> sortedRoutePitchsSFCWithCotationLevelAsString(String key,
			Map<String, List<RoutePitchSFC>> routePitchsMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoutePitchSFC> sortedRoutePitchsSFCWithCotationLevelAsString(List<RoutePitchSFC> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoutePitchSFC> sortedRoutePitchsSFCList(String key, Map<String, List<RoutePitchSFC>> routePitchsMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClimbingSiteDTO getClimbingSiteDTOById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClimbingSiteSFC getClimbingSiteSFCByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, SiteRoutesSFC> getSiteRouteMapByClimbingSiteId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<RoutePitchSFC>> getRoutePitchsMapByClimbingSiteId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
