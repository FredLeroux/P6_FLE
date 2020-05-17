package fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique;

import java.util.List;
/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote allow to retrieve all value from a specific table column using the representing entity and field
 * 
 */
public interface IsUniqueGenericInterface {
	/**
	 * 
	 * @param fieldName the field in entity representing the column of interest
	 * @param entityName the entity name of entity representing database table of interest
	 * @return a Lis&lt;Object&gt; of all table.column((entityName.fieldName) elements
	 */
	List<Object> columnElementsList(String fieldName, String entityName);
}
