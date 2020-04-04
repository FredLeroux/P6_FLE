package std.fle._08_filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.ConfigurationFileReader;
import fle.toolBox.FredParser;
import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.security.bcrypt.PassWord;
import std.fle._02_dto._02_02_modelsDTO._02_02_01_usersDTO.UsersAccountInfoAuthentificatorDTO;
import std.fle._05_controller.SessionVariables;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersAccountInfoService;

public class Authentificator extends HandlerInterceptorAdapter {

	@Autowired
	LocalMessage local;

	@Autowired
	UsersAccountInfoService uAccservice;

	private PassWord passManager = new PassWord();
	private ConfigurationFileReader config = new ConfigurationFileReader("configuration/securitySettings/LogTentativeMax.xml");
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SessionVariables sessVar = new SessionVariables(request);
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		if (!login.isEmpty() && !pass.isEmpty()) {
			UsersAccountInfoAuthentificatorDTO authen = null;
			try {
				authen = uAccservice.getAuthentificatorDTO(request.getParameter("login"));
			} catch (Exception e) {
				response.sendRedirect("incorrectConnexion");
				return false;
			}
			if(sessVar.getLoginTentative()>= FredParser.toInteger(config.getProperty("maxTentatativesAllowed"))) {
				response.sendRedirect("fuckedUp");
				return false;
			}
			if (passManager.isPassMatch(pass, authen.getPassword())) {
					setSessionVar(authen, sessVar);		
				response.sendRedirect("index.html");
			} else {
				setTentative(sessVar);
				response.sendRedirect("wrongConnexion?tentative="+sessVar.getLoginTentative());
				return false;
			}
		} else {
			response.sendRedirect("emptyConnexion");
			return false;
		}
		return false;
	}
	
	
	private void setSessionVar(UsersAccountInfoAuthentificatorDTO authen,SessionVariables sessVar) {
		sessVar.setConnexion(local.message("logOut.name"));
		sessVar.setLogged(true);
		sessVar.setSecurityLevel(authen.getSecurityLevel());
		sessVar.setPseudo(authen.getPseudonyme());
		sessVar.setAccountID(authen.getId());	
	}
	
	private void setTentative(SessionVariables sessVar) {
		if(sessVar.getLoginTentative() == null) {
			sessVar.setLoginTentative(1);
		}else {
		sessVar.setLoginTentative(sessVar.getLoginTentative()+1);}				
		
	}

}
