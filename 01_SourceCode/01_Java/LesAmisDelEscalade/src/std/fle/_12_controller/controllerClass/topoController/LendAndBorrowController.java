package std.fle._12_controller.controllerClass.topoController;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import std.fle._12_controller.modelManagement.topoModelManagement.TopoModelManagement;



@Controller
public class LendAndBorrowController {
	
	@Autowired
	TopoModelManagement manager;
	
	
	@GetMapping(value = "05_topo/borrowDemandsList")
	public ModelAndView displayBorroDemandsList(ModelAndView model) {
		return manager.manageBorrowDemandsList(model);		
	}
	
	@GetMapping(value = "05_topo/borrowDemand")
	public ModelAndView seeDemand(ModelAndView model) {
		return manager.manageBorrowDemand(model, "05_topo/borrowDemandsList");		
	}
	
	@GetMapping(value = "05_topo/borrowDemandAccepted")
	public ModelAndView acceptDemand(ModelAndView model) {
		return manager.manageDemandeAccepted(model,"05_topo/borrowDemandsList");		
	}
	
	@GetMapping(value = "05_topo/borrowDemandRejected")
	public ModelAndView rejectedDemand(ModelAndView model) {
		return manager.manageDemandeRejected(model,"05_topo/borrowDemandsList");		
	}
	
	@GetMapping(value = "05_topo/updateBorrow")
	public  @ResponseBody String testSendReceived(HttpServletRequest request) {	
		JSONObject object = new JSONObject();
		object.put("numberOfWaitingDemand", manager.numberOfWaitingBorrowDemand());//
		return object.toString();
	}
	
	
	
	
}
