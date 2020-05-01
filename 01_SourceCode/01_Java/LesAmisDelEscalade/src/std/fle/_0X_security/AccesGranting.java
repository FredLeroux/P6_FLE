package std.fle._0X_security;

import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Frederic Leroux <br>
 * @apiNote define the maximum level rank allowed.
 */
public interface AccesGranting {
	
	/**
	 * 
	 * @return true if account level is equals to admin level
	 */
	public Boolean toAdmin();
	
	
	public ModelAndView sendForbiddenMessage(String viewName);

}
