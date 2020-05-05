package std.fle._01_entity._assetsEnum;

public enum AccountStatus {
	UNLOCK("unlock.name",0),
	LOCK("lock.name",1);
	
	private String statusNameKey;
	private Integer statusCode;
	
	public String getStatusNameKey() {
		return statusNameKey;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	private AccountStatus(String key, Integer statusCode) {
		this.statusNameKey = key;
		this.statusCode = statusCode;
	}
	
	

}
