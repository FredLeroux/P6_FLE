package std.fle._0x_controller.controllerClass.homeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Reinit {
	
	
	@GetMapping(value="/reInit")
	public ModelAndView reInit() {
		return new ModelAndView("redirect:/index.html");
	}

}
