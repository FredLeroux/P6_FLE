package fle.toolBox;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @note <b> Use toString() to get the generate code as string</b><br>
 *       Generate a random code function of size setted and boolean
 *       isSymboleAccepted if symnboles are accepted.<br>
 *       The code will be composed with char randomly selected among digits,
 *       characters, Capital characters and if needed with characters among the
 *       acceptedSymbolList by default.<br>
 *       Defualt symbols are :<br>
 *       unicode 33,35,36,37,38,42,43,45,63,64,95 wich gives char
 *       !,#,$,%,&,*,+,-,?,@,_ <br>
 *       to change this list use getter and setter on acceptedSymbolList.
 * 
 */
public class FredCodeGenerator extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2533829612096180604L;

	private Random random = new Random();
	private char toAppend = 0;
	private StringBuilder codeGenerated = new StringBuilder();
	/**
	 * @apiNote w/o symbols : ' " , + # and .
	 */
	private Integer[] acceptedSymbolList = { 33, 36, 37, 42, 63, 64, 95 };
	private boolean isSymbolAccepted = false;

	/**
	 * 
	 * @param codeSize
	 * @param isSymbolAccepted
	 * @apiNote Generate a radom code of size = codeSize with or not symbol<br>
	 *       isSymbolAccepted true(w/o symbols : ' " , + # - & and .) or false.<br> Use toString to get the codeGenerated
	 *       as string however return a String ArrayList size = codeSize containing
	 *       random char
	 * 
	 */
	public FredCodeGenerator(Integer codeSize, boolean isSymbolAccepted) {
		setSymbolAccpeted(isSymbolAccepted);
		fillThis(codeSize);
		buildCode();
	}

	public boolean isSymbolAccepted() {
		return isSymbolAccepted;
	}

	public void setSymbolAccpeted(boolean isSymbolAccepted) {
		this.isSymbolAccepted = isSymbolAccepted;
	}

	public char getToAppend() {
		return toAppend;
	}

	public void setToAppend(char[] characterArray) {
		this.toAppend = characterArray[0];
	}

	/**
	 * 
	 * @return Integer array containing CHAR ASCII Unicode
	 */

	public Integer[] getAcceptedSymbolList() {
		return acceptedSymbolList;
	}

	/**
	 * 
	 * @param acceptedSymbolList Integer array waiting for ASCII Unicode list
	 */
	public void setAcceptedSymbolList(Integer[] acceptedSymbolList) {
		this.acceptedSymbolList = acceptedSymbolList;
	}

	/**
	 * 
	 * @param minRangeValue the lowest range value
	 * @param maxRangeValue the exact highest range value
	 * @return an Integer among the range minRangeValue et maxRangeValue
	 * @note as the random excluded the maxRangeValue method automaticaly adjust max
	 *       value to include it
	 */

	private Integer random(Integer minRangeValue, Integer maxRangeValue) {
		Integer randomInt = random.nextInt((maxRangeValue - minRangeValue) + 1) + minRangeValue;
		return randomInt;

	}

	/**
	 * 
	 * @param ASCIIUnicode ASCII unicode integer
	 * @return a char array containing one character equivalent to the ASCII Unicode
	 *         random
	 */
	private char[] randomCharacter(Integer ASCIIUnicode) {
		char[] characterArray = Character.toChars(ASCIIUnicode);
		return characterArray;
	}

	/**
	 * 
	 * @param minRangeValue
	 * @param maxRangeValue
	 * @return a char[] of 1 character wich unicode is within minRangeValue and
	 *         maxRangeValue
	 */
	private char[] randomCharBetweenRange(Integer minRangeValue, Integer maxRangeValue) {
		return randomCharacter(random(minRangeValue, maxRangeValue));
	}

	/**
	 * 
	 * @return a char[] of 1 character wich unicode is within range 33 and 45
	 */
	private char[] randomSymbol() {
		Integer index = random(0, (acceptedSymbolList.length - 1));
		Integer symbol = acceptedSymbolList[index];
		return randomCharacter(symbol);

	}

	/**
	 * 
	 * @return a char[] of 1 character wich unicode is within range 48 and 57
	 */
	private char[] randomDigit() {
		return randomCharBetweenRange(48, 57);
	}

	/**
	 * 
	 * @return a char[] of 1 character wich unicode is within range 97 and 122
	 */
	private char[] randomChar() {
		return randomCharBetweenRange(97, 122);
	}

	/**
	 * 
	 * @return a char[] of 1 character wich unicode is within range 65 and 90
	 */
	private char[] randomCapitalChar() {
		return randomCharBetweenRange(65, 90);
	}

	/**
	 * 
	 * @retun toAppend char setted with a random char of random type
	 *        digit,Capital,character abd/or Symbol
	 */
	private char randomCharType() {
		Integer minRangeValue = null;
		if (isSymbolAccepted()) {
			minRangeValue = 0;
		} else {
			minRangeValue = 1;
		}
		Integer randomType = random(minRangeValue, 3);
		if (randomType == 0) {
			setToAppend(randomSymbol());
		} else if (randomType == 1) {
			setToAppend(randomDigit());
		} else if (randomType == 2) {
			setToAppend(randomChar());
		} else if (randomType == 3) {
			setToAppend(randomCapitalChar());
		}
		return getToAppend();
	}

	/**
	 * 
	 * @param codeSize fill this ArrayList with randoChar until this.size =
	 *                 codesize;
	 * 
	 */
	private void fillThis(Integer codeSize) {
		while (this.size() < codeSize) {
			randomCharType();
			this.add(FredParser.asString(getToAppend()));
		}
	}

	/**
	 * 
	 * @return the generated code function of fillThis method
	 */
	private StringBuilder buildCode() {
		for (String str : this) {
			codeGenerated.append(str);
		}
		return codeGenerated;
	}

	@Override
	public String toString() {
		return codeGenerated.toString();
	}

}
