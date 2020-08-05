<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/07_01_02_messagesCSS.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/iconsCss.css" />

<title><springTags:message code="topoLendingRefusedPage.title"/></title>
</head>
<body>
<br>
<div class = "messageContainer">
<div class = "iconBasisSize">
<springTags:message code ="topoLendingRefused.title"></springTags:message><br>
</div>
<div class = "messageBodyCenterAlign">
<springTags:message code ="topoLendingRefused.message"/>
<br>
<br>
<button class = "link" onclick="changeParentLocation('${pageContext.request.contextPath}/<springTags:message code ="createAccount.href"/>')" >
<springTags:message code ="createAccount.name"/></button><br><br>
</div>
</div>
<br>
<br>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/04_01_02_link.js"></script>
</body>
</html>