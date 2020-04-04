package std.fle._08_filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.Internationalization.LocalMessage;
import std.fle._05_controller.SessionVariables;
import std.fle._0X_security.SecurityLevel;

public class Opening extends HandlerInterceptorAdapter {
	
	@Autowired
	LocalMessage local;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SessionVariables sessVar = new SessionVariables(request);
		
		if(!sessVar.getLogged()) {
			sessVar.setLogged(false);
			sessVar.setSecurityLevel(SecurityLevel.VISITOR.rank());
			sessVar.setConnexion(local.message("connexion.name"));
			sessVar.setPseudo(local.message("visitor.name"));
		}
		return true;
	}

}
