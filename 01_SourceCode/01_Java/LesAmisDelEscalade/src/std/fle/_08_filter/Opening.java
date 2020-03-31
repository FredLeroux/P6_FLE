package std.fle._08_filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.Internationalization.LocalMessage;
import std.fle._00_general.AppVariables;
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
			System.out.println("initiate");
			sessVar.setLogged(false);
			sessVar.setSecurityLevel(SecurityLevel.VISITOR.rank());
			sessVar.setConnexion(local.message("connexion.name"));
		}
		return true;
	}

}
