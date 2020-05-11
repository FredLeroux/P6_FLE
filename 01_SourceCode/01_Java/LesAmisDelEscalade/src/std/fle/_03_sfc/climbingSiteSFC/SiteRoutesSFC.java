package std.fle._03_sfc.climbingSiteSFC;

import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;
import fle.toolBox.springFormManager.annotations.entityModelAssociation.EntityModelAssociation;


@SpringFormSettings(
		action = "createRoute",
		method = "post",
		modelAttribute = "route",
		name = "routeFormular",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		submitButtonAlignmentPropertyKey = "userFormBtn.align",
		submitButtonMessagePropertyKey = "userFormBtn.message.createRoute",
		jspFilePath = "createNewSiteRouteForm.path",
		labelMessageSourceSuffix = "userForm.label",
		readOnly = false)
@Validated
public class SiteRoutesSFC extends SFC {

	@HiddenPath
	private Integer id;

	private String routeName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	

}
