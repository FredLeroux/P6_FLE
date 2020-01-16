package fle.toolBox.classType;

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
public abstract class ENT {

}
