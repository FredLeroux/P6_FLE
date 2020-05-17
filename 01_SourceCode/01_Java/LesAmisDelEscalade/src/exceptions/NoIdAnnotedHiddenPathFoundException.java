package exceptions;

public class NoIdAnnotedHiddenPathFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -262982123695082954L;

	
	public NoIdAnnotedHiddenPathFoundException() {
		super ("Used Class do not have field annotated with HiddenPath");
	}
	
	public NoIdAnnotedHiddenPathFoundException(String message) {
		super(message);
	}
}
