package std.fle._08_filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.FredParser;
import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.security.bcrypt.PassWord;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoAuthentificatorDTO;
import std.fle._05_controller.SessionVariables;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersAccountInfoService;
import std.fle._0X_security.SecurityLevel;

public class Authentificator extends HandlerInterceptorAdapter {

	@Autowired
	LocalMessage local;

	@Autowired
	UsersAccountInfoService uAccservice;

	private PassWord passManager = new PassWord();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SessionVariables sessVar = new SessionVariables(request);
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		if (!login.isEmpty()) {
			UsersAccountInfoAuthentificatorDTO authen = null;
			try {
				authen = uAccservice.getPassPseudoAndLevel(request.getParameter("login"));
			} catch (Exception e) {
				response.sendRedirect("incorrectConnexion");
				return false;
			}
			if (passManager.isPassMatch(pass, authen.getPassword())) {
				sessVar.setConnexion(local.message("logOut.name"));
				sessVar.setLogged(true);
				sessVar.setSecurityLevel(authen.getSecurityLevel());
				response.sendRedirect("index.html");
			} else {
				response.sendRedirect("wrongConnexion");
				return false;
			}
		} else {
			response.sendRedirect("emptyConnexion");
			return false;
		}
		return false;
	}

}
