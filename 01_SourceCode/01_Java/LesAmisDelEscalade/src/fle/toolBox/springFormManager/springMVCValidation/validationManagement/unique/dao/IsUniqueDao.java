package fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique.dao;

import org.springframework.transaction.annotation.Transactional;

import fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique.IsUniqueGenericInterface;


/**
 * 
 * @author Frederic Leroux <br>
 *	@see {@link IsUniqueGenericInterface} and  {@link IsUniqueGenericInterface#columnElementsList(String, String)}
 */
@Transactional
public interface IsUniqueDao extends IsUniqueGenericInterface{
	

}
