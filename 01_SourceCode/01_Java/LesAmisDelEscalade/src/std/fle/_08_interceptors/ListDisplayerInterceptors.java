package std.fle._08_interceptors;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import std.fle._0X_security.AccesGranting;
import std.fle._0x_controller.modelManagement.listManagement.ListGenerator;

public class ListDisplayerInterceptors extends HandlerInterceptorAdapter {

	@Autowired
	AccesGranting granting;

	@Autowired
	ListGenerator listGenerator;
	
	
	
	

	private final String membersListType = "members";
	private final String climbingSiteListType = "climbingSites";
	private final String forbiddenMessageURI = "/03_messagesPages/accesDenied";
	private String listInitiate =null;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String listType = request.getParameter("listType");
		if (listType != null) {
			listInitiate = listType;
		}
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		if (ismembersListType(listInitiate)) {
			if (granting.toAdmin()) {
				map= listGenerator.getMembersList();
			} else {				
				redirectToForbiddenMessage(request,response);
				return false;
			}
		}
		if(isClimbingSitesType(listInitiate)) {
			map=listGenerator.getClimbingSiteList();
		}
		request.setAttribute("map", map);
		return true;
	}

	private boolean ismembersListType(String listType) {
		return membersListType.equals(listType);
	}
	
	private boolean isClimbingSitesType(String listType) {
		return climbingSiteListType.equals(listType);
	}

	private void redirectToForbiddenMessage(HttpServletRequest request,HttpServletResponse response) {
		dispatch(request,response, forbiddenMessageURI);	
	}

	private void dispatch(HttpServletRequest request,HttpServletResponse response, String redirectURL) {
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher(forbiddenMessageURI);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
