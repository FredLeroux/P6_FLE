<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code ="unknownMail.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
</head>
<div class = "messageContainer">
	<div class = "messageTitleBad">
		<springTags:message code ="unknownTitle.message"/>
	</div>
	<div class = "messageBodyCenterAlign">
		<span class="mailUnknown" >
			${mail}
		</span>
	</div>
	<br>
	<br>
	<div class = "centerDiv">
		<div class = "messageBodyLeftAlign">
			<springTags:message code ="unknownBody.message"></springTags:message>
			<a href="${backToCallPageHref}">
				<springTags:message code ="unknownReTryLink.message"/>
			</a>
		</div>
		<br>
	</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
<script type="text/javascript">	
	disableLoadModal();	
</script>
