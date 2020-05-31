package std.fle._0x_controller.controllerClass.climbingSiteController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.FredParser;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteDisplaySFC;
import std.fle._0x_controller.modelManagement.climbingSiteModelManagement.ClimbingSiteModelManagement;
import std.fle._0x_controller.modelManagement.climbingSiteModelManagement.ClimbingSiteModelMgntAndControllerVar;
import std.fle._0x_controller.modelManagement.climbingSiteModelManagement.RoutesAndPitchsPage;

@Controller
public class ClimbingSiteShowerController extends ClimbingSiteModelMgntAndControllerVar {
	
	@Autowired
	private ClimbingSiteModelManagement manager; 
	
	
	
	@GetMapping(value = "/04_listPage/climbingSiteDetails/{id}")
	public ModelAndView displayFormVarInit (ModelAndView model,@PathVariable Integer id) {
		return manager.displayFormVarInit(model,id, "06_climbingSite/climbingSiteDetailsDisplay");
		
	}
		
	
	@GetMapping(value = "06_climbingSite/climbingSiteDetailsDisplay")
	public ModelAndView displayClimBingSiteDetails(ModelAndView model,
			@ModelAttribute(name = "siteInfoDisplay") ClimbingSiteDisplaySFC climbingSiteDisplaySFC) {
		return manager.manageDisplayClimBingSiteDetails(model);
	}
	
	@PostMapping(value ="06_climbingSite/postComment")
	public ModelAndView postComment(ModelAndView model) {		
		return manager.managePostComment("comment");
	}
	
	
	@GetMapping(value = "06_climbingSite/RoutesAndPitchsListPage")
	public  @ResponseBody String testSendReceived(HttpServletRequest request) {	
		JSONObject object = new JSONObject();
		Integer currentPage = FredParser.toInteger(request.getParameter("page"));
		String to = request.getParameter("to");
		Integer pageToDisplay = null;
		if(to.equals("next")) {
			pageToDisplay = currentPage+1;
		}else {
			pageToDisplay = currentPage-1;
		}	
		object.put("list", manager.getPageAsJSONArray(pageToDisplay));
		object.put("page", pageToDisplay);
		System.out.println("Pas ROGER NOOON");
		return object.toString();
	}
	

}
