package fle.toolBox.dateAndTime.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.time.format.FormatStyle;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote : To use in order to indentified a string "yyyy-MM-dd HH:mm:ss.S" as
 *          a date (for example a string raw date commimg from a data base)
 * @see #rawFormatPattern()
 * @see #dateFormatStyle()
 * 
 */
@Retention(RUNTIME)
@Target(FIELD)

public @interface DateTimeRawFormat {

	/**
	 * 
	 * Is the raw format returned by the source (data base, properties ....).<br>
	 * Use : <br>
	 * <ul>
	 * <li>"basicIsoDate" for DateTimeFormatter.BASIC_ISO_DATE</li>
	 * <li>"IsoLocalDate" for DateTimeFormatter.ISO_LOCAL_DATE</li>
	 * <li>"IsoLocalTime" for DateTimeFormatter.ISO_LOCAL_TIME</li>
	 * <li>"IsoLocalDateTime" for DateTimeFormatter.ISO_LOCAL_DATE_TIME</li>
	 * <li>or custom like "yyyy-MM-dd'T'HH:mm:ss" (it is the ISO_LOCAL_DATE_TIME wrote)</li>
	 * </ol><br>
	 * by default set to "yyyy-MM-dd HH:mm:ss.S" (pattern from postgreSQL date column)
	 * 
	 */
	String rawFormatPattern() default "yyyy-MM-dd HH:mm:ss.S";
	
	FormatStyle dateFormatStyle();

}

