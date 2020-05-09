package std.fle._0x_controller.modelManagement.topoModelManagement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.FredParser;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import std.fle._00_general.SessionVariables;
import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;
import std.fle._06_dao.topoDao.TopoDAO;
import std.fle._07_service.climbingTopoService.TopoService;

@Service
public class TopoModelManagementImplemented implements TopoModelManagement{
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	SelectInputForController selectFieldManager;
	
	@Autowired
	TopoService topoService;
	
	private SessionVariables sessVar = new SessionVariables();
	
	@Override
	public ModelAndView manageDisplayCreateNewTopoForm(ModelAndView model,ClimbingTopoSFC climbingTopoSFC) {
		sessVar.setRequest(request);
		model.setViewName("05_topo/createNewTopoForm");		
		selectFieldManager.addSelectListsAndValues(climbingTopoSFC, model);
		return model;
	}
	
	@Override
	public ModelAndView manageCreateNewTopo(ModelAndView model,ClimbingTopoSFC climbingTopoSFC, BindingResult results) {
		if(results.hasErrors()) {
			model.setViewName("05_topo/createNewTopoForm");
			selectFieldManager.selectListAndValueOnBindingError(climbingTopoSFC, model);
			return model;
		}
		sessVar.setRequest(request);
		topoService.saveNewTopo(climbingTopoSFC,sessVar.getAccountID());
		return new ModelAndView("redirect:/05_topo/createNewTopoForm");
			
	}

}
