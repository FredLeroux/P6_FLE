package fle.toolBox;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @note Build full request URI containing as follow : <br>
 *       Scheme :// Domaine : Port / contextPath / URI
 * 
 */
public class AppURI {

	public AppURI() {
	}

	private final static String scheme(HttpServletRequest request) {
		return request.getScheme() + "://";
	}

	private final static String domain(HttpServletRequest request) {
		return request.getServerName() + ":";
	}

	private final static Integer port(HttpServletRequest request) {
		return request.getServerPort();
	}

	private final static String context(HttpServletRequest request) {
		return request.getContextPath() + "/";
	}

	private final static String URI(HttpServletRequest request) {
		return request.getRequestURI();
	}

	/**
	 * 
	 * @param request
	 * @return String URI as follow :<br>
	 *         Scheme :// Domain : Port / contextPath /
	 */
	public static String fullContextPathURI(HttpServletRequest request) {
		StringBuilder uri = new StringBuilder();
		uri.append(scheme(request));
		uri.append(domain(request));
		uri.append(port(request));
		uri.append(context(request));
		return uri.toString();

	}

	public String fullContextPathURINotStatic(HttpServletRequest request) {
		StringBuilder uri = new StringBuilder();
		uri.append(request.getScheme() + "://");
		uri.append(request.getServerName() + ":");
		uri.append(request.getServerPort());
		uri.append(request.getContextPath() + "/");
		return uri.toString();
	}
	
	

	/**
	 * 
	 * @param request
	 * @return String URI as follow :<br>
	 *         Scheme :// Domain : Port / contextPath / Request URI
	 */

	public static final String fullRequestURI(HttpServletRequest request) {
		StringBuilder uri = new StringBuilder();
		uri.append(scheme(request));
		uri.append(domain(request));
		uri.append(port(request));
		uri.append(URI(request));
		return uri.toString();

	}

}
