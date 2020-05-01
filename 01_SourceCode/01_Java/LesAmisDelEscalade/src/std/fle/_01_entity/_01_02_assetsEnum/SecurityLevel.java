package std.fle._01_entity._01_02_assetsEnum;



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
