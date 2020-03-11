package std.fle._05_controller._01_HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@GetMapping(value = "/test/iframeTest")
	public ModelAndView iframe() {
		return new ModelAndView("test/iframeTest");
		
	}
	
}