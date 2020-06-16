package std.fle._0x_controller.modelManagement.topoModelManagement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import std.fle._03_sfc.topoSFC.ClimbingTopoDisplaySFC;
import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;

public interface TopoModelManagement {

	public ModelAndView manageDisplayCreateNewTopoForm(ModelAndView model, ClimbingTopoSFC climbingTopoSFC);

	public ModelAndView manageCreateNewTopo(ModelAndView model, ClimbingTopoSFC climbingTopoSFC,String modelAttributeName, BindingResult results);

	public ModelAndView manageRedirectToUpdateForm(Integer id);

	public ModelAndView manageDisplayClimbingTopo(ModelAndView model, String modelAttributeName,
			ClimbingTopoSFC climbingTopoSFC);

	public ModelAndView manageUpdateTopo(ModelAndView model, ClimbingTopoSFC climbingTopoSFC,String modelAttributeName, BindingResult results);

	public ModelAndView manageAccessToTopoLending(Integer id);

	public ModelAndView manageDisplayTopoDetails(ModelAndView model, String modelAttributeName, Integer id);

	public ModelAndView manageBorrowThisTopo(ClimbingTopoDisplaySFC climbingTopoDisplaySFC, HttpServletRequest request);

	public ModelAndView manageBorrowDemandsList(ModelAndView model);

	public ModelAndView manageBorrowDemand(ModelAndView model, String redirectTo);
	
	public ModelAndView manageDeleteTopo();

}
