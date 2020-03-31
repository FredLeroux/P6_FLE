package std.fle._05_controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import std.fle._00_general.AppVariables;

public class SessionVariables {

	private HttpServletRequest request = null;

	private String securityLevel = AppVariables.SECURITY_LEVEL.var();
	private String logged = AppVariables.LOGGED.var();
	private String connexion = AppVariables.CONNEXION.var();

	public SessionVariables(HttpServletRequest request) {
		this.request = request;
	}

	private HttpSession session() {
		return request.getSession();
	}

	public void setSecurityLevel(Integer integer) {
		session().setAttribute(securityLevel, integer);
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

	public void setLogged(boolean bool) {
		session().setAttribute(logged, bool);
	}

	public String getConnexion() {
		return (String) session().getAttribute(connexion);
	}

	public void setConnexion(String string) {
		session().setAttribute(connexion, string);
	}

}
