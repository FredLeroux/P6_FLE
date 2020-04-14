package std.fle._08_filter;

import javax.servlet.http.HttpServletRequest;

import fle.toolBox.Internationalization.LocalMessage;
import std.fle._05_controller.SessionVariables;
import std.fle._0X_security.SecurityLevel;

public class InitiateApp {
	
	
	
	public static void initiateApp(HttpServletRequest request, LocalMessage local) {
		SessionVariables sessVar = new SessionVariables(request);		
		if (!sessVar.getLogged()) {
			sessVar.setLogged(false);
			sessVar.setSecurityLevel(SecurityLevel.VISITOR.rank());
			sessVar.setConnexion(local.message("connexion.name"));
			sessVar.setPseudo(local.message("visitor.name"));
			sessVar.setAllowResetPass(false);
		}
	}

}
