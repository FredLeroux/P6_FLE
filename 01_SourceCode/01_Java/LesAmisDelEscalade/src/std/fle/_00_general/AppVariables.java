package std.fle._00_general;

public enum AppVariables {
	
	LOGGED("logged"),
	SECURITY_LEVEL("securityLevel"),
	CONNEXION("connexion"),
	PSEUDO("pseudo"),
	ACCOUNT_ID("accountID"),
	LOGIN_TENTATIVE("loginTentative");
	
	private String var;

	private AppVariables(String var) {
		this.var = var;
	}

	public String var() {
		return var;
	}
	
	

}
