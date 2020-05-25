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
	/**
	 * 
	 * @param cOI                object to check
	 * @param modelAttributeName <b><u>NULLABLE</u></b> the modelAttribute where to
	 *                           apply constraints,if not needed can be set to null,for example in case
	 *                           of object update;
	 * @param result             is the BindingResult where to set the error;
	 * @apiNote add error to Bindingresult if @unique annotated field <b>is <u>NOT
	 *          UNIQUE</u> and modelAttribute <u>NOT NULL</u></b>.
	 */
	public void SpringMVCValidationCheck(Object cOI, String modelAttributeName, BindingResult result);

}
