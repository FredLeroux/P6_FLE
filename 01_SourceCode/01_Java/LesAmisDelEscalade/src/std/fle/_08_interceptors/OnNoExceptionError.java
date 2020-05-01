package std.fle._08_interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class OnNoExceptionError extends HandlerInterceptorAdapter {

	RequestDispatcher dispatcher;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("errorcode is ==");
		System.out.println(request.getAttribute("javax.servlet.error.status_code"));
		System.out.println(request.getRequestURI());
		dispatcher = request.getRequestDispatcher("internalError");
		dispatcher.forward(request, response);		
		return false;
	}
}
