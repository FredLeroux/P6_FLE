package std.fle._08_interceptors;

import javax.servlet.http.HttpServletRequest;

import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.springFormManager.annotations.inputTextArea.InputTextAreaGetLimit;
import std.fle._00_general.SessionVariables;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteCommentsSFC;
import std.fle._0X_security.SecurityLevel;

public class InitiateAppInterceptor {
	
	private static ClimbingSiteCommentsSFC climbingSiteCommentsSFC = new ClimbingSiteCommentsSFC();
	
	public static void initiateApp(HttpServletRequest request, LocalMessage local) {
		SessionVariables sessVar = new SessionVariables(request);		
		if (!sessVar.getLogged()) {
			sessVar.setIsAppInitiated(true);
			sessVar.setLogged(false);
			sessVar.setSecurityLevel(SecurityLevel.VISITOR.rank());
			sessVar.setConnexion(local.message("connexion.name"));
			sessVar.setPseudo(local.message("visitor.name"));
			sessVar.setAllowResetPass(false);
			InputTextAreaGetLimit.textAreaAttributeNameAndLimitMap(climbingSiteCommentsSFC)
			.forEach((key, value) -> sessVar.addSessionVariable(key, value));
			
		}
	}

	
	
}
