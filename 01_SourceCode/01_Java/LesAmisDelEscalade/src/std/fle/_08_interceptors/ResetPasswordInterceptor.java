package std.fle._08_interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.Internationalization.LocalMessage;
import std.fle._05_controller.SessionVariables;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersAccountInfoService;

public class ResetPasswordInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	UsersAccountInfoService service;
	
	@Autowired
	LocalMessage local;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SessionVariables sessVar = new SessionVariables(request);
		String code = request.getParameter("reset");
		Integer id = service.usersAccountInfoIdByResetPassword(code);
		InitiateAppInterceptor.initiateApp(request, local);
		if(id ==null) {
			response.sendRedirect("resetCodeExpired");
			return false;
		}else {
			sessVar.setAccountID(id);
			sessVar.setAllowResetPass(true);			
			return true;
		}
		
	}

}
