<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code ="accountActivated.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
</head>
<div class = "messageContainer">
	<div class = "messageTitleGood">
		<springTags:message code ="activationConfirmationTitle.message"/>
	</div>
	<br>
	<div class = "messageBodyCenterAlign">
		<springTags:message code ="activationConfirmationBody.message"/>
	</div>
	<br>	
</div>
<br>
