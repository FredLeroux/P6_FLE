package std.fle._01_entity.assetsEnum;

public enum LendingStatus {
	
	WAITING("waiting"),
	ACCEPTED("accepted"),
	REJECTED("rejected");

	private String status;

	private LendingStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	@Override
	public String toString() {		
		return status;
	}
	
	
	
	
}
