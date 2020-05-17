package std.fle._06_dao.climbingSiteDao;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import std.fle._02_dto.modelsDTO.climbingSiteDTO.ClimbingSiteDTO;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.RoutePitchDTO;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.SiteRoutesDTO;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;

@Transactional
public interface ClimbingSiteDAO {

	public void saveClimbingSite(ClimbingSiteSFC climbingSiteSFC, Map<String, SiteRoutesSFC> siteRoutesMap,
			Map<String, List<RoutePitchSFC>> routePitchsMap);

	public List<RoutePitchDTO> sortedRoutePitchsDTOList(String key, Map<String, List<RoutePitchSFC>> routePitchsMap);

	public List<RoutePitchSFC> sortedRoutePitchsSFCList(String key, Map<String, List<RoutePitchSFC>> routePitchsMap);

}
