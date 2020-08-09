package std.fle._08_interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import std.fle._00_general.SessionVariables;

public class SiteAcces extends HandlerInterceptorAdapter {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SessionVariables sessVar = new SessionVariables(request);
		if(sessVar.getPseudo() == null) {
			response.sendRedirect(request.getContextPath());
			return false;
		}else {
			return true;
		}

	}

}
