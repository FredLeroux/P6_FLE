package std.fle._01_entity._01_02_assetsEnum;

public enum SecurityLevel {
	
	ADMIN("admin.name",0),
	SUPER_USER("superUser.name",1),
	USER("user.name",2),
	VISITOR("visitor.name",3);
	
	private String levelNameKey;
	private Integer levelCode;
	
	public String getLevelNameKey() {
		return levelNameKey;
	}
	public Integer getLevelCode() {
		return levelCode;
	}
	private SecurityLevel(String levelNameKey, Integer levelCode) {
		this.levelNameKey = levelNameKey;
		this.levelCode = levelCode;
	}
	
	
	
	

}
