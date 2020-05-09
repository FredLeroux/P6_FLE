package std.fle._0x_controller.modelManagement.topoModelManagement;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;

public interface TopoModelManagement {
	
	public ModelAndView manageDisplayCreateNewTopoForm(ModelAndView model,ClimbingTopoSFC climbingTopoSFC);
	
	public ModelAndView manageCreateNewTopo(ModelAndView model,ClimbingTopoSFC climbingTopoSFC, BindingResult results);

}
