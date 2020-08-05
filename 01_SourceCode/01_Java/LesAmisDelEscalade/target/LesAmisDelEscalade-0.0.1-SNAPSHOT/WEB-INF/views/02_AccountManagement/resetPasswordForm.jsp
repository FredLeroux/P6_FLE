<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code = "resetPass.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<div class = "messageContainer">
	<div class = "messageTitleMitaMita">
		<springTags:message code ="reInitPasswordTitle.message"/>
	</div>
	<br>
	<div id="passForm" class = "messageBodyCenterAlign">
		<%@ include file = "/resources/02_templatesJsp/formJsp/formFiles/resetPassFormTmplt.jsp" %>
	</div>
</div>
<br>
