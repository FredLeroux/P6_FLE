package std.fle._06_dao.climbingSiteDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.FredParser;
import fle.toolBox.CRUD.dao.DAOGenericInterface;
import fle.toolBox.localeKeyToBoolean.StringToBoolean;
import std.fle._01_entity.models.site.ClimbingSite;
import std.fle._01_entity.models.site.RoutePitch;
import std.fle._01_entity.models.site.SiteRoutes;
import std.fle._02_dto.assetsClassesDTO.ClimbingLevelsDTO;
import std.fle._02_dto.assetsClassesDTO.CountiesDTO;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.ClimbingSiteDTO;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.RoutePitchDTO;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.SiteRoutesDTO;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;
import std.fle._06_dao._06_01_daoInterface._06_01_01_assetsDao.ClimbingLevelsDAO;
import std.fle._06_dao._06_01_daoInterface._06_01_01_assetsDao.CountiesDao;
import std.fle._06_dao.statesDao.StatesDAO;

@Repository
public class ClimbingSiteDAOImplemented implements ClimbingSiteDAO {

	@Autowired
	DAOGenericInterface<ClimbingSite, ClimbingSiteDTO> dao;
	
	@Autowired
	DAOGenericInterface<SiteRoutes, SiteRoutesDTO> daoRoute;
	
	@Autowired
	StringToBoolean stringToBoolean;

	@Autowired
	StatesDAO statesDao;

	@Autowired
	CountiesDao countiesDao;

	@Autowired
	ClimbingLevelsDAO climbingLevelDao;

	private ClimbingSite climbingSite = new ClimbingSite();
	private SiteRoutes siteRoutes = new SiteRoutes();
	private RoutePitch routePitch = new RoutePitch();
	private ClimbingSiteDTO climbingSiteDTO = new ClimbingSiteDTO();
	private SiteRoutesDTO siteRoutesDTO = new SiteRoutesDTO();
	private RoutePitchDTO routePitchDTO = new RoutePitchDTO();
	private ClimbingSiteSFC climbingSiteSFC = new ClimbingSiteSFC();
	private SiteRoutesSFC siteRoutesSFC = new SiteRoutesSFC();
	private RoutePitchSFC routePitchSFC = new RoutePitchSFC();

	@Override
	public void saveClimbingSite(ClimbingSiteSFC climbingSiteSFC, Map<String, SiteRoutesSFC> siteRoutesMap,
			Map<String, List<RoutePitchSFC>> routePitchsMap) {
		ClimbingSiteDTO dto = climbingSiteDTOSetted(climbingSiteSFC, siteRoutesMap, routePitchsMap);
		dao.saveDTO(climbingSite, dto);
		
	}
	
	
	@Override
	public List<RoutePitchDTO> sortedRoutePitchsDTOList(String key,
			Map<String, List<RoutePitchSFC>> routePitchsMap){
		List<RoutePitchDTO> list = convertListRoutePitchSFCToListDTO(sortedRoutePitchsSFCList(key, routePitchsMap));			
		return list;
	}
	
	@Override
	public List<RoutePitchSFC> sortedRoutePitchsSFCList(String key,Map<String, List<RoutePitchSFC>> routePitchsMap){
		List<RoutePitchSFC> list =  routePitchsMap.get(key);
		Collections.sort(list,(o1,o2)->o1.getPitchNumber().compareTo(o2.getPitchNumber()));
		return list;
	}
	
	
	private Map<String, List<RoutePitchDTO>> convertToRoutePitchsDTOMap(String key,
			Map<String, List<RoutePitchSFC>> routePitchsMap) {
		Map<String, List<RoutePitchDTO>> map = new LinkedHashMap<>();
		List<RoutePitchDTO> list = convertListRoutePitchSFCToListDTO(routePitchsMap.get(key));
		map.put(key, list);
		return map;
	}
	

	private ClimbingSiteDTO climbingSiteDTOSetted(ClimbingSiteSFC climbingSiteSFC,
			Map<String, SiteRoutesSFC> siteRoutesMap, Map<String, List<RoutePitchSFC>> routePitchsMap) {
		ClimbingSiteDTO dto = convertClimbingSiteSFCToDTO(climbingSiteSFC);
		dto.setSitesRoutes(siteRouteDtoList(dto, siteRoutesMap, routePitchsMap));
		dto.setState(getStatesDTO(climbingSiteSFC.getClimbingSiteStateId()));
		dto.setCounty(getCountiesDTO(climbingSiteSFC.getClimbingSiteCountyId()));
		return dto;
	}

	private List<SiteRoutesDTO> siteRouteDtoList(ClimbingSiteDTO climbingSiteDTO,
			Map<String, SiteRoutesSFC> siteRoutesMap, Map<String, List<RoutePitchSFC>> routePitchsMap) {
		List<SiteRoutesDTO> list = new ArrayList<>();
		siteRoutesDTOMap(siteRoutesMap)
				.forEach((key, value) -> list.add(siteRouteDTOSetted(key, climbingSiteDTO, value, routePitchsMap)));
		return list;
	}

	private SiteRoutesDTO siteRouteDTOSetted(String key, ClimbingSiteDTO climbingSiteDTO,
			SiteRoutesDTO siteRouteDTOToset, Map<String, List<RoutePitchSFC>> routePitchsMap) {
		Map<String, List<RoutePitchDTO>> map = convertToRoutePitchsDTOMap(key, routePitchsMap);
		setClimbingSiteDTOToSiteRoutesDTO(climbingSiteDTO, siteRouteDTOToset);
		setSitesRoutesDTOToRoutePitchDTOList(siteRouteDTOToset, map.get(key));
		setRoutePitchDTOListToSitesRoutesDTO(map.get(key), siteRouteDTOToset);
		return siteRouteDTOToset;
	}

	private void setClimbingSiteDTOToSiteRoutesDTO(ClimbingSiteDTO climbingSiteDTO, SiteRoutesDTO siteRouteDto) {
		siteRouteDto.setClimbingSite(climbingSiteDTO);
	}

	private void setRoutePitchDTOListToSitesRoutesDTO(List<RoutePitchDTO> routePitchDTOList,
			SiteRoutesDTO siteRouteDTO) {
		siteRouteDTO.setRoutePitchs(routePitchDTOList);
	}

	private void setSitesRoutesDTOToRoutePitchDTOList(SiteRoutesDTO siteRouteDTO,
			List<RoutePitchDTO> routePitchDTOList) {
		routePitchDTOList.forEach(o -> o.setSiteRoutesDTO(siteRouteDTO));
	}

	private Map<String, SiteRoutesDTO> siteRoutesDTOMap(Map<String, SiteRoutesSFC> siteRoutesMap) {
		Map<String, SiteRoutesDTO> map = new LinkedHashMap<>();
		siteRoutesMap.forEach((key, value) -> map.put(key, convertSiteRouteSFCToDTO(value)));
		return map;
	}
	

	private List<RoutePitchDTO> convertListRoutePitchSFCToListDTO(
			List<RoutePitchSFC> routePitchSFCSet) {
		List<RoutePitchDTO> list = new ArrayList<>();
		routePitchSFCSet.forEach(o -> list.add(routePitchDTOSetted(o)));
		return list;
	}

	private RoutePitchDTO routePitchDTOSetted(RoutePitchSFC routePitchSFC) {
		RoutePitchDTO dto = convertRoutePitchSFCToDTO(routePitchSFC);
		dto.setClimbingLevelsDTO(getClimbinglevelDTO(routePitchSFC.getPitchClimbingLevels()));
		return dto;
	}

	private ClimbingSiteDTO convertClimbingSiteSFCToDTO(ClimbingSiteSFC climbingSiteSFC) {
		return dao.converter().converSFCToDTO(climbingSiteSFC, climbingSiteDTO);
	}

	private SiteRoutesDTO convertSiteRouteSFCToDTO(SiteRoutesSFC siteRouteSFC) {
		return dao.converter().converSFCToDTO(siteRouteSFC, siteRoutesDTO);
	}

	private RoutePitchDTO convertRoutePitchSFCToDTO(RoutePitchSFC routePitchSFC) {
		return dao.converter().converSFCToDTO(routePitchSFC, routePitchDTO);
	}

	private StatesDTO getStatesDTO(Integer stateId) {
		return statesDao.getDTOByID(stateId);
	}

	private CountiesDTO getCountiesDTO(Integer countyId) {
		return countiesDao.getDTOByID(countyId);
	}

	private ClimbingLevelsDTO getClimbinglevelDTO(String climbingLevelId) {
		return climbingLevelDao.getDTOByID(FredParser.toInteger(climbingLevelId));
	}

}