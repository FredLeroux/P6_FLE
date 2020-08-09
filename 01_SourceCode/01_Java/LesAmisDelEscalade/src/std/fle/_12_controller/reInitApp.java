package std.fle._12_controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class reInitApp {

	@GetMapping(value = "/reInitialisation")
	public  void Reinit(HttpServletRequest request) {
		System.out.println("yop");
		//return "go";
	}



}
