<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/07_01_02_messagesCSS.css" />
<title><springTags:message code ="accountActivated.title"></springTags:message></title>
</head>
<body>
<div class = "messageContainer">
<div class = "messageTitleGood">
<springTags:message code ="activationConfirmationTitle.message"></springTags:message><br>
</div><br><br>
<div class = "messageBodyCenterAlign">
<springTags:message code ="activationConfirmationBody.message"></springTags:message><br>
</div><br><br>
<div class = "linkContainer">
<label class = "link"   onclick="changeParentLocation('${pageContext.request.contextPath}/index.html')" ><springTags:message code ="backHome.message"></springTags:message></label><br><br>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/04_01_02_link.js"></script>
</body>
</html>