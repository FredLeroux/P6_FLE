<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code ="errorPage.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
</head>
<div id ="errorPageUp">
</div>
<br>
<div class = "messageContainer">
	<div class = "messageTitleBad">
		<springTags:message code ="errorPageTitle.message"/>
		<br>
	</div>
	<br>
	<br>
	<div class = "messageBodyCenterAlign">
		<springTags:message code ="errorPageBody.message"/>
		<br>
	</div>
	<br>
	<br>
	<div class = "linkContainer">
		<a class = "link"  href="${pageContext.request.contextPath}/reInit" target="_top">
		<springTags:message code ="erroPageBack.message"/>
		</a>
		<br>
		<br>
	</div>
</div>
<br>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
<script type="text/javascript">
window.location = "#errorPageUp";
</script>
