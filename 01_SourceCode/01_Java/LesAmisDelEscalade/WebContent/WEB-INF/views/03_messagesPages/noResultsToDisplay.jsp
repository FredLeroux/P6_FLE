<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code ="noResultsToDisplay.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
</head>
<div class = "messageContainer">
	<springTags:message code ="noResultToDisplay.title"/>
	<br>
	<div class = "messageBodyCenterAlign">
		<springTags:message code ="noResultToDisplay.message"/>
	</div>
	<br>
</div>
<br>