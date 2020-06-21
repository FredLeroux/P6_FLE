package std.fle._08_interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.Internationalization.LocalMessage;
import std.fle._07_service.usersAccountInfoService.UsersAccountInfoService;
import std.fle._08_interceptors.appInitiators.InitiateAppInterceptor;

public class AccountActivationInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	UsersAccountInfoService accountService;
	@Autowired
	LocalMessage local;
	
	private InitiateAppInterceptor initiateAppInterceptor = new InitiateAppInterceptor();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		initiateAppInterceptor.initiateApp(request, local);
		if(accountService.activateAccount(request.getParameter("code"))) {			
			response.sendRedirect("accountActivated");
			return false;
		}else {
			response.sendRedirect("accountActivationError");
			return false;
		}
	}

}
