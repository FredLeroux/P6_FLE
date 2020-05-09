<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/07_01_02_messagesCSS.css" />
<title><springTags:message code ="accountNotYetActivated.title"></springTags:message></title>
</head>
<body>
<div class = "messageContainer">
<div class = "messageTitleMitaMita"><springTags:message code ="accountNotYetActivatedTitle.message"></springTags:message></div><br><br>
<div class = "messageBodyLeftAlign"><springTags:message code ="accountNotYetActivatedBody.message"></springTags:message></div>
<div class = linkContainer>
<a href="accountActivationError"><springTags:message code ="accountNotYetActivated.link"></springTags:message></a><br><br>
<label class = "link"   onclick="changeParentLocation('${pageContext.request.contextPath}/index.html')" ><springTags:message code ="backHome.message"></springTags:message></label><br><br>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/04_01_02_link.js"></script>
</body>
</body>
</html>