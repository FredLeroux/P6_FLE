package exceptions;

public class NoNameInColumnAnnotationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7562660423148135737L;

	public NoNameInColumnAnnotationException() {
		
	}
	
	public NoNameInColumnAnnotationException(String message) {
		super(message);
	}

}
