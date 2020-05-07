package std.fle._0x_controller.modelManagement.topoModelManagement;

import org.springframework.web.servlet.ModelAndView;

import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;

public interface TopoModelMangement {
	
	public ModelAndView manageDisplayCreateNewTopoForm(ModelAndView model,ClimbingTopoSFC climbingTopoSFC);

}
