package std.fle._0x_controller.controllerClass.topoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;
import std.fle._0x_controller.modelManagement.topoModelManagement.TopoModelMangement;

@Controller
public class TopoController {
	
	@Autowired
	TopoModelMangement topoModelManager;
	
	@GetMapping("05_topo/createNewTopoForm")
	public ModelAndView displayCreateTopoForm(ModelAndView model,@ModelAttribute(name = "createTopo") ClimbingTopoSFC climbingTopoSFC) {
		System.out.println("topoController");
		return topoModelManager.manageDisplayCreateNewTopoForm(model, climbingTopoSFC);
	}

}
