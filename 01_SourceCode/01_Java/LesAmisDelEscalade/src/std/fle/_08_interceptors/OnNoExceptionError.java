package std.fle._08_interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.logger.Log4J2;

/**
 * @apiNote will catch all request sending a error (excepted 500), this
 *          interceptor needs to have in deployement descriptor (web.xml) the
 *          following attribute <br>
 *          &lterror-page><br>
 *          &ltlocation>/errorNotException</location><br>
 *          &lt/error-page><br>
 *          where "/errorNotException" is the intercepted url
 *
 *
 */
public class OnNoExceptionError extends HandlerInterceptorAdapter {

	private Log4J2<OnNoExceptionError> logger = new Log4J2<OnNoExceptionError>(this);
	private RequestDispatcher dispatcher;


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		StringBuilder errorMessage =  new StringBuilder();
		errorMessage.append("Internal error : NO_EXCEPTION_ERROR"+"\n");
		errorMessage.append("URL : " + request.getAttribute("javax.servlet.forward.request_uri")+"\n");// return the url wich
																									// threw the error
		errorMessage.append("STATUS_CODE : " + request.getAttribute("javax.servlet.error.status_code")+"\n");
		logger.log().warn(errorMessage);
		dispatcher = request.getRequestDispatcher("internalError");
		dispatcher.forward(request, response);
		return false;
	}
}
