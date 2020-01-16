package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
