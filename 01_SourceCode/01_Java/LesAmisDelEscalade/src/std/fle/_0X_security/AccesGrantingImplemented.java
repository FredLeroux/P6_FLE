package std.fle._0X_security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import std.fle._01_entity._01_02_assetsEnum.SecurityLevel;
import std.fle._05_controller.SessionVariables;

@Service
public class AccesGrantingImplemented implements AccesGranting {
	
	
	@Autowired
	HttpServletRequest request;
	
	
	private SessionVariables sessvar = new SessionVariables();
	
	@Override
	public Boolean toAdmin() {
		sessvar.setRequest(request);
		return sessvar.getSecurityLevel() == SecurityLevel.ADMIN.rank();
	}
	@Override
	public ModelAndView sendForbiddenMessage(String viewName) {
		System.out.println("sendForbiddenMessage");
		return new ModelAndView(viewName);
		
	}
	
	

}
