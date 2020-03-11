package fle.toolBox.exceptionsThrower;

import java.util.List;

import exceptions.NoIdAnnotedHiddenPathFoundException;
import exceptions.NotUniqueJavaScriptVarFound;

//TODO passthrough all class using Exceptions thrower and replace with static 

/**
 * 
 * @author Frederic Leroux <br>
 *         Contains method to:<br>
 *         Check if the specified arg is null || 0.<br>
 *         Will throw a null pointer exception if so.<br>
 *         It is possible to add a custom message.
 */
public  class ExceptionsThrower {

	public static void ifNull(String toCheck) throws NullPointerException {
		if (toCheck == null) {
			throw new NullPointerException();
		}
	}

	public static void ifNull(String toCheck, String customMessage) throws NullPointerException {
		if (toCheck == null) {
			throw new NullPointerException(customMessage);
		}
	}

	public static void ifNull(Integer toCheck) throws NullPointerException {
		if (toCheck == null) {
			throw new NullPointerException();
		}
	}

	public static void ifNull(Integer toCheck, String customMessage) throws NullPointerException {
		if (toCheck == null) {
			throw new NullPointerException(customMessage);
		}
	}
	
	public static void ifNull(Object toCheck) throws NullPointerException {
		if (toCheck == null) {
			throw new NullPointerException();
		}
	}

	public static void ifNull(Object toCheck, String customMessage) throws NullPointerException {
		if (toCheck == null) {
			throw new NullPointerException(customMessage);
		}
	}
	
	

	public static void ifZero(char toCheck) throws NullPointerException {
		if (toCheck == 0) {
			throw new NullPointerException();
		}
	}

	public static void ifZero(char toCheck, String customMessage) throws NullPointerException {
		if (toCheck == 0) {
			throw new NullPointerException(customMessage);
		}
	}

	public static void ifZero(int toCheck) throws NullPointerException {
		if (toCheck == 0) {
			throw new NullPointerException();
		}
	}

	public static void ifZero(int toCheck, String customMessage) throws NullPointerException {
		if (toCheck == 0) {
			throw new NullPointerException(customMessage);
		}
	}

	public static void ifZero(long toCheck) throws NullPointerException {
		if (toCheck == 0) {
			throw new NullPointerException();
		}
	}

	public static void ifZero(long toCheck, String customMessage) throws NullPointerException {
		if (toCheck == 0) {
			throw new NullPointerException(customMessage);
		}
	}

	public static void ifZero(double toCheck) throws NullPointerException {
		if (toCheck == 0) {
			throw new NullPointerException();
		}
	}

	public static void ifZero(double toCheck, String customMessage) throws NullPointerException {
		if (toCheck == 0) {
			throw new NullPointerException(customMessage);
		}
	}

	public static void ifDivideByZero(int toCheck) throws ArithmeticException {
		if (toCheck == 0) {
			throw new ArithmeticException();
		}
	}

	public static void ifDivideByZero(int toCheck, String customMessage) throws ArithmeticException {
		if (toCheck == 0) {
			throw new ArithmeticException(customMessage);
		}
	}

	public static void ifDivideByZero(long toCheck) throws ArithmeticException {
		if (toCheck == 0) {
			throw new ArithmeticException();
		}
	}

	public static void ifDivideByZero(long toCheck, String customMessage) throws ArithmeticException {
		if (toCheck == 0) {
			throw new ArithmeticException(customMessage);
		}
	}

	public static void ifDivideByZero(double toCheck) throws ArithmeticException {
		if (toCheck == 0) {
			throw new ArithmeticException();
		}
	}

	public static void ifDivideByZero(double toCheck, String customMessage) throws ArithmeticException {
		if (toCheck == 0) {
			throw new ArithmeticException(customMessage);
		}
	}
	
	public static void ifDifferent(int int1,int int2) throws NotUniqueJavaScriptVarFound {
		if (int1!=int2) {
			throw new  NotUniqueJavaScriptVarFound();
		}
		
	}
	
	public static void ifDifferent(int int1,int int2, String customMessage) throws NotUniqueJavaScriptVarFound {
		if (int1!=int2) {
			throw new  NotUniqueJavaScriptVarFound(customMessage);
		}
		
	}
	
	public static void ifDifferent(Integer int1,Integer int2) throws NotUniqueJavaScriptVarFound {
		if (int1!=int2) {
			throw new  NotUniqueJavaScriptVarFound();
		}
		
	}
	
	public static void ifDifferent(Integer int1,Integer int2, String customMessage) throws NotUniqueJavaScriptVarFound {
		if (int1!=int2) {
			throw new  NotUniqueJavaScriptVarFound(customMessage);
		}
		
	}

	public static void ifDifferent(String int1,String  int2) throws NotUniqueJavaScriptVarFound {
		if (!int1.equals(int2)) {
			throw new  NotUniqueJavaScriptVarFound();
		}
		
	}
	
	public static void ifDifferent(String  int1,String  int2, String customMessage) throws NotUniqueJavaScriptVarFound {
		if (!int1.equals(int2)) {
			throw new  NotUniqueJavaScriptVarFound(customMessage);
		}
		
	}
	
	public static void ifEmpty(List<?> list) throws NoIdAnnotedHiddenPathFoundException {
		if(list.isEmpty()) {
			throw new NoIdAnnotedHiddenPathFoundException();
		}
	}
	
	public static void ifEmpty(List<?> list,String customMessage) throws NoIdAnnotedHiddenPathFoundException {
		if(list.isEmpty()) {
			throw new NoIdAnnotedHiddenPathFoundException(customMessage);
		}
	}
	
	
}
