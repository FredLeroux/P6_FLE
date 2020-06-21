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

<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/editSiteRouteTmplt.jsp" %>	

<jstl:set var="routePithContainer" scope="page" value="${routePitchList}"/>
<jstl:forEach items="${routePitchList}" var="pitch">
<jstl:set var="lvl" scope="page" value="${pitch.climbingLevels}"/>
			<li><a href="${routePitchEditController}">${pitch.pitchNumber}->${lvl.cotationLevel}</a></li>
		</jstl:forEach>

<button  onclick="window.location.href='${cancel}'">CANCEL</button>
<br>
<br>
</body>
</html>