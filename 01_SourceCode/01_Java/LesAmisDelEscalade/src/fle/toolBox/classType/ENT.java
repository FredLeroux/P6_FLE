package fle.toolBox.classType;

import java.io.Serializable;

/**
 * 
 * @author Frederic Leroux
 * @apiNote ENT (ENT=Entity class annotated by hibernate @Entity annotation ) allow to
 *          declare all application Entities classes as Entity by extending this
 *          class.<br>
 *          Instead of type a class as follow :<br>
 *          public class x{@code<O extends Object>} for a O destinated to be an
 *          Entity<br>
 *          do the following : <br>
 *          public class x{@code<O extends Entity>} and so only Entity extended
 *          classes will be accepted
 * 
 *
 */
public abstract class ENT implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3202309568296301474L;

}
