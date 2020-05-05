package std.fle._08_interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.Internationalization.LocalMessage;
import std.fle._05_slo.innerJoinSLO.MembersListSLO;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersInfoService;

public class OpeningInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	LocalMessage local;
	
	@Autowired
	UsersInfoService service;
	
	private MembersListSLO slo = new MembersListSLO();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		InitiateAppInterceptor.initiateApp(request,local);
		return true;
	}

}
