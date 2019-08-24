package test.testconnexiondb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestConnexionDbController {

	
	@RequestMapping(value = "/testconnexiondb", method =RequestMethod.POST)
	public ModelAndView testConnexionDbDisplay(@ModelAttribute(value ="TestConnexionDb") TestConnexionDb test) {
	return new ModelAndView("/test/testConnexionDb");	
	}
}
