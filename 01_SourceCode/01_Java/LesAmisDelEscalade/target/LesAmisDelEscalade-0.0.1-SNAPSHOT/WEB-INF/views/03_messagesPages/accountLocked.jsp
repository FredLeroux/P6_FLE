<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code ="accountLocked.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
</head>
<div class ="messageContainer">
	<div class = "messageTitleBad">
		<springTags:message code ="accountLockedTitle.message"/>
	</div>
	<br>
	<div class = "messageBodyLeftAlign">
		<springTags:message code ="accountLockedBody.message"/>
	</div>
	<br>
</div>
<br>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
