package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PageNumberException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7684636989100829642L;

	
	

	public PageNumberException() {
		throw new ResponseStatusException(HttpStatus.CONFLICT);
		
	}
	
	public PageNumberException(String message) {
		throw new ResponseStatusException(HttpStatus.CONFLICT, message);
		
		
		
	}
	public PageNumberException(Integer page) {
		throw new ResponseStatusException(HttpStatus.CONFLICT, "Page Number " +page+" Not Found");
		
		
		
	}
	
	
	
	
}
