<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code ="accountAlreadyActivated.title"/>
	</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
</head>
<div class = "messageContainer">
	<div class = "messageTitleMitaMita">
		<springTags:message code ="accountAlreadyActivatedTitle.message"/>
	</div>
	<br>
	<div class = "messageBodyLeftAlign">
		<springTags:message code ="accountAlreadyActivatedListIntro.message"/>
		<ol>
			<li>
				<springTags:message code ="accountAlreadyActivatedLi1.message"/>
				<br>
			</li>		
			<li>
				<springTags:message code ="accountAlreadyActivatedLi2.message"/>
				<br>
			</li>
		</ol>
	</div>
	<br>
</div>
<br>