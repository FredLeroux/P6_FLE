package std.fle._06_dao.climbingSiteDao.siteMapping;

import java.util.ArrayList;
import java.util.List;

import std.fle._02_dto.assetsClassesDTO.ClimbingLevelsDTO;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.RoutePitchDTO;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;

public abstract class RoutePitchMapping extends SiteRoutesMapping {
	
	private RoutePitchDTO routePitchDTO = new RoutePitchDTO();
	private RoutePitchSFC routePitchSFC = new RoutePitchSFC();
	
	
	
	
	
	
	
	
	
	
	
	
	private List<RoutePitchDTO> convertListRoutePitchSFCToListDTO(List<RoutePitchSFC> routePitchSFCSet,ClimbingLevelsDTO climbingLevelsDTO) {
		List<RoutePitchDTO> list = new ArrayList<>();
		routePitchSFCSet.forEach(o -> list.add(routePitchDTOSetted(o,climbingLevelsDTO)));
		return list;
	}

	private RoutePitchDTO routePitchDTOSetted(RoutePitchSFC routePitchSFC,ClimbingLevelsDTO climbingLevelsDTO) {
		RoutePitchDTO dto = convertRoutePitchSFCToDTO(routePitchSFC);
		dto.setClimbingLevels(climbingLevelsDTO);
		return dto;
	}
	
	private RoutePitchDTO convertRoutePitchSFCToDTO(RoutePitchSFC routePitchSFC) {
		return converter.convertSFCToDTO(routePitchSFC, routePitchDTO);
	}
	
	
	

}
