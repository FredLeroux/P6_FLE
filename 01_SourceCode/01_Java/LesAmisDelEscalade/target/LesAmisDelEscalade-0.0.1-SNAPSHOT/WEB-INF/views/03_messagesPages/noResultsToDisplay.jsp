<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
<title><springTags:message code ="noResultsToDisplay.title"></springTags:message></title>
</head>
<body>
<div class = "messageContainer">
<springTags:message code ="noResultToDisplay.title"></springTags:message><br>
<br>
<div class = "messageBodyCenterAlign">
<springTags:message code ="noResultToDisplay.message"></springTags:message><br>
</div>
</div><br><br>
</body>
</html>