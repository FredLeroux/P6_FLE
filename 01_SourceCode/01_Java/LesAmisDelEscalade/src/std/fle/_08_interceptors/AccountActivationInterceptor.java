package std.fle._08_interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.Internationalization.LocalMessage;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersAccountInfoService;

public class AccountActivationInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	UsersAccountInfoService accountService;
	@Autowired
	LocalMessage local;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		InitiateAppInterceptor.initiateApp(request, local);
		if(accountService.activateAccount(request.getParameter("code"))) {			
			response.sendRedirect("accountActivated");
			return false;
		}else {
			response.sendRedirect("accountActivationError");
			return false;
		}
	}

}
