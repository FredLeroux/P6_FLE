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
import std.fle._10_security.AccesGranting;
import std.fle._12_controller.listManagement.ListGenerator;

public class ListDisplayerInterceptors extends HandlerInterceptorAdapter {

	@Autowired
	AccesGranting granting;

	@Autowired
	ListGenerator listGenerator;

	private final String membersListType = "members";
	private final String climbingSiteShowListType = "climbingSitesShow";
	private final String climbingSiteEditListType = "climbingSitesEdit";
	private final String climbingSiteCommentsListType = "climbingSitesComments";
	private final String toposListType = "topos";
	private final String toposMineListType = "toposMine";
	private final String listInListController = "/04_listPage/listInListPage";
	private final String forbiddenMessageURI = "/03_messagesPages/accesDenied";
	private final String emptyListMessageURI = "/03_messagesPages/noResultsToDisplay";
	private String listInitiate =null;
	private String siteIdForComment = null;



	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String listType = request.getParameter("listType");
		String update = request.getParameter("update");
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		if (listType != null) {
			listInitiate = listType;
		}if (ismembersListType(listInitiate)) {
			if (granting.toAdmin()) {
				map= listGenerator.getMembersList(listInitiate);
			} else {
				redirectToForbiddenMessage(request,response);
				return false;
			}
		}
		else if(isClimbingSiteShowType(listInitiate)) {
			map=listGenerator.getClimbingSiteListShow(listInitiate);
		}
		else if(isClimbingSiteEditType(listInitiate)) {
			map=listGenerator.getClimbingSiteListEdit(listInitiate);
		}
		else if(isClimbingSiteCommentsType(listInitiate)) {
			LinkedHashMap<String, Object> mapComment = new LinkedHashMap<>();
			mapComment=listGenerator.getclimbingSiteCommentsSLOList(getId(request),request,listInitiate);
			if(isListEmpty(mapComment)) {
				redirectToNoResultsMessage(request,response);
				return false;
			}
			redirectToListInListController(request, response, mapComment,update);
			return false;
		}
		else if(isToposListType(listInitiate)) {
			map = listGenerator.getTopoSLOsLoggedOwnerExcludedList(request,listInitiate);
		}
		else if(isToposMineListType(listInitiate)) {
			map = listGenerator.getTopoMineSLOList(request,listInitiate);
		}
		if(isListEmpty(map)) {
			redirectToNoResultsMessage(request,response);
			return false;
		}
		addRequestAttributes(map, update, request);

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
		return climbingSiteCommentsListType.equals(listType);
	}

	private boolean isToposListType(String listType) {
		return toposListType.equals(listType);
	}

	private boolean isToposMineListType(String listType) {
		return toposMineListType.equals(listType);
	}

	private boolean isListEmpty(LinkedHashMap<String, Object> map) {
		List<?> list = (List<?>) map.get("list");
		return list.isEmpty();
	}


	private void redirectToListInListController(HttpServletRequest request,HttpServletResponse response,LinkedHashMap<String, Object> map,String update) {
		addRequestAttributes(map, update, request);
		dispatch(request,response, listInListController);
	}

	private void addRequestAttributes(LinkedHashMap<String, Object> map, String update,HttpServletRequest request) {
		request.setAttribute("map", map);
		if(update!=null) {
			request.setAttribute("update", "true");
		}
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
