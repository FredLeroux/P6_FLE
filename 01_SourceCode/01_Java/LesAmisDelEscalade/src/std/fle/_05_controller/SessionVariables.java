package std.fle._05_controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import std.fle._00_general.AppVariables;

public class SessionVariables {

	private HttpServletRequest request = null;

	private String securityLevel = AppVariables.SECURITY_LEVEL.var();
	private String logged = AppVariables.LOGGED.var();
	private String connexion = AppVariables.CONNEXION.var();
	private String pseudo = AppVariables.PSEUDO.var();
	private String accountID = AppVariables.ACCOUNT_ID.var();
	private String loginTentative = AppVariables.LOGIN_TENTATIVE.var();

	public SessionVariables(HttpServletRequest request) {
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
		if(session().getAttribute(loginTentative)== null) {
			setLoginTentative(0);
		}
		return (Integer) session().getAttribute(loginTentative);
	}

	public void setLoginTentative(Integer loginTentative) {
		session().setAttribute(this.loginTentative, loginTentative);
	}

	public void clearSession() {
		session().invalidate();
	}

}
