package std.fle._05_controller._01_HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

	
	
	@RequestMapping("/home")
	public ModelAndView homeDisplay() {
		return new ModelAndView ("01_home/index");
		
	}
}
