<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/07_01_01_welcomeCss.css" />
<title><springTags:message code = "welcome.title"></springTags:message></title>
</head>
<body>
<br>
<br>
<div id="welcome" class="welcomeFormatting">
<springTags:message  code = "welcome.locale"></springTags:message>
</div>
<br>
<br>
</body>
</html>