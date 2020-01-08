package std.fle._05_controller._01_HomeController;

import java.util.LinkedHashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.filesManagement.PropertiesToHashMap;
import fle.toolBox.filesManagement.PropertyFile;
import std.fle.Config;

@Controller
public class HomeController {
	@Autowired
	ServletContext context;

	PropertyFile config = new PropertyFile();

	@RequestMapping("/home")
	public ModelAndView homeDisplay(ModelAndView model) {
		model.setViewName("01_home/index");				
		model.addAllObjects(Config.jspCompomentsPath(context));		
		model.addObject("connexionHref", "menuNavBarConnexion.href");
		model.addObject("connexionName", "menuNavBarConnexion.nameToManagInFilterhandler");
		model.addObject("iFrameSource", "'test/iframeTest.html'");

		return model;

	}
}
