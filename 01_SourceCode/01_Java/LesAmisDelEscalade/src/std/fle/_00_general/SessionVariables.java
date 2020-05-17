package std.fle._00_general;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionVariables {

	private HttpServletRequest request = null;
	private String isAppInitiated = AppVariables.IS_APP_INITIATED.var();
	private String securityLevel = AppVariables.SECURITY_LEVEL.var();
	private String logged = AppVariables.LOGGED.var();
	private String connexion = AppVariables.CONNEXION.var();
	private String pseudo = AppVariables.PSEUDO.var();
	private String accountID = AppVariables.ACCOUNT_ID.var();
	private String loginTentative = AppVariables.LOGIN_TENTATIVE.var();
	private String login = AppVariables.LOGIN.var();
	private String allowResetPass = AppVariables.ALLOW_RESET_PASS.var();
	

	public SessionVariables(HttpServletRequest request) {
		this.request = request;
	}
	
	public SessionVariables() {
		
	}
	
	

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	private HttpSession session() {
		return request.getSession();
	}

	public void setSecurityLevel(Integer securityLevel) {
		session().setAttribute(this.securityLevel, securityLevel);
	}

	public Integer getSecurityLevel() {
		return (Integer) session().getAttribute(securityLevel);
	}

	public boolean getLogged() {
		if (session().getAttribute(logged) == null) {
			return false;
		} else {
			return (boolean) session().getAttribute(logged);
		}

	}

	public void setLogged(boolean logged) {
		session().setAttribute(this.logged, logged);
	}

	public String getConnexion() {
		return (String) session().getAttribute(connexion);
	}

	public void setConnexion(String connexion) {
		session().setAttribute(this.connexion, connexion);
	}

	public String getPseudo() {
		return (String) session().getAttribute(pseudo);
	}

	public void setPseudo(String pseudo) {
		session().setAttribute(this.pseudo, pseudo);
	}

	public Integer getAccountID() {
		return (Integer) session().getAttribute(accountID);
	}

	public void setAccountID(Integer accountID) {
		session().setAttribute(this.accountID, accountID);
	}

	public Integer getLoginTentative() {
		if (session().getAttribute(loginTentative) == null) {
			setLoginTentative(0);
		}
		return (Integer) session().getAttribute(loginTentative);
	}

	public void setLoginTentative(Integer loginTentative) {
		session().setAttribute(this.loginTentative, loginTentative);
	}

	public String getLogin() {
		return (String) session().getAttribute(login);
	}

	public void setLogin(String login) {
		session().setAttribute(this.login, login);
	}

	public Boolean getAllowResetPass() {
		return (Boolean) session().getAttribute(allowResetPass);

	}

	public void setAllowResetPass(Boolean allowResetPass) {
		session().setAttribute(this.allowResetPass, allowResetPass);
	}

	public Boolean getIsAppInitiated() {
		if (session().getAttribute(isAppInitiated) == null) {
			return false;
		} else {
			return (Boolean) session().getAttribute(isAppInitiated);
		}
	}

	public void setIsAppInitiated(Boolean isAppInitiated) {
		session().setAttribute(this.isAppInitiated, isAppInitiated);
	}	

	public void clearSession() {
		session().invalidate();
	}

}
