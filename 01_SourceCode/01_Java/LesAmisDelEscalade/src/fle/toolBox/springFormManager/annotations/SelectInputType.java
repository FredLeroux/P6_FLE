package fle.toolBox.springFormManager.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

//TODO 1-JAVADOC
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface SelectInputType {

	String selectListName();

	String selectValueName();
	
	String defaultValue() default "";
	
	String splitter() default "/";

	String query() default "";

	String optionValueFieldName() default "";

	String optionDisplayValueFieldName() default "";

	String messageSourceSuffix() default "";

	Class<?> dtoClass() default void.class;

	String masterFieldName() default "";

	String filterByFieldName() default "";

	String dependentFieldName() default "";

	String filteringAction() default "";

	

	/**
	 * 
	 * @default void class (class name via void.class.getName() gives "void"
	 */
	Class<?> enumClass() default void.class;

}
