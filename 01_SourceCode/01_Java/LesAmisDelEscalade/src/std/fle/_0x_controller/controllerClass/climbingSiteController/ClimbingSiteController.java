package std.fle._0x_controller.controllerClass.climbingSiteController;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.JSPString;
import fle.toolBox.modelConverter.ModelConverter;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.ClimbingSiteDTO;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.RoutePitchDTO;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.SiteRoutesDTO;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;
import std.fle._03_sfc.climbingSiteSFC.associatedClimbingSiteSFC.RoutePitchClimbingLvlSFC;

@Controller
public class ClimbingSiteController {
	
	@Autowired
	SelectInputForController selectService;

	private final String siteRouteModifLink = "correctSiteRouteName";
	private Map<String, SiteRoutesSFC> siteRoutesMap = new LinkedHashMap<>();
	private Map<String, LinkedHashSet<RoutePitchClimbingLvlSFC>> routePitchsMap = new LinkedHashMap<>();
	private ModelConverter converter = new ModelConverter();
	private ClimbingSiteDTO climbingSiteDTO = new ClimbingSiteDTO();
	private SiteRoutesDTO siteroutesDto = new SiteRoutesDTO();
	private RoutePitchDTO routePitchDTO = new RoutePitchDTO();
	private String siteName = null;
	private String routeName = null;
	

	@GetMapping("06_climbingSite/createNewSiteForm")
	public ModelAndView displaySiteFullInfoForm(ModelAndView model,
			@ModelAttribute(name = "siteFullInfo") ClimbingSiteSFC climbingSiteSFC) {
		model.setViewName("06_climbingSite/createNewSiteForm");
		model.addObject("siteRoutesController", JSPString.parse("addSiteRoutes"));
		return model;
	}

	@PostMapping("06_climbingSite/addSiteRoutes")
	public ModelAndView setClimbingSiteDto(ModelAndView model, ClimbingSiteSFC climbingSiteSFC) {
		climbingSiteDTO = converter.converSFCToDTO(climbingSiteSFC, climbingSiteDTO);
		siteName = climbingSiteSFC.getClimbingSiteName();		
		model.setViewName("redirect:displaySiteRoutesList");
		return model;
	}

	@GetMapping("06_climbingSite/displaySiteRoutesList")
	public ModelAndView displaySiteRoutesList(ModelAndView model, ClimbingSiteSFC climbingSiteSFC,
			@ModelAttribute(name = "route") SiteRoutesSFC sfc) {
		model.setViewName("06_climbingSite/siteRoutesForm");
		model.addObject("siteName",siteName);
		model.addObject("siteRoutesList", siteRoutesMap);
		model.addObject("siteRouteModifLink", siteRouteModifLink);
		return model;
	}
	
	@PostMapping("06_climbingSite/createRoute")
	public ModelAndView createRoute(ModelAndView model, ClimbingSiteSFC climbingSiteSFC, SiteRoutesSFC sfc) {
		if(siteRoutesMap.containsKey(sfc.getRouteName())) {
			model.setViewName("redirect:displaySiteRoutesList");
			return model;
		}
		routeName=sfc.getRouteName();
		siteRoutesMap.put(routeName, sfc);		
		return new ModelAndView("redirect:displayRoutePitchForm");
	}

	@GetMapping("06_climbingSite/displayRoutePitchForm")
	public ModelAndView displayRoutePitchForm(ModelAndView model,
			@ModelAttribute(name = "routePitch") RoutePitchClimbingLvlSFC routePitchClimbingLvlSFC) {
		model.setViewName("06_climbingSite/routePitchForm");
		model.addObject("siteName",siteName);
		model.addObject("routeName",routeName);
		model.addObject("routePitchList",routePitchsMap);
		selectService.addSelectListsAndValues(routePitchClimbingLvlSFC, model);
		return model;
	}
	
	@PostMapping("06_climbingSite/createRoutePitch")
	public ModelAndView createRoutePitch(ModelAndView model,RoutePitchClimbingLvlSFC routePitchClimbingLvlSFC) {
		LinkedHashSet<RoutePitchClimbingLvlSFC> routePitchList = new LinkedHashSet<>();		
		if(!routePitchsMap.containsKey(routeName)) {
			routePitchList.add(routePitchClimbingLvlSFC);
			routePitchsMap.put(routeName,routePitchList);
		}else {
			routePitchsMap.get(routeName).add(routePitchClimbingLvlSFC);			
		}		
		return new ModelAndView("redirect:displayRoutePitchForm");
	}
	
	

}
