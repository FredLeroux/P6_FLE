package fle.toolBox.springFormManager.annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote Allow to set all needed variables to generate a Spring Formular
 * 
 */

@Retention(RUNTIME)
@Target({ ElementType.TYPE })
@Repeatable(value = SpringForm.class)

public @interface SpringFormSettings {
	/**
	 * 
	 * the form name
	 */
	public String name();

	/**
	 * 
	 * the form action
	 */
	public String action();

	/**
	 * 
	 * the form method
	 */
	public String method();

	/**
	 * 
	 * the form model attribute
	 */
	public String modelAttribute();

	/**
	 * 
	 * configuration file key to get the button message
	 */
	public String buttonMessagePropertyKey();

	/**
	 * 
	 * configuration file key to get the button alignment
	 */
	public String buttonAlignmentPropertyKey();

	/**
	 * 
	 * boolean wich set the form as Read Only(true) or Modifiable(false)
	 */
	public boolean readOnly();

	/**
	 * 
	 * jspFilePath is the path to use in order to create the JSP containing the
	 * Spring Formular, <br>
	 * as example : <br>
	 * for a JSP named "form.jsp" in "/resource/template" path will be : <br>
	 * "/resource/template/form.jsp"
	 */
	public String jspFilePath();

	/**
	 * 
	 * the message source suffix allowing to get the locale MessageSource properties
	 * key<br>
	 * i.e. for a key as "identity.name" labelMessageSourceSuffix will be : <br>
	 * ".name"
	 * 
	 */
	public String labelMessageSourceSuffix();

	/**
	 * 
	 * propertiesFilePath is the path where to find conguration file<br>
	 * as example :<br>
	 * for a configuration file in "classpath:config" named "config.xml" path will
	 * be : <br>
	 * "config/config.xml"
	 */
	public String propertiesFilePath();

}
