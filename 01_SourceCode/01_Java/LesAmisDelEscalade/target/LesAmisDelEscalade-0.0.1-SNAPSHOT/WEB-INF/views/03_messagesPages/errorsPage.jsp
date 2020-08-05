<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
<title><springTags:message code ="errorPage.title"></springTags:message></title>
</head>
<body>
<div class = "messageContainer">
<div class = "messageTitleBad">
<springTags:message code ="errorPageTitle.message"></springTags:message><br>
</div><br><br>
<div class = "messageBodyCenterAlign">
<springTags:message code ="errorPageBody.message"></springTags:message><br>
</div><br><br>
<div class = "linkContainer">
<!--  <label class = "link"   onclick="changeParentLocation('${pageContext.request.contextPath}/index.html')" ><springTags:message code ="erroPageBack.message"></springTags:message></label><br><br>
-->

<a class = "link"  href="${pageContext.request.contextPath}/reInit" target="_top"><springTags:message code ="erroPageBack.message"></springTags:message></a><br><br>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
</body>
</html>