package std.fle._12_controller.controllerClass.errorhandler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.logger.Log4J2;

@ControllerAdvice
public class ErrorHandler {

	private Log4J2<ErrorHandler> logger = new Log4J2<ErrorHandler>(this);

	@ExceptionHandler(Exception.class)
	public ModelAndView error500(Exception e, HttpServletRequest request) {
		StringBuilder errorMessage = new StringBuilder();
		errorMessage.append("Internal error : " + e.getClass().getSimpleName()+"\n");
		errorMessage.append("URL : " + request.getAttribute("javax.servlet.forward.request_uri")+"\n");
		errorMessage.append("STATUS_CODE : 500"+"\n");
		errorMessage.append("Stack_Trace :"+"\n");
		if (stackTraceFilter(e.getStackTrace()).size() == 0) {
			errorMessage.append(e.getStackTrace());
		} else {
			errorMessage.append(stackTraceFilter(e.getStackTrace()));
		}
		logger.log().warn(errorMessage.toString());
		return new ModelAndView("redirect:/internalError");
	}

	private ArrayList<String> stackTraceFilter(StackTraceElement[] stackTrace) {
		ArrayList<String> stackTraceClean = new ArrayList<>();
		for (StackTraceElement trace : stackTrace) {
			if (trace.toString().contains("std.fle") || trace.toString().contains("fle.toolBox")) {
				stackTraceClean.add(trace.toString() + "\n");
			}
		}
		return stackTraceClean;
	}

}