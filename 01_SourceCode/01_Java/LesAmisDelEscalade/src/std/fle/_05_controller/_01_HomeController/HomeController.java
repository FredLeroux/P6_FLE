package std.fle._05_controller._01_HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

	
	
	@RequestMapping("/home")
	public ModelAndView homeDisplay(ModelAndView model) {
		model.setViewName("01_home/index");
		model.addObject("connexionHref", "menuNavBarConnexion.href");
		model.addObject("connexionName", "menuNavBarConnexion.nameToManagInFilterhandler");
		model.addObject("iFrameSource", "'test/iframeTest.html'");
		
		return model;
		
	}
}
