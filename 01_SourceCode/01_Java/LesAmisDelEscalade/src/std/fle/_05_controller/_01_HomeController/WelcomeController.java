package std.fle._05_controller._01_HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class WelcomeController {
	

	@GetMapping(value = "/01_home/01_01_welcomePage/welcomePage")
	public ModelAndView iframe() {
		return new ModelAndView("/01_home/01_01_welcomePage/welcomePage");
		
	}

}
