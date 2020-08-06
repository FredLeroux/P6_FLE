<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code ="accountCreationConfirmation.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
</head>
<div class = "messageContainer">
		<div class = "messageTitleGood">
			<springTags:message code ="confirmationTitle.message"/>
		</div>
		<br>
		<div class ="messageBodyCenterAlign">
			<springTags:message code ="confirmationBody.message"/>
		</div>
		<br>
	<br>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
<script type="text/javascript">
	var loadModal = newLoadModal();
	loadModal.disableLoadModal();
</script>