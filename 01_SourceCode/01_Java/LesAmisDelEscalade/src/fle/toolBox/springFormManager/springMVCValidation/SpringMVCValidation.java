package fle.toolBox.springFormManager.springMVCValidation;

import org.springframework.validation.BindingResult;
/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote will add error to BindingResult if tested field value is not unique
 * @see {@link SpringMVCValidationImplemented}
 */
public interface SpringMVCValidation {

	
	/**
	 * add error to Bindingresult if @unique annotated field is not unique
	 */
	public void SpringMVCValidationCheck(Object cOI, BindingResult result);
	
	

}
