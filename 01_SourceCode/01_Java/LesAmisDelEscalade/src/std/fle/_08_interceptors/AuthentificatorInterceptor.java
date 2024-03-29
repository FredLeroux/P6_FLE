package std.fle._08_interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.ConfigurationFileReader;
import fle.toolBox.FredParser;
import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.security.bcrypt.PassWord;
import std.fle._00_general.SessionVariables;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoAccessDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoAuthentificatorDTO;
import std.fle._07_service.usersAccountInfoService.UsersAccountInfoService;

public class AuthentificatorInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	LocalMessage local;

	@Autowired
	UsersAccountInfoService uAccservice;

	private PassWord passManager = new PassWord();
	private ConfigurationFileReader config = new ConfigurationFileReader(
			"configuration/securitySettings/securitySettings.xml");
	private Integer maxTentative = FredParser.toInteger(config.getProperty("maxTentatativesAllowed"));

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SessionVariables sessVar = new SessionVariables(request);
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		UsersAccountInfoAuthentificatorDTO authen = null;
		UsersAccountInfoAccessDTO accountAcces = null;
		if (!login.isEmpty() && !pass.isEmpty()) {

			try {
				authen = uAccservice.getAuthentificatorDTOByLogin(request.getParameter("login"));
				login=authen.getLogin();
			} catch (Exception e) {
				response.sendRedirect("incorrectConnexion");
				return false;
			}
			try {
				accountAcces = access(login);
			} catch (Exception e) {
				response.sendRedirect("accountAccesError");
				return false;
			}
			if (!isAccountActivated(accountAcces)) {
				response.sendRedirect("accountNotActivated");
				return false;
			}
			lockAccount(login, sessVar.getLoginTentative(), maxTentative);
			if (isAccountLocked(accountAcces, maxTentative)) {
				sessVar.setLogin(login);
				response.sendRedirect("lockedAccount");
				return false;
			}
			if (passManager.isPassMatch(pass, authen.getPassword())) {
				setSessionVar(authen, sessVar,login);
				response.sendRedirect("welcome");
			} else {
				setTentative(sessVar);
				response.sendRedirect("wrongConnexion?tentative=" + sessVar.getLoginTentative());
				return false;
			}
		} else {
			response.sendRedirect("emptyConnexion");
			return false;
		}
		return false;
	}

	private void setSessionVar(UsersAccountInfoAuthentificatorDTO authen, SessionVariables sessVar,String login) {
		sessVar.setConnexion(local.message("logOut.name"));
		sessVar.setLogged(true);
		sessVar.setSecurityLevel(authen.getSecurityLevel());
		sessVar.setPseudo(authen.getPseudonyme());
		sessVar.setLogin(login);
		sessVar.setAccountID(authen.getId());
	}

	private void setTentative(SessionVariables sessVar) {
		if (sessVar.getLoginTentative() == null) {
			sessVar.setLoginTentative(1);
		} else {
			sessVar.setLoginTentative(sessVar.getLoginTentative() + 1);
		}

	}

	private boolean isTentativeOver(Integer tentativeNumber, Integer maxTentativeAllowed) {
		return tentativeNumber >= maxTentativeAllowed;
	}

	private void lockAccount(String login, Integer tentativeNumber, Integer maxTentativeAllowed) {
		if (isTentativeOver(tentativeNumber, maxTentativeAllowed)) {
			uAccservice.lockAccount(maxTentativeAllowed, login);
		}
	}

	private boolean isAccountLocked(UsersAccountInfoAccessDTO accountAcces, Integer maxTentativeAllowed) {
		return accountAcces.getLoginTentativeNumber() >= maxTentativeAllowed;
	}

	private boolean isAccountActivated(UsersAccountInfoAccessDTO accountAcces) {
		return accountAcces.getAccountActivationStatus();
	}


	private UsersAccountInfoAccessDTO access(String login) {
		return uAccservice.accountAcces(login);
	}

}
