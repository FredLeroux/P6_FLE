<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />	
<title><springTags:message code="accountActivatedError.title"/></title>
</head>
<div class="messageContainer">
	<div class = "messageTitleBad">
		<springTags:message code="activationErrorTitle.message"/>
	</div>	
	<div class = "messageBodyLeftAlign">
		<springTags:message code="alreadyActivatedListIntro.message"></springTags:message>		
		<ol>
			<li>
				<springTags:message code="activationErrorAlreadyActivated.message"/>
				<br>	
				<br>				
			</li>				
			<li>
				<springTags:message code="activationErrorGetNewCode.message"/>
				<span id="formular" class="formLi">
					<%@ include	file="/resources/02_templatesJsp/formJsp/formFiles/askMail.jsp"%>
				</span>
			</li>
			<li>
				<springTags:message code="activationErrorBadMan.message"/>
			</li>
		</ol>
	</div>
	<br>
</div>	
<br>