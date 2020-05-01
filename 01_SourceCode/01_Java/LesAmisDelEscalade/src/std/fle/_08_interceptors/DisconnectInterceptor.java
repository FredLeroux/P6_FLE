package std.fle._08_interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.Internationalization.LocalMessage;
import std.fle._05_controller.SessionVariables;

public class DisconnectInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	LocalMessage local;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SessionVariables sessVar = new SessionVariables(request);
		sessVar.clearSession();
		response.sendRedirect("index.html");
		return false;
	}

}
