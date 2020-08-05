<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code="topoLendingRefusedPage.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/iconsCss.css" />	
</head>
<div class = "messageContainer">
	<div class = "iconBasisSize">
		<springTags:message code ="topoLendingRefused.title"/>
	</div>
	<div class = "messageBodyCenterAlign">
		<springTags:message code ="topoLendingRefused.message"/>
		<br>
		<button class = "link" onclick="changeParentLocation('${pageContext.request.contextPath}/<springTags:message code ="createAccount.href"/>')" >
			<springTags:message code ="createAccount.name"/>
		</button>
		<br>
	</div>
</div>
<br>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
