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
	routeName = ${routeName}<br>
	ERROR = ${pitchError}
	<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/createNewRoutePitchTmplt.jsp" %>
	<jstl:set var="routePithContainer" scope="page" value="${routePitchList}"/>
	<table>
		<jstl:forEach items="${routePitchList}" var="pitch" varStatus="indexGetter">
			<jstl:set var="lvl" scope="page" value="${pitch.climbingLevelsDTO}"/>
			<jstl:set var="hrefParamaters" value="?route=${routeName}&index=${indexGetter.index}"></jstl:set>
				<tr>
					<td><springTags:message code = "pitch.name"/> ${pitch.pitchNumber}</td>
					<td><springTags:message code = "cotation.name"/>${lvl.cotationLevel}</td>
					<td><a href="${pitchRouteModification}${hrefParamaters}" ><springTags:message code = "pitchModification.name"/></a></td>
					<td><a href="${deleteRoutePitch}${hrefParamaters}" ><springTags:message code = "deletePitch.name"/></a></td>
				</tr>		
		</jstl:forEach>
	</table>
	<br><br>
	<button  onclick="window.location.href='displaySiteRoutesList'">terminer</button>
	<br><br>
</body>
</html>