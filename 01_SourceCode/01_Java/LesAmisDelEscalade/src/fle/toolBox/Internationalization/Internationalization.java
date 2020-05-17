package fle.toolBox.Internationalization;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

import fle.toolBox.exceptionsThrower.ExceptionsThrower;



public class Internationalization {

	String suffix = null;

	public String getSuffix() {
		ExceptionsThrower.ifNull(suffix);
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * 
	 * @param key           the key to be find in message source properties file
	 * @param messageSource org.springframework.context.MessageSource autowired
	 * @return the properties message source key at locale language
	 */
	public String messI18n(String key, MessageSource messageSource) {
		return localeMessage(key, messageSource);
	}

	private String localeMessage(String key, MessageSource messageSource) {
		String message;
		Locale locale = LocaleContextHolder.getLocale();
		try {
			message = messageSource.getMessage(key, null, locale).toString();
		} catch (NoSuchMessageException e) {
			throw new NoSuchMessageException(key, locale);
		}
		return message;
	}

	/**
	 * 
	 * @param field
	 * @return a string composed of the string str + suffix setted via setSuffix
	 *         setter
	 */
	public String createKey(String str) {
		return str + "." + getSuffix();
	}
	
	public String keyFinal(String str) {
		return str.concat(getSuffix());
	}

}
