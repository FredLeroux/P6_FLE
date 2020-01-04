package std.fle._05_controller._01_HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	
	
	@RequestMapping("/home")
	public String homeDisplay() {
		return "/01_home/index";
		
	}
}
