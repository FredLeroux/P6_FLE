package std.fle._0x_controller.modelManagement.topoModelManagement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.FredParser;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import std.fle._00_general.SessionVariables;
import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;
import std.fle._06_dao.topoDao.TopoDAO;

@Service
public class TopoModelManagementImplemented implements TopoModelMangement{
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	SelectInputForController selectFieldManager;
	
	@Autowired
	TopoDAO topoDao;
	
	private SessionVariables sessVar = new SessionVariables();
	
	@Override
	public ModelAndView manageDisplayCreateNewTopoForm(ModelAndView model,ClimbingTopoSFC climbingTopoSFC) {
		sessVar.setRequest(request);
		model.setViewName("05_topo/createNewTopoForm");
		System.out.println("topoControllerManager");
		topoDao.saveNewTopo(climbingTopoSFC,sessVar.getAccountID());
		selectFieldManager.addSelectListsAndValues(climbingTopoSFC, model);
		return model;
	}

}
