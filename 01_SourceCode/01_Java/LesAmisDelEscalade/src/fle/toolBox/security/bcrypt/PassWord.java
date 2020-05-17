package fle.toolBox.security.bcrypt;

import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote allow to manager encode password:
 *          <li>{@link #encode(String)} create a hashed string using Bcrypt with
 *          by default a strength at 10 (can be change via
 *          {@link #setStrength(Integer)}), and the use of a SecureRandom.
 *          <li>{@link #isPassMatch(String, String)} return true if passEntered
 *          after hashing is equals to hashed pass in database
 */
public class PassWord {

	private Integer strength = 10;

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public String encode(String toHash) {
		return encoder().encode(toHash);
	}

	public boolean isPassMatch(String passEntered, String encodedPassword) {
		return encoder().matches(passEntered, encodedPassword);
	}

	private BCryptPasswordEncoder encoder() {
		SecureRandom random = new SecureRandom();
		return new BCryptPasswordEncoder(strength, random);
	}

}
