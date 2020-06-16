package std.fle._0x_controller.controllerClass.topoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import std.fle._0x_controller.modelManagement.topoModelManagement.TopoModelManagement;



@Controller
public class LendAndBorrowController {
	
	@Autowired
	TopoModelManagement manager;
	
	
	@GetMapping(value = "05_topo/borrowDemandsList")
	public ModelAndView displayBorroDemandsList(ModelAndView model) {
		return manager.manageBorrowDemandsList(model);		
	}
	
	@GetMapping(value = "05_topo/borrowDemand")
	public ModelAndView acceptDemand(ModelAndView model) {
		return manager.manageBorrowDemand(model,"05_topo/borrowDemandsList");
	}
	
	
	
	
}
