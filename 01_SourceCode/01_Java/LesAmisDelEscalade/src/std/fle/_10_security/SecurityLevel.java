package std.fle._10_security;



public enum SecurityLevel  {
	
	ADMIN(0),
	SUPER_USER(1),
	USER(2),
	VISITOR(3);
	
	
	private Integer rank;

	private SecurityLevel(Integer rank) {
		this.rank = rank;
	}

	public Integer rank() {
		return rank;
	}
	
	
	
	
	
	


	
	
	
	

}
