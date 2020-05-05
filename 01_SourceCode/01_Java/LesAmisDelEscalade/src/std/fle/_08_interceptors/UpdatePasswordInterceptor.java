package std.fle._08_interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.security.bcrypt.PassWord;
import std.fle._07_service.usersAccountInfoService.UsersAccountInfoService;
import std.fle._0x_controller.SessionVariables;

public class UpdatePasswordInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	UsersAccountInfoService usersAccountservice;

	private PassWord passManager = new PassWord();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String oldPassword = request.getParameter("oldPassword");
		SessionVariables sessVar = new SessionVariables(request);
		Integer id = sessVar.getAccountID();
		if (passManager.isPassMatch(oldPassword, usersAccountservice.getAuthentificatorById(id).getPassword())) {			
			return true;
			
		} else {
			response.sendRedirect("passwordConfirmationError");
			return false;
		}
	}
}
