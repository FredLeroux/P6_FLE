package std.fle._00_general;

public enum AppVariables {
	
	LOGGED("logged"),
	SECURITY_LEVEL("securityLevel"),
	CONNEXION("connexion"),
	PSEUDO("pseudo"),
	ACCOUNT_ID("accountID"),
	LOGIN_TENTATIVE("loginTentative"),
	LOGIN("login"),
	ALLOW_RESET_PASS("allowResetPass"),
	IS_APP_INITIATED("isAppInitiated"),
	FORGOT_PASS("forgotPass");
	
	private String var;

	private AppVariables(String var) {
		this.var = var;
	}

	public String var() {
		return var;
	}
	
	

}
