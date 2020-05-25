package std.fle._06_dao.climbingSiteDao;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import std.fle._02_dto.modelsDTO.climbingSiteDTO.RoutePitchDTO;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;

@Transactional
public interface ClimbingSiteDAO {

	public void saveClimbingSite(ClimbingSiteSFC climbingSiteSFC, Map<String, SiteRoutesSFC> siteRoutesMap,
			Map<String, List<RoutePitchSFC>> routePitchsMap);
	
	public void updateClimbingSite(ClimbingSiteSFC climbingSiteSFC, Map<String, SiteRoutesSFC> siteRoutesMap,
			Map<String, List<RoutePitchSFC>> routePitchsMap);

	/**
	 * 
	 * @param id
	 * Delete by id a ClimbingSite object and only this kind of object 
	 */
	public void climbingSiteDelete(Integer id);
	
	public List<RoutePitchDTO> sortedRoutePitchsDTOList(String key, Map<String, List<RoutePitchSFC>> routePitchsMap);

	public List<RoutePitchSFC> sortedRoutePitchsSFCList(String key, Map<String, List<RoutePitchSFC>> routePitchsMap);

	public ClimbingSiteSFC getClimbingSiteSFCByID(Integer id);

	public Map<String, SiteRoutesSFC> getSiteRouteMapByClimbingSiteId(Integer id);

	public Map<String, List<RoutePitchSFC>> getRoutePitchsMapByClimbingSiteId(Integer id);

}
