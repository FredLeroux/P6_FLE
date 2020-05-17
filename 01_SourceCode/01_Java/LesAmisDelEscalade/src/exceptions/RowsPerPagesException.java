package exceptions;

public class RowsPerPagesException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4004849292372705399L; 
	
	
	public RowsPerPagesException() {
		
	}
	
	public RowsPerPagesException(String message) {
		//throw new ResponseStatusException(HttpStatus.CONFLICT, message);
	}

}
