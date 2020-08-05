<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code ="codeExpired.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
</head>
<div class = "messageContainer">
	<div class = "messageTitleBad">
		<springTags:message code ="codeExpiredTitle.message"/>
	</div>
	<br>
	<div class = "messageBodyCenterAlign">
		<springTags:message code ="codeExpiredBody.message"/>
	</div>
	<br>
</div>
<br>


