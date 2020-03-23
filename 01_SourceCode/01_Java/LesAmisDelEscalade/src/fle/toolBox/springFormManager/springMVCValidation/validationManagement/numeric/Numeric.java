package fle.toolBox.springFormManager.springMVCValidation.validationManagement.numeric;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import fle.toolBox.springFormManager.springMVCValidation.SpringMVCValidation;


/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote allow to check if a string is numeric. this annotation is to be used
 *          in association with SpringMVCValidation. <br>
 *          <li>If maxDigits, totalDigits ,precision,
 *          maxDigitsKey,totalDigitsKey, precisionKey and configFilePath are not
 *          set field will accept only int maximum value 2 147 483 647.
 *          <li>In case of configFilePath use with allow to set numeric
 *          informations via properties file all key have to be set all other
 *          attributes not mandatory has to be 0 or default
 *          <li>maxDigits(Key) use with precision(Key) allow to enter a numeric
 *          value as follow :
 *          [0-9]{1,(maxDigits(Key)-precision(Key))}.[0-9]{precision(Key)}
 *          <li>totalDigits(Key) use with precision(Key) impose to enter numeric
 *          value as follow:
 *          [0-9]{totalDigits(Key)-precision(Key}.[0-9]{precision(Key)}
 *          <li>If precision(key) == total or max digits numeric value begins
 *          absolutly with "0." .
 *          <li>precison(Key) cannot be superior to max or total digits.
 *          <li>Mandatory modelAttributeValue allow error mapping
 *          {@link #modelAttributeValue()}.
 * 
 * @See {@link SpringMVCValidation}
 * 
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface Numeric {
	/**
	 * Allow to set the error code specifically to the modelAttribute i.e <br>
	 * for a simple model entity:<br>
	 * * code will be "NotNumeric.modelAttributeValue.field".<br>
	 * for an associated models entity:<br>
	 * code will be "NotNumeric.modelAttributeValue.entityName.field"<br>
	 * generic code error will be "NotNumeric", this will allow customization of
	 * error message via properties file.
	 * 
	 * 
	 * 
	 */
	public String modelAttributeValue();

	/**
	 *
	 * Set the maximum number digits i.e. field value has to be between
	 * "1-maxDigits".
	 */
	public int maxDigits() default 0;

	/**
	 * 
	 * set the total number digits i.e. field value length has to be equals at
	 * "totalDigits".
	 */
	public int totalDigits() default 0;

	/**
	 * 
	 * set the deciamal number i.e decimal number length has to be equals to
	 * "precision".
	 */
	public int precision() default 0;
/**
 * 
 *  set the path to properties file containings the max, total digits and precison keys.
 */
	public String configFilePath() default "";
/**
 * Idem as 
 * {@link #maxDigits()}
 * but set in a properties file
 */
	public String maxDigitsKey() default "";
	/**
	 * Idem as 
	 * {@link #totalDigits()}
	 * but set in a properties file
	 */
	public String totalDigitsKey() default "";
	/**
	 * Idem as 
	 * {@link #precision()}
	 * but set in a properties file
	 */
	public String precisionKey() default "";
}
