package fle.toolBox.fieldTranslator;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote For all declared class field @ToTranslate annotated allow to
 *          translate a field value usng MessageSource property key and so
 *          Internationlizing it .
 */
public interface FieldsTranslator {
	
	
	public  void translateFieldValue(Object entity);
	
	

}
