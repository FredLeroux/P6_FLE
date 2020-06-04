package std.fle._08_interceptors;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fle.toolBox.FredParser;
import std.fle._0X_security.AccesGranting;
import std.fle._0x_controller.modelManagement.listManagement.ListGenerator;

public class ListDisplayerInterceptors extends HandlerInterceptorAdapter {

	@Autowired
	AccesGranting granting;

	@Autowired
	ListGenerator listGenerator;
	
	//TODO 0-00 Implement empty list error with jsp no noResultToDisplay to add to message controller and home 
	
	
	

	private final String membersListType = "members";
	private final String climbingSiteShowListType = "climbingSitesShow";
	private final String climbingSiteEditListType = "climbingSitesEdit";
	private final String climbingSiteCommentsType = "climbingSitesComments";	
	private final String forbiddenMessageURI = "/03_messagesPages/accesDenied";
	private final String emptyListMessageURI = "/03_messagesPages/noResultsToDisplay";
	private String listInitiate =null;
	private String siteIdForComment = null;

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
		if(isClimbingSiteShowType(listInitiate)) {
			map=listGenerator.getClimbingSiteListShow();
		}
		if(isClimbingSiteEditType(listInitiate)) {
			map=listGenerator.getClimbingSiteListEdit();
		}
		if(isClimbingSiteCommentsType(listInitiate)) {		
			map=listGenerator.getclimbingSiteCommentsSLOList(getId(request),request);
		}
		if(isListEmpty(map)) {
			redirectToNoResultsMessage(request,response);
			return false;
		}
		request.setAttribute("map", map);
		return true;
	}

	private boolean ismembersListType(String listType) {
		return membersListType.equals(listType);
	}
	
	private boolean isClimbingSiteShowType(String listType) {
		return climbingSiteShowListType.equals(listType);
	}
	
	private boolean isClimbingSiteEditType(String listType) {
		return climbingSiteEditListType.equals(listType);
	}
	
	private boolean isClimbingSiteCommentsType(String listType) {
		return climbingSiteCommentsType.equals(listType);
	}
	
	private boolean isListEmpty(LinkedHashMap<String, Object> map) {
		List<?> list = (List<?>) map.get("list");		
		return list.isEmpty(); 
	}

	private void redirectToForbiddenMessage(HttpServletRequest request,HttpServletResponse response) {
		dispatch(request,response, forbiddenMessageURI);	
	}
	
	private void redirectToNoResultsMessage(HttpServletRequest request,HttpServletResponse response) {
		dispatch(request,response, emptyListMessageURI);	
	}
	
	

	private void dispatch(HttpServletRequest request,HttpServletResponse response, String redirectURL) {
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher(redirectURL);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private Integer getId(HttpServletRequest request) {
		Integer id = null;
		if(request.getParameter("id") == null) {
			id =FredParser.toInteger(siteIdForComment);  ;
		}else {
			siteIdForComment = request.getParameter("id");
			id= FredParser.toInteger(siteIdForComment);			
		}	
		return id;
	}

}
