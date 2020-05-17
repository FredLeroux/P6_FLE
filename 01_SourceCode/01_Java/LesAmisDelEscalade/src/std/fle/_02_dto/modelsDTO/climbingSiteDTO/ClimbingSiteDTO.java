package std.fle._02_dto.modelsDTO.climbingSiteDTO;

import java.util.List;

import fle.toolBox.classType.DTO;
import std.fle._02_dto.assetsClassesDTO.CountiesDTO;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;

public class ClimbingSiteDTO extends DTO {

	private Integer id;

	private String climbingSiteName;

	private String siteDescription;

	private Integer altitude;

	private Integer heightMin;

	private Integer heightMax;

	private Integer numberOfRoutes;

	private String accessToSite;

	private StatesDTO state;

	private CountiesDTO county;
	
	private Boolean official;

	private List<SiteRoutesDTO> sitesRoutes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClimbingSiteName() {
		return climbingSiteName;
	}

	public void setClimbingSiteName(String climbingSiteName) {
		this.climbingSiteName = climbingSiteName;
	}

	public String getSiteDescription() {
		return siteDescription;
	}

	public void setSiteDescription(String siteDescription) {
		this.siteDescription = siteDescription;
	}

	public Integer getAltitude() {
		return altitude;
	}

	public void setAltitude(Integer altitude) {
		this.altitude = altitude;
	}

	public Integer getHeightMin() {
		return heightMin;
	}

	public void setHeightMin(Integer heightMin) {
		this.heightMin = heightMin;
	}

	public Integer getHeightMax() {
		return heightMax;
	}

	public void setHeightMax(Integer heightMax) {
		this.heightMax = heightMax;
	}

	public Integer getNumberOfRoutes() {
		return numberOfRoutes;
	}

	public void setNumberOfRoutes(Integer numberOfRoutes) {
		this.numberOfRoutes = numberOfRoutes;
	}

	public String getAccessToSite() {
		return accessToSite;
	}

	public void setAccessToSite(String accessToSite) {
		this.accessToSite = accessToSite;
	}

	public StatesDTO getState() {
		return state;
	}

	public void setState(StatesDTO state) {
		this.state = state;
	}

	public CountiesDTO getCounty() {
		return county;
	}

	public void setCounty(CountiesDTO county) {
		this.county = county;
	}

	public List<SiteRoutesDTO> getSitesRoutes() {
		return sitesRoutes;
	}

	public void setSitesRoutes(List<SiteRoutesDTO> sitesRoutes) {
		this.sitesRoutes = sitesRoutes;
	}

	public Boolean getOfficial() {
		return official;
	}

	public void setOfficial(Boolean official) {
		this.official = official;
	}
	
	

	

}
