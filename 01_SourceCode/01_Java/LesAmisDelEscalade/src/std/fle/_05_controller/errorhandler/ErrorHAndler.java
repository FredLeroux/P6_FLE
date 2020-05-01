package std.fle._05_controller.errorhandler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import std.fle._05_controller.SessionVariables;

@ControllerAdvice
public class ErrorHAndler {
	
	
	//@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ModelAndView error500(Exception e,HttpServletRequest request) {		
		SessionVariables sessVar = new SessionVariables(request);
		if(sessVar.getIsAppInitiated()) {
			System.out.println("Internal  "+ e.getClass().getSimpleName());
			System.out.println(stackTraceFilter(e.getStackTrace()));			
			return new ModelAndView("redirect:/error");
		}else {
			System.out.println("Tentative acces without app initiated" +"   "+e.getClass().getSimpleName());
			System.out.println(stackTraceFilter(e.getStackTrace()));
			return new ModelAndView("redirect:/error");
		}
	}


private ArrayList<String> stackTraceFilter(StackTraceElement[] stackTrace) {
	ArrayList<String> stackTraceClean = new ArrayList<>();
	for(StackTraceElement trace : stackTrace) {
		if(trace.toString().contains("std.fle")|| trace.toString().contains("fle.toolBox")) {
			stackTraceClean.add(trace.toString()+"\n");
		}
	}
	return stackTraceClean;
}



}