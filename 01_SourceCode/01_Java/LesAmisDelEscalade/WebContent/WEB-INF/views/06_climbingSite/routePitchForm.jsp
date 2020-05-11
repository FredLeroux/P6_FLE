<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${siteName}<br>
routeNmae = ${routeName}<br>
<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/createNewRoutePitchTmplt.jsp" %>
<jstl:set var="routePithContainer" scope="page" value="${routePitchList}"/>
<jstl:forEach items="${routePitchList[routeName]}" var="pitch">
			<li><Label>${pitch.pitchNumber}</Label>
		</jstl:forEach>
		<br><br>
		<button onclick="window.location.href='displaySiteRoutesList'">terminer</button>
		<br><br>
</body>
</html>