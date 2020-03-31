package std.fle._00_general;

public enum AppVariables {
	
	LOGGED("logged"),
	SECURITY_LEVEL("securityLevel"),
	CONNEXION("connexion");
	
	private String var;

	private AppVariables(String var) {
		this.var = var;
	}

	public String var() {
		return var;
	}
	
	

}
