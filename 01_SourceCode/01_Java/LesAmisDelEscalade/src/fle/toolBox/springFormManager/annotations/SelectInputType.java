package fle.toolBox.springFormManager.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote
 *          <h1><b><u>Aim</u></b></h1>
 *          <dd>This annotation used in association with
 *          {@link fle.toolBox.springFormManager.SpringMVCFormGenerator} and
 *          {@link fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController}
 *          will generated a form select input with :
 *          <li>select options list setted via an Enum
 *          ({@link #enumClass()})<br>
 *          or DataBaseTable({@link #entityClass()}
 *          <li>default value {@link #defaultValue()}.
 *          <h1><b><u>Options</u></b></h1>
 *          <li>Using {@link #messageSourceSuffix()} allow to translate in
 *          locale language the select options display values.
 *          <li>create dependent select input field i.e. a value selected in a
 *          first select input field will set and filter a second select input
 *          field options list(only with database source, unlimited chain is
 *          possible).
 *          <ol>
 *          to do so :
 *          <ol>
 *          <li>the first field called master field needs to be annotated with
 *          {@link #dependentFieldName()} and
 *          {@link #dependentFieldNameFilteringAction()}
 *          <li>the second field called dependent field needs to be annotated
 *          with first field name {@link #dtoClass()}
 *          {@link #relationShipField()} and
 *          {@link #relationShipFieldFilter()}
 *          </ol>
 *          </ol>
 *          <h1><b><u>Contrains</u></b></h1>
 *          <li>In case of {@link #enumClass()} use avoid all other not
 *          mandatory annotation attributes.
 *          <li>In case of {@link #entityClass()} use avoid
 *          {@link #enumClass()}.
 *          <ol>
 *          <u> use imperatively :</u> <br>
 *          {@link #dtoClass()} <br>
 *          {@link #optionDisplayValueFieldName()} <br>
 *          {@link #optionValueFieldName()} <br>
 *          <u>use optionally :</u> <br>
 *          note : this optional list becames mandatory if one element of the bellow list is used/needed<br>
 *          {@link #dependentFieldName()} <br>
 *          {@link #dependentFieldNameFilteringAction()} <br>
 *          {@link #relationShipField()}<br>
 *          {@link #relationShipFieldFilter()}<br>
 *          {@link #masterFieldName()}
 * 
 * 
 * 
 * 
 */
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface SelectInputType {

	/**
	 * 
	 * the javascript options list var name for the select input generated.
	 */
	String selectListName();

	/**
	 * 
	 * the javascript selected value var name of the select input generated.
	 */
	String selectValueName();

	/**
	 * 
	 * the default value displayed in the select input generated if not needed put "".
	 */
	String defaultValue() ;

	/**
	 * 
	 * the char used to split the generated string via this annotation
	 */
	String splitter() default "/";

	/**
	 * 
	 * Is the entity class used to generate query in order to get the database table
	 * data(corresponding to the field type in entity model use to create the SFC)
	 */
	Class<?> entityClass() default void.class;

	/**
	 * 
	 * Is the DTO class field name use to set Select options list value(the one will
	 * be sent in request and set as foreign key ), usually "id" integer dto class
	 * attribute
	 */
	String optionValueFieldName() default "";

	/**
	 * 
	 * Is the DTO class field name use to set Select options list display value(the
	 * one will appear in the dropdown list and in select field), usualy a string
	 * representing the name of the object
	 */

	String optionDisplayValueFieldName() default "";

	/**
	 * 
	 * the suffix wich allow to translate data in local, use only in case of data in
	 * database table wich have to be translated.<br>
	 * As example:<br>
	 * for a table of color containing the color name : "black".
	 * <li>if messageSourceSuffix is not setted the Select list will contains the
	 * display value black regardless the local<br>
	 * <li>however if messageSourceSuffix is set, the system will check in message
	 * source the presence of the properties i.e.<br>
	 * if messageSourceSuffix is set to ".color" then sytem will check in message
	 * source for "black.color" and return so the local value as follow :<br>
	 * <li>for a properties file "color_fr_FR.properties" containing pair
	 * "black.color=Noir" display value of "black" will be "Noir"
	 * <li>if no properties files or key the the display value will be the default
	 * value which will be "black.color"
	 */
	String messageSourceSuffix() default "";

	/**
	 * 
	 * The entity dto used to get the object list from database used to fill the
	 * select input options list
	 */
	Class<?> dtoClass() default void.class;

	/**
	 * 
	 * The dtoClass field name which is the relation ship owner
	 */
	String relationShipField() default "";

	/**
	 * 
	 * 
	 * the dto field form relationShipField used as filter, usually "id" integer dto
	 * class attribute i.e.<br>
	 * <ul>
	 * <li>For a relation Ship many-to-one between a table states and a table
	 * counties with a Foreign key "states_id_fk"
	 * <li>the relationShipField "state" owner of relationship in CountiesDTO.class
	 * will create a list of StatesDTO.
	 * <li>the relationShipFieldFilter "id" representing the states id value will
	 * allow to filter the StatesDTO list by "id" value and so display only counties
	 * where "states_id_fk" equals "id"
	 * 
	 */
	String relationShipFieldFilter() default "";

	/**
	 * 
	 * The name of the field wich will generate a list dependent of the selected
	 * options set on the select input field annotated with this attribute.<br>
	 * Allow to retrieve the dependent field selectListName.
	 */
	String dependentFieldName() default "";

	/**
	 * 
	 * The form action used to filter the dependent list
	 * 
	 */
	String dependentFieldNameFilteringAction() default "";

	/**
	 * @apiNote Waiting for:<br>
	 *          an Enum implementing SelectOptionsInterface
	 *          <li>with enum instances wich associate two string as properties.
	 *          <li>with SelectOptions.class as class attribute.
	 *          <li>with constructor wich instanciate SelectOptions.class attribute
	 *          as new SelectOptions(value,displayValue).
	 *          <li>and implementing SelectOptionsInterface method with the
	 *          SelectOptions.class attribute.
	 * @default void class (class name via void.class.getName() gives "void"
	 */

	Class<?> enumClass() default void.class;

	/**
	 * 
	 * is the field in this class which will be used to generate this field select
	 * list.<br>
	 * for a countiesId list dependending on a stateId field, the master field is
	 * stateId cause state contains counties
	 */
	String masterFieldName() default "";

}
