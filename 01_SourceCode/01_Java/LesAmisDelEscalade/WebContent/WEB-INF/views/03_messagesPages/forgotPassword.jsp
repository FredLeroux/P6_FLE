<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
	<title>
		<springTags:message code="forgotPassword.title"/>
	</title>
</head>
<div class="messageContainer">
	<div class = "messageTitleGood">
		<springTags:message code="forgotPasswordTitle.message"/>
	</div>
	<br>		
	<div class = "messageBodyLeftAlign">
		<div class ="errorMessage">
			${errorNoCheckBox}
		</div>
		<br>
		<div>
			<springTags:message code="forgotPasswordBody.message"/>
		</div>
		<br>	
		<input type="checkbox" name = "login" value ="login" form = "forgotPasswordFormular">
		<label for ="login">
			<springTags:message code = "forgotPasswordLogin.message"/>
		</label>
		<br>
		<input type="checkbox" name = "pass" value ="pass" form = "forgotPasswordFormular">
		<label for ="pass">
			<springTags:message code = "forgotPasswordPass.message"/>
		</label>		
		<div id="formular">
			<%@ include	file="/resources/02_templatesJsp/formJsp/formFiles/forgotPasswordFormTmplt.jsp"%>
		</div>			
	</div>		
</div>
<br>