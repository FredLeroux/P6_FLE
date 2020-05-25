package std.fle._03_sfc.climbingSiteSFC;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.annotations.HiddenPath;
import fle.toolBox.springFormManager.annotations.SpringFormSettings;


@SpringFormSettings(
		action = "pitchs/createRoute",
		method = "post",
		modelAttribute = "route",
		name = "routeFormular",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		submitButtonAlignmentPropertyKey = "userFormBtn.align",
		submitButtonMessagePropertyKey = "userFormBtn.message.createRoute",
		jspFilePath = "createNewSiteRouteForm.path",
		labelMessageSourceSuffix = "userForm.label",
		readOnly = false)
@SpringFormSettings(
		action = "routeModification",
		method = "post",
		modelAttribute = "editRoute",
		name = "editRouteFormular",
		propertiesFilePath = "configuration/springFormSettings/formSettings.xml",
		submitButtonAlignmentPropertyKey = "userFormBtn.align",
		submitButtonMessagePropertyKey = "userFormBtn.message.editRoute",
		jspFilePath = "editSiteRouteForm.path",
		labelMessageSourceSuffix = "userForm.label",
		readOnly = false)
@Validated
public class SiteRoutesSFC extends SFC {

	@HiddenPath
	private Integer id;

	@NotEmpty
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((routeName == null) ? 0 : routeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SiteRoutesSFC other = (SiteRoutesSFC) obj;
		if (routeName == null) {
			if (other.routeName != null)
				return false;
		} else if (!routeName.equals(other.routeName))
			return false;
		return true;
	}
	

}
