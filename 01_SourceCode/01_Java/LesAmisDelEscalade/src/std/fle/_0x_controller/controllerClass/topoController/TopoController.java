package std.fle._0x_controller.controllerClass.topoController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import std.fle._00_general.SessionVariables;
import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;
import std.fle._07_service.climbingTopoService.TopoService;
import std.fle._0x_controller.modelManagement.topoModelManagement.TopoModelManagement;

@Controller
public class TopoController {

	@Autowired
	TopoModelManagement topoModelManager;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	SelectInputForController selectFieldManager;
	
	@Autowired
	TopoService topoService;
	
	private SessionVariables sessVar = new SessionVariables();

	@GetMapping("05_topo/createNewTopoForm")
	public ModelAndView displayCreateTopoForm(ModelAndView model,
			@ModelAttribute(name = "createTopo") ClimbingTopoSFC climbingTopoSFC) {
		return topoModelManager.manageDisplayCreateNewTopoForm(model, climbingTopoSFC);
	}

	@PostMapping("05_topo/createNewTopo")
	public ModelAndView createNewTopo(ModelAndView model,
			@ModelAttribute(name = "createTopo") @Validated ClimbingTopoSFC climbingTopoSFC,BindingResult results) {
		if(results.hasErrors()) {
			System.out.println(results.getFieldErrors());
			model.setViewName("05_topo/createNewTopoForm");
			selectFieldManager.selectListAndValueOnBindingError(climbingTopoSFC, model);
			return model;
		}
		sessVar.setRequest(request);
		topoService.saveNewTopo(climbingTopoSFC,sessVar.getAccountID());
		return new ModelAndView("redirect:/05_topo/createNewTopoForm");
	}

}
