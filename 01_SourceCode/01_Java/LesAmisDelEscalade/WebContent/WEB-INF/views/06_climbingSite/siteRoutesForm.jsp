<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${siteName}<br>
<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/createNewSiteRouteTmplt.jsp" %>		
<jstl:set var="hrefParamaters" value="?route=${routeName}&index=${indexGetter.index}"></jstl:set>
<table>	
<jstl:forEach items="${siteRoutesList}" var="route">
<jstl:set var = "routeName" value = "${route.key}"></jstl:set>
				<tr>
					<td><springTags:message code = "route.name"/> ${routeName}</td>
					<td><a href="${siteRouteEditController}?route=${routeName}" ><springTags:message code = "routeModification.name"/></a></td>
					<td><a href="${editRoutePitchs}?route=${routeName}" ><springTags:message code = "routePitchListModification.name"/></a></td>
					<td><a href="${siteRouteDeleteController}?route=${routeName}" ><springTags:message code = "deleteSiteRoute.name"/></a></td>				
				</tr>
		</jstl:forEach>
		
		
</table>
		<br><br>
		<button  onclick="window.location.href='${routeEndController}'">terminer</button>
		<br><br>
</body>
</html>