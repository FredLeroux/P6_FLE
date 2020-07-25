package std.fle._07_service.climbingSiteService;

import java.util.List;
import java.util.Map;

import std.fle._02_dto.modelsDTO.climbingSiteDTO.ClimbingSiteDTO;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.RoutePitchDTO;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteDisplaySFC;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;

public interface ClinbingSiteService {


	public void saveClimbingSite(ClimbingSiteSFC climbingSiteSFC, Map<String, SiteRoutesSFC> siteRoutesMap,
			Map<String, List<RoutePitchSFC>> routePitchsMap);

	public void updateClimbingSite(ClimbingSiteSFC climbingSiteSFC, Map<String, SiteRoutesSFC> siteRoutesMap,
			Map<String, List<RoutePitchSFC>> routePitchsMap);

	public ClimbingSiteDisplaySFC getClimbingSiteDisplaySFCById(Integer id);

	/**
	 * 
	 * @param id Delete by id a ClimbingSite object and only this kind of object
	 */
	public void climbingSiteDelete(Integer id);

	public List<RoutePitchDTO> sortedRoutePitchsDTOList(String key, Map<String, List<RoutePitchSFC>> routePitchsMap);

	public List<RoutePitchSFC> sortedRoutePitchsSFCWithCotationLevelAsString(String key,
			Map<String, List<RoutePitchSFC>> routePitchsMap);

	public List<RoutePitchSFC> sortedRoutePitchsSFCWithCotationLevelAsString(List<RoutePitchSFC> list);

	public List<RoutePitchSFC> sortedRoutePitchsSFCList(String key, Map<String, List<RoutePitchSFC>> routePitchsMap);

	public ClimbingSiteDTO getClimbingSiteDTOById(Integer id);

	public ClimbingSiteSFC getClimbingSiteSFCByID(Integer id);

	public Map<String, SiteRoutesSFC> getSiteRouteMapByClimbingSiteId(Integer id);

	public Map<String, List<RoutePitchSFC>> getRoutePitchsMapByClimbingSiteId(Integer id);

}
