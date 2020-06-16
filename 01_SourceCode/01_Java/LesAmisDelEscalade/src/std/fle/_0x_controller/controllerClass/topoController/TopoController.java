package std.fle._0x_controller.controllerClass.topoController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import std.fle._03_sfc.topoSFC.ClimbingTopoDisplaySFC;
import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;
import std.fle._07_service.climbingTopoService.TopoService;
import std.fle._0x_controller.modelManagement.topoModelManagement.TopoModelManagement;

@Controller
public class TopoController {

	@Autowired
	TopoModelManagement manager;

	@Autowired
	HttpServletRequest request;

	@Autowired
	SelectInputForController selectFieldManager;

	@Autowired
	TopoService topoService;

	@GetMapping("05_topo/createNewTopoForm")
	public ModelAndView displayCreateTopoForm(ModelAndView model,
			@ModelAttribute(name = "createTopo") ClimbingTopoSFC climbingTopoSFC) {
		return manager.manageDisplayCreateNewTopoForm(model, climbingTopoSFC);
	}

	@PostMapping("05_topo/createNewTopo")
	public ModelAndView createNewTopo(ModelAndView model,
			@ModelAttribute(name = "createTopo") @Validated ClimbingTopoSFC climbingTopoSFC, BindingResult results) {
		return manager.manageCreateNewTopo(model, climbingTopoSFC,"createTopo", results);
	}

	@GetMapping(value = "04_listPage/editTopo/{id}")
	public ModelAndView redirectUpdateTopoForm(@PathVariable Integer id) {
		return manager.manageRedirectToUpdateForm(id);
	}

	@GetMapping(value = "05_topo/displayUpdateForm")
	public ModelAndView displayUpdateForm(ModelAndView model,
			@ModelAttribute(name = "updateTopo") ClimbingTopoSFC climbingTopoSFC) {
		return manager.manageDisplayClimbingTopo(model, "updateTopo", climbingTopoSFC);
	}

	@PostMapping(value = "05_topo/updateTopo")
	public ModelAndView updateTopo(ModelAndView model,
			@ModelAttribute(name = "updateTopo") @Validated ClimbingTopoSFC climbingTopoSFC, BindingResult results) {
		return manager.manageUpdateTopo(model, climbingTopoSFC,"updateTopo", results);
	}

	@GetMapping(value = "04_listPage/borrowMe/{id}")
	public ModelAndView redirectTopo(@PathVariable Integer id) {
		return manager.manageAccessToTopoLending(id);
	}

	@GetMapping(value = "05_topo/displayTopodetails/{id}")
	public ModelAndView displayTopo(ModelAndView model,
			@ModelAttribute(name = "displayTopo") ClimbingTopoDisplaySFC climbingTopoDisplaySFC,
			@PathVariable Integer id) {
		return manager.manageDisplayTopoDetails(model, "displayTopo", id);
	}

	@PostMapping(value = "05_topo/displayTopodetails/borrowThisTopo")
	public ModelAndView borrowThisTopo(ClimbingTopoDisplaySFC climbingTopoDisplaySFC, HttpServletRequest request) {
		return manager.manageBorrowThisTopo(climbingTopoDisplaySFC, request);
	}
	
	@GetMapping(value = "05_topo/deleteTopo")
	public ModelAndView deleteTopo() {
		return manager.manageDeleteTopo();
	}

}
