<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code ="accountNotYetActivated.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<div class = "messageContainer">
	<div class = "messageTitleMitaMita">
		<springTags:message code ="accountNotYetActivatedTitle.message"/>
	</div>
	<br>
	<div class = "messageBodyLeftAlign">
		<springTags:message code ="accountNotYetActivatedBody.message"/>
	</div>
	<br>
	<div class = linkContainer>
		<div>
			<button onclick= "navTo('accountActivationError')" class="pageButtonNormal">
				<springTags:message code ="accountNotYetActivated.link"/>
			</button>
		</div>
		<br>
	</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
