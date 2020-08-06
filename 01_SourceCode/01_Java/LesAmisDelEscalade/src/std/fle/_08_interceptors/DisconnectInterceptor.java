package std.fle._08_interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.Internationalization.LocalMessage;
import std.fle._00_general.SessionVariables;
import std.fle._08_interceptors.appInitiators.InitiateAppInterceptor;

public class DisconnectInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	LocalMessage local;
	private InitiateAppInterceptor initiateAppInterceptor = new InitiateAppInterceptor();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SessionVariables sessVar = new SessionVariables(request);
		sessVar.clearSession();
		if(!disconnectAfterAccountSupression(request)) {
			response.sendRedirect("index.html");
		}else {
			initiateAppInterceptor.initiateApp(request,local);
			response.sendRedirect("03_messagesPages/reload");
		}

		return false;
	}

	private boolean disconnectAfterAccountSupression(HttpServletRequest request) {
		if(request.getParameter("deletion")!= null) {
				return true;
		}else {
			return false;
		}


	}

}
