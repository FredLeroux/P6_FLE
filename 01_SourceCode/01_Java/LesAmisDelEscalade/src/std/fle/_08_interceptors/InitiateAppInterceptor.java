package std.fle._08_interceptors;

import javax.servlet.http.HttpServletRequest;

import fle.toolBox.Internationalization.LocalMessage;
import std.fle._00_general.SessionVariables;
import std.fle._01_entity._assetsEnum.SecurityLevel;

public class InitiateAppInterceptor {
	
	
	
	public static void initiateApp(HttpServletRequest request, LocalMessage local) {
		SessionVariables sessVar = new SessionVariables(request);		
		if (!sessVar.getLogged()) {
			sessVar.setIsAppInitiated(true);
			sessVar.setLogged(false);
			sessVar.setSecurityLevel(SecurityLevel.VISITOR.rank());
			sessVar.setConnexion(local.message("connexion.name"));
			sessVar.setPseudo(local.message("visitor.name"));
			sessVar.setAllowResetPass(false);
		}
	}

}
