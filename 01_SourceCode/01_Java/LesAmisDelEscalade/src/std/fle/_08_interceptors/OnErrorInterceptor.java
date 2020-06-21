package std.fle._08_interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.Internationalization.LocalMessage;
import std.fle._00_general.SessionVariables;
import std.fle._08_interceptors.appInitiators.InitiateAppInterceptor;

public class OnErrorInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	LocalMessage local;
	
	private InitiateAppInterceptor initiateAppInterceptor = new InitiateAppInterceptor();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {	
		
		SessionVariables sessVar = new SessionVariables(request);
		if(sessVar.getIsAppInitiated()) {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++here");
			response.sendRedirect("internalError");			
			return false;
			
		}else {
			initiateAppInterceptor.initiateApp(request, local);			
			return true;}	
		
	}

}
