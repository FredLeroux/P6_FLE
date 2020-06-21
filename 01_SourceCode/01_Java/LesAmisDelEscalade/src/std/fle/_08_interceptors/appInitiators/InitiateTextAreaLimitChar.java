package std.fle._08_interceptors.appInitiators;

import fle.toolBox.springFormManager.annotations.inputTextArea.InputTextAreaGetLimit;
import std.fle._00_general.SessionVariables;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteCommentsSFC;

public class InitiateTextAreaLimitChar {
	
	
	private ClimbingSiteCommentsSFC climbingSiteCommentsSFC = new ClimbingSiteCommentsSFC();
	
	
	public void initiateSessionVars(SessionVariables sessVar) {
		InputTextAreaGetLimit.textAreaAttributeNameAndLimitMap(climbingSiteCommentsSFC)		
		.forEach((key, value) -> sessVar.addSessionVariable(key, value));
	}
	

}
