package std.fle._08_filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersInfoService;

public class UserUpdateHandler extends HandlerInterceptorAdapter {
	//TODO supress class
	@Autowired
	UsersInfoService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		return true;
	}

}
